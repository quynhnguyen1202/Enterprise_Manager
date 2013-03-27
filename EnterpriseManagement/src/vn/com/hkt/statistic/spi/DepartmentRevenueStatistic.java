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
import vn.com.hkt.data.entity.Department;
import vn.com.hkt.data.entity.Operation;
import vn.com.hkt.data.entity.UnitMoney;
import vn.com.hkt.statistic.api.IDepartmentRevenueStatistic;

/**
 *
 * @author QuynhNguyen
 */
public class DepartmentRevenueStatistic implements IDepartmentRevenueStatistic {

    private List<Double> result;
    private EntityManager em;

    @Override
    public float revenueGetByDepartment(long idDepartment, Date dateStart, Date dateEnd) {
        float sum = 0;
        String sql = "select sum(tbl." + Operation.FIELD_MONEYAFTERDISCOUNT + ") from " + Operation.class.getSimpleName() + " tbl where (tbl." + Operation.FIELD_ID + "=?1) "
                + "and ( tbl." + Operation.FIELD_DATEEXECUTE + " >= ?2)"
                + " and (tbl." + Operation.FIELD_DATEEXECUTE + "<=?3) and tbl." + Operation.FIELD_CLASSIFICATION + "= 1 ";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {
            result = em.createQuery(sql).setParameter(1, idDepartment).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).getResultList();
            if (result != null && !result.isEmpty()) {
                try {
                    sum = Float.parseFloat(result.get(0).toString());
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                sum = 0;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return sum;
    }

    @Override
    public float revenueGetByTotalDepartment(long idDepartment, Date dateStart, Date dateEnd) {
        float revenue = 0;
        String sql = "with tmp ( id , idDepartment ) as "
                + "(select d." + Department.FIELD_ID + " ,d." + Department.FIELD_IDDEPARTMENT
                + " from " + Department.class.getSimpleName() + " d  "
                + "where d." + Department.FIELD_ID + " =  " + idDepartment
                + " union all  select  d." + Department.FIELD_ID + " ,d." + Department.FIELD_IDDEPARTMENT
                + " From " + Department.class.getSimpleName() + " d join tmp t on t.id=d.IdDepartment )"
                + "select  sum( o." + Operation.FIELD_MONEYAFTERDISCOUNT + " * u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + " ) "
                + "from " + Operation.class.getSimpleName() + " o join  " + UnitMoney.class.getSimpleName() + " u on o.idUnitMoney = u.id "
                + "join  tmp t on t.id=o.IdDepartment "
                + " where o." + Operation.FIELD_DATEEXECUTE + " >= ?2 and o." + Operation.FIELD_DATEEXECUTE + " <= ?3 and o." + Operation.FIELD_CLASSIFICATION + "= 1 ";
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
    public float revenueGetByTotalChildrenDepartment(long idDepartment, Date dateStart, Date dateEnd) {
        float revenue = 0;
        revenue = revenueGetByTotalDepartment(idDepartment, dateStart, dateEnd) - revenueGetByDepartment(idDepartment, dateStart, dateEnd);
        return revenue;
    }

    @Override
    public float spendingGetByDepartment(long idDepartment, Date dateStart, Date dateEnd) {
        float spending = 0;
        String sql = "select sum(tbl." + Operation.FIELD_MONEYAFTERDISCOUNT + ") from " + Operation.class.getSimpleName() + " tbl where (tbl." + Operation.FIELD_ID + "=?1) "
                + "and ( tbl." + Operation.FIELD_DATEEXECUTE + " >= ?2)"
                + " and (tbl." + Operation.FIELD_DATEEXECUTE + "<=?3) and tbl." + Operation.FIELD_CLASSIFICATION + "= 0 ";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {
            result = em.createQuery(sql).setParameter(1, idDepartment).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).getResultList();
            if (result != null && !result.isEmpty()) {
                try {
                    spending = Float.parseFloat(result.get(0).toString());
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                spending = 0;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return spending;
    }

    @Override
    public float spendingGetByTotalDepartment(long idDepartment, Date dateStart, Date dateEnd) {
        float spending = 0;
        String sql = "with tmp ( id , idDepartment ) as "
                + "(select d." + Department.FIELD_ID + " ,d." + Department.FIELD_IDDEPARTMENT
                + " from " + Department.class.getSimpleName() + " d  "
                + "where d." + Department.FIELD_ID + " =  " + idDepartment
                + " union all  select  d." + Department.FIELD_ID + " ,d." + Department.FIELD_IDDEPARTMENT
                + " From " + Department.class.getSimpleName() + " d join tmp t on t.id=d.IdDepartment )"
                + "select  sum( o." + Operation.FIELD_MONEYAFTERDISCOUNT + " * u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + " ) "
                + "from " + Operation.class.getSimpleName() + " o join  " + UnitMoney.class.getSimpleName() + " u on o.idUnitMoney = u.id "
                + "join  tmp t on t.id=o.IdDepartment "
                + " where o." + Operation.FIELD_DATEEXECUTE + " >= ?2 and o." + Operation.FIELD_DATEEXECUTE + " <= ?3 and o." + Operation.FIELD_CLASSIFICATION + "= 0 ";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {
            result = em.createNativeQuery(sql).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).getResultList();
            if (result != null && !result.isEmpty()) {
                spending = Float.parseFloat(result.get(0).toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return spending;
    }

    @Override
    public float spendingGetByTotalChildrenDepartment(long idDepartment, Date dateStart, Date dateEnd) {
        float spending = 0;
        spending = spendingGetByTotalDepartment(idDepartment, dateStart, dateEnd) - spendingGetByDepartment(idDepartment, dateStart, dateEnd);
        return spending;
    }
}
