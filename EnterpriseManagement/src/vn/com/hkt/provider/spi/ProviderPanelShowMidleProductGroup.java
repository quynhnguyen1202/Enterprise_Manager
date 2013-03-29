/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import java.util.List;
import vn.com.hkt.dao.api.IMidleProductGroupDao;
import vn.com.hkt.dao.api.IProductGroupDao;
import vn.com.hkt.dao.spi.MidleProductGroupDao;
import vn.com.hkt.dao.spi.ProductGroupDao;
import vn.com.hkt.data.entity.MidleProductGroup;
import vn.com.hkt.data.entity.ProductGroup;
import vn.com.hkt.provider.api.IProviderPanelShowMidleProductGroup;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowMidleProductGroup implements IProviderPanelShowMidleProductGroup {

    private MidleProductGroup midleProductGroup;
    private IMidleProductGroupDao iMidleProductGroupDao;
    private IProductGroupDao iProductGroupDao;

    public ProviderPanelShowMidleProductGroup() {
        midleProductGroup=new MidleProductGroup();
        iMidleProductGroupDao = new MidleProductGroupDao();
        iProductGroupDao=new ProductGroupDao();
    }

    @Override
    public void setClassname(Class classname) {
        setClassname(MidleProductGroup.class);
    }

    @Override
    public void setDataView(MidleProductGroup object) {
        this.midleProductGroup = object;
    }

    @Override
    public MidleProductGroup getDataView() {
        if (midleProductGroup == null) {
            midleProductGroup = new MidleProductGroup();
        }
        return midleProductGroup;
    }

    @Override
    public long addData() {
        if (midleProductGroup != null) {
            iMidleProductGroupDao.insert(midleProductGroup);
            return midleProductGroup.getId();

        }
        return -1;
    }

    @Override
    public long deleteData() {
        if (midleProductGroup != null) {
            System.out.println(iMidleProductGroupDao.delete(midleProductGroup));
            
            return 1;

        }
        return -1;
    }

    @Override
    public long updateData() {
        if (midleProductGroup != null) {
            iMidleProductGroupDao.update(midleProductGroup);
            return midleProductGroup.getId();

        }
        return -1;
    }

    @Override
    public void resetData() {
        midleProductGroup = new MidleProductGroup();
    }

    @Override
    public void refreshData() {
        midleProductGroup = iMidleProductGroupDao.getById(getDataView().getId());
    }

    @Override
    public boolean checkData() {
        if (midleProductGroup == null) {
            return true;

        }
        return false;
    }

    @Override
    public MidleProductGroup getObjectbyID(long id) {
        return iMidleProductGroupDao.getById(id);
    }

    @Override
    public List<MidleProductGroup> getMidleGroupByProductId(long idProduct) {
       List<MidleProductGroup> listDep=iMidleProductGroupDao.getByIdProduct(idProduct);
       return listDep;
    }

    @Override
    public List<ProductGroup> getProductGroupByIDGroup(long idGroup) {
        List<ProductGroup> listDep=iProductGroupDao.getByIdProductGroup(idGroup);
        return listDep;
    }

    @Override
    public ProductGroup getProductGroupByID(long idGroup) {;
        ProductGroup pg=iProductGroupDao.getById(idGroup);
        return pg;
    }

   
}
