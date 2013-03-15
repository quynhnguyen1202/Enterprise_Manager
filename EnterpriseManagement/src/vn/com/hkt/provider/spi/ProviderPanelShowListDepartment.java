/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import java.util.List;
import vn.com.hkt.dao.api.IDepartmentDao;
import vn.com.hkt.dao.spi.DepartmentDao;
import vn.com.hkt.data.entity.Department;
import vn.com.hkt.provider.api.IProviderPanelShowListDepartment;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderShowListDepartment implements IProviderPanelShowListDepartment {
private IDepartmentDao iDepartmentDao;

    public ProviderShowListDepartment() {
        iDepartmentDao = new DepartmentDao();
    }

    @Override
    public List<Department> getListInformation() {
        List<Department> listdDepartments = iDepartmentDao.selectAll();
        return listdDepartments;
    }
    
}
