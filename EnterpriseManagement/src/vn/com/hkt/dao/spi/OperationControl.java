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
import vn.com.hkt.data.entity.Operation;

/**
 *
 * @author QuynhNguyen
 */
public class OperationControl implements Control {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("EM");
    EntityManager em = emf.createEntityManager();

    @Override
    public void insertObject() {
        long Id = 0;
        long IdProject = 0;
        float MoneyTotal = 0;
        float MoneyAfterTax = 0;
        float MoneyAfterDiscount = 0;
        Date DateExecute = null;
        long IdEmployee=0;
        long IdDepartment = 0;
        long IdEnterprise = 0;

        Operation ope = new Operation(Id, IdProject, MoneyTotal, MoneyAfterTax, MoneyAfterDiscount, IdEnterprise, IdDepartment, DateExecute, IdEmployee);

        try {
            em.getTransaction().begin();
            em.persist(ope);
            em.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            em.close();
        }
    }

    @Override
    public void updateObject() {
        Operation ope = new Operation();
        try {
            em.getTransaction().begin();
            em.merge(ope);
            em.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            em.close();
        }
    }

    @Override
    public List<Object> getListObject(String s) {
        try {
            String sql = "Select tbl from Operation tbl " + s;
            return em.createQuery(sql).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public void deleleObject() {
        Operation ope = new Operation();
        try {
            em.getTransaction().begin();
            em.remove(ope);
            em.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            em.close();
        }
    }
}
