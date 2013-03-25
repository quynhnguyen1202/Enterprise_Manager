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
public class UnitMoney implements IEntity {

    public static final String FIELD_ID = "Id";
    public static final String FIELD_NAME = "Name";
    public static final String FIELD_CODE = "code";
    public static final String FIELD_IS_DEFAULT = "isDefault";
    public static final String FIELD_RATIO_WITH_DEFAULT = "RatiowithDefault";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String Name;
    private boolean isDefault;
    private float RatiowithDefault;
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
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

    @Override
    public String toString() {
        return Name;
    }
}
