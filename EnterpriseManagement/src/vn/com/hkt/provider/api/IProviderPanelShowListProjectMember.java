/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.api;

import java.util.Date;
import java.util.List;
import vn.com.hkt.data.entity.ProjectMember;

/**
 *
 * @author QuynhNguyen
 */
public interface IProviderPanelShowListProjectMember extends IProviderListGeneral<ProjectMember> {

    public List<ProjectMember> getByIdProject(long id);

    public List<ProjectMember> getByIdEnterprise(long id);

    public List<ProjectMember> getByDateStart(Date date);

    public List<ProjectMember> getByDateEnd(Date date);

    public List<ProjectMember> getByCodeProjectMember(String code);
}
