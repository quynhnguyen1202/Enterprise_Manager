/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.api;

import java.util.Date;
import java.util.List;
import vn.com.hkt.data.entity.Operation;

/**
 *
 * @author QuynhNguyen
 */
public interface IOperationDao extends IEntityDao<Operation> {

    public List<Operation> getByIdProject(long id);

    public List<Operation> getByDateExecute(Date date);

    public List<Operation> getByIdEmployee(long id);

    public List<Operation> getByIdDepartment(long id);

    public List<Operation> getByCode(String code);

    public List<Operation> getByClassification(String classification);
}
