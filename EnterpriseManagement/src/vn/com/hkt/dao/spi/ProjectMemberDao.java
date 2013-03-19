/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.spi;

import java.util.Date;
import java.util.List;
import vn.com.hkt.dao.api.IProjectMemberDao;
import vn.com.hkt.data.entity.ProjectMember;

/**
 *
 * @author QuynhNguyen
 */
public class ProjectMemberDao extends EntityDao<ProjectMember> implements IProjectMemberDao {

    public ProjectMemberDao() {
        setClassName(ProjectMember.class);
    }

    @Override
    public List<ProjectMember> getByIDProject(long idProject) {
        String sql = "Select tbl from ProjectMember tbl where tbl." + ProjectMember.FIELD_IDPROJECT + " =?1 ";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            return em.createQuery(sql).setParameter(1, idProject).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<ProjectMember> getByIDEnterprise(long idEnterprise) {
        String sql = "Select tbl from ProjectMember tbl where tbl." + ProjectMember.FIELD_IDENTERPRISE + " =?1 ";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            return em.createQuery(sql).setParameter(1, idEnterprise).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<ProjectMember> getByDateStart(Date dateStart) {
        String sql = "Select tbl from ProjectMember tbl where tbl." + ProjectMember.FIELD_DATESTART + " =?1 ";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            return em.createQuery(sql).setParameter(1, dateStart).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<ProjectMember> getByDateEnd(Date dateEnd) {
        String sql = "Select tbl from ProjectMember tbl where tbl." + ProjectMember.FIELD_DATEEND + " =?1 ";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            return em.createQuery(sql).setParameter(1, dateEnd).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<ProjectMember> getByCodeProjectMember(String code) {
        String sql = "Select tbl from ProjectMember tbl where tbl." + ProjectMember.FIELD_CODE_PROJECTMEMBER + " =?1 ";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            return em.createQuery(sql).setParameter(1, code).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }
}
