/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.spi;

import java.util.List;
import vn.com.hkt.dao.api.IEmployeeDao;
import vn.com.hkt.data.entity.Employee;

/**
 *
 * @author QuynhNguyen
 */
public class EmployeeDao extends EntityDao<Employee> implements IEmployeeDao {

    public EmployeeDao() {
        setClassName(Employee.class);
    }

    @Override
    public List<Employee> getByName(String name) {
        String sql = "Select tbl from Employee tbl where tbl." + Employee.FIELD_NAME + " like '%?1'";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {
            return em.createQuery(sql).setParameter(1, name).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Employee> getByCode(String code) {
        String sql = "Select tbl from Employee tbl where tbl." + Employee.FIELD_CODEEMPLOYEE + " like '%?1'";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {
            return em.createQuery(sql).setParameter(1, code).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Employee> getByIdDepartment(long id) {
        String sql = "Select tbl from Employee tbl where tbl." + Employee.FIELD_IDDEPARTMENT + "= ?1";
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
}
