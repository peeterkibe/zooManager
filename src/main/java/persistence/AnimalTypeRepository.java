package persistence;

import model.Animal;
import model.AnimalType;
import util.DBUtil;

import javax.persistence.EntityManager;

public class AnimalTypeRepository {

    private EntityManager em;
    public AnimalTypeRepository() {
        this.em = DBUtil.getEntityManager();
    }


    public void saveAnimalType(AnimalType animalType) {
        try {
            this.em.getTransaction().begin();
            this.em.persist(animalType);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
    }

    public void updateAnimalType(AnimalType animalType) {
        try {
            this.em.getTransaction().begin();
            this.em.merge(animalType);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
    }

    public void deleteAnimalType(AnimalType animalType) {
        try {
            this.em.getTransaction().begin();
            this.em.remove(em.merge(animalType));
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
    }

    public void addAnimalType(AnimalType animalType) {
    }
}