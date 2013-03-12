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
public class MidleProductGroup {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
