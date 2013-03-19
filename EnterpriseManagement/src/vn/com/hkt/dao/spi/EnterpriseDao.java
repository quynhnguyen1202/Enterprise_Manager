/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.spi;

import java.util.Date;
import java.util.List;
import vn.com.hkt.dao.api.IEnterpriseDao;
import vn.com.hkt.data.entity.Enterprise;

/**
 *
 * @author QuynhNguyen
 */
public class EnterpriseDao extends EntityDao<Enterprise> implements IEnterpriseDao {

    public EnterpriseDao() {
        setClassName(Enterprise.class);
    }

    @Override
    public List<Enterprise> getListByIdEnterprise(long id) {
        String sql = "Select tbl from Enterprise tbl where tbl." + Enterprise.FIELD_IDENTERPRISE + " =?1 ";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            return em.createQuery(sql).setParameter(1, id).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Enterprise> getIdByName(String name) {
        String sql = "Select tbl form Enterprise tbl where tbl." + Enterprise.FIELD_NAME + " like '%?1' ";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            return em.createQuery(sql).setParameter(1, name).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Enterprise> getByDateActivate(Date date) {
        String sql = "Select tbl form Enterprise tbl where tbl." + Enterprise.FIELD_DATEACTIVATE + "= ?1 ";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            return em.createQuery(sql).setParameter(1, date).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Enterprise> getByCode(String code) {
        String sql = "Select tbl form Enterprise tbl where tbl." + Enterprise.FIELD_CODEENTERPRISE + "  = ?1 ";
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
