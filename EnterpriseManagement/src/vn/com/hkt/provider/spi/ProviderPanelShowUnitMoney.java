/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import vn.com.hkt.dao.api.IUnitMoneyDao;
import vn.com.hkt.dao.spi.UnitMoneyDao;
import vn.com.hkt.data.entity.UnitMoney;
import vn.com.hkt.provider.api.IProviderPanelShowUnitMoney;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowUnitMoney implements IProviderPanelShowUnitMoney {

    private UnitMoney unitMoney;
    private IUnitMoneyDao iUnitMoneyDao;

    public ProviderPanelShowUnitMoney() {
        iUnitMoneyDao = new UnitMoneyDao();
    }

    @Override
    public void setClassname(Class classname) {
        setClassname(UnitMoney.class);
    }

    @Override
    public void setDataView(UnitMoney object) {
        this.unitMoney = object;
    }

    @Override
    public UnitMoney getDataView() {
        if (unitMoney == null) {
            unitMoney = new UnitMoney();

        }
        return unitMoney;
    }

    @Override
    public long addData() {
        if (unitMoney != null) {
            iUnitMoneyDao.insert(unitMoney);
            return unitMoney.getId();
        }
        return -1;
    }

    @Override
    public long deleteData() {
        if (unitMoney != null) {
            iUnitMoneyDao.delete(unitMoney);
            return unitMoney.getId();
        }
        return -1;
    }

    @Override
    public long updateData() {
        if (unitMoney != null) {
            iUnitMoneyDao.update(unitMoney);
            return unitMoney.getId();
        }
        return -1;
    }

    @Override
    public void resetData() {
        unitMoney = new UnitMoney();
    }

    @Override
    public void refreshData() {
        long id = getDataView().getId();
        unitMoney = iUnitMoneyDao.getById(id);
    }

    @Override
    public boolean checkData() {
        if (unitMoney == null) {
            return true;
        }
        return false;
    }

    @Override
    public UnitMoney getObjectbyID(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
