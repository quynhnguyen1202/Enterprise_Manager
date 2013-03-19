/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import java.util.Date;
import java.util.List;
import vn.com.hkt.dao.api.IProjectDao;
import vn.com.hkt.dao.api.IProjectMemberDao;
import vn.com.hkt.dao.spi.ProjectMemberDao;
import vn.com.hkt.data.entity.ProjectMember;
import vn.com.hkt.provider.api.IProviderPanelShowListProjectMember;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowListProjectMember implements IProviderPanelShowListProjectMember {

    private IProjectMemberDao iProjectMemberDao;

    public ProviderPanelShowListProjectMember() {
        iProjectMemberDao = new ProjectMemberDao();
    }

    @Override
    public List<ProjectMember> getListInformation() {
        List<ProjectMember> l = iProjectMemberDao.selectAll();
        return l;
    }

    @Override
    public List<ProjectMember> getByIdProject(long id) {
        List<ProjectMember> l = iProjectMemberDao.getByIDProject(id);
        return l;
    }

    @Override
    public List<ProjectMember> getByIdEnterprise(long id) {
        List<ProjectMember> l = iProjectMemberDao.getByIDEnterprise(id);
        return l;
    }

    @Override
    public List<ProjectMember> getByDateStart(Date date) {
        List<ProjectMember> l = iProjectMemberDao.getByDateStart(date);
        return l;
    }

    @Override
    public List<ProjectMember> getByDateEnd(Date date) {
        List<ProjectMember> l = iProjectMemberDao.getByDateEnd(date);
        return l;
    }

    @Override
    public List<ProjectMember> getByCodeProjectMember(String code) {
        List<ProjectMember> l = iProjectMemberDao.getByCodeProjectMember(code);
        return l;
    }
}
