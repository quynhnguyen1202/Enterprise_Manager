/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.data.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

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
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DateExecute;
    private long IdEmployee;

    public long getIdEmployee() {
        return IdEmployee;
    }

    public void setIdEmployee(long IdEmployee) {
        this.IdEmployee = IdEmployee;
    }

    public Operation() {
    }

    public Operation(long Id, long IdProject, float MoneyTotal, float MoneyAfterTax, float MoneyAfterDiscount, long IdEnterprise, long IdDepartment, Date DateExecute,long IdEmployee) {
        this.Id = Id;
        this.IdProject = IdProject;
        this.MoneyTotal = MoneyTotal;
        this.MoneyAfterTax = MoneyAfterTax;
        this.MoneyAfterDiscount = MoneyAfterDiscount;
        this.IdEnterprise = IdEnterprise;
        this.IdDepartment = IdDepartment;
        this.DateExecute = DateExecute;
    }

    public Date getDateExecute() {
        return DateExecute;
    }

    public void setDateExecute(Date DateExecute) {
        this.DateExecute = DateExecute;
    }

    public long getIdDepartment() {
        return IdDepartment;
    }

    public void setIdDepartment(long IdDepartment) {
        this.IdDepartment = IdDepartment;
    }

    public long getIdEnterprise() {
        return IdEnterprise;
    }

    public void setIdEnterprise(long IdEnterprise) {
        this.IdEnterprise = IdEnterprise;
    }

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
