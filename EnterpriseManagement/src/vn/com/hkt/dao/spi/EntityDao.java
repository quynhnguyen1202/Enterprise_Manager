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

    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("EM");
    protected EntityManager em = emf.createEntityManager();
    private Class clsName;

    @Override
    public boolean insert(E object) {
        if (em == null || !em.isOpen()) {
            em = emf.createEntityManager();
        }
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
        if (em == null || !em.isOpen()) {
            em = emf.createEntityManager();
        }
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
        if (em == null || !em.isOpen()) {
            em = emf.createEntityManager();
        }
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
        if (em == null || !em.isOpen()) {
            em = emf.createEntityManager();
        }
        try {
            return (E) em.find(clsName, id);
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

//    @Override
//    public List<E> query(String sql) {
//        if (em == null || !em.isOpen()) {
//            em = emf.createEntityManager();
//        }
//        try {
//            return (List) em.createQuery(sql);
//        } catch (Exception e) {
//            return null;
//        } finally {
//            em.close();
//        }
//    }
    @Override
    public void setClassName(Class clsName) {
        this.clsName = clsName;
    }

    @Override
    public List<E> selectAll() {
        if (em == null || !em.isOpen()) {
            em = emf.createEntityManager();
        }
        try {
            return em.createQuery("Select tbl from " + clsName.getSimpleName() + " tbl").getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
