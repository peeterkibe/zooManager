package model;

import javax.persistence.*;

@Entity
public class AnimalType {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int idAnimalType;
     private String animalType;
     private String feed;
     private int speciesOfAnimals;

     @ManyToOne
     @JoinColumn (name = "speciesOfAnimal")
     private Animal animal;

    public int getIdAnimalType() {
        return idAnimalType;
    }

    public void setIdAnimalType(int idAnimalType) {
        this.idAnimalType = idAnimalType;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getFeed() {
        return feed;
    }

    public void setFeed(String feed) {
        this.feed = feed;
    }

    public int getSpeciesOfAnimals() {
        return speciesOfAnimals;
    }

    public void setSpeciesOfAnimals(int speciesOfAnimals) {
        this.speciesOfAnimals = speciesOfAnimals;
    }

    @Override
    public String toString() {
        return "AnimalType{" +
                "idAnimalType=" + idAnimalType +
                ", animalType='" + animalType + '\'' +
                ", feed='" + feed + '\'' +
                ", speciesOfAnimals=" + speciesOfAnimals +
                '}';
    }
}
