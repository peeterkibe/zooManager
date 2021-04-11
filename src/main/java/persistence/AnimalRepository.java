package persistence;

import model.Animal;
import util.DBUtil;

import javax.persistence.EntityManager;

public class AnimalRepository {
    private EntityManager em;
    public AnimalRepository() {
        this.em = DBUtil.getEntityManager();
    }

    public AnimalRepository (DBUtil dbUtil) {
    }

    public void saveAnimal(Animal animal) {
        try {
            this.em.getTransaction().begin();
            this.em.persist(animal);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
    }

    public void updateAnimal(Animal animal) {
        try {
            this.em.getTransaction().begin();
            this.em.merge(animal);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
    }

    public void deleteAnimal(Animal animal) {
        try {
            this.em.getTransaction().begin();
            this.em.remove(em.merge(animal));
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
    }
}

