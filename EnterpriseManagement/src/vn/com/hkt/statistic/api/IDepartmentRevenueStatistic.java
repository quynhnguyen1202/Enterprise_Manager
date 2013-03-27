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
public interface IDepartmentRevenueStatistic {

    public float revenueGetByDepartment(long idDepartment, Date dateStart, Date dateEnd);

    public float revenueGetByTotalDepartment(long idDepartment, Date dateStart, Date dateEnd);

    public float revenueGetByTotalChildrenDepartment(long idDepartment, Date dateStart, Date dateEnd);

    public float spendingGetByDepartment(long idDepartment, Date dateStart, Date dateEnd);

    public float spendingGetByTotalDepartment(long idDepartment, Date dateStart, Date dateEnd);

    public float spendingGetByTotalChildrenDepartment(long idDepartment, Date dateStart, Date dateEnd);
}
