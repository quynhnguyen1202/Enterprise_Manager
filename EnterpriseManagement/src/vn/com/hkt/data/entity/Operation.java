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
public class Operation implements IEntity{

    public static final String FIELD_ID = "Id";
    public static final String FIELD_IDPROJECT = "IdProject";
    public static final String FIELD_IDENTERPRISE = "IdEnterprise";
    public static final String FIELD_IDDEPARTMENT = "IdDepartment";
    public static final String FIELD_IDEMPLOYEE = "IdEmployee";
    public static final String FIELD_DATEEXECUTE = "DateExecute";
    public static final String FIELD_CLASSIFICATION = "classification";
    public static final String FIELD_CODEOPERATION = "codeOperation";
    public static final String FIELD_MONEYAFTERDISCOUNT = "MoneyAfterDiscount";
    public static final String FIELD_MONEYAFTERTAX = "MoneyAfterTax";
    public static final String FIELD_MONEYTOTAL = "MoneyTotal";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private long IdProject;
    private float MoneyTotal;
    private float MoneyAfterTax;
    private float MoneyAfterDiscount;
    private long IdEnterprise;
    private long IdDepartment;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DateExecute;
    private long IdEmployee;
    private long IdUnitMoney;
    private boolean classification; // mua hoac ban : classification = 1 : ban , = 0 : mua
    private String codeOperation;

    public String getCodeOperation() {
        return codeOperation;
    }

    public void setCodeOperation(String codeOperation) {
        this.codeOperation = codeOperation;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public long getIdEmployee() {
        return IdEmployee;
    }

    public long getIdUnitMoney() {
        return IdUnitMoney;
    }

    public void setIdUnitMoney(long IdUnitMoney) {
        this.IdUnitMoney = IdUnitMoney;
    }

    public boolean isClassification() {
        return classification;
    }

    public void setClassification(boolean classification) {
        this.classification = classification;
    }

    public void setIdEmployee(long IdEmployee) {
        this.IdEmployee = IdEmployee;
    }

    public Operation() {
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
