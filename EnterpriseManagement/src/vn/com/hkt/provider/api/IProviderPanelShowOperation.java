/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.api;

import java.util.List;
import vn.com.hkt.data.entity.Department;
import vn.com.hkt.data.entity.Employee;
import vn.com.hkt.data.entity.Enterprise;
import vn.com.hkt.data.entity.Operation;
import vn.com.hkt.data.entity.Project;
import vn.com.hkt.data.entity.UnitMoney;

/**
 *
 * @author QuynhNguyen
 */
public interface IProviderPanelShowOperation extends IProviderGeneral<Operation> {
    public List<Enterprise> getListEnterprise();
    public List<Department> getListDepartmentByIDEnt(long idEnterprise);
    public List<Employee> getListEmployeeByIDDep(long idDepartment);
    public List<Project> getListProjectByIDEnt(long idEnterprise);
    public List<UnitMoney> getListUnitMoney();
}
