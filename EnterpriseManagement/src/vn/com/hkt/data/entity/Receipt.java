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
public class Receipt {

    public static final String FIELD_ID = "Id";
    public static final String FIELD_IDOPERATION = "IdOperation";
    public static final String FIELD_IDENTERPRISE = "IdEnterprise";
    public static final String FIELD_IDDEPARTMENT = "IdDepartment";
    public static final String FIELD_IDEMPLOYEE = "IdEmployee";
    public static final String FIELD_DATEPROCESS = "DateProcess";
    public static final String FIELD_CLASSIFICATION = "Classification";
    public static final String FIELD_CODE_RECEIPT = "codeReceipt";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private long IdOperation;
    private long IdEnterprise;
    private long IdDepartment;
    private long IdEmployee;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DateProcess;
    private float MoneyTotal;
    private long IdUnitMoney;
    private boolean Classification; // Thu hoac chi
    private String codeReceipt;

    public String getCodeReceipt() {
        return codeReceipt;
    }

    public void setCodeReceipt(String codeReceipt) {
        this.codeReceipt = codeReceipt;
    }

    public boolean isClassification() {
        return Classification;
    }

    public void setClassification(boolean Classification) {
        this.Classification = Classification;
    }

    public Date getDateProcess() {
        return DateProcess;
    }

    public void setDateProcess(Date DateProcess) {
        this.DateProcess = DateProcess;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public long getIdDepartment() {
        return IdDepartment;
    }

    public void setIdDepartment(long IdDepartment) {
        this.IdDepartment = IdDepartment;
    }

    public long getIdEmployee() {
        return IdEmployee;
    }

    public void setIdEmployee(long IdEmployee) {
        this.IdEmployee = IdEmployee;
    }

    public long getIdEnterprise() {
        return IdEnterprise;
    }

    public void setIdEnterprise(long IdEnterprise) {
        this.IdEnterprise = IdEnterprise;
    }

    public long getIdOperation() {
        return IdOperation;
    }

    public void setIdOperation(long IdOperation) {
        this.IdOperation = IdOperation;
    }

    public long getIdUnitMoney() {
        return IdUnitMoney;
    }

    public void setIdUnitMoney(long IdUnitMoney) {
        this.IdUnitMoney = IdUnitMoney;
    }

    public float getMoneyTotal() {
        return MoneyTotal;
    }

    public void setMoneyTotal(float MoneyTotal) {
        this.MoneyTotal = MoneyTotal;
    }
}
