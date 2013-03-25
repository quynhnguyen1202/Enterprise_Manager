/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.api;

import java.util.List;
import vn.com.hkt.data.entity.Employee;

/**
 *
 * @author QuynhNguyen
 */
public interface IProviderPanelShowListEmployee extends IProviderListGeneral<Employee> {

    public List<Employee> getByName(String name);

    public List<Employee> getByIdDepartment(long idDepartment);

    public List<Employee> getByCodeEmployee(String code);

    public Employee getByIdEmployee(long idEmployee);
}
