package persistence;

import model.Login;
import util.DBUtil;
import javax.persistence.EntityManager;

public class LoginRepository {

        private EntityManager em;

    public LoginRepository() {
        this.em = DBUtil.getEntityManager();
    }

    public boolean validateLogin(Login login) {
        String sql = "from Login where userName = :loginName and password = :loginPassWord";
            Login loginResult = em.createQuery(sql, Login.class)
                    .setParameter("loginName", login.getUserName())
                    .setParameter("loginPassWord", login.getPassword())
                    .getSingleResult();
//        if(loginResult != null)  {
//            return true;
//        }
//        return false;

            return (loginResult != null) ? true : false;
        }

        public void saveLogin(Login login) {
            try {
                this.em.getTransaction().begin();
                this.em.persist(login);
                this.em.getTransaction().commit();
            } catch (Exception e) {
                this.em.getTransaction().rollback();
            }
        }
    }


