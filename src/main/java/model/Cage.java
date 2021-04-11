package model;


import javax.persistence.*;


@Entity
public class Cage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCage;
    private String enclosureName;
    private int AnimalType;

    @ManyToOne
    @JoinColumn (name = "idHandler")
    private Handler handler;

    @OneToMany
    @JoinColumn (name = "AnimalType")
    private AnimalType animalType;

    public int getAnimalType() { return AnimalType; }

    public void setAnimalType(int animalType) { AnimalType = animalType;}

    public int getIdCage() { return idCage; }

    public void setIdCage(int idCage) { this.idCage = idCage;}

    public String getEnclosureName() { return enclosureName; }

    public void setEnclosureName(String enclosureName) { this.enclosureName = enclosureName; }

    public Handler getHandler() { return handler; }

    public void setHandler(Handler handler) { this.handler = handler; }

    @Override
    public String toString() {
        return "Cage{" +
                "idCage=" + idCage +
                ", enclosureName='" + enclosureName + '\'' +
                '}';
    }


}
