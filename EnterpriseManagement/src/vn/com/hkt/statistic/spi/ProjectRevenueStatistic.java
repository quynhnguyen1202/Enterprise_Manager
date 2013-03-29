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
                + " and ( o." + Operation.FIELD_DATEEXECUTE + " >= ?2 )"
                + " and (o." + Operation.FIELD_DATEEXECUTE + "<=?3) and o." + Operation.FIELD_CLASSIFICATION + " = 1 ";
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
    public float spendingGetByProject(long idProject, Date dateStart, Date dateEnd) {
        String sql = "select sum(o." + Operation.FIELD_MONEYAFTERDISCOUNT + ") from " + Operation.class.getSimpleName() + " o,"
                + " where (o." + Operation.FIELD_IDPROJECT + "=?1 )"
                + " and ( o." + Operation.FIELD_DATEEXECUTE + " >= ?2 )"
                + " and (o." + Operation.FIELD_DATEEXECUTE + "<=?3) and o." + Operation.FIELD_CLASSIFICATION + " = 0";
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
    public float revenueGetByProject(long idProject, long idDepartment, long idEnterprise, Date dateStart, Date dateEnd) {
        if (idEnterprise > 0) {
            if (idDepartment > 0) {
                String sql = "select sum(o." + Operation.FIELD_MONEYAFTERDISCOUNT + ") from " + Operation.class.getSimpleName() + " o,"
                        + " where (o." + Operation.FIELD_IDPROJECT + "=?1 )"
                        + " and o." + Operation.FIELD_IDDEPARTMENT + " = ?2 and o." + Operation.FIELD_IDENTERPRISE + " = ?3 "
                        + " and ( o." + Operation.FIELD_DATEEXECUTE + " >= ?4 )"
                        + " and (o." + Operation.FIELD_DATEEXECUTE + "<=?5) and o." + Operation.FIELD_CLASSIFICATION + " = 1 ";
                if (em == null || !em.isOpen()) {
                    em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();

                }
                try {
                    result = em.createNativeQuery(sql).setParameter(1, idProject).setParameter(2, idDepartment).setParameter(3, idEnterprise).setParameter(4, dateStart, TemporalType.DATE).setParameter(5, dateEnd, TemporalType.DATE).getResultList();
                    if (result != null && !result.isEmpty()) {
                        revenue = Float.parseFloat(result.get(0).toString());
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                String sql = "select sum(o." + Operation.FIELD_MONEYAFTERDISCOUNT + ") from " + Operation.class.getSimpleName() + " o,"
                        + " where (o." + Operation.FIELD_IDPROJECT + "=?1 )"
                        + "  and o." + Operation.FIELD_IDENTERPRISE + " = ?3"
                        + " and ( o." + Operation.FIELD_DATEEXECUTE + " >= ?4 )"
                        + " and (o." + Operation.FIELD_DATEEXECUTE + "<=?5) and o." + Operation.FIELD_CLASSIFICATION + " = 1 ";
                if (em == null || !em.isOpen()) {
                    em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();

                }
                try {
                    result = em.createNativeQuery(sql).setParameter(1, idProject).setParameter(3, idEnterprise).setParameter(4, dateStart, TemporalType.DATE).setParameter(5, dateEnd, TemporalType.DATE).getResultList();
                    if (result != null && !result.isEmpty()) {
                        revenue = Float.parseFloat(result.get(0).toString());
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        } else {
            if (idDepartment > 0) {
                String sql = "select sum(o." + Operation.FIELD_MONEYAFTERDISCOUNT + ") from " + Operation.class.getSimpleName() + " o,"
                        + " where (o." + Operation.FIELD_IDPROJECT + "=?1 )"
                        + " and o." + Operation.FIELD_IDDEPARTMENT + " = ?2 "
                        + " and ( o." + Operation.FIELD_DATEEXECUTE + " >= ?4 )"
                        + " and (o." + Operation.FIELD_DATEEXECUTE + "<=?5) and o." + Operation.FIELD_CLASSIFICATION + " = 1 ";
                if (em == null || !em.isOpen()) {
                    em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();

                }
                try {
                    result = em.createNativeQuery(sql).setParameter(1, idProject).setParameter(2, idDepartment).setParameter(4, dateStart, TemporalType.DATE).setParameter(5, dateEnd, TemporalType.DATE).getResultList();
                    if (result != null && !result.isEmpty()) {
                        revenue = Float.parseFloat(result.get(0).toString());
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                String sql = "select sum(o." + Operation.FIELD_MONEYAFTERDISCOUNT + ") from " + Operation.class.getSimpleName() + " o,"
                        + " where (o." + Operation.FIELD_IDPROJECT + "=?1 )"
                        + " and ( o." + Operation.FIELD_DATEEXECUTE + " >= ?4 )"
                        + " and (o." + Operation.FIELD_DATEEXECUTE + "<=?5) and o." + Operation.FIELD_CLASSIFICATION + " = 1 ";
                if (em == null || !em.isOpen()) {
                    em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();

                }
                try {
                    result = em.createNativeQuery(sql).setParameter(1, idProject).setParameter(4, dateStart, TemporalType.DATE).setParameter(5, dateEnd, TemporalType.DATE).getResultList();
                    if (result != null && !result.isEmpty()) {
                        revenue = Float.parseFloat(result.get(0).toString());
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        return revenue;
    }

    @Override
    public float spendingGetByProject(long idProject, long idDepartment, long idEnterprise, Date dateStart, Date dateEnd) {
        float spending = 0;
        if (idEnterprise > 0) {
            if (idDepartment > 0) {
                String sql = "select sum(o." + Operation.FIELD_MONEYAFTERDISCOUNT + ") from " + Operation.class.getSimpleName() + " o,"
                        + " where (o." + Operation.FIELD_IDPROJECT + "=?1 )"
                        + " and o." + Operation.FIELD_IDDEPARTMENT + " = ?2 and o." + Operation.FIELD_IDENTERPRISE + " = ?3 "
                        + " and ( o." + Operation.FIELD_DATEEXECUTE + " >= ?4 )"
                        + " and (o." + Operation.FIELD_DATEEXECUTE + "<=?5) and o." + Operation.FIELD_CLASSIFICATION + " = 0 ";
                if (em == null || !em.isOpen()) {
                    em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();

                }
                try {
                    result = em.createNativeQuery(sql).setParameter(1, idProject).setParameter(2, idDepartment).setParameter(3, idEnterprise).setParameter(4, dateStart, TemporalType.DATE).setParameter(5, dateEnd, TemporalType.DATE).getResultList();
                    if (result != null && !result.isEmpty()) {
                        spending = Float.parseFloat(result.get(0).toString());
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                String sql = "select sum(o." + Operation.FIELD_MONEYAFTERDISCOUNT + ") from " + Operation.class.getSimpleName() + " o,"
                        + " where (o." + Operation.FIELD_IDPROJECT + "=?1 )"
                        + "  and o." + Operation.FIELD_IDENTERPRISE + " = ?3 "
                        + " and ( o." + Operation.FIELD_DATEEXECUTE + " >= ?4 )"
                        + " and (o." + Operation.FIELD_DATEEXECUTE + "<=?5) and o." + Operation.FIELD_CLASSIFICATION + " = 0 ";
                if (em == null || !em.isOpen()) {
                    em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();

                }
                try {
                    result = em.createNativeQuery(sql).setParameter(1, idProject).setParameter(3, idEnterprise).setParameter(4, dateStart, TemporalType.DATE).setParameter(5, dateEnd, TemporalType.DATE).getResultList();
                    if (result != null && !result.isEmpty()) {
                        spending = Float.parseFloat(result.get(0).toString());
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        } else {
            if (idDepartment > 0) {
                String sql = "select sum(o." + Operation.FIELD_MONEYAFTERDISCOUNT + ") from " + Operation.class.getSimpleName() + " o,"
                        + " where (o." + Operation.FIELD_IDPROJECT + "=?1 )"
                        + " and o." + Operation.FIELD_IDDEPARTMENT + " = ?2 "
                        + " and ( o." + Operation.FIELD_DATEEXECUTE + " >= ?4 )"
                        + " and (o." + Operation.FIELD_DATEEXECUTE + "<=?5) and o." + Operation.FIELD_CLASSIFICATION + " = 0 ";
                if (em == null || !em.isOpen()) {
                    em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();

                }
                try {
                    result = em.createNativeQuery(sql).setParameter(1, idProject).setParameter(2, idDepartment).setParameter(4, dateStart, TemporalType.DATE).setParameter(5, dateEnd, TemporalType.DATE).getResultList();
                    if (result != null && !result.isEmpty()) {
                        spending = Float.parseFloat(result.get(0).toString());
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                String sql = "select sum(o." + Operation.FIELD_MONEYAFTERDISCOUNT + ") from " + Operation.class.getSimpleName() + " o,"
                        + " where (o." + Operation.FIELD_IDPROJECT + "=?1 )"
                        + " and ( o." + Operation.FIELD_DATEEXECUTE + " >= ?4 )"
                        + " and (o." + Operation.FIELD_DATEEXECUTE + "<=?5) and o." + Operation.FIELD_CLASSIFICATION + " = 0 ";
                if (em == null || !em.isOpen()) {
                    em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();

                }
                try {
                    result = em.createNativeQuery(sql).setParameter(1, idProject).setParameter(4, dateStart, TemporalType.DATE).setParameter(5, dateEnd, TemporalType.DATE).getResultList();
                    if (result != null && !result.isEmpty()) {
                        spending = Float.parseFloat(result.get(0).toString());
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        return spending;
    }
}
