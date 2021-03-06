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
public class Department implements IEntity {

    public static final String FIELD_ID = "Id";
    public static final String FIELD_NAME = "Name";
    public static final String FIELD_DATEACTIVATE = "DateActivate";
    public static final String FIELD_IDENTERPRISE = "IdEnterprise";
    public static final String FIELD_IDDEPARTMENT = "IdDepartment";
    public static final String FIELD_CODEDEPARTMENT = "codeDepartment";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String Name;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DateActivate;
    private long IdEnterprise; // Id cua doanh nghiep cha
    private long IdDepartment; // Id cua phong ban cha
    private String codeDepartment;

    public String getCodeDepartment() {
        return codeDepartment;
    }

    public void setCodeDepartment(String codeDepartment) {
        this.codeDepartment = codeDepartment;
    }

    public Date getDateActivate() {
        return DateActivate;
    }

    @Override
    public String toString() {
        return Name;
    }

    public void setDateActivate(Date DateActivate) {
        this.DateActivate = DateActivate;
    }

    @Override
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

    public long getIdEnterprise() {
        return IdEnterprise;
    }

    public void setIdEnterprise(long IdEnterprise) {
        this.IdEnterprise = IdEnterprise;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
}
