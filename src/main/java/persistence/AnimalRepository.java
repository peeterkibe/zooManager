package persistence;

import model.Animal;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class AnimalRepository {
    private EntityManager em;
    public AnimalRepository() {
        this.em = DBUtil.getEntityManager();
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

    public List<Animal> listAnimals(){
        String sql = "select * from animal";
        return this.em.createQuery(sql, Animal.class).getResultList();

    }
}

