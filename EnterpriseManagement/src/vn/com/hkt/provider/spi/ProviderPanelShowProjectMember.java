/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import vn.com.hkt.dao.api.IProjectMemberDao;
import vn.com.hkt.dao.spi.ProjectMemberDao;
import vn.com.hkt.data.entity.ProjectMember;
import vn.com.hkt.provider.api.IProviderPanelShowProjectMember;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowProjectMember implements IProviderPanelShowProjectMember {

    private ProjectMember projectMember;
    private IProjectMemberDao iProjectMemberDao;

    public ProviderPanelShowProjectMember() {
        iProjectMemberDao = new ProjectMemberDao();
    }

    @Override
    public void setClassname(Class classname) {
        setClassname(ProjectMember.class);
    }

    @Override
    public void setDataView(ProjectMember object) {
        this.projectMember = object;
    }

    @Override
    public ProjectMember getDataView() {
        if (projectMember == null) {
            projectMember = new ProjectMember();
        }
        return projectMember;
    }

    @Override
    public long addData() {
        if (projectMember != null) {
            iProjectMemberDao.insert(projectMember);
            return projectMember.getId();

        }
        return -1;
    }

    @Override
    public long deleteData() {
        if (projectMember != null) {
            iProjectMemberDao.delete(projectMember);
            return projectMember.getId();

        }
        return -1;
    }

    @Override
    public long updateData() {
        if (projectMember != null) {
            iProjectMemberDao.update(projectMember);
            return projectMember.getId();

        }
        return -1;
    }

    @Override
    public void resetData() {
        projectMember = new ProjectMember();
    }

    @Override
    public void refreshData() {
        projectMember = iProjectMemberDao.getById(getDataView().getId());
    }

    @Override
    public boolean checkData() {
        if (projectMember == null) {
            return true;
        }
        return false;
    }

    @Override
    public ProjectMember getObjectbyID(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
