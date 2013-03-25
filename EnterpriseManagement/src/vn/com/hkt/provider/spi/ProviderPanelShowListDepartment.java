/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import java.util.ArrayList;
import java.util.List;
import vn.com.hkt.dao.api.IDepartmentDao;
import vn.com.hkt.dao.api.IEnterpriseDao;
import vn.com.hkt.dao.spi.DepartmentDao;
import vn.com.hkt.dao.spi.EnterpriseDao;
import vn.com.hkt.data.entity.Department;
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
        List<Department> listDep = iDepartmentDao.getByEntpriseId(idEnterprise);
        if (listDep == null) {
            listDep = new ArrayList<Department>();
        }
        listDep.add(0, null);
        return listDep;
    }

    @Override
    public List<Department> getByEntName(String EnterpriseName) {
        List<Department> list1 = null;
        for (int i = 0; i < iEnterpriseDao.getIdByName(EnterpriseName).size(); i++) {
            list1 = iDepartmentDao.getByEntpriseId(i);

        }

        return list1;
    }

    @Override
    public List<Department> getByName(String name) {
        List<Department> li = iDepartmentDao.getByName(name);
        return li;
    }

    @Override
    public Department getByIdDepartment(long idDepartment) {
        return iDepartmentDao.getById(idDepartment);
    }

    
}
