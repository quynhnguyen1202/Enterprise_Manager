/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.api;

import java.util.List;
import vn.com.hkt.data.entity.Product;

/**
 *
 * @author QuynhNguyen
 */
public interface IProviderPanelShowListProduct extends IProviderListGeneral<Product> {

    public List<Product> getByName(String name);

    public List<Product> getByIdEnterprise(long id);

    public List<Product> getByIdDepartment(long id);

    public List<Product> getByCodeProduct(String code);
}
