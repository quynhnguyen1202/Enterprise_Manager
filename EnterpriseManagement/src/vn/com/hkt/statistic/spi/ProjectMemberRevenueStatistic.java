/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.statistic.spi;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import vn.com.hkt.dao.spi.EntityManageFactoryTest;
import vn.com.hkt.data.entity.Operation;
import vn.com.hkt.data.entity.ProjectMember;
import vn.com.hkt.data.entity.UnitMoney;
import vn.com.hkt.statistic.api.IProjectMemberRevenueStatistic;

/**
 *
 * @author QuynhNguyen
 */
public class ProjectMemberRevenueStatistic implements IProjectMemberRevenueStatistic {

    float revenue = 0, spending = 0;
    private EntityManager em;
    List<Double> result;

    @Override
    public float revenueGetByProjectMember(long idEmployee, long idProject,Date dateStart, Date dateEnd) {
        String sql = " Select (sum(o." + Operation.FIELD_MONEYAFTERDISCOUNT + ")*u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + "*pm." + ProjectMember.FIELD_PERCENT + ")"
                + " from " + Operation.class.getSimpleName() + " o ," + UnitMoney.class.getSimpleName() + " u," + ProjectMember.class.getSimpleName() + " pm "
                + " where o." + Operation.FIELD_IDEMPLOYEE + " = pm." + ProjectMember.FIELD_IDEMPLOYEE + " and o." + Operation.FIELD_IDPROJECT + " = pm." + ProjectMember.FIELD_IDPROJECT
                + " and " + Operation.FIELD_CLASSIFICATION + "= 1"
                + " and pm." + ProjectMember.FIELD_IDEMPLOYEE + "= ?1 and pm." + ProjectMember.FIELD_IDPROJECT + "= ?2"
                + " and o."+Operation.FIELD_DATEEXECUTE+" <= ?3 and o."+Operation.FIELD_DATEEXECUTE+" >= ?4";;
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {
            result = em.createQuery(sql).setParameter(1, idEmployee).setParameter(2, idProject).setParameter(3, dateEnd).setParameter(4, dateStart).getResultList();
            if (result != null && !result.isEmpty()) {
                revenue = Float.parseFloat(result.get(0).toString());
            } else {
                revenue = 0;
            }
        } catch (Exception e) {
            revenue = 0;
        }
        return revenue;

    }

    @Override
    public float spendingGetByProjectMember(long idEmployee, long idProject,Date dateStart, Date dateEnd) {
        String sql = " Select (sum(o." + Operation.FIELD_MONEYAFTERDISCOUNT + ")*u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + "*pm." + ProjectMember.FIELD_PERCENT + ")"
                + " from " + Operation.class.getSimpleName() + " o ," + UnitMoney.class.getSimpleName() + " u," + ProjectMember.class.getSimpleName() + " pm "
                + " where o." + Operation.FIELD_IDEMPLOYEE + " = pm." + ProjectMember.FIELD_IDEMPLOYEE + " and o." + Operation.FIELD_IDPROJECT + " = pm." + ProjectMember.FIELD_IDPROJECT
                + " and " + Operation.FIELD_CLASSIFICATION + "= 0"
                + " and pm." + ProjectMember.FIELD_IDEMPLOYEE + "= ?1 and pm." + ProjectMember.FIELD_IDPROJECT + "= ?2"
                + " and o."+Operation.FIELD_DATEEXECUTE+" <= ?3 and o."+Operation.FIELD_DATEEXECUTE+" >= ?4";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {
            result = em.createQuery(sql).setParameter(1, idEmployee).setParameter(2, idProject).setParameter(3, dateEnd).setParameter(4, dateStart).getResultList();
            if (result != null && !result.isEmpty()) {
                spending = Float.parseFloat(result.get(0).toString());
            } else {
                spending = 0;
            }
        } catch (Exception e) {
            revenue = 0;
        }
        return spending;
    }
}
