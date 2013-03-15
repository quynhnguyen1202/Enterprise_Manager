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
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String Name;
    private String Descript;
    private long IdEnterprise;
    private long IdDepartment;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DateStart;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DateEnd;

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

    public Date getDateEnd() {
        return DateEnd;
    }

    public void setDateEnd(Date DateEnd) {
        this.DateEnd = DateEnd;
    }

    public Date getDateStart() {
        return DateStart;
    }

    public void setDateStart(Date DateStart) {
        this.DateStart = DateStart;
    }

    public String getDescript() {
        return Descript;
    }

    public void setDescript(String Descript) {
        this.Descript = Descript;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    @Override
    public String toString() {
        return Name;
    }
}
