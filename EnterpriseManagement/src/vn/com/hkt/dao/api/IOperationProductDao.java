/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.api;

import java.util.List;
import vn.com.hkt.data.entity.OperationProduct;

/**
 *
 * @author QuynhNguyen
 */
public interface IOperationProductDao extends IEntityDao<OperationProduct> {

    public List<OperationProduct> getByIdOperation(long idOperation);

    public List<OperationProduct> getByIdProduct(long idProduct);

    public List<OperationProduct> getByIdProductGroup(long idProductGroup);

    public List<OperationProduct> getByCodeOperationProduct(String code);
}
