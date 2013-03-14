/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.spi;

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
        String sql = "Select tbl from Enterprise tbl where tbl.IdEnterprise =?1 ";
        if (em == null || !em.isOpen()) {
            em = emf.createEntityManager();
        }
        try {

            return em.createQuery(sql).setParameter(1, id).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }
}
