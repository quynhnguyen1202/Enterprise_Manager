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

    public float revenueGetByTotalProject(long idProject, Date dateStart, Date dateEnd);

    public float revenueGetByTotalChildrenProject(long idProject, Date dateStart, Date dateEnd);

    public float spendingGetByProject(long idProject, Date dateStart, Date dateEnd);

    public float spendingGetByTotalProject(long idProject, Date dateStart, Date dateEnd);

    public float spendingGetByTotalChildrenProject(long idProject, Date dateStart, Date dateEnd);

    public float revenueGetByProject(long idProject, long idDepartment, long idEnterprise, Date dateStart, Date dateEnd);

    public float spendingGetByProject(long idProject, long idDepartment, long idEnterprise, Date dateStart, Date dateEnd);

    public float revenueGetByTotalProject(long idProject, long idDepartment, long idEnterprise, Date dateStart, Date dateEnd);

    public float spendingGetByTotalProject(long idProject, long idDepartment, long idEnterprise, Date dateStart, Date dateEnd);

    public float revenueGetByTotalChildrenProject(long idProject, long idDepartment, long idEnterprise, Date dateStart, Date dateEnd);

    public float spendingGetByTotalChildrenProject(long idProject, long idDepartment, long idEnterprise, Date dateStart, Date dateEnd);
}
