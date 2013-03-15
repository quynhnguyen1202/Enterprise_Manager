/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import vn.com.hkt.data.entity.OperationProduct;
import vn.com.hkt.provider.api.IProviderPanelShowOperationProduct;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowOperationProduct extends ProviderGeneral<OperationProduct>
        implements IProviderPanelShowOperationProduct {

    public ProviderPanelShowOperationProduct() {
        setClassname(OperationProduct.class);
    }
    
}
