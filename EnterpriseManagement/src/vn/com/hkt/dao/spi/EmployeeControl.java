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
import vn.com.hkt.data.entity.Employee;

/**
 *
 * @author QuynhNguyen
 */
public class EmployeeControl implements Control {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("EM");
    EntityManager em = emf.createEntityManager();

    @Override
    public void insertObject() {
        long Id = 0;
        String Name = null;
        long IdDeparment = 0;
        Employee emp = new Employee();
        emp.setId(Id);
        emp.setName(Name);
        emp.setIdDepartment(IdDeparment);
        try {
            em.getTransaction().begin();
            em.persist(emp);
            em.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            em.close();
        }
    }

    @Override
    public void updateObject() {
        Employee emp = new Employee();
        try {
            em.getTransaction().begin();
            em.merge(emp);
            em.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            em.close();
        }
    }

    @Override
    public List<Object> getListObject(String s) {
        try {
            String sql = "Select tbl from Employee tbl " + s;
            return em.createQuery(sql).getResultList();

        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public void deleleObject() {
       Employee emp = new Employee();
        try {
            em.getTransaction().begin();
            em.remove(emp);
            em.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            em.close();
        }  }
}
