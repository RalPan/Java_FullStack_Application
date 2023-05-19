package we.final_project_thymeleaf_JDBC.DAOs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import we.final_project_thymeleaf_JDBC.model.user;

public interface userRepo extends JpaRepository<user, Integer> {

    public int findByName(String name);
}
