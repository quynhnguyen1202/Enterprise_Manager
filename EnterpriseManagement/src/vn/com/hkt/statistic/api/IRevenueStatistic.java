/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.statistic.api;

import java.util.Date;
import java.util.Date;

/**
 *
 * @author QuynhNguyen
 */
public interface IRevenueStatistic {

    public float revenueGetByEnterprise(long idEnterprise, Date DateStart, Date DateEnd);

    public float revenueGetByDepartment(long idDepartment, Date DateStart, Date DateEnd);

    public float revenueGetByEmployee(long idEmployee, Date DateStart, Date DateEnd);

    public float revenueGetByProductGroup(long idProductGroup, Date DateStart, Date DateEnd);

    public float revenueGetByProduct(long idProduct, Date DateStart, Date DateEnd);

    public float revenueGetByProject(long idProject, Date DateStart, Date DateEnd);
}
