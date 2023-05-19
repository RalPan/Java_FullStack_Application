package we.final_project_thymeleaf_JDBC.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class user {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int userID;
    @Column
    private String name;
    @Column
    private String contact;

    public user() {
    }

    public user(int userID, String name, String contact) {
        this.userID = userID;
        this.name = name;
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + userID +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
