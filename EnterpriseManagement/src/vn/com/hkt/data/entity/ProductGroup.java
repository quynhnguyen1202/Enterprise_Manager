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
public class ProductGroup {

    public static final String FIELD_ID = "";
    public static final String FIELD_NAME = "Name";
    public static final String FIELD_IDPRODUCTGROUP = "IdProductGroup";
    public static final String FIELD_IDENTERPRISE = "IdEnterprise";
    public static final String FIELD_CODEPRODUCTGROUP = "codeProductGroup";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String Name;
    private long IdProductGroup;
    private long IdEnterprise;
    private String codeProductGroup;

    public String getCodeProductGroup() {
        return codeProductGroup;
    }

    public void setCodeProductGroup(String codeProductGroup) {
        this.codeProductGroup = codeProductGroup;
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

    public long getIdProductGroup() {
        return IdProductGroup;
    }

    public void setIdProductGroup(long IdProductGroup) {
        this.IdProductGroup = IdProductGroup;
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
