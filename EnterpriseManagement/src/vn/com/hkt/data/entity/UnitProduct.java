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
public class UnitProduct {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long Id;
    private String Name;
    private boolean isDefault;
    private float RatiowithDefault;

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

    public float getRatiowithDefault() {
        return RatiowithDefault;
    }

    public void setRatiowithDefault(float RatiowithDefault) {
        this.RatiowithDefault = RatiowithDefault;
    }

    public boolean isIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }
    
    
    
}
