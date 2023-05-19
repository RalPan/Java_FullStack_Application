package we.final_project_thymeleaf_JDBC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import we.final_project_thymeleaf_JDBC.model.fodmap;
import we.final_project_thymeleaf_JDBC.DAOs.ingredientsDAO;
import we.final_project_thymeleaf_JDBC.model.ingredients;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
@Component
public class operations {

    @Autowired
    ingredientsDAO ingredientsDAO;

    public Map<String, Integer> getMealIngredients(String ingredients){
        Map<String, Integer> ingredientQuantities = new HashMap<>();
        String quantity;
        String[] ingredientQnt;
        String[] ingredientList = ingredients.split(", ");
        for (String pair : ingredientList){
            ingredientQnt = pair.split(": ");
            quantity = ingredientQnt[1];

            quantity = quantity.replaceAll("[^0-9]", "");
            ingredientQuantities.put(ingredientQnt[0], Integer.parseInt(quantity));
        }
        return ingredientQuantities;
    }

    public fodmap calculateFodmaps(String ingredients){
        Map<String, Integer> ingredientQuantities = getMealIngredients(ingredients);
        fodmap mealFodmaps = new fodmap(0, 0, 0, 0, 0, 0);
        Set<String> keys = ingredientQuantities.keySet();
        for (String k : keys) {
            ingredients ingredient = ingredientsDAO.findByName(k);
            //there is probably a better way to do this maybe with streams
            float quantityScale = (float) ingredientQuantities.get(k)/ingredient.getQuantity();
            mealFodmaps.setFructose(mealFodmaps.getFructose() + quantityScale*ingredient.getFructose());
            mealFodmaps.setLactose(mealFodmaps.getLactose() + quantityScale*ingredient.getLactose());
            mealFodmaps.setSorbitol(mealFodmaps.getSorbitol() + quantityScale*ingredient.getSorbitol());
            mealFodmaps.setMannitol(mealFodmaps.getMannitol() + quantityScale*ingredient.getMannitol());
            mealFodmaps.setGOS(mealFodmaps.getGOS() + quantityScale*ingredient.getGOS());
            mealFodmaps.setFructans(mealFodmaps.getFructans() + quantityScale*ingredient.getFructans());
        }
        return mealFodmaps;
    }
}
