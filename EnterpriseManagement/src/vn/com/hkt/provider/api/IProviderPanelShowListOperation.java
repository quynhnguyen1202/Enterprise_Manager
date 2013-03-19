/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.api;

import java.util.Date;
import java.util.List;
import vn.com.hkt.data.entity.Operation;

/**
 *
 * @author QuynhNguyen
 */
public interface IProviderPanelShowListOperation extends IProviderListGeneral<Operation> {

    public List<Operation> getByIdProject(long id);

    public List<Operation> getByDateExecute(Date date);

    public List<Operation> getByIdEmployee(long id);

    public List<Operation> getByIdDepartment(long id);

    public List<Operation> getByIdEnterprise(long id);

    public List<Operation> getByClassification(boolean classification);

    public List<Operation> getByCodeOperation(String code);
}
