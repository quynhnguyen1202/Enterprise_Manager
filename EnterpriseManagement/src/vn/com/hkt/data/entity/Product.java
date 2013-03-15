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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String Name;
    private long IdEnterprise;
    private long IdDepartment;

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

    @Override
    public String toString() {
        return Name;
    }
}
