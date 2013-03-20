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
public interface IReceiptStatistic {
    public float receiptGetByEnterprise(long idEnterprise,Date dateStart,Date dateEnd);
    public float receiptGetByDepartment(long idDepartment, Date dateStart, Date dateEnd);
    public float receiptGetByEmployee(long idEmployee,Date dateStart,Date dateEnd);
    public float receiptGetByProductGroup(long idProductGroup,Date dateStart,Date dateEnd);
    public float receipGetByProduct(long idProduct,Date dateStart,Date dateEnd);
    public float receiptGetByProject(long idProject,Date dateStart,Date dateEnd);
    
}
