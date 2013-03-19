/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.api;

import java.util.List;
import vn.com.hkt.data.entity.ProductGroup;

/**
 *
 * @author QuynhNguyen
 */
public interface IProviderPanelShowListProductGroup extends IProviderListGeneral<ProductGroup> {
    public List<ProductGroup> getByIdEnterprise(long idEnterprise);
    
    
}
