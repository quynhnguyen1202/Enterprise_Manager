/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.statistic.spi;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.swing.JOptionPane;
import vn.com.hkt.dao.spi.EntityManageFactoryTest;
import vn.com.hkt.data.entity.Enterprise;
import vn.com.hkt.data.entity.Operation;
import vn.com.hkt.data.entity.UnitMoney;
import vn.com.hkt.statistic.api.IEnterpriseRevenueStatistic;

/**
 *
 * @author QuynhNguyen
 */
public class EnterpriseRevenueStatistic implements IEnterpriseRevenueStatistic {

    private EntityManager em;
    List<Object> result = null;

    @Override
    public float revenueGetByTotalEnterprise(long idEnterprise, Date dateStart, Date dateEnd) {
        float revenue = 0;
        String sql = "with tmp ( id , idEnterprise ) as "
                + "(select e." + Enterprise.FIELD_ID + " ,e." + Enterprise.FIELD_IDENTERPRISE
                + " from " + Enterprise.class.getSimpleName() + " e  "
                + "where e." + Enterprise.FIELD_ID + " =  " + idEnterprise
                + " union all  select  e." + Enterprise.FIELD_ID + " ,e." + Enterprise.FIELD_IDENTERPRISE
                + " From " + Enterprise.class.getSimpleName() + " e join tmp t on t.id=e." + Enterprise.FIELD_IDENTERPRISE + " )"
                + "select  sum( o." + Operation.FIELD_MONEYAFTERDISCOUNT + " * u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + " ) "
                + "from " + Operation.class.getSimpleName() + " o join  " + UnitMoney.class.getSimpleName() + " u on o." + Operation.FIELD_ID_UNITMONEY + " = u." + UnitMoney.FIELD_ID
                + "join  tmp t on t.id=o." + Operation.FIELD_IDENTERPRISE
                + " where o." + Operation.FIELD_DATEEXECUTE + " >= ?2 and o." + Operation.FIELD_DATEEXECUTE + " <= ?3  and o." + Operation.FIELD_CLASSIFICATION + " = 1 ";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {
            result = em.createNativeQuery(sql).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).getResultList();
            if (result != null && !result.isEmpty()) {
                revenue = Float.parseFloat(result.get(0).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }

        return revenue;

    }

    @Override
    public float revenueGetByTotalChildrenEnterprise(long idParentEnterprise, Date dateStart, Date dateEnd) {
        float revenueChildren = revenueGetByTotalEnterprise(idParentEnterprise, dateStart, dateEnd) - revenueGetByEnterprise(idParentEnterprise, dateStart, dateEnd);
        return revenueChildren;
    }

    @Override
    public float revenueGetByEnterprise(long idEnterprise, Date dateStart, Date dateEnd) {
        float sum = 0;
        String sql = "select sum(tbl." + Operation.FIELD_MONEYAFTERDISCOUNT + ")"
                + " from " + Operation.class.getSimpleName() + " tbl where (tbl." + Operation.FIELD_IDENTERPRISE + "=?1) "
                + " and ( tbl." + Operation.FIELD_DATEEXECUTE + " >= ?2 )"
                + " and (tbl." + Operation.FIELD_DATEEXECUTE + "<=?3)"
                + " and (tbl." + Operation.FIELD_CLASSIFICATION + " = 1)";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            result = em.createQuery(sql).setParameter(1, idEnterprise).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).getResultList();
            if (result != null && !result.isEmpty()) {
                try {
                    sum = Float.parseFloat(result.get(0).toString());
                } catch (Exception e) {
                    System.out.println(e);
                    sum = 0;
                }
            } else {
                sum = 0;
            }
        } catch (Exception e) {
            sum = 0;
            System.out.println(e);
        } finally {
            em.close();
        }
        return sum;
    }

    @Override
    public float spendingGetByEnterprise(long idEnterprise, Date dateStart, Date dateEnd) {
        float spending = 0;
        String sql = "with tmp ( id , idEnterprise ) as "
                + "(select e." + Enterprise.FIELD_ID + " ,e." + Enterprise.FIELD_IDENTERPRISE
                + " from " + Enterprise.class.getSimpleName() + " e  "
                + "where e." + Enterprise.FIELD_ID + " =  " + idEnterprise
                + " union all  select  e." + Enterprise.FIELD_ID + " ,e." + Enterprise.FIELD_IDENTERPRISE
                + " From " + Enterprise.class.getSimpleName() + " e join tmp t on t.id=e." + Enterprise.FIELD_IDENTERPRISE + " )"
                + "select  sum( o." + Operation.FIELD_MONEYAFTERDISCOUNT + " * u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + " ) "
                + "from " + Operation.class.getSimpleName() + " o join  " + UnitMoney.class.getSimpleName() + " u on o." + Operation.FIELD_ID_UNITMONEY + " = u." + UnitMoney.FIELD_ID
                + "join  tmp t on t.id=o." + Operation.FIELD_IDENTERPRISE
                + " where o." + Operation.FIELD_DATEEXECUTE + " >= ?2 and o." + Operation.FIELD_DATEEXECUTE + " <= ?3  and o." + Operation.FIELD_CLASSIFICATION + " = 0 ";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {
            result = em.createNativeQuery(sql).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).getResultList();
            if (result != null && !result.isEmpty()) {
                spending = Float.parseFloat(result.get(0).toString());
            } else {
                spending = 0;
            }
        } catch (Exception e) {
            spending = 0;
            System.out.println(e);
        }

        return spending;
    }

    @Override
    public float spendingGetByTotalEnterprise(long idEnterprise, Date dateStart, Date dateEnd) {
        float spending = 0;
        String sql = "with tmp ( id , idEnterprise ) as "
                + "(select e." + Enterprise.FIELD_ID + " ,e." + Enterprise.FIELD_IDENTERPRISE
                + " from " + Enterprise.class.getSimpleName() + " e  "
                + "where e." + Enterprise.FIELD_ID + " =  " + idEnterprise
                + " union all  select  e." + Enterprise.FIELD_ID + " ,e." + Enterprise.FIELD_IDENTERPRISE
                + " From " + Enterprise.class.getSimpleName() + " e join tmp t on t.id=e." + Enterprise.FIELD_IDENTERPRISE + ")"
                + "select  sum( o." + Operation.FIELD_MONEYAFTERDISCOUNT + " * u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + " ) "
                + "from " + Operation.class.getSimpleName() + " o join  " + UnitMoney.class.getSimpleName() + " u on o." + Operation.FIELD_ID_UNITMONEY + " = u." + UnitMoney.FIELD_ID
                + "join  tmp t on t.id=o." + Operation.FIELD_IDENTERPRISE
                + " where o." + Operation.FIELD_DATEEXECUTE + " >= ?2 and o." + Operation.FIELD_DATEEXECUTE + " <= ?3  and o." + Operation.FIELD_CLASSIFICATION + " = 0 ";
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
    public float spendingGetByTotalChildrenEnterprise(long idEnterprise, Date dateStart, Date dateEnd) {
        float spending = 0;
        spending = spendingGetByTotalEnterprise(idEnterprise, dateStart, dateEnd) - spendingGetByEnterprise(idEnterprise, dateStart, dateEnd);
        return spending;
    }
}
