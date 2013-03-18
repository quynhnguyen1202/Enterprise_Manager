/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import vn.com.hkt.dao.api.IReceiptDao;
import vn.com.hkt.dao.spi.ReceiptDao;
import vn.com.hkt.data.entity.Receipt;
import vn.com.hkt.provider.api.IProviderPanelShowReceipt;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowReceipt implements IProviderPanelShowReceipt {

    private Receipt receipt;
    private IReceiptDao iReceiptDao;

    public ProviderPanelShowReceipt() {
        iReceiptDao = new ReceiptDao();
    }

    @Override
    public void setClassname(Class classname) {
        setClassname(Receipt.class);
    }

    @Override
    public void setDataView(Receipt object) {
        this.receipt = object;
    }

    @Override
    public Receipt getDataView() {
        if (receipt == null) {
            receipt = new Receipt();
        }
        return receipt;
    }

    @Override
    public long addData() {
        if (receipt != null) {
            iReceiptDao.insert(receipt);
            return receipt.getId();
        }
        return -1;
    }

    @Override
    public long deleteData() {
        if (receipt != null) {
            iReceiptDao.delete(receipt);
            return receipt.getId();
        }
        return -1;
    }

    @Override
    public long updateData() {
        if (receipt != null) {
            iReceiptDao.delete(receipt);
            return receipt.getId();
        }
        return -1;
    }

    @Override
    public void resetData() {
        receipt = new Receipt();
    }

    @Override
    public void refreshData() {
        receipt = iReceiptDao.getById(getDataView().getId());
    }

    @Override
    public boolean checkData() {
        if (receipt == null) {
            return true;
        }
        return false;
    }

    @Override
    public Receipt getObjectbyID(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
