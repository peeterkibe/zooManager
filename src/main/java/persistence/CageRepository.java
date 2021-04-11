package persistence;

import model.AnimalType;
import model.Cage;
import util.DBUtil;

import javax.persistence.EntityManager;

public class CageRepository {

    private EntityManager em;
    public CageRepository() {
        this.em = DBUtil.getEntityManager();
    }

    public CageRepository (DBUtil dbUtil) {
    }

    public void saveCage(Cage cage) {
        try {
            this.em.getTransaction().begin();
            this.em.persist(cage);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
    }

    public void updateCage(Cage cage) {
        try {
            this.em.getTransaction().begin();
            this.em.merge(cage);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
    }

    public void deleteCage(Cage cage) {
        try {
            this.em.getTransaction().begin();
            this.em.remove(em.merge(cage));
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
    }
}

