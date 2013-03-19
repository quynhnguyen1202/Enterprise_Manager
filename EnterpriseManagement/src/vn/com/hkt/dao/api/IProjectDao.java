/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.api;

import java.util.Date;
import java.util.List;
import vn.com.hkt.data.entity.Project;

/**
 *
 * @author QuynhNguyen
 */
public interface IProjectDao extends IEntityDao<Project> {

    public List<Project> getByName(String name);

    public List<Project> getByIdEnterPrise(long id);

    public List<Project> getByIdDepartment(long id);

    public List<Project> getByDateStart(Date dateStart);

    public List<Project> getByDateEnd(Date dateEnd);

    public List<Project> getByCode(String code);
}
