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
public interface IProductGroupRevenueStatistic {

    public float revenueGetByTotalProductGroup(long idProductGroup, Date dateStart, Date dateEnd);

    public float revenueGetByProductGroup(long idProductGroup, Date dateStart, Date dateEnd);

    public float revenueGetByTotalChildrenProductGroup(long idProductGroup, Date dateStart, Date dateEnd);
    
    public float spendingGetByTotalProductGroup(long idProductGroup, Date dateStart, Date dateEnd);

    public float spendingGetByProductGroup(long idProductGroup, Date dateStart, Date dateEnd);

    public float spendingGetByTotalChildrenProductGroup(long idProductGroup, Date dateStart, Date dateEnd);
    
}
