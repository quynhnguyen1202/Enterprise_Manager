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
    public List<Object> getListObject( String string) {
        try {
            String sql = "Select tbl from Enterprise tbl "+ string;
            return em.createQuery(sql).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }

    }

    @Override
    public void deleleObject() {
        Enterprise ent = new Enterprise();
        try {
            em.getTransaction().begin();
            em.remove(ent);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
    }

    @Override
    public void insertObject() {
        long Id = 0;
    String Name = null;
        Date DateActivative = null;
     long IdEnterprise = 0;
     String Slogan = null;
     String Picture = null;
     Enterprise ent= new Enterprise();
     ent.setId(Id);
     ent.setName(Name);
     ent.setDateActivative(DateActivative);
     ent.setIdEnterprise(IdEnterprise);
     ent.setPicture(Picture);
     ent.setSlogan(Slogan);
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

    
}
