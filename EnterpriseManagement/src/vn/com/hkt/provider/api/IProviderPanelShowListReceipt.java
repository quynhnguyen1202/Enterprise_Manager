/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.api;

import java.util.Date;
import java.util.List;
import vn.com.hkt.data.entity.Receipt;

/**
 *
 * @author QuynhNguyen
 */
public interface IProviderPanelShowListReceipt extends IProviderListGeneral<Receipt> {

    public List<Receipt> getByIdOperation(long id);

    public List<Receipt> getByIdEnterprise(long id);

    public List<Receipt> getByIdDepartment(long id);

    public List<Receipt> getByIdEmployee(long id);

    public List<Receipt> getByDateProcess(Date date);

    public List<Receipt> getByClassification(boolean classification);

    public List<Receipt> getByCode(String code);
}
