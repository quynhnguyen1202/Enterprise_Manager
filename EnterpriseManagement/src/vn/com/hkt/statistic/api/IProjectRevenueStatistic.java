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
public interface IProjectRevenueStatistic {

    public float revenueGetByProject(long idProject, Date dateStart, Date dateEnd);

    public float spendingGetByProject(long idProject, Date dateStart, Date dateEnd);
}
