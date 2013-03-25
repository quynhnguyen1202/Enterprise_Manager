/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import java.util.ArrayList;
import java.util.List;
import vn.com.hkt.dao.api.IEnterpriseDao;
import vn.com.hkt.dao.api.IProductGroupDao;
import vn.com.hkt.dao.spi.EnterpriseDao;
import vn.com.hkt.dao.spi.ProductGroupDao;
import vn.com.hkt.data.entity.Enterprise;
import vn.com.hkt.data.entity.ProductGroup;
import vn.com.hkt.provider.api.IProviderPanelShowProductGroup;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowProductGroup implements IProviderPanelShowProductGroup {

    private ProductGroup productGroup;
    private IProductGroupDao iProductGroupDao;
    private  IEnterpriseDao iEnterpriseDao;
    public ProviderPanelShowProductGroup() {
        iProductGroupDao = new ProductGroupDao();
        iEnterpriseDao = new EnterpriseDao();
    }

    @Override
    public void setClassname(Class classname) {
        setClassname(ProductGroup.class);
    }

    @Override
    public void setDataView(ProductGroup object) {
        this.productGroup = object;
    }

    @Override
    public ProductGroup getDataView() {
        if (productGroup == null) {
            productGroup = new ProductGroup();

        }
        return productGroup;
    }

    @Override
    public long addData() {
        if (productGroup != null) {
            iProductGroupDao.insert(productGroup);
            return productGroup.getId();
        }
        return -1;
    }

    @Override
    public long deleteData() {
        if (productGroup != null) {
            iProductGroupDao.delete(productGroup);
            return productGroup.getId();
        }
        return -1;
    }

    @Override
    public long updateData() {
        if (productGroup != null) {
            iProductGroupDao.update(productGroup);
            return productGroup.getId();
        }
        return -1;
    }

    @Override
    public void resetData() {
        productGroup = new ProductGroup();
    }

    @Override
    public void refreshData() {
        productGroup = iProductGroupDao.getById(getDataView().getId());
    }

    @Override
    public boolean checkData() {
        if (productGroup == null) {
            return true;
        }
        return false;
    }

    @Override
    public ProductGroup getObjectbyID(long id) {
       if (id > 0) {
            return iProductGroupDao.getById(id);
        }
        return null;
    }

    @Override
    public Enterprise getEnterpriseByID(long idEnterprise) {
        if (idEnterprise > 0) {
            return iEnterpriseDao.getById(idEnterprise);
        }
        return null;
    }

    @Override
    public List<ProductGroup> getListGroupByEntID(long idEnterprise) {
        List<ProductGroup> listDep = iProductGroupDao.getByIdEnterprise(idEnterprise);
        if (listDep == null) {
            listDep = new ArrayList<ProductGroup>();
        }
        listDep.add(0, null);
        return listDep;
    }

    @Override
    public List<Enterprise> getListEnterprise() {
        List<Enterprise> enterprises = iEnterpriseDao.selectAll();
        if (enterprises == null) {
            enterprises = new ArrayList<Enterprise>();
        }
        enterprises.add(0, null);
        return enterprises;
    }
}
