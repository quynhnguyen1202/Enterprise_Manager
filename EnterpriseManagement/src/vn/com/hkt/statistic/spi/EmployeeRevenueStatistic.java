/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.statistic.spi;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import vn.com.hkt.dao.spi.EntityManageFactoryTest;
import vn.com.hkt.data.entity.Employee;
import vn.com.hkt.data.entity.Operation;
import vn.com.hkt.data.entity.UnitMoney;
import vn.com.hkt.statistic.api.IEmployeeRevenueStatistic;

/**
 *
 * @author QuynhNguyen
 */
public class EmployeeRevenueStatistic implements IEmployeeRevenueStatistic {

    private float revenue = 0;
    private List<Double> result = null;
    private EntityManager em;
    private float spending = 0;

    @Override
    public float revenueGetByEmployee(long idEmployee, Date dateStart, Date dateEnd) {
        String sql = "select sum(tbl." + Operation.FIELD_MONEYAFTERDISCOUNT + ") from " + Operation.class.getSimpleName() + " tbl where tbl." + Operation.FIELD_IDEMPLOYEE + "=?1 "
                + "  and (tbl." + Operation.FIELD_DATEEXECUTE + " >= ?2 )"
                + " and (tbl." + Operation.FIELD_DATEEXECUTE + "<=?3) and ( tbl." + Operation.FIELD_CLASSIFICATION + "= 1 )";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {
            result = em.createQuery(sql).setParameter(1, idEmployee).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).getResultList();
            if (result != null && !result.isEmpty()) {
                revenue = Float.parseFloat(result.get(0).toString());
            } else {
                revenue = 0;
            }
        } catch (Exception e) {
            revenue = 0;
            System.out.println(e);
        } finally {
            em.close();
        }
        return revenue;
    }

    @Override
    public float spendingGetByEmployee(long idEmployee, Date dateStart, Date dateEnd) {
        String sql = "select sum(tbl." + Operation.FIELD_MONEYAFTERDISCOUNT + ") from " + Operation.class.getSimpleName() + " tbl where tbl." + Operation.FIELD_IDEMPLOYEE + "=?1) "
                + " and (tbl." + Operation.FIELD_DATEEXECUTE + " >= ?2 )"
                + " and (tbl." + Operation.FIELD_DATEEXECUTE + "<=?3) and ( tbl." + Operation.FIELD_CLASSIFICATION + "= 0 ";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {
            result = em.createQuery(sql).setParameter(1, idEmployee).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).getResultList();
            if (result != null && !result.isEmpty()) {
                spending = Float.parseFloat(result.get(0).toString());
            } else {
                spending = 0;
            }
        } catch (Exception e) {
            spending = 0;
            System.out.println(e);
        } finally {
            em.close();
        }
        return spending;
    }

   
}
