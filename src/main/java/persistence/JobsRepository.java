package persistence;

import model.Jobs;
import model.Schedule;
import util.DBUtil;

import javax.persistence.EntityManager;

public class JobsRepository {
    private EntityManager em;

    public JobsRepository() {
        this.em = DBUtil.getEntityManager();
    }

    public void addJob(Jobs jobs){
        try {
            this.em.getTransaction().begin();
            this.em.persist(jobs);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
    }

    public void updateJob (Jobs jobs){
        try {
            this.em.getTransaction().begin();
            this.em.merge(jobs);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
    }

    public void deleteJob (Jobs jobs){
        try {
            this.em.getTransaction().begin();
            this.em.remove(em.merge(jobs));
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
    }
}
