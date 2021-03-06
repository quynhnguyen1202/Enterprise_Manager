/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import java.util.List;
import vn.com.hkt.dao.api.IEmployeeDao;
import vn.com.hkt.dao.spi.EmployeeDao;
import vn.com.hkt.data.entity.Employee;
import vn.com.hkt.provider.api.IProviderListGeneral;
import vn.com.hkt.provider.api.IProviderPanelShowListEmployee;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowListEmployee implements IProviderPanelShowListEmployee {

    private IEmployeeDao iEmployeeDao;

    public ProviderPanelShowListEmployee() {
        iEmployeeDao = new EmployeeDao();
    }

    @Override
    public List<Employee> getListInformation() {
        List<Employee> listEmployees = iEmployeeDao.selectAll();
        return listEmployees;
    }

    @Override
    public List<Employee> getByName(String name) {
        List<Employee> l = iEmployeeDao.getByName(name);
        return l;
    }

    @Override
    public List<Employee> getByIdDepartment(long idDepartment) {
        List<Employee> l = iEmployeeDao.getByIdDepartment(idDepartment);
        return l;
    }

    @Override
    public List<Employee> getByCodeEmployee(String code) {
        List<Employee> l = iEmployeeDao.getByCode(code);
        return l;
    }

    @Override
    public Employee getByIdEmployee(long idEmployee) {
        return iEmployeeDao.getById(idEmployee);
    }
}
