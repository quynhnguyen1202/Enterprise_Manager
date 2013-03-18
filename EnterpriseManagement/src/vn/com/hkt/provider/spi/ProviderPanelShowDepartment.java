/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import vn.com.hkt.dao.api.IDepartmentDao;
import vn.com.hkt.dao.spi.DepartmentDao;
import vn.com.hkt.data.entity.Department;
import vn.com.hkt.provider.api.IProviderPanelShowDepartment;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowDepartment implements IProviderPanelShowDepartment {

    Department department;
    IDepartmentDao iDepartmentDao;

    public ProviderPanelShowDepartment() {
        iDepartmentDao = new DepartmentDao();
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
      long id=getDataView().getId();
      department=iDepartmentDao.getById(id);
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
}
