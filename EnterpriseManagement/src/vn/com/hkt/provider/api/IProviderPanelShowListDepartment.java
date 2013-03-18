/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.api;

import java.util.List;
import vn.com.hkt.data.entity.Department;

/**
 *
 * @author QuynhNguyen
 */
public interface IProviderPanelShowListDepartment extends IProviderListGeneral<Department> {
    public List<Department> getByIDEnt (long idEnterprise);
    public List<Department> getByEntName(String EnterpriseName);
    
}
