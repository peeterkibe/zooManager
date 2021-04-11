package persistence;

import model.Schedule;
import util.DBUtil;

import javax.persistence.EntityManager;

public class ScheduleRepository {
    private EntityManager em;

    public ScheduleRepository() {
        this.em = DBUtil.getEntityManager();
    }

    public void addSchedule(Schedule schedule){
        try {
            this.em.getTransaction().begin();
            this.em.persist(schedule);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
    }

    public void updateSchedule (Schedule schedule){
        try {
            this.em.getTransaction().begin();
            this.em.merge(schedule);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
    }

    public void deleteSchedule (Schedule schedule){
        try {
            this.em.getTransaction().begin();
            this.em.remove(em.merge(schedule));
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
    }
}
