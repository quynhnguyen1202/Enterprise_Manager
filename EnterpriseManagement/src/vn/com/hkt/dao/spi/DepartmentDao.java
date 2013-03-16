/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.spi;

import java.util.List;
import vn.com.hkt.dao.api.IDepartmentDao;
import vn.com.hkt.data.entity.Department;

/**
 *
 * @author QuynhNguyen
 */
public class DepartmentDao extends EntityDao<Department> implements IDepartmentDao {
    DepartmentDao departmentDao = new DepartmentDao();
    public DepartmentDao() {
        setClassName(Department.class);
    
    }

    @Override
    public List<Department> getByIdDepartment(long IdDepartment) {
        String sql = "Select dep from Department dep where dep.IdDepartment = ?1";
        return departmentDao.em.createQuery(sql).setParameter(1, IdDepartment).getResultList();
    }
}
