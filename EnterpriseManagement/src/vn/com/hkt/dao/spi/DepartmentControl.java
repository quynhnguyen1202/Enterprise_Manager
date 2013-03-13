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
import vn.com.hkt.data.entity.Department;

/**
 *
 * @author QuynhNguyen
 */
public class DepartmentControl implements Control {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("EM");
    EntityManager em = emf.createEntityManager();

    @Override
    public void insertObject() {
        long Id = 0;
        String Name = null;
        Date DateActivate = null;
        long IdEnterprise = 0;
        long IdDepartment = 0;
        Department dep = new Department();
        dep.setId(Id);
        dep.setName(Name);
        dep.setDateActivate(DateActivate);
        dep.setIdDepartment(IdDepartment);
        dep.setIdEnterprise(IdEnterprise);
        try {
            em.getTransaction().begin();
            em.persist(dep);
            em.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            em.close();
        }
  }

    @Override
    public void updateObject() {
        Department dep = new Department();
        try {
            em.getTransaction().begin();
            em.merge(dep);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Object> getListObject(String s) {
        try {
            String sql = "Select tbl from Department tbl " + s;
            return em.createQuery(sql).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public void deleleObject() {
        Department dep = new Department();
        try {
            em.getTransaction().begin();
            em.remove(dep);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
    }
}
