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
public class Project implements IEntity{

    public static final String FIELD_ID = "Id";
    public static final String FIELD_NAME = "Name";
    public static final String FIELD_IDENTERPRISE = "IdEnterprise";
    public static final String FIELD_DESCRIPT = "Descript";
    public static final String FIELD_IDDEPARTMENT = "IdDepartment";
    public static final String FIELD_DATESTART = "DateStart";
    public static final String FIELD_DATEEND = "DateEnd";
    public static final String FIELD_CODEPROJECT  = "codeProject";
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
    private String codeProject;

    public String getCodeProject() {
        return codeProject;
    }

    public void setCodeProject(String codeProject) {
        this.codeProject = codeProject;
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

    @Override
    public String toString() {
        return Name;
    }
}
