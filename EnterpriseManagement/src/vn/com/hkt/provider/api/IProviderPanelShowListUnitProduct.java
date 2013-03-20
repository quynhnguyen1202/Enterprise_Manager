/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.api;

import java.util.List;
import vn.com.hkt.data.entity.UnitProduct;

/**
 *
 * @author QuynhNguyen
 */
public interface IProviderPanelShowListUnitProduct extends IProviderListGeneral<UnitProduct> {

    public List<UnitProduct> getByName(String name);

    public List<UnitProduct> getByCode(String code);

    public List<UnitProduct> getByDefault(boolean d);
}
