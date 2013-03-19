/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import java.util.List;
import vn.com.hkt.dao.api.IUnitMoneyDao;
import vn.com.hkt.dao.spi.UnitMoneyDao;
import vn.com.hkt.data.entity.UnitMoney;
import vn.com.hkt.provider.api.IProviderPanelShowListUnitMoney;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowListUnitMoney implements IProviderPanelShowListUnitMoney {

    private IUnitMoneyDao iUnitMoneyDao;

    public ProviderPanelShowListUnitMoney() {
        iUnitMoneyDao = new UnitMoneyDao();
    }

    @Override
    public List<UnitMoney> getListInformation() {
        List<UnitMoney> l = iUnitMoneyDao.selectAll();
        return l;
    }

    @Override
    public List<UnitMoney> getByName(String name) {
        List<UnitMoney> l = iUnitMoneyDao.getByName(name);
        return l;
    }

    @Override
    public List<UnitMoney> getByCode(String code) {
        List<UnitMoney> l = iUnitMoneyDao.getByCode(code);
        return l;
    }
}
