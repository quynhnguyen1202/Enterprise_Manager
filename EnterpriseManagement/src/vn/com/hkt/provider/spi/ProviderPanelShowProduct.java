/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import java.util.ArrayList;
import java.util.List;
import vn.com.hkt.dao.api.IDepartmentDao;
import vn.com.hkt.dao.api.IEnterpriseDao;
import vn.com.hkt.dao.api.IProductDao;
import vn.com.hkt.dao.api.IProductGroupDao;
import vn.com.hkt.dao.spi.DepartmentDao;
import vn.com.hkt.dao.spi.EnterpriseDao;
import vn.com.hkt.dao.spi.ProductDao;
import vn.com.hkt.dao.spi.ProductGroupDao;
import vn.com.hkt.data.entity.Department;
import vn.com.hkt.data.entity.Enterprise;
import vn.com.hkt.data.entity.Product;
import vn.com.hkt.data.entity.ProductGroup;
import vn.com.hkt.provider.api.IProviderPanelShowProduct;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowProduct implements IProviderPanelShowProduct {

    Product product;
    IProductDao iProductDao;
    private IProductGroupDao iProductGroupDao;
    private IEnterpriseDao iEnterpriseDao;
    private IDepartmentDao iDepartmentDao;

    public ProviderPanelShowProduct() {
        iProductDao = new ProductDao();
        iProductGroupDao=new ProductGroupDao();
        iDepartmentDao=new DepartmentDao();
        iEnterpriseDao=new EnterpriseDao();
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

    @Override
    public List<Enterprise> getListEnterprise() {
        List<Enterprise> enterprises = iEnterpriseDao.selectAll();
        if (enterprises == null) {
            enterprises = new ArrayList<Enterprise>();
        }
        enterprises.add(0, null);
        return enterprises;
    }

    @Override
    public List<ProductGroup> getListGroup() {
        List<ProductGroup> groups = iProductGroupDao.selectAll();
        return groups;
    }

    @Override
    public List<Department> getDepartmentByEntID(long idEnterprise) {
        List<Department> listDep = iDepartmentDao.getByEntpriseId(idEnterprise);
        if (listDep == null) {
            listDep = new ArrayList<Department>();
        }
        listDep.add(0, null);
        return listDep;
    }
}
