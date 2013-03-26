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
public interface IEnterpriseRevenueStatistic {

    public float revenueGetByTotalEnterprise(long idEnterprise, Date dateStart, Date dateEnd);

    public float revenueGetByTotalChildrenEnterprise(long idParentEnterprise, Date dateStart, Date dateEnd);

    public float revenueGetByEnterprise(long idEnterprise, Date dateStart, Date dateEnd);

    public float spendingGetByEnterprise(long idEnterprise, Date dateStart, Date dateEnd);

    public float spendingGetByTotalEnterprise(long idEnterprise, Date dateStart, Date dateEnd);

    public float spendingGetByTotalChildrenEnterprise(long idEnterprise, Date dateStart, Date dateEnd);
}
