/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import java.util.List;
import vn.com.hkt.dao.api.IDepartmentDao;
import vn.com.hkt.dao.api.IEnterpriseDao;
import vn.com.hkt.dao.spi.DepartmentDao;
import vn.com.hkt.dao.spi.EnterpriseDao;
import vn.com.hkt.data.entity.Department;
import vn.com.hkt.data.entity.Enterprise;
import vn.com.hkt.provider.api.IProviderPanelShowListDepartment;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowListDepartment implements IProviderPanelShowListDepartment {

    private IDepartmentDao iDepartmentDao;
    private IEnterpriseDao iEnterpriseDao;

    public ProviderPanelShowListDepartment() {
        iDepartmentDao = new DepartmentDao();
        iEnterpriseDao = new EnterpriseDao();
    }

    @Override
    public List<Department> getListInformation() {
        List<Department> listdDepartments = iDepartmentDao.selectAll();
        return listdDepartments;
    }

    @Override
    public List<Department> getByIDEnt(long idEnterprise) {
        // List<Enterprise> list1= iEnterpriseDao.getListByIdEnterprise(idEnterprise);
        return null;
    }

    @Override
    public List<Department> getByEntName(String EnterpriseName) {
        List<Department> list1 = null;
        for (int i = 0; i < iEnterpriseDao.getIdByName(EnterpriseName).size(); i++) {
            list1 = iDepartmentDao.getByEntpriseId(i);

        }

        return list1;
    }
}
