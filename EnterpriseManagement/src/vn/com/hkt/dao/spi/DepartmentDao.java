/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.spi;

import java.util.Date;
import java.util.List;
import vn.com.hkt.dao.api.IDepartmentDao;
import vn.com.hkt.data.entity.Department;

/**
 *
 * @author QuynhNguyen
 */
public class DepartmentDao extends EntityDao<Department> implements IDepartmentDao {

    public DepartmentDao() {
        setClassName(Department.class);

    }

    @Override
    public List<Department> getByEntpriseId(long enterpriseId) {
        String sql = "Select tbl from Department tbl where tbl.IdEnterprise = ?1";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            return em.createQuery(sql).setParameter(1, enterpriseId).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Department> getByName(String Name) {
       String sql = "Select tbl from Department tbl where tbl.Name = ?1";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            return em.createQuery(sql).setParameter(1,Name ).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Department> getByDateActivate(Date date) {
        String sql = "Select tbl from Department tbl where tbl.DateActivate = ?1";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            return em.createQuery(sql).setParameter(1, date).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Department> getByIdDepartment(long IdDepartment) {
        String sql = "Select tbl from Department tbl where tbl.IdDepartment = ?1";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            return em.createQuery(sql).setParameter(1, IdDepartment).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }
}
