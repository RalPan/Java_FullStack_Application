package we.final_project_thymeleaf_JDBC.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@PrimaryKeyJoinColumn
public class ingredients extends fodmap {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int ingredientID;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private String unit;
    @ManyToMany(mappedBy = "mealIngredients")
    Set<meals> inMeals;

    public ingredients() {
    }

    public ingredients(int ingredientID, String name, int quantity, String unit, int Fructose, int Lactose, int Sorbitol,
                       int Mannitol, int GOS, int Fructans ) {
        super(Fructose,Lactose, Sorbitol, Mannitol, GOS, Fructans);
        this.ingredientID = ingredientID;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;

    }

    @Override
    public String toString() {
        return "ingredients{" +
                "ingredientID=" + ingredientID +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                '}';
    }

    public int getIngredientID() {
        return ingredientID;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

}
