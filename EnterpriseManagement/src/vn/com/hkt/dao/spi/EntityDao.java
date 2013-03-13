/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.spi;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import vn.com.hkt.dao.api.IEntityDao;

/**
 *
 * @author QuynhNguyen
 */
public class EntityDao<E> implements IEntityDao<E> {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("EM");
    EntityManager em = emf.createEntityManager();

    @Override
    public boolean insert(E object) {
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean update(E object) {
        try {
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean delete(E object) {
        try {
            em.getTransaction().begin();
            em.remove(object);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public E getById(long id) {
        try {
            String sql = "Select tbl from ?1 where object.id = ?1";
            return (E) em.createQuery(sql).setParameter(1, id).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<E> query(String sql) {
        try {
            return (List) em.createQuery(sql);
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }
}
