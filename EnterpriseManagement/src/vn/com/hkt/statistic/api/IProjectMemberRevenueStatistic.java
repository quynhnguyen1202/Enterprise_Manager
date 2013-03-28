/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.statistic.api;

import java.util.Date;

/**
 *
 * @author QuynhNguyen
 */
public interface IProjectMemberRevenueStatistic {

    public float revenueGetByProjectMember(long idEmployee, long idProject,Date dateStart, Date dateEnd);

    public float spendingGetByProjectMember(long idEmployee, long idProject,Date dateStart, Date dateEnd);
}
