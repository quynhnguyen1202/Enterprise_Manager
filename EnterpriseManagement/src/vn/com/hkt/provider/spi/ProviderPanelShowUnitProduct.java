/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import vn.com.hkt.dao.api.IUnitProductDao;
import vn.com.hkt.dao.spi.UnitProductDao;
import vn.com.hkt.data.entity.UnitMoney;
import vn.com.hkt.data.entity.UnitProduct;
import vn.com.hkt.provider.api.IProviderPanelShowUnitProduct;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowUnitProduct implements IProviderPanelShowUnitProduct {

    private UnitProduct unitProduct;
    private IUnitProductDao iUnitProductDao;

    public ProviderPanelShowUnitProduct() {
        iUnitProductDao = new UnitProductDao();
    }

    @Override
    public void setClassname(Class classname) {
        setClassname(UnitProduct.class);
    }

    @Override
    public void setDataView(UnitProduct object) {
        this.unitProduct = object;
    }

    @Override
    public UnitProduct getDataView() {
        if (unitProduct == null) {
            unitProduct = new UnitProduct();
        }
        return unitProduct;
    }

    @Override
    public long addData() {
        if (unitProduct != null) {
            iUnitProductDao.insert(unitProduct);
            return unitProduct.getId();
        }
        return -1;
    }

    @Override
    public long deleteData() {
        if (unitProduct != null) {
            iUnitProductDao.delete(unitProduct);
            return unitProduct.getId();
        }
        return -1;
    }

    @Override
    public long updateData() {
        if (unitProduct != null) {
            iUnitProductDao.update(unitProduct);
            return unitProduct.getId();
        }
        return -1;
    }

    @Override
    public void resetData() {
        unitProduct = new UnitProduct();
    }

    @Override
    public void refreshData() {
        long id = getDataView().getId();
        unitProduct = iUnitProductDao.getById(id);
    }

    @Override
    public boolean checkData() {
        if (unitProduct == null) {
            return true;
        }
        return false;
    }

    @Override
    public UnitProduct getObjectbyID(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
