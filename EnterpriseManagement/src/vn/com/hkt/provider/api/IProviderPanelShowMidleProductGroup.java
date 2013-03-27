/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.api;

import java.util.List;
import vn.com.hkt.data.entity.MidleProductGroup;
import vn.com.hkt.data.entity.ProductGroup;

/**
 *
 * @author QuynhNguyen
 */
public interface IProviderPanelShowMidleProductGroup extends IProviderGeneral<MidleProductGroup> {
   public List<MidleProductGroup> getMidleGroupByProductId(long idProduct);
   public List<ProductGroup> getProductGroupByIDGroup(long idGroup);
}
