/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.spi;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import vn.com.hkt.dao.api.Control;
import vn.com.hkt.data.entity.MidleProductGroup;

/**
 *
 * @author QuynhNguyen
 */
public class MidleProductGroupControl implements Control {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("EM");
    EntityManager em = emf.createEntityManager();

    @Override
    public void insertObject() {
        long Id = 0;
        long IdProduct = 0;
        long IdGroup = 0;
        MidleProductGroup mpg = new MidleProductGroup();
        mpg.setId(Id);
        mpg.setIdGroupProduct(IdGroup);
        mpg.setIdProduct(IdProduct);
        try {
            em.getTransaction().begin();
            em.persist(mpg);
            em.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            em.close();
        }
    }

    @Override
    public void updateObject() {
        MidleProductGroup mpg = new MidleProductGroup();
        try {
            em.getTransaction().begin();
            em.merge(mpg);
            em.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            em.close();
        }
    }

    @Override
    public List<Object> getListObject(String s) {
        try {
            String sql = "Select tbl from MidleProductGroup tbl  " + s;
            return em.createQuery(sql).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public void deleleObject() {
        MidleProductGroup mpg = new MidleProductGroup();
        try {
            em.getTransaction().begin();
            em.remove(mpg);
            em.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            em.close();
        }
    }
}
