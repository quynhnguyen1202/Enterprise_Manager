/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.api;

import java.util.Date;
import java.util.List;
import vn.com.hkt.data.entity.Department;

/**
 *
 * @author QuynhNguyen
 */
public interface IDepartmentDao extends IEntityDao<Department> {

    public List<Department> getByEntpriseId(long enterpriseId);

    public List<Department> getByName(String Name);

    public List<Department> getByDateActivate(Date date);

    public List<Department> getByIdDepartment(long IdDepartment);
}
