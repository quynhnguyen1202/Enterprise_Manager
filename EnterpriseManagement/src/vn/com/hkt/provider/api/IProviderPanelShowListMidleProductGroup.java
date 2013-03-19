/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.api;

import java.util.List;
import vn.com.hkt.data.entity.MidleProductGroup;

/**
 *
 * @author QuynhNguyen
 */
public interface IProviderPanelShowListMidleProductGroup extends IProviderListGeneral<MidleProductGroup> {

    public List<MidleProductGroup> getByIdProduct(long idProduct);

    public List<MidleProductGroup> getByIdGroup(long idGroup);
}
