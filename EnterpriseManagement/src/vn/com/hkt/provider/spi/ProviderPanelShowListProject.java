/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import java.util.List;
import vn.com.hkt.dao.api.IProjectDao;
import vn.com.hkt.dao.spi.ProjectDao;
import vn.com.hkt.data.entity.Project;
import vn.com.hkt.provider.api.IProviderPanelShowListProject;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowListProject implements IProviderPanelShowListProject{
    private IProjectDao iProjectDao;

    public ProviderPanelShowListProject() {
    iProjectDao= new ProjectDao();}
    

    @Override
    public List<Project> getListInformation() {
        List<Project> l= iProjectDao.selectAll();
        return l;
    }
    
}
