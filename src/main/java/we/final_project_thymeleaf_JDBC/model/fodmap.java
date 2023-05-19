package we.final_project_thymeleaf_JDBC.model;

import jakarta.persistence.*;

@MappedSuperclass
public class fodmap {
    private float Fructose;
    private float  Lactose;
    private float  Sorbitol;
    private float  Mannitol;
    private float  GOS;
    private float  Fructans;

    @Override
    public String toString() {
        return "fodmap{" +
                "Fructose=" + Fructose +
                ", Lactose=" + Lactose +
                ", Sorbitol=" + Sorbitol +
                ", Mannitol=" + Mannitol +
                ", GOS=" + GOS +
                ", Fructans=" + Fructans +
                '}';
    }

    public fodmap() {
    }

    public fodmap(int fructose, int lactose, int sorbitol, int mannitol, int GOS, int fructans) {
        this.Fructose = fructose;
        this.Lactose = lactose;
        this.Sorbitol = sorbitol;
        this.Mannitol = mannitol;
        this.GOS = GOS;
        this.Fructans = fructans;
    }

    public void setFructose(float fructose) {
        Fructose = fructose;
    }

    public void setLactose(float lactose) {
        Lactose = lactose;
    }

    public void setSorbitol(float sorbitol) {
        Sorbitol = sorbitol;
    }

    public void setMannitol(float mannitol) {
        Mannitol = mannitol;
    }

    public void setGOS(float GOS) {
        this.GOS = GOS;
    }

    public void setFructans(float fructans) {
        Fructans = fructans;
    }

    public float getFructose() {
        return Fructose;
    }

    public float getLactose() {
        return Lactose;
    }

    public float getSorbitol() {
        return Sorbitol;
    }

    public float getMannitol() {
        return Mannitol;
    }

    public float getGOS() {
        return GOS;
    }

    public float getFructans() {
        return Fructans;
    }
}
