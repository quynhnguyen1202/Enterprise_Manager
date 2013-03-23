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

    @Override
    public float revenueGetByEmployee(long idEmployee, Date dateStart, Date dateEnd) {
        String sql = "select sum(tbl." + Operation.FIELD_MONEYAFTERDISCOUNT + ") from" + Operation.class.getSimpleName() + " tbl where (Id=?1) "
                + "and (tbl." + Operation.FIELD_DATEEXECUTE + " >= ?2 )"
                + " and (tbl." + Operation.FIELD_DATEEXECUTE + "<?3)";
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
            System.out.println(e);
        } finally {
            em.close();
        }
        return revenue;
    }

    public float revenueGetByTotalEmployee(long idEmployee, Date dateStart, Date dateEnd) {
        String sql = "with tmp ( id , idEmployee ) as "
                + "(select d." + Employee.FIELD_ID + " ,d." + Employee.FIELD_IDDEPARTMENT
                + " from " + Employee.class.getSimpleName() + " d  "
                + "where d." + Employee.FIELD_ID + " =  " + idEmployee
                + " union all  select  d." + Employee.FIELD_ID + " ,d." + Employee.FIELD_IDDEPARTMENT
                + " From " + Employee.class.getSimpleName() + " d join tmp t on t.id=d.IdEmployee )"
                + "select  sum( o." + Operation.FIELD_MONEYAFTERDISCOUNT + " * u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + " ) "
                + "from " + Operation.class.getSimpleName() + " o join  " + UnitMoney.class.getSimpleName() + " u on o.idUnitMoney = u.id "
                + "join  tmp t on t.id=o.IdEmployee "
                + " where o." + Operation.FIELD_DATEEXECUTE + " >= ?2 and o." + Operation.FIELD_DATEEXECUTE + " < ?3 ";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {
            result = em.createNativeQuery(sql).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).getResultList();
            if (result != null && !result.isEmpty()) {
                revenue = Float.parseFloat(result.get(0).toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return revenue;
    }

    @Override
    public float revenueGetByTotalChildrenEmployee(long idEmployee, Date dateStart, Date dateEnd) {
        revenue = revenueGetByTotalEmployee(idEmployee, dateStart, dateEnd) - revenueGetByEmployee(idEmployee, dateStart, dateEnd);
        return revenue;
    }
}
