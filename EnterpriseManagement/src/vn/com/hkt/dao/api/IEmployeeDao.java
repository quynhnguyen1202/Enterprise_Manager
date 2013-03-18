/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.api;

import java.util.List;
import vn.com.hkt.data.entity.Employee;

/**
 *
 * @author QuynhNguyen
 */
public interface IEmployeeDao extends IEntityDao<Employee> {
    public List<Employee> getByName(String name);
    public List<Employee> getByCode(String code);
    public List<Employee> getByIdDepartment(long id);
}
