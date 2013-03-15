/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.spi;

import vn.com.hkt.dao.api.IUnitProductDao;
import vn.com.hkt.data.entity.UnitProduct;

/**
 *
 * @author QuynhNguyen
 */
public class UnitProductDao extends EntityDao<UnitProduct> implements IUnitProductDao {
    
    public UnitProductDao() {
        setClassName(UnitProduct.class);
    }
}
