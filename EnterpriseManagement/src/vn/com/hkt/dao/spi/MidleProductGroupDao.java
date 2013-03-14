/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.spi;

import vn.com.hkt.dao.api.IMidleProductGroupDao;
import vn.com.hkt.data.entity.MidleProductGroup;

/**
 *
 * @author QuynhNguyen
 */
public class MidleProductGroupDao extends EntityDao<MidleProductGroup> implements IMidleProductGroupDao {
    
    public MidleProductGroupDao() {
        setClassName(MidleProductGroup.class);
    }
}
