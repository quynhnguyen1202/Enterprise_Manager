/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import vn.com.hkt.dao.api.IOperationDao;
import vn.com.hkt.dao.spi.OperationDao;
import vn.com.hkt.data.entity.Operation;
import vn.com.hkt.provider.api.IProviderPanelShowOperation;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowOperation implements IProviderPanelShowOperation {

    private Operation operation;
    private IOperationDao iOperationDao;

    public ProviderPanelShowOperation() {
        iOperationDao = new OperationDao();
    }

    @Override
    public void setClassname(Class classname) {
        setClassname(Operation.class);
    }

    @Override
    public void setDataView(Operation object) {
        this.operation = object;
    }

    @Override
    public Operation getDataView() {
        if (operation == null) {
            operation = new Operation();

        }
        return operation;
    }

    @Override
    public long addData() {
        if (operation != null) {
            iOperationDao.insert(operation);
            return operation.getId();

        }
        return -1;
    }

    @Override
    public long deleteData() {
        if (operation != null) {
            iOperationDao.delete(operation);
            return operation.getId();

        }
        return -1;
    }

    @Override
    public long updateData() {
        if (operation != null) {
            iOperationDao.update(operation);
            return operation.getId();

        }
        return -1;
    }

    @Override
    public void resetData() {
        operation = new Operation();
    }

    @Override
    public void refreshData() {
        operation = iOperationDao.getById(getDataView().getId());
    }

    @Override
    public boolean checkData() {
        if (operation == null) {
            return true;

        }
        return false;
    }

    @Override
    public Operation getObjectbyID(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
