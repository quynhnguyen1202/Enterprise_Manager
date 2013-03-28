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
public interface IEmployeeRevenueStatistic {

    public float revenueGetByEmployee(long idEmployee, Date dateStart, Date dateEnd);

//    public float revenueGetByTotalEmployee(long idEmployee, Date dateStart, Date dateEnd);
//
//    public float revenueGetByTotalChildrenEmployee(long idEmployee, Date dateStart, Date dateEnd);

    public float spendingGetByEmployee(long idEmployee, Date dateStart, Date dateEnd);

//    public float spendingGetByTotalEmployee(long idEmployee, Date dateStart, Date dateEnd);
//
//    public float spendingGetByTotalChildrenEmployee(long idEmployee, Date dateStart, Date dateEnd);
    
     public float revenueGetByEmployee(long idEmployee,long idDepartment,long idEnterprise, Date dateStart, Date dateEnd);

//    public float revenueGetByTotalEmployee(long idEmployee,long idDepartment,long idEnterprise, Date dateStart, Date dateEnd);
//
//    public float revenueGetByTotalChildrenEmployee(long idEmployee,long idDepartment,long idEnterprise, Date dateStart, Date dateEnd);

    public float spendingGetByEmployee(long idEmployee,long idDepartment,long idEnterprise, Date dateStart, Date dateEnd);

//    public float spendingGetByTotalEmployee(long idEmployee,long idDepartment,long idEnterprise, Date dateStart, Date dateEnd);
//
//    public float spendingGetByTotalChildrenEmployee(long idEmployee,long idDepartment,long idEnterprise, Date dateStart, Date dateEnd);
}
