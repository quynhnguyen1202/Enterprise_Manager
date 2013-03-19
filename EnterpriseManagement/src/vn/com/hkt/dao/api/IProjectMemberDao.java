/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.api;

import java.util.Date;
import java.util.List;
import vn.com.hkt.data.entity.ProjectMember;

/**
 *
 * @author QuynhNguyen
 */
public interface IProjectMemberDao extends IEntityDao<ProjectMember> {

    public List<ProjectMember> getByIDProject(long idProject);

    public List<ProjectMember> getByIDEnterprise(long idEnterprise);

    public List<ProjectMember> getByDateStart(Date dateStart);

    public List<ProjectMember> getByDateEnd(Date dateEnd);

    public List<ProjectMember> getByCodeProjectMember(String code);
}
