/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import vn.com.hkt.dao.api.IEmployeeDao;
import vn.com.hkt.dao.spi.EmployeeDao;
import vn.com.hkt.data.entity.Employee;
import vn.com.hkt.provider.api.IProviderPanelShowEmployee;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowEmployee implements IProviderPanelShowEmployee {

    private Employee employee;
    private IEmployeeDao iEmployeeDao;

    public ProviderPanelShowEmployee() {
        iEmployeeDao = new EmployeeDao();
    }

    @Override
    public void setClassname(Class classname) {
        setClassname(Employee.class);
    }

    @Override
    public void setDataView(Employee object) {
        this.employee = object;
    }

    @Override
    public Employee getDataView() {
        if (employee == null) {
            employee = new Employee();

        }
        return employee;
    }

    @Override
    public long addData() {
        if (employee != null) {
            iEmployeeDao.insert(employee);
            return employee.getId();
        }
        return -1;
    }

    @Override
    public long deleteData() {
        if (employee != null) {
            iEmployeeDao.delete(employee);
            return 1;
        }
        return -1;
    }

    @Override
    public long updateData() {
        if (employee != null) {
            iEmployeeDao.update(employee);
            return employee.getId();
        }
        return -1;
    }

    @Override
    public void resetData() {
        employee = new Employee();
    }

    @Override
    public void refreshData() {
        employee = iEmployeeDao.getById(getDataView().getId());
    }

    @Override
    public boolean checkData() {
        if (employee == null) {
            return true;
        }
        return false;
    }

    @Override
    public Employee getObjectbyID(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
