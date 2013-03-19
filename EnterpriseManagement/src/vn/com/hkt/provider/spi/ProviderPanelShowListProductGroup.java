/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import java.util.List;
import vn.com.hkt.dao.api.IProductGroupDao;
import vn.com.hkt.dao.spi.ProductGroupDao;
import vn.com.hkt.data.entity.ProductGroup;
import vn.com.hkt.provider.api.IProviderPanelShowListProductGroup;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowListProductGroup implements IProviderPanelShowListProductGroup {

    private IProductGroupDao iProductGroupDao;

    public ProviderPanelShowListProductGroup() {
        iProductGroupDao = new ProductGroupDao();
    }

    @Override
    public List<ProductGroup> getListInformation() {
        List<ProductGroup> l = iProductGroupDao.selectAll();
        return l;
    }

    @Override
    public List<ProductGroup> getByIdEnterprise(long idEnterprise) {
        List<ProductGroup> listproductgroup = iProductGroupDao.getByIdEnterprise(idEnterprise);
        return listproductgroup;
    }

    @Override
    public List<ProductGroup> getByName(String name) {
        List<ProductGroup> listproductgroup = iProductGroupDao.getByName(name);
        return listproductgroup;
    }

    @Override
    public List<ProductGroup> getByIdProductGroup(long id) {
        List<ProductGroup> l = iProductGroupDao.getByIdProductGroup(id);
        return l;
    }

    @Override
    public List<ProductGroup> getByCodeProductGroup(String code) {
        List<ProductGroup> l = iProductGroupDao.getByCodeProductGroup(code);
        return l;
    }
}
