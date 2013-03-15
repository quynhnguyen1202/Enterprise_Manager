/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

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
public class ProviderPanelShowListProjectMember implements IProviderPanelShowListProjectMember{
    private IProjectMemberDao iProjectMemberDao;

    public ProviderPanelShowListProjectMember() {
        iProjectMemberDao= new ProjectMemberDao();
    }
    

    @Override
    public List<ProjectMember> getListInformation() {
        List<ProjectMember> l= iProjectMemberDao.selectAll();
        return l;
    }
    
}
