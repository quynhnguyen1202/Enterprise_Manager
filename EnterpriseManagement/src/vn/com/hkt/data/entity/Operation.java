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
public class Operation {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private long Id;
    private long IdProject;
    private float MoneyTotal;
    private float MoneyAfterTax;
    private float  MoneyAfterDiscount;
    private long IdEnterprise;
    private long IdDepartment;

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public long getIdProject() {
        return IdProject;
    }

    public void setIdProject(long IdProject) {
        this.IdProject = IdProject;
    }

    public float getMoneyAfterDiscount() {
        return MoneyAfterDiscount;
    }

    public void setMoneyAfterDiscount(float MoneyAfterDiscount) {
        this.MoneyAfterDiscount = MoneyAfterDiscount;
    }

    public float getMoneyAfterTax() {
        return MoneyAfterTax;
    }

    public void setMoneyAfterTax(float MoneyAfterTax) {
        this.MoneyAfterTax = MoneyAfterTax;
    }

    public float getMoneyTotal() {
        return MoneyTotal;
    }

    public void setMoneyTotal(float MoneyTotal) {
        this.MoneyTotal = MoneyTotal;
    }
    
    
}
