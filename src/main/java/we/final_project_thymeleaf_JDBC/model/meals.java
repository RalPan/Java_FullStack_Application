package we.final_project_thymeleaf_JDBC.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.Jsr310Converters;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Entity
public class meals {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int mealID;
    @ManyToOne
    @JoinColumn(name = "toleranceID")
    private tolerance tolerance;
    @Column
    private String name;
    @Column
    private String ingredients;
    @Column
    private LocalDateTime time;

    @ManyToMany
    @JoinTable(name = "mealIngredients",
    joinColumns = {@JoinColumn(name = "mealID")},
    inverseJoinColumns = {@JoinColumn(name = "ingredientID")})
    private Set<ingredients> mealIngredients;

    public meals() {
        LocalDateTime date = LocalDateTime.now();
        this.time = date;
    }

    public meals(int mealID, tolerance tolerance, String name, String ingredients, LocalDateTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        this.mealID = mealID;
        this.tolerance = tolerance;
        this.name = name;
        this.ingredients = ingredients;
        this.time = LocalDateTime.parse(time.format(formatter));
    }


    public int getMealID() {
        return mealID;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public we.final_project_thymeleaf_JDBC.model.tolerance getTolerance() {
        return tolerance;
    }

    public void setTolerance(we.final_project_thymeleaf_JDBC.model.tolerance tolerance) {
        this.tolerance = tolerance;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
