package we.final_project_thymeleaf_JDBC.DAOs;

import org.springframework.data.jpa.repository.JpaRepository;
import we.final_project_thymeleaf_JDBC.model.ingredients;

public interface ingredientRepo extends JpaRepository<ingredients, Integer> {
    public ingredients findByName(String name);
}
