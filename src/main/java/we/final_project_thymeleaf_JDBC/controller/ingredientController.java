package we.final_project_thymeleaf_JDBC.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import we.final_project_thymeleaf_JDBC.model.ingredients;
import we.final_project_thymeleaf_JDBC.DAOs.ingredientRepo;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
@CrossOrigin
public class ingredientController {
    @Autowired
    private ingredientRepo ingredientRepo;


    @GetMapping("/ingredients")
    public ResponseEntity<List<ingredients>> allIngredients() {
        List<ingredients> ingredients = ingredientRepo.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(ingredients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ingredients> getIngredientsById(@PathVariable("id") Integer id) {
        ingredients ingredients = ingredientRepo.getReferenceById(id);
        return new ResponseEntity<ingredients>(ingredients, HttpStatus.OK);
    }
//I don't know how to use what is past this point
    @PostMapping("/add")
    public ResponseEntity<Void> addNewIngredients(@RequestBody ingredients course) {
        ingredientRepo.save(course);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredients(@PathVariable("id") Integer id) {
        ingredientRepo.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ingredients> updateIngredients(@PathVariable("id") Integer id, @RequestBody ingredients course) {
        ingredientRepo.save(course);
        return new ResponseEntity<ingredients>(course, HttpStatus.OK);
    }
}
