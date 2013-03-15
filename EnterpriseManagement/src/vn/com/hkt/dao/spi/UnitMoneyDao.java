/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.spi;

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
}
