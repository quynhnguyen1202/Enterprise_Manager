/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.spi;

import java.util.Date;
import java.util.List;
import vn.com.hkt.dao.api.IProjectDao;
import vn.com.hkt.data.entity.Project;

/**
 *
 * @author QuynhNguyen
 */
public class ProjectDao extends EntityDao<Project> implements IProjectDao {

    public ProjectDao() {
        setClassName(Project.class);
    }

    @Override
    public List<Project> getByName(String name) {
        String sql = "Select tbl from Project tbl where tbl." + Project.FIELD_NAME + " = ?1";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {
            return (List) em.createQuery(sql).setParameter(1, name);
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Project> getByIdEnterPrise(long id) {
        String sql = "Select tbl from Project tbl where tbl." + Project.FIELD_IDENTERPRISE + " = ?1";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {
            return  em.createQuery(sql).setParameter(1, id).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Project> getByIdDepartment(long id) {
        String sql = "Select tbl from Project tbl where tbl." + Project.FIELD_IDDEPARTMENT + " = ?1";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {
            return em.createQuery(sql).setParameter(1, id).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Project> getByDateStart(Date dateStart) {
        String sql = "Select tbl from Project tbl where tbl." + Project.FIELD_DATESTART + " = ?1";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {
            return (List) em.createQuery(sql).setParameter(1, dateStart);
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Project> getByDateEnd(Date dateEnd) {
        String sql = "Select tbl from Project tbl where tbl." + Project.FIELD_DATEEND + " = ?1";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {
            return (List) em.createQuery(sql).setParameter(1, dateEnd);
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Project> getByCode(String code) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
