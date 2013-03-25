/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.api;

import java.util.List;
import vn.com.hkt.data.entity.Department;
import vn.com.hkt.data.entity.Enterprise;
import vn.com.hkt.data.entity.Product;
import vn.com.hkt.data.entity.ProductGroup;

/**
 *
 * @author QuynhNguyen
 */
public interface IProviderPanelShowProduct extends IProviderGeneral<Product> {
    public List<Enterprise> getListEnterprise();
    public List<ProductGroup> getListGroup();
    public List<Department> getDepartmentByEntID(long idEnterprise);
}
