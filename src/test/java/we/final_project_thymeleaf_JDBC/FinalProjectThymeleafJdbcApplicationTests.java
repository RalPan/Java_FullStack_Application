package we.final_project_thymeleaf_JDBC;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import we.final_project_thymeleaf_JDBC.model.meals;
import we.final_project_thymeleaf_JDBC.service.*;
import we.final_project_thymeleaf_JDBC.DAOs.*;

import we.final_project_thymeleaf_JDBC.model.ingredients;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FinalProjectThymeleafJdbcApplicationTests {
	@Autowired
	private inputValidation inputValidation;
	@Autowired
	private ingredientRepo ingredientRepo;
	@Autowired
	private toleranceRepo toleranceRepo;
	@Autowired
	private mealRepo mealRepo;

	public boolean isValid(String ingredientList) {
		return inputValidation.ingredientsValid(ingredientList);
	}
	@Test
	void testIngredientRepo() {
		
		assertEquals(3,ingredientRepo.findByName("tomato").getIngredientID());
		List<ingredients> allIngredients = ingredientRepo.findAll();
		assertTrue(allIngredients.size() > 1);
		int id = allIngredients.size() + 1;
		ingredients ing = new ingredients(id, "test ingredient", 100, "ml", 12, 24, 12, 1, 0,3);
		ingredientRepo.save(ing);
		assertEquals(id,ingredientRepo.findByName("test ingredient").getIngredientID());
		ingredientRepo.delete(ing);
	}
	@Test
	void testMealRepo() {

		List<meals> allMeals = mealRepo.findAll();
		assertTrue(allMeals.size() >= 1);
		List<meals> userMeals = mealRepo.findByTolerance(1);
	}
	@Test
	void validIngredients() {
		assertTrue(isValid("tomato: 20g, milk: 30ml"));
		assertTrue(isValid("tomato: 5g, feta cheese: 5g, milk: 30ml"));
	}

	@Test
	void invalidIngredients() {
		assertFalse(isValid("tomato: 20g, cucumber: g, milk: 30ml"));
		assertFalse(isValid("tomato: 20g, feta cheese 5g, milk 30ml"));
		assertFalse(isValid("tomato: 20g"));
		assertFalse(isValid("tomato: 20"));
		assertFalse(isValid("tomato: 20g cucumber: g milk: 30ml"));
		assertFalse(isValid("tomato, 20ml: feta cheese 5g: milk 30ml"));
		assertFalse(isValid("tomato 20ml: feta cheese 5g: milk 30ml"));
	}
	@Test
	void contextLoads() {
	}

}
