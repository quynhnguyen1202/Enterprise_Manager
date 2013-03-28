/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.api;

import java.util.List;
import vn.com.hkt.data.entity.Department;
import vn.com.hkt.data.entity.Employee;
import vn.com.hkt.data.entity.Enterprise;
import vn.com.hkt.data.entity.Project;

/**
 *
 * @author Administrator
 */
public interface IProviderPanelShowChartLine {
    public List<Enterprise> getListEnterprise();
    public List<Department> getListDepartmentByIdEnt(long idEnterprise);
    public List<Employee> getListEmployeeByIdDep(long idDepartment);
    public List<Project> getListProjectIdEnt(long idEnterprise);
    public List<Project> getListProject();
    public List<Project> getListProjectByIdDep(long idDepartment);
}
