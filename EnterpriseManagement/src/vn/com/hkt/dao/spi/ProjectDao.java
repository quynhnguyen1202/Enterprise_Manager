/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.spi;

import vn.com.hkt.dao.api.IProjectDao;
import vn.com.hkt.data.entity.Project;

/**
 *
 * @author QuynhNguyen
 */
public class ProjectDao extends EntityDao<Project> implements IProjectDao {
    
    public ProjectDao() {
        setClassName(Project.class);
    }
}
