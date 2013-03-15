/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import java.util.List;
import vn.com.hkt.dao.api.IReceiptDao;
import vn.com.hkt.dao.spi.ReceiptDao;
import vn.com.hkt.data.entity.Receipt;
import vn.com.hkt.provider.api.IProviderPanelShowListReceipt;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowListReceipt implements IProviderPanelShowListReceipt {

    private IReceiptDao iReceiptDao;

    public ProviderPanelShowListReceipt() {
        iReceiptDao = new ReceiptDao();
    }

    @Override
    public List<Receipt> getListInformation() {
        List<Receipt> l = iReceiptDao.selectAll();
        return l;
    }
}
