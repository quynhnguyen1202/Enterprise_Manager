/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import vn.com.hkt.data.entity.Receipt;
import vn.com.hkt.provider.api.IProviderPanelShowReceipt;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowReceipt extends ProviderGeneral<Receipt> implements IProviderPanelShowReceipt {
    
    public ProviderPanelShowReceipt() {
        setClassname(Receipt.class);
    }
}
