package we.final_project_thymeleaf_JDBC.DAOs;

import org.springframework.data.jpa.repository.JpaRepository;
import we.final_project_thymeleaf_JDBC.model.meals;

import java.util.List;

public interface mealRepo extends JpaRepository<meals, Integer> {
    public List<meals> findByTolerance(int toleranceID);
}
