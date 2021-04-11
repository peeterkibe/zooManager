package persistence;


import model.Handler;
import util.DBUtil;

import javax.persistence.EntityManager;

public class HandlerRepository {
    private EntityManager em;

    public HandlerRepository() {
        this.em = DBUtil.getEntityManager();
    }

    public void addHandler(Handler handler){
        try {
            this.em.getTransaction().begin();
            this.em.persist(handler);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
    }

    public void updateHandler (Handler handler){
        try {
            this.em.getTransaction().begin();
            this.em.merge(handler);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
    }

    public void deleteHandler (Handler handler){
        try {
            this.em.getTransaction().begin();
            this.em.remove(em.merge(handler));
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
    }
}
