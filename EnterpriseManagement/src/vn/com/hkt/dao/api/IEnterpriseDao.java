/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.api;

import java.util.Date;
import java.util.List;
import vn.com.hkt.data.entity.Enterprise;

/**
 *
 * @author QuynhNguyen
 */
public interface IEnterpriseDao extends IEntityDao<Enterprise> {

    public List<Enterprise> getListByIdEnterprise(long id);

    public List<Enterprise> getIdByName(String name);

    public List<Enterprise> getByDateActivate(Date date);

    public List<Enterprise> getByCode(String code);
}
