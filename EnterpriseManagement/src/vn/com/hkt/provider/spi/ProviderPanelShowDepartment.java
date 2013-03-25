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
import vn.com.hkt.data.entity.Enterprise;
import vn.com.hkt.provider.api.IProviderPanelShowDepartment;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowDepartment implements IProviderPanelShowDepartment {

    Department department;
    IDepartmentDao iDepartmentDao;
    IEnterpriseDao iEnterpriseDao;

    public ProviderPanelShowDepartment() {
        iDepartmentDao = new DepartmentDao();
        iEnterpriseDao = new EnterpriseDao();
    }

    @Override
    public void setClassname(Class classname) {
        setClassname(Department.class);
    }

    @Override
    public void setDataView(Department object) {
        this.department = object;
    }

    @Override
    public Department getDataView() {
        if (department == null) {
            department = new Department();
        }
        return department;
    }

    @Override
    public long addData() {
        if (department != null) {
            iDepartmentDao.insert(department);
            return department.getId();
        }
        return -1;
    }

    @Override
    public long deleteData() {
        if (department != null) {
            iDepartmentDao.delete(department);
            return 1;

        }
        return -1;
    }

    @Override
    public long updateData() {
        if (department != null) {
            iDepartmentDao.update(department);
            return department.getId();

        }
        return -1;
    }

    @Override
    public void resetData() {
        department = new Department();

    }

    @Override
    public void refreshData() {
        long id = getDataView().getId();
        department = iDepartmentDao.getById(id);
    }

    @Override
    public boolean checkData() {
        if (department == null) {
            return true;
        }
        return false;
    }

    @Override
    public Department getObjectbyID(long id) {
        if (id > 0) {
            return iDepartmentDao.getById(id);
        }
        return null;

    }

    @Override
    public List<Enterprise> getListEnterprise() {
        List<Enterprise> enterprises = iEnterpriseDao.selectAll();
        if (enterprises == null) {
            enterprises = new ArrayList<Enterprise>();
        }
        enterprises.add(0, null);
        return enterprises;
    }

    @Override
    public List<Department> getListDepartmentByIDEnt(long idEnterprise) {
        List<Department> listDep = iDepartmentDao.getByEntpriseId(idEnterprise);
        if (listDep == null) {
            listDep = new ArrayList<Department>();
        }
        listDep.add(0, null);
        return listDep;

    }

    @Override
    public Enterprise getEnterpriseByID(long idEnterprise) {
        if (idEnterprise > 0) {
            return iEnterpriseDao.getById(idEnterprise);
        }
        return null;
    }
}
