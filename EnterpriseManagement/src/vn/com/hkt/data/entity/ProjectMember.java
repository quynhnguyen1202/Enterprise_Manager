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
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long Id;
    private long IdProject;
    private long IdEnterprise;
    private  int Percent;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DateStart;
    @Temporal(javax.persistence.TemporalType.DATE)
    private  Date DateEnd;

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

    public long getIdEnterprise() {
        return IdEnterprise;
    }

    public void setIdEnterprise(long IdEnterprise) {
        this.IdEnterprise = IdEnterprise;
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
