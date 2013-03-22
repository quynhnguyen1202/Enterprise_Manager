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
import vn.com.hkt.data.entity.Operation;
import vn.com.hkt.data.entity.Project;
import vn.com.hkt.data.entity.UnitMoney;
import vn.com.hkt.statistic.api.IProjectRevenueStatistic;

/**
 *
 * @author QuynhNguyen
 */
public class ProjectRevenueStatistic implements IProjectRevenueStatistic {

    private EntityManager em;
    List<Double> result = null;
    private float revenue = 0;

    @Override
    public float revenueGetByProject(long idProject, Date dateStart, Date dateEnd) {
        String sql = "select sum(o." + Operation.FIELD_MONEYAFTERDISCOUNT + ") from " + Operation.class.getSimpleName() + " o,"
                + " where (o." + Operation.FIELD_IDPROJECT + "=?1 )"
                + "and ( o." + Operation.FIELD_DATEEXECUTE + " >= ?2 )"
                + " and (o." + Operation.FIELD_DATEEXECUTE + "<?3)";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            result = em.createQuery(sql).setParameter(1, idProject).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).getResultList();
            if (result != null && !result.isEmpty()) {
                try {
                    revenue = Float.parseFloat(result.get(0).toString());
                } catch (Exception e) {
                    System.out.println(e);
                }

            } else {
                revenue = 0;
            }

        } catch (Exception e) {
            return 0;
        } finally {
            em.close();
        }
        return revenue;
    }

    @Override
    public float revenueGetByTotalProject(long idProject, Date dateStart, Date dateEnd) {
        String sql = "with tmp ( id , idProject ) as "
                + "(select e." + Project.FIELD_ID + " ,e." + Project.FIELD_IDENTERPRISE
                + " from " + Project.class.getSimpleName() + " e  "
                + "where e." + Project.FIELD_ID + " =  " + idProject
                + " union all  select  e." + Project.FIELD_ID + " ,e." + Project.FIELD_IDENTERPRISE
                + " From " + Project.class.getSimpleName() + " e join tmp t on t.id=e.IdProject )"
                + "select  sum( o." + Operation.FIELD_MONEYAFTERDISCOUNT + " * u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + " ) "
                + "from " + Operation.class.getSimpleName() + " o join  " + UnitMoney.class.getSimpleName() + " u on o.idUnitMoney = u.id "
                + "join  tmp t on t.id=o.IdProject "
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
    public float revenueGetByTotalChildrenProject(long idProject, Date dateStart, Date dateEnd) {
        revenue = revenueGetByTotalProject(idProject, dateStart, dateEnd) - revenueGetByProject(idProject, dateStart, dateEnd);
        return revenue;
    }
}
