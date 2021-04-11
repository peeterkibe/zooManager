package persistence;

import model.Veterinarian;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class VeterinarianRepository {
    private EntityManager em;

    public VeterinarianRepository() {
        this.em = DBUtil.getEntityManager();
    }

    public void addVeterinarian(Veterinarian veterinarian){
        try {
            this.em.getTransaction().begin();
            this.em.persist(veterinarian);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
    }

    public void updateVeterinarian (Veterinarian veterinarian){
        try {
            this.em.getTransaction().begin();
            this.em.merge(veterinarian);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
    }

    public void deleteVeterinarian (Veterinarian veterinarian){
        try {
            this.em.getTransaction().begin();
            this.em.remove(em.merge(veterinarian));
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }

    }
    public List<Veterinarian> searchByName(String name) {
        return this.em.createQuery("SELECT m FROM Veterinarian m WHERE m.name = ?1", Veterinarian.class).
                setParameter(1, name).
                getResultList();
    }
}
