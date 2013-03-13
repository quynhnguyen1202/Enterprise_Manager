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
import vn.com.hkt.data.entity.Product;

/**
 *
 * @author QuynhNguyen
 */
public class ProductControl implements Control {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("EM");
    EntityManager em = emf.createEntityManager();

    @Override
    public void insertObject() {
        long Id = 0;
        String Name = null;
        long IdEnterprise = 0;
        long IdDepartment = 0;
        Product pr = new Product();
        pr.setId(Id);
        pr.setName(Name);
        pr.setIdDepartment(IdDepartment);
        pr.setIdEnterprise(IdEnterprise);
        try {
            em.getTransaction().begin();
            em.persist(pr);
            em.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            em.close();
        }
    }

    @Override
    public void updateObject() {
        Product pr = new Product();
        try {
            em.getTransaction().begin();
            em.merge(pr);
            em.getTransaction().commit();

        } catch (Exception e) {
        } finally {
            em.close();
        }
    }

    @Override
    public List<Object> getListObject(String s) {
        try {
            String sql = "Select tbl from Product tbl " + s;
            return em.createQuery(sql).getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void deleleObject() {
        Product pr = new Product();
        try {
            em.getTransaction().begin();
            em.remove(pr);
            em.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            em.close();
        }
    }
}
