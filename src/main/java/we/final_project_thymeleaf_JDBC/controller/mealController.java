package we.final_project_thymeleaf_JDBC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import we.final_project_thymeleaf_JDBC.DAOs.mealRepo;
import we.final_project_thymeleaf_JDBC.model.*;

import java.util.List;
@RestController
@RequestMapping("/meal")
@CrossOrigin
public class mealController {
    @Autowired
    private mealRepo mealRepo;
    @GetMapping("/userMeals")
    public ResponseEntity<List<meals>> userMeal() {
        int currentUserID = mainController.currentUserID;
        System.out.println(mealRepo.findAll().toArray().toString());
        List<meals> mealList = mealRepo.findAll();
        System.out.println(mealRepo.findAll().toArray().toString());
        for (meals m : mealList){
            tolerance tol = m.getTolerance();
            System.out.println(tol.getToleranceID());
            if (tol.getToleranceID() != currentUserID){
                mealList.remove(m);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(mealList);
    }

    @GetMapping("/meals")
    public ResponseEntity<List<meals>> allMeal() {
        System.out.println("allMeal");
        List<meals> meals = mealRepo.findAll();
        System.out.println(meals);
        return ResponseEntity.status(HttpStatus.OK).body(meals);
    }

    @GetMapping("/{id}")
    public ResponseEntity<meals> getMealById(@PathVariable("id") Integer id) {
        meals meal = mealRepo.findById(id).orElse(null);
        return new ResponseEntity<meals>(meal, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addNewMeal(@RequestBody meals meals) {
        mealRepo.save(meals);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeal(@PathVariable("id") Integer id) {
        mealRepo.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<meals> updateMeal(@PathVariable("id") Integer id, @RequestBody meals meals) {
        mealRepo.save(meals);
        return new ResponseEntity<meals>(meals, HttpStatus.OK);
    }

    public int countMeals() {
        List<meals> meals = mealRepo.findAll();
        return meals.size();
    }
}
