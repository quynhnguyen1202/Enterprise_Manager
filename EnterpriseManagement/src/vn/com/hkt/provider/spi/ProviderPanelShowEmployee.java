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
public class ProviderPanelShowEmployee extends ProviderGeneral<Employee> implements IProviderPanelShowEmployee {

    public ProviderPanelShowEmployee() {
        setClassname(Employee.class);
    }

   
}
