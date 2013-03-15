/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import java.util.List;
import vn.com.hkt.dao.api.IOperationDao;
import vn.com.hkt.dao.spi.OperationDao;
import vn.com.hkt.data.entity.Operation;
import vn.com.hkt.provider.api.IProviderPanelShowListOperation;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowListOperation implements IProviderPanelShowListOperation {

    private IOperationDao iOperationDao;

    public ProviderPanelShowListOperation() {
        iOperationDao = new OperationDao();
    }

    @Override
    public List<Operation> getListInformation() {
        List<Operation> l = iOperationDao.selectAll();
        return l;
    }
}
