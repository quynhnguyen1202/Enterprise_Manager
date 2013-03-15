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
public class ProviderPanelShowListMidleProductGroup implements IProviderPanelShowListMidleProductGroup{
private IMidleProductGroupDao iMidleProductGroupDao;

    public ProviderPanelShowListMidleProductGroup() {
        iMidleProductGroupDao= new MidleProductGroupDao();
    }

    @Override
    public List<MidleProductGroup> getListInformation() {
        List<MidleProductGroup> l = iMidleProductGroupDao.selectAll();
        return l;
    }
    
}
