/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author QuynhNguyen
 */
@Entity
public class OperationProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private long IdOperation;
    private long IdProduct;
    private long IdProductGroup;
    private long Quantity;
    private float UnitPrice;

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public long getIdOperation() {
        return IdOperation;
    }

    public void setIdOperation(long IdOperation) {
        this.IdOperation = IdOperation;
    }

    public long getIdProduct() {
        return IdProduct;
    }

    public void setIdProduct(long IdProduct) {
        this.IdProduct = IdProduct;
    }

    public long getIdProductGroup() {
        return IdProductGroup;
    }

    public void setIdProductGroup(long IdProductGroup) {
        this.IdProductGroup = IdProductGroup;
    }

    public long getIdUnitMoney() {
        return IdUnitMoney;
    }

    public void setIdUnitMoney(long IdUnitMoney) {
        this.IdUnitMoney = IdUnitMoney;
    }

    public long getIdUnitProduct() {
        return IdUnitProduct;
    }

    public void setIdUnitProduct(long IdUnitProduct) {
        this.IdUnitProduct = IdUnitProduct;
    }

    public long getQuantity() {
        return Quantity;
    }

    public void setQuantity(long Quantity) {
        this.Quantity = Quantity;
    }

    public float getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(float UnitPrice) {
        this.UnitPrice = UnitPrice;
    }
    private long IdUnitProduct;
    private long IdUnitMoney;
}
