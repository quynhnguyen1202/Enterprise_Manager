/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.api;

import java.util.List;
import vn.com.hkt.data.entity.UnitMoney;

/**
 *
 * @author QuynhNguyen
 */
public interface IUnitMoneyDao extends IEntityDao<UnitMoney> {

    public List<UnitMoney> getByName(String name);

    public List<UnitMoney> getByCode(String code);

    public List<UnitMoney> getByDefault(boolean d);
}
