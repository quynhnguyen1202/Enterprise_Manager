/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.spi;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import vn.com.hkt.dao.api.Control;
import vn.com.hkt.data.entity.ProductGroup;

/**
 *
 * @author QuynhNguyen
 */
public class ProductGroupControl implements Control{
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("EM");
    EntityManager em= emf.createEntityManager();

    @Override
    public void insertObject() {
        long Id=0;
    String Name= null;
    long IdProductGroup=0;
    long IdEnterprise=0;
    
    ProductGroup pg= new ProductGroup();
    pg.setId(Id);
    pg.setName(Name);
    pg.setIdEnterprise(IdEnterprise);
    pg.setIdProductGroup(IdProductGroup);
        try {
            em.getTransaction().begin();
            em.persist(pg);
            em.getTransaction().commit();
        } catch (Exception e) {
        }
        finally
        {
        em.close();
        }
    }

    @Override
    public void updateObject() {
        ProductGroup pg= new ProductGroup();
       try {
            em.getTransaction().begin();
            em.merge(pg);
            em.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            em.close();
        }   }

    @Override
    public List<Object> getListObject(String s) {
       try {
            String sql = "Select tbl from ProductGroup tbl " + s;
            return em.createQuery(sql).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }  }

    @Override
    public void deleleObject() {
        ProductGroup pg= new ProductGroup();
        try {
            em.getTransaction().begin();
            em.remove(pg);
            em.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            em.close();
        } }
    
}
