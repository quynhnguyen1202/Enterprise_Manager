/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import java.util.List;
import vn.com.hkt.dao.api.IProductDao;
import vn.com.hkt.dao.spi.ProductDao;
import vn.com.hkt.data.entity.Product;
import vn.com.hkt.provider.api.IProviderPanelShowListProduct;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowListProduct implements IProviderPanelShowListProduct {

    private IProductDao iProductDao;

    public ProviderPanelShowListProduct() {
        iProductDao = new ProductDao();
    }

    @Override
    public List<Product> getListInformation() {
        List<Product> l = iProductDao.selectAll();
        return l;
    }

    @Override
    public List<Product> getByName(String name) {
        List<Product> l = iProductDao.getByName(name);
        return l;
    }

    @Override
    public List<Product> getByIdEnterprise(long id) {
        List<Product> l = iProductDao.getByIdEnterprise(id);
        return l;
    }

    @Override
    public List<Product> getByIdDepartment(long id) {
        List<Product> l = iProductDao.getByIdDepartment(id);
        return l;
    }

    @Override
    public List<Product> getByCodeProduct(String code) {
        List<Product> l = iProductDao.getByCode(code);
        return l;
    }
}
