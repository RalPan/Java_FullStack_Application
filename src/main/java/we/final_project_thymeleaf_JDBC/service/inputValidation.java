package we.final_project_thymeleaf_JDBC.service;

import org.springframework.stereotype.Component;

@Component
public class inputValidation {
    public boolean ingredientsValid(String ingredients) {
        String[] ingredientValidation = null;
        try {
            ingredientValidation = ingredients.split(", ");
        }catch(Exception e){
            System.out.println(e.toString());
            return false;
        }
        if (ingredientValidation.length== 1){
            return false;
        }
        String regex = "[A-Za-z ]+: [0-9]{1,2}[A-Za-z]+";
        for (String i : ingredientValidation) {
            if (i.matches(regex)) {
                System.out.println("mathces");
            } else {
                System.out.println("no match");
                return false;
            }
        }
        return true;
    }
}
