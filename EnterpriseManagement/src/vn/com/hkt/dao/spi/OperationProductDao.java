/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.spi;

import vn.com.hkt.dao.api.IOperationProductDao;
import vn.com.hkt.data.entity.OperationProduct;

/**
 *
 * @author QuynhNguyen
 */
public class OperationProductDao extends EntityDao<OperationProduct> implements IOperationProductDao {
    
    public OperationProductDao() {
        setClassName(OperationProduct.class);
    }
}
