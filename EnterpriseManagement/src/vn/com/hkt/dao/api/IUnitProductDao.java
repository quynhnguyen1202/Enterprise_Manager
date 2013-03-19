/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.api;

import java.util.List;
import vn.com.hkt.data.entity.UnitProduct;

/**
 *
 * @author QuynhNguyen
 */
public interface IUnitProductDao extends IEntityDao<UnitProduct> {

    public List<UnitProduct> getByName(String name);

    public List<UnitProduct> getByCode(String code) ;
}
