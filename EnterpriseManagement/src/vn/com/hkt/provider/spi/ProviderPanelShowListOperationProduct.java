/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import java.util.List;
import vn.com.hkt.dao.api.IOperationDao;
import vn.com.hkt.dao.api.IOperationProductDao;
import vn.com.hkt.dao.spi.OperationDao;
import vn.com.hkt.dao.spi.OperationProductDao;
import vn.com.hkt.data.entity.OperationProduct;
import vn.com.hkt.provider.api.IProviderPanelShowListOperationProduct;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowListOperationProduct implements IProviderPanelShowListOperationProduct {

    private IOperationProductDao iOperationDao;

    public ProviderPanelShowListOperationProduct() {
        iOperationDao = new OperationProductDao();
    }

    @Override
    public List<OperationProduct> getListInformation() {
        List<OperationProduct> l = iOperationDao.selectAll();
        return l;
    }

    @Override
    public List<OperationProduct> getByIdOperation(long id) {
        List<OperationProduct> l = iOperationDao.getByIdOperation(id);
        return l;
    }

    @Override
    public List<OperationProduct> getByIdProduct(long id) {
        List<OperationProduct> l = iOperationDao.getByIdProduct(id);
        return l;
    }

    @Override
    public List<OperationProduct> getByIdProductGroup(long id) {
        List<OperationProduct> l = iOperationDao.getByIdProductGroup(id);
        return l;
    }

    @Override
    public List<OperationProduct> getByCodeOperationProduct(String code) {
        List<OperationProduct> l = iOperationDao.getByCodeOperationProduct(code);
        return l;
    }
}
