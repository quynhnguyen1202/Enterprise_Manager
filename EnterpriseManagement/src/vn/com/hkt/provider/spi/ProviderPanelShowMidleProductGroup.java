/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import vn.com.hkt.data.entity.MidleProductGroup;
import vn.com.hkt.provider.api.IProviderPanelShowMidleProductGroup;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowMidleProductGroup extends ProviderGeneral<MidleProductGroup>
        implements IProviderPanelShowMidleProductGroup {

    public ProviderPanelShowMidleProductGroup() {
        setClassname(MidleProductGroup.class);
    }
    
}
