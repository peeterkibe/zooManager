package model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Cage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCage;
    private String enclosureName;

    public int getIdCage() { return idCage; }

    public void setIdCage(int idCage) { this.idCage = idCage;}

    public String getEnclosureName() { return enclosureName; }

    public void setEnclosureName(String enclosureName) { this.enclosureName = enclosureName; }

    @Override
    public String toString() {
        return "Cage{" +
                "idCage=" + idCage +
                ", enclosureName='" + enclosureName + '\'' +
                '}';
    }
}
