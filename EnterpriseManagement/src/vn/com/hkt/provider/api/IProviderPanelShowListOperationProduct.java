/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.api;

import java.util.List;
import vn.com.hkt.data.entity.OperationProduct;

/**
 *
 * @author QuynhNguyen
 */
public interface IProviderPanelShowListOperationProduct extends IProviderListGeneral<OperationProduct> {

    public List<OperationProduct> getByIdOperation(long id);

    public List<OperationProduct> getByIdProduct(long id);

    public List<OperationProduct> getByIdProductGroup(long id);

    public List<OperationProduct> getByCodeOperationProduct(String code);
}
