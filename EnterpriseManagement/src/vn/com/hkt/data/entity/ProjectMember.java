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
public class ProjectMember {

    public static final String FIELD_ID = "Id";
    public static final String FIELD_IDPROJECT = "IdProject";
    public static final String FIELD_IDEMPLOYEE = "IdEmployee";
    public static final String FIELD_DATESTART = "DateStart";
    public static final String FIELD_DATEEND = "DateEnd";
    public static final String FIELD_CODE_PROJECTMEMBER = "codeProjectMember";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private long IdProject;
    private long IdEmployee;
    private int Percent;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DateStart;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DateEnd;
    private String codeProjectMember;

    public String getCodeProjectMember() {
        return codeProjectMember;
    }

    public void setCodeProjectMember(String codeProjectMember) {
        this.codeProjectMember = codeProjectMember;
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

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public long getIdEmployee() {
        return IdEmployee;
    }

    public void setIdEmployee(long IdEmployee) {
        this.IdEmployee = IdEmployee;
    }

  

    public long getIdProject() {
        return IdProject;
    }

    public void setIdProject(long IdProject) {
        this.IdProject = IdProject;
    }

    public int getPercent() {
        return Percent;
    }

    public void setPercent(int Percent) {
        this.Percent = Percent;
    }
}
