/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.api;

import java.util.List;
import vn.com.hkt.dao.spi.EntityDao;
import vn.com.hkt.data.entity.Department;

/**
 *
 * @author QuynhNguyen
 */
public interface  IDepartmentDao extends IEntityDao<Department> {
    public List<Department> getByIdDepartment( long IdDepartment);
}
