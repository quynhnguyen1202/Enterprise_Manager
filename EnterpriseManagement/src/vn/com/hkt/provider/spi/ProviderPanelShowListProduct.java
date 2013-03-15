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
        iProductDao= new ProductDao();
    }

    @Override
    public List<Product> getListInformation() {
        List<Product> l= iProductDao.selectAll();
        return l;
    }
    
}
