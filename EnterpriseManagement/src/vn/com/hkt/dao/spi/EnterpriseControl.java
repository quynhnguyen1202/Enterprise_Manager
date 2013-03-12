/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.spi;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import vn.com.hkt.dao.api.Control;
import vn.com.hkt.data.entity.Enterprise;

/**
 *
 * @author QuynhNguyen
 */
public class EnterpriseControl implements Control {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("EM");
    EntityManager em = emf.createEntityManager();

    public void insertObject(long Id, String Name, Date DateActivative, long IdEnterprise, String Slogan, String Picture) {
        Enterprise ent = new Enterprise(Id, Name, DateActivative, IdEnterprise, Slogan, Picture);
        try {
            em.getTransaction().begin();
            em.persist(ent);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }

    }

    @Override
    public void updateObject() {
        Enterprise ent = new Enterprise();
        try {
            em.getTransaction().begin();
            em.merge(ent);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Object> getListObject(long id) {
        try {
            String sql = "Select tbl from Enterprise tbl where Id=?1";
            return em.createQuery(sql).setParameter(1, id).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }

    }

    @Override
    public void deleleObject() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void insertObject() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateObject(long id) {
        List<Object> list1 = getListObject(id);

        if (list1 != null && !list1.isEmpty()) {
            for (Object en : list1) {
                
            }

        }
    }
}
