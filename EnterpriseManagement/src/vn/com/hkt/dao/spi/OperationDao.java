/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.spi;

import vn.com.hkt.dao.api.IOperationDao;
import vn.com.hkt.data.entity.Operation;

/**
 *
 * @author QuynhNguyen
 */
public class OperationDao extends EntityDao<Operation> implements IOperationDao {
    
    public OperationDao() {
        setClassName(Operation.class);
    }
}
