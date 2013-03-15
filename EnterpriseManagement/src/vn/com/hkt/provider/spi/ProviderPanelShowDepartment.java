/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import vn.com.hkt.data.entity.Department;
import vn.com.hkt.provider.api.IProviderPanelShowDepartment;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowDepartment extends ProviderGeneral<Department> implements IProviderPanelShowDepartment {

    public ProviderPanelShowDepartment() {
        setClassname(Department.class);
    }

    
}
