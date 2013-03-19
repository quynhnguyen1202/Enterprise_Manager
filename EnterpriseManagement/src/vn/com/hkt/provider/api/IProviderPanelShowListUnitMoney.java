/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.api;

import java.util.List;
import vn.com.hkt.data.entity.UnitMoney;

/**
 *
 * @author QuynhNguyen
 */
public interface IProviderPanelShowListUnitMoney extends IProviderListGeneral<UnitMoney> {

    public List<UnitMoney> getByName(String name);

    public List<UnitMoney> getByCode(String code);
}
