/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import java.util.List;
import vn.com.hkt.dao.api.IMidleProductGroupDao;
import vn.com.hkt.dao.spi.MidleProductGroupDao;
import vn.com.hkt.data.entity.MidleProductGroup;
import vn.com.hkt.provider.api.IProviderPanelShowListMidleProductGroup;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowListMidleProductGroup implements IProviderPanelShowListMidleProductGroup {

    private IMidleProductGroupDao iMidleProductGroupDao;

    public ProviderPanelShowListMidleProductGroup() {
        iMidleProductGroupDao = new MidleProductGroupDao();
    }

    @Override
    public List<MidleProductGroup> getListInformation() {
        List<MidleProductGroup> l = iMidleProductGroupDao.selectAll();
        return l;
    }

    @Override
    public List<MidleProductGroup> getByIdProduct(long idProduct) {
        List<MidleProductGroup> l = iMidleProductGroupDao.getByIdProduct(idProduct);
        return l;
    }

    @Override
    public List<MidleProductGroup> getByIdGroup(long idGroup) {
        List<MidleProductGroup> l = iMidleProductGroupDao.getByIdGroupProduct(idGroup);
        return l;
    }
}
