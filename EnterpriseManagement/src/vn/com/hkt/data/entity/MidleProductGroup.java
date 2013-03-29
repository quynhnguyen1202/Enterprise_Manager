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
public class MidleProductGroup implements IEntity{

    public static final String FIELD_ID = "Id";
    public static final String FIELD_IDPRODUCT = "IdProduct";
    public static final String FIELD_IDGROUPPRODUCT = "IdGroupProduct";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Override
    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }
    private long IdProduct;
    private long IdGroupProduct;

    public long getIdGroupProduct() {
        return IdGroupProduct;
    }

    public void setIdGroupProduct(long IdGroupProduct) {
        this.IdGroupProduct = IdGroupProduct;
    }

    public long getIdProduct() {
        return IdProduct;
    }

    public void setIdProduct(long IdProduct) {
        this.IdProduct = IdProduct;
    }
}
