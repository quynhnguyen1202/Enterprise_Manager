/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.api;

import java.util.Date;
import java.util.List;
import vn.com.hkt.data.entity.Project;

/**
 *
 * @author QuynhNguyen
 */
public interface IProviderPanelShowListProject extends IProviderListGeneral<Project> {

    public List<Project> getByName(String name);

    public List<Project> getByDateStart(Date date);

    public List<Project> getByDateEnd(Date date);

    public List<Project> getByIdEnterprise(long id);

    public List<Project> getByIdDepartment(long id);

    public List<Project> getByCodeProject(String code);
}
