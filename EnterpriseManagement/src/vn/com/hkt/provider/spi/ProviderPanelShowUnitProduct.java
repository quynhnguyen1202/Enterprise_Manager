/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import vn.com.hkt.data.entity.UnitProduct;
import vn.com.hkt.provider.api.IProviderPanelShowUnitProduct;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowUnitProduct extends ProviderGeneral<UnitProduct> implements IProviderPanelShowUnitProduct {
    
    public ProviderPanelShowUnitProduct() {
        setClassname(UnitProduct.class);
    }
}
