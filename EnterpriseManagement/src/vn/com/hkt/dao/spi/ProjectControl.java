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
import vn.com.hkt.data.entity.Project;

/**
 *
 * @author QuynhNguyen
 */
public class ProjectControl implements Control{
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("EM");
    EntityManager em= emf.createEntityManager();

    @Override
    public void insertObject() {
        long Id=0;
        String Name= null;
        String Descript= null;
        Date DateStart;
        Date DateEnd;
        Project p = new Project();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
        }
        finally 
        {
        
        em.close();}
    }

    @Override
    public void updateObject() {
        Project p = new Project();
       try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
        }
        finally 
        {
        
        em.close();}  }

    @Override
    public List<Object> getListObject(String s) {
        try {
            String sql="Select tbl from Project tbl"+s;
            return em.createQuery(sql).getResultList();
        } catch (Exception e) {
            return null;
        }
        finally{
        em.close();}
 }

    @Override
    public void deleleObject() {
        Project p = new Project();
       try {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception e) {
        }
        finally 
        {
        
        em.close();}  }
    
}
