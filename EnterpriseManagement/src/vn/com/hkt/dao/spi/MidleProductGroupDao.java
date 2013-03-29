/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.spi;

import java.util.List;
import vn.com.hkt.dao.api.IMidleProductGroupDao;
import vn.com.hkt.data.entity.MidleProductGroup;

/**
 *
 * @author QuynhNguyen
 */
public class MidleProductGroupDao extends EntityDao<MidleProductGroup> implements IMidleProductGroupDao {

    public MidleProductGroupDao() {
        setClassName(MidleProductGroup.class);
    }

    @Override
    public List<MidleProductGroup> getByIdProduct(long id) {
        String sql = "Select tbl from "+MidleProductGroup.class.getSimpleName()+" tbl where tbl." + MidleProductGroup.FIELD_IDPRODUCT + " =?1 ";
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
    public List<MidleProductGroup> getByIdGroupProduct(long id) {
        String sql = "Select tbl from MidleProductGroup tbl where tbl." + MidleProductGroup.FIELD_IDGROUPPRODUCT + " =?1 ";
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
}
