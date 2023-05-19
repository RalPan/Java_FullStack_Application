package we.final_project_thymeleaf_JDBC.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import we.final_project_thymeleaf_JDBC.model.fodmap;
import we.final_project_thymeleaf_JDBC.model.meals;
import we.final_project_thymeleaf_JDBC.service.*;
@Controller
public class mainController {
    @Autowired
    mealController mealController;
    @Autowired
    toleranceController toleranceController;
    @Autowired
    operations operations;
    @Autowired
    inputValidation inputValidation;
    //No longer used due to JPA directory issues, see bugs in documentation for details
    @Autowired
    userController userController;
    String ingredientList;
    String name;
    String mealName;
    fodmap mealFodmap = new fodmap(0, 0, 0, 0, 0,0);
    //Set to one due to JPA directory issues, see bugs in documentation for details
    public static int currentUserID = 1;


    @GetMapping("home")
    public String home(Model model) {
        model.addAttribute("name", name);
        return "home";
    }
    @PostMapping("homeForm")
    public String homeForm(HttpServletRequest request) {
        name = request.getParameter("name");
        /* //Attempt at registering a new user- doesn't work due to issues with the JPA repository
        currentUserID = userController.findUserByName(name);
        if (currentUserID == 0){
            user newUser = new user();
            newUser.setName(name);
            userController.addNewUsers(newUser);
        }

         */
        return "redirect:/welcome";
    }
    @GetMapping("welcome")
    public String welcome(Model model) {
        model.addAttribute("name", name);
        return "welcome";
    }

    @PostMapping("goToMeal")
    public String goToMeal(HttpServletRequest request) {
        return "redirect:/meal";
    }
    @GetMapping("meal")
    public String meal(Model model) {
        model.addAttribute("name", mealName);
        model.addAttribute("ingredientList", ingredientList);
        model.addAttribute("fodmaps", mealFodmap.toString());
        return "meal";
    }

    @PostMapping("mealForm")
    public String mealForm(HttpServletRequest request) {
        String mealNameUntested = request.getParameter("name");
        String ingredientListUntested = request.getParameter("ingredientList");
        if(!inputValidation.ingredientsValid(ingredientListUntested)){
            return "redirect:/meal";
        }
        mealName = mealNameUntested;
        ingredientList = ingredientListUntested;
        mealFodmap = operations.calculateFodmaps(ingredientList);

        meals meal = new meals();
        meal.setIngredients(ingredientList);
        meal.setTolerance(toleranceController.getToleranceById(currentUserID).getBody());
        meal.setName(mealName);
        mealController.addNewMeal(meal);
        return "redirect:/meal";
    }

    @PostMapping("seeMeals")
    public String seeMeals(HttpServletRequest request) {
        return "redirect:/meal/userMeals";
    }
    @PostMapping("seeIngredients")
    public String seeIngredients(HttpServletRequest request) {
        return "redirect:/ingredient/ingredients";
    }
}
