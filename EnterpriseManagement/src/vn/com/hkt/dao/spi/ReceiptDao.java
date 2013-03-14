/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.spi;

import vn.com.hkt.dao.api.IReceiptDao;
import vn.com.hkt.data.entity.Receipt;

/**
 *
 * @author QuynhNguyen
 */
public class ReceiptDao extends EntityDao<Receipt> implements IReceiptDao {
    
    public ReceiptDao() {
        setClassName(Receipt.class);
    }
}
