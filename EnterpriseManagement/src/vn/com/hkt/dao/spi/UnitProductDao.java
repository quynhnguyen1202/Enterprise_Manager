/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.spi;

import java.util.List;
import vn.com.hkt.dao.api.IUnitProductDao;
import vn.com.hkt.data.entity.UnitProduct;

/**
 *
 * @author QuynhNguyen
 */
public class UnitProductDao extends EntityDao<UnitProduct> implements IUnitProductDao {

    public UnitProductDao() {
        setClassName(UnitProduct.class);
    }

    @Override
    public List<UnitProduct> getByName(String name) {
        String sql = "Select tbl from UnitProduct tbl where tbl." + UnitProduct.FIELD_NAME + " =?1 ";
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
    public List<UnitProduct> getByCode(String code) {
        String sql = "Select tbl from UnitProduct tbl where tbl." + UnitProduct.FIELD_CODE + " =?1 ";
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

    @Override
    public List<UnitProduct> getByDefault(boolean d) {
         String sql = "Select tbl from UnitProduct tbl where tbl." + UnitProduct.FIELD_IS_DEFAULT + " =?1 ";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            return em.createQuery(sql).setParameter(1, d).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }
}
