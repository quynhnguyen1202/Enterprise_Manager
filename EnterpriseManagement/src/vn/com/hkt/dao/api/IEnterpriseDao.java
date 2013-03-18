/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.api;

import java.util.List;
import vn.com.hkt.data.entity.Enterprise;

/**
 *
 * @author QuynhNguyen
 */
public interface IEnterpriseDao extends IEntityDao<Enterprise> {

    public List<Enterprise> getListByIdEnterprise(long id);
    public  long getIdByName(String name);
}
