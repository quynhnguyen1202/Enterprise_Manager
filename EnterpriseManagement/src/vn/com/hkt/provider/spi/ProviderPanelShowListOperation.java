/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import java.util.Date;
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

    @Override
    public List<Operation> getByIdProject(long id) {
        List<Operation> l = iOperationDao.getByIdProject(id);
        return l;
    }

    @Override
    public List<Operation> getByDateExecute(Date date) {
        List<Operation> l = iOperationDao.getByDateExecute(date);
        return l;
    }

    @Override
    public List<Operation> getByIdEmployee(long id) {
        List<Operation> l = iOperationDao.getByIdEmployee(id);
        return l;
    }

    @Override
    public List<Operation> getByIdDepartment(long id) {
        List<Operation> l = iOperationDao.getByIdDepartment(id);
        return l;
    }

    @Override
    public List<Operation> getByIdEnterprise(long id) {
        List<Operation> l = iOperationDao.getByIdEnterprise(id);
        return l;
    }

    @Override
    public List<Operation> getByClassification(boolean classification) {
        List<Operation> l = iOperationDao.getByClassification(classification);
        return l;
    }

    @Override
    public List<Operation> getByCodeOperation(String code) {
        List<Operation> l = iOperationDao.getByCode(code);
        return l;
    }

    @Override
    public Operation getByOperationId(long idOperation) {
        return iOperationDao.getById(idOperation);
    }
}
