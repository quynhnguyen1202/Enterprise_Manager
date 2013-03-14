/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.spi;

import vn.com.hkt.dao.api.IEnterpriseDao;
import vn.com.hkt.data.entity.Enterprise;

/**
 *
 * @author QuynhNguyen
 */
public class EnterpriseDao extends EntityDao<Enterprise> implements IEnterpriseDao {

    public EnterpriseDao() {
        setClassName(Enterprise.class);
    }
   
        
}
