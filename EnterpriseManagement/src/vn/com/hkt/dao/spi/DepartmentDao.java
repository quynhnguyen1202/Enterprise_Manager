/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.spi;

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
}
