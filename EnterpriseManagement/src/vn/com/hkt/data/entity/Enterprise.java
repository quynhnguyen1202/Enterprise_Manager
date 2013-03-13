/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.data.entity;

import java.util.Date;
import javax.annotation.Generated;
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
public class Enterprise {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long Id; // Id của mỗi Enterprise
    private String Name;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DateActivative;
    private long IdEnterprise; // ID của Enterprise cha
    private String Slogan;
    private String Picture; // đường dẫn đến logo

    public Enterprise(long Id, String Name, Date DateActivative, long IdEnterprise, String Slogan, String Picture) {
        this.Id = Id;
        this.Name = Name;
        this.DateActivative = DateActivative;
        this.IdEnterprise = IdEnterprise;
        this.Slogan = Slogan;
        this.Picture = Picture;
    }

    public Enterprise() {
    }

    public Date getDateActivative() {
        return DateActivative;
    }

    public void setDateActivative(Date DateActivative) {
        this.DateActivative = DateActivative;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
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

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String Picture) {
        this.Picture = Picture;
    }

    public String getSlogan() {
        return Slogan;
    }

    public void setSlogan(String Slogan) {
        this.Slogan = Slogan;
    }
}
