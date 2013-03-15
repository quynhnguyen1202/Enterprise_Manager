/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import java.util.List;
import vn.com.hkt.data.entity.ProductGroup;
import vn.com.hkt.provider.api.IProviderPanelShowProductGroup;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowProductGroup extends ProviderGeneral<ProductGroup> implements IProviderPanelShowProductGroup{

    public ProviderPanelShowProductGroup() {
        setClassname(ProductGroup.class);
    }

    
    
}
