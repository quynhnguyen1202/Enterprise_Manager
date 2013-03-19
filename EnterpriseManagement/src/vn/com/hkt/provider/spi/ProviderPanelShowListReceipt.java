/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import java.util.Date;
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

    @Override
    public List<Receipt> getByIdOperation(long id) {
        List<Receipt> l = iReceiptDao.getByIdOperation(id);
        return l;
    }

    @Override
    public List<Receipt> getByIdEnterprise(long id) {
        List<Receipt> l = iReceiptDao.getByIdEnterprise(id);
        return l;
    }

    @Override
    public List<Receipt> getByIdDepartment(long id) {
        List<Receipt> l = iReceiptDao.getByIdDepartment(id);
        return l;
    }

    @Override
    public List<Receipt> getByIdEmployee(long id) {
        List<Receipt> l = iReceiptDao.getByIdEmployee(id);
        return l;
    }

    @Override
    public List<Receipt> getByDateProcess(Date date) {
        List<Receipt> l = iReceiptDao.getByDateProcess(date);
        return l;
    }

    @Override
    public List<Receipt> getByClassification(boolean classification) {
        List<Receipt> l = iReceiptDao.getByClassification(classification);
        return l;
    }

    @Override
    public List<Receipt> getByCode(String code) {
        List<Receipt> l = iReceiptDao.getByCodeReceipt(code);
        return l;
    }
}
