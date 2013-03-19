/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.spi;

import java.util.List;
import vn.com.hkt.dao.api.IUnitMoneyDao;
import vn.com.hkt.data.entity.UnitMoney;

/**
 *
 * @author QuynhNguyen
 */
public class UnitMoneyDao extends EntityDao<UnitMoney> implements IUnitMoneyDao {
    
    public UnitMoneyDao() {
        setClassName(UnitMoney.class);
    }

    @Override
    public List<UnitMoney> getByName(String name) {
        String sql = "Select tbl from UnitMoney tbl where tbl." + UnitMoney.FIELD_NAME + " =?1 ";
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
    public List<UnitMoney> getByCode(String code) {
       String sql = "Select tbl from UnitMoney tbl where tbl." + UnitMoney.FIELD_CODE + " =?1 ";
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
