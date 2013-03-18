/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import vn.com.hkt.dao.api.IProductDao;
import vn.com.hkt.dao.spi.ProductDao;
import vn.com.hkt.data.entity.Product;
import vn.com.hkt.provider.api.IProviderPanelShowProduct;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowProduct implements IProviderPanelShowProduct {

    Product product;
    IProductDao iProductDao;

    public ProviderPanelShowProduct() {
        iProductDao = new ProductDao();
    }

    @Override
    public void setClassname(Class classname) {
        setClassname(Product.class);
    }

    @Override
    public void setDataView(Product object) {
        this.product = object;
    }

    @Override
    public Product getDataView() {
        if (product == null) {
            product = new Product();
        }
        return product;
    }

    @Override
    public long addData() {
        if (product != null) {
            iProductDao.insert(product);
            return product.getId();
        }
        return -1;
    }

    @Override
    public long deleteData() {
        if (product != null) {
            iProductDao.delete(product);
            return product.getId();
        }
        return -1;
    }

    @Override
    public long updateData() {
        if (product != null) {
            iProductDao.update(product);
            return product.getId();
        }
        return -1;
    }

    @Override
    public void resetData() {
        product = new Product();
    }

    @Override
    public void refreshData() {
        product = iProductDao.getById(getDataView().getId());
    }

    @Override
    public boolean checkData() {
        if (product == null) {
            return true;
        }
        return false;
    }

    @Override
    public Product getObjectbyID(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
