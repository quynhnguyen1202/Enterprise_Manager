/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.api;

import java.util.List;
import vn.com.hkt.data.entity.Receipt;

/**
 *
 * @author QuynhNguyen
 */
public interface IReceiptDao extends IEntityDao<Receipt> {

    public List<Receipt> getByIdOperation(long idOperation);

    public List<Receipt> getByIdEnterprise(long idEnterprise);

    public List<Receipt> getByIdDepartment(long idDepartment);

    public List<Receipt> getByIdEmployee(long idEmployee);

    public List<Receipt> getByClassification(boolean classification);

    public List<Receipt> getByCodeReceipt(String code);
}
