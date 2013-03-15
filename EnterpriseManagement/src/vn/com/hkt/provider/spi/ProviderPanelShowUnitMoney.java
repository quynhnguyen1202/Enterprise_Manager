/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import vn.com.hkt.data.entity.UnitMoney;
import vn.com.hkt.provider.api.IProviderPanelShowUnitMoney;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowUnitMoney extends ProviderGeneral<UnitMoney> implements IProviderPanelShowUnitMoney {
    
    public ProviderPanelShowUnitMoney() {
        setClassname(UnitMoney.class);
    }
}
