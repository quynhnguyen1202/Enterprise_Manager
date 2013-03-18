/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import vn.com.hkt.dao.api.IProjectDao;
import vn.com.hkt.dao.spi.ProjectDao;
import vn.com.hkt.data.entity.Project;
import vn.com.hkt.provider.api.IProviderPanelShowProject;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowProject implements IProviderPanelShowProject {

    private Project project;
    private IProjectDao iProjectDao;

    public ProviderPanelShowProject() {
        iProjectDao = new ProjectDao();
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
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
