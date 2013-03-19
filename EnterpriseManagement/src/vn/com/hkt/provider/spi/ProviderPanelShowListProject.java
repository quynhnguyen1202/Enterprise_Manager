/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import java.util.Date;
import java.util.List;
import vn.com.hkt.dao.api.IProjectDao;
import vn.com.hkt.dao.spi.ProjectDao;
import vn.com.hkt.data.entity.Project;
import vn.com.hkt.provider.api.IProviderPanelShowListProject;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowListProject implements IProviderPanelShowListProject {

    private IProjectDao iProjectDao;

    public ProviderPanelShowListProject() {
        iProjectDao = new ProjectDao();
    }

    @Override
    public List<Project> getListInformation() {
        List<Project> l = iProjectDao.selectAll();
        return l;
    }

    @Override
    public List<Project> getByName(String name) {
        List<Project> l = iProjectDao.getByName(name);
        return l;
    }

    @Override
    public List<Project> getByDateStart(Date date) {
        List<Project> l = iProjectDao.getByDateStart(date);
        return l;
    }

    @Override
    public List<Project> getByDateEnd(Date date) {
        List<Project> l = iProjectDao.getByDateEnd(date);
        return l;
    }

    @Override
    public List<Project> getByIdEnterprise(long id) {
        List<Project> l = iProjectDao.getByIdEnterPrise(id);
        return l;
    }

    @Override
    public List<Project> getByIdDepartment(long id) {
        List<Project> l = iProjectDao.getByIdDepartment(id);
        return l;
    }

    @Override
    public List<Project> getByCodeProject(String code) {
        List<Project> l = iProjectDao.getByCode(code);
        return l;
    }
}
