/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.api;

import java.util.List;
import vn.com.hkt.data.entity.Department;
import vn.com.hkt.data.entity.Enterprise;
import vn.com.hkt.data.entity.Project;

/**
 *
 * @author QuynhNguyen
 */
public interface IProviderPanelShowProject extends IProviderGeneral<Project> {
    public List<Department> getListDepartmentByIDEnt(long idEnterprise);
    public List<Enterprise> getListEnterprise();
    public Enterprise getEnterpriseByID(long idEnterprise);
}
