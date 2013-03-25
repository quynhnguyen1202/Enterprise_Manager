/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.api;

import java.util.List;
import vn.com.hkt.data.entity.Employee;
import vn.com.hkt.data.entity.Enterprise;

/**
 *
 * @author QuynhNguyen
 */
public interface IProviderPanelShowEmployee extends IProviderGeneral<Employee> {
    public List<Enterprise> getListEnterprise();
}
