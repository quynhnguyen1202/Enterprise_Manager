/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.api;

import java.util.List;
import vn.com.hkt.data.entity.Enterprise;
import vn.com.hkt.data.entity.ProductGroup;

/**
 *
 * @author QuynhNguyen
 */
public interface IProviderPanelShowProductGroup extends IProviderGeneral<ProductGroup> {
    public Enterprise getEnterpriseByID(long idEnterprise);
    public List<ProductGroup> getListGroupByEntID(long idEnterprise);
    public List<Enterprise> getListEnterprise();
}
