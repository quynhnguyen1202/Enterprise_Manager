/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import vn.com.hkt.dao.api.IOperationProductDao;
import vn.com.hkt.dao.spi.OperationProductDao;
import vn.com.hkt.data.entity.OperationProduct;
import vn.com.hkt.provider.api.IProviderPanelShowOperationProduct;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowOperationProduct
        implements IProviderPanelShowOperationProduct {

    private OperationProduct operationProduct;
    private IOperationProductDao iOperationProductDao;

    public ProviderPanelShowOperationProduct() {
        iOperationProductDao = new OperationProductDao();
    }

    @Override
    public void setClassname(Class classname) {
        setClassname(OperationProduct.class);
    }

    @Override
    public void setDataView(OperationProduct object) {
        this.operationProduct = object;
    }

    @Override
    public OperationProduct getDataView() {
        if (operationProduct == null) {
            operationProduct = new OperationProduct();
        }
        return operationProduct;
    }

    @Override
    public long addData() {
        if (operationProduct != null) {
            iOperationProductDao.insert(operationProduct);
            return operationProduct.getId();
        }
        return -1;
    }

    @Override
    public long deleteData() {
        if (operationProduct != null) {
            iOperationProductDao.delete(operationProduct);
            return operationProduct.getId();
        }
        return -1;
    }

    @Override
    public long updateData() {
        if (operationProduct != null) {
            iOperationProductDao.update(operationProduct);
            return operationProduct.getId();
        }
        return -1;
    }

    @Override
    public void resetData() {
        operationProduct = new OperationProduct();
    }

    @Override
    public void refreshData() {
        operationProduct = iOperationProductDao.getById(getDataView().getId());
    }

    @Override
    public boolean checkData() {
        if (operationProduct == null) {
            return true;
        }
        return false;
    }

    @Override
    public OperationProduct getObjectbyID(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
