package we.final_project_thymeleaf_JDBC.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@PrimaryKeyJoinColumn
public class tolerance extends fodmap {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int toleranceID;
    @OneToMany
    @JoinColumn(name = "mealID")
    private List<meals> personmeals;

    @OneToOne(cascade = CascadeType.MERGE)
    @PrimaryKeyJoinColumn
    private user userInfo;
//for the Repository interface
    public tolerance() {
        super();
    }

    public tolerance(int toleranceID, user userInfo, int Fructose, int Lactose, int Sorbitol, int Mannitol, int GOS, int Fructans ) {
        super(Fructose,Lactose, Sorbitol, Mannitol, GOS, Fructans);
        this.userInfo = userInfo;
        this.toleranceID = toleranceID;
    }

    @Override
    public String toString() {
        return "tolerance{" +
                "toleranceID=" + toleranceID +
                ", userInfo=" + userInfo +
                '}';
    }

    public int getToleranceID() {
        return toleranceID;
    }

}
