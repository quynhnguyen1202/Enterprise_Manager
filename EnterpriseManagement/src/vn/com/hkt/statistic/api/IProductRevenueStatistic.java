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
public interface IProductRevenueStatistic {

    public float revenueGetByProduct(long idProduct, Date dateStart, Date dateEnd);
}
