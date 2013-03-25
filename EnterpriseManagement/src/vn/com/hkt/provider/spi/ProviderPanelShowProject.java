/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import java.util.ArrayList;
import java.util.List;
import vn.com.hkt.dao.api.IDepartmentDao;
import vn.com.hkt.dao.api.IEnterpriseDao;
import vn.com.hkt.dao.api.IProjectDao;
import vn.com.hkt.dao.spi.DepartmentDao;
import vn.com.hkt.dao.spi.EnterpriseDao;
import vn.com.hkt.dao.spi.ProjectDao;
import vn.com.hkt.data.entity.Department;
import vn.com.hkt.data.entity.Enterprise;
import vn.com.hkt.data.entity.Project;
import vn.com.hkt.provider.api.IProviderPanelShowProject;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowProject implements IProviderPanelShowProject {

    private Project project;
    private IProjectDao iProjectDao;
    private IDepartmentDao iDepartmentDao;
    private IEnterpriseDao iEnterpriseDao;

    public ProviderPanelShowProject() {
        iProjectDao = new ProjectDao();
        iDepartmentDao = new DepartmentDao();
        iEnterpriseDao = new EnterpriseDao();
    }

    @Override
    public void setClassname(Class classname) {
        setClassname(Project.class);
    }

    @Override
    public void setDataView(Project object) {
        this.project = object;
    }

    @Override
    public Project getDataView() {
        if (project == null) {
            project = new Project();

        }
        return project;
    }

    @Override
    public long addData() {
        if (project != null) {
            iProjectDao.insert(project);
            return project.getId();
        }
        return -1;
    }

    @Override
    public long deleteData() {
        if (project != null) {
            iProjectDao.delete(project);
            return project.getId();
        }
        return -1;
    }

    @Override
    public long updateData() {
        if (project != null) {
            iProjectDao.update(project);
            return project.getId();
        }
        return -1;
    }

    @Override
    public void resetData() {
        project = new Project();
    }

    @Override
    public void refreshData() {
        project = iProjectDao.getById(getDataView().getId());
    }

    @Override
    public boolean checkData() {
        if (project == null) {
            return true;

        }
        return false;
    }

    @Override
    public Project getObjectbyID(long id) {
        if (id > 0) {
            return iProjectDao.getById(id);
        }
        return null;
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
    public List<Enterprise> getListEnterprise() {
        List<Enterprise> enterprises = iEnterpriseDao.selectAll();
        if (enterprises == null) {
            enterprises = new ArrayList<Enterprise>();
        }
        enterprises.add(0, null);
        return enterprises;
    }

    @Override
    public Enterprise getEnterpriseByID(long idEnterprise) {
        if (idEnterprise > 0) {
            return iEnterpriseDao.getById(idEnterprise);
        }
        return null;
    }
}
