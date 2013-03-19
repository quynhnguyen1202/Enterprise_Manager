/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import java.util.List;
import vn.com.hkt.dao.api.IUnitProductDao;
import vn.com.hkt.dao.spi.UnitProductDao;
import vn.com.hkt.data.entity.UnitProduct;
import vn.com.hkt.provider.api.IProviderPanelShowListUnitProduct;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowListUnitProduct implements IProviderPanelShowListUnitProduct {

    private IUnitProductDao iUnitProductDao;

    public ProviderPanelShowListUnitProduct() {
        iUnitProductDao = new UnitProductDao();
    }

    @Override
    public List<UnitProduct> getListInformation() {
        List<UnitProduct> l = iUnitProductDao.selectAll();
        return l;
    }

    @Override
    public List<UnitProduct> getByName(String name) {
        List<UnitProduct> l = iUnitProductDao.getByName(name);
        return l;
    }

    @Override
    public List<UnitProduct> getByCode(String code) {
        List<UnitProduct> l = iUnitProductDao.getByCode(code);
        return l;
    }
}
