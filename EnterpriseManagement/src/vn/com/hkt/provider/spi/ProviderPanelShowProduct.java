/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import vn.com.hkt.data.entity.Product;
import vn.com.hkt.provider.api.IProviderPanelShowProduct;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowProduct extends ProviderGeneral<Product> implements IProviderPanelShowProduct{

    public ProviderPanelShowProduct() {
        setClassname(Product.class);
    }

   
}
