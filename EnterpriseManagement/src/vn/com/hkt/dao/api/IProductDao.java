/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.api;

import java.util.List;
import vn.com.hkt.data.entity.Product;

/**
 *
 * @author QuynhNguyen
 */
public interface IProductDao extends IEntityDao<Product> {

    public List<Product> getByIdEnterprise(long id);

    public List<Product> getByIdDepartment(long id);

    public List<Product> getByName(String name);

    public List<Product> getByCode(String code);
}
