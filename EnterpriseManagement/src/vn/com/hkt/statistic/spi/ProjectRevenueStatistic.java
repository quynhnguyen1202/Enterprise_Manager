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
    public float revenueGetByTotalProject(long idProject, Date dateStart, Date dateEnd) {
        String sql = "with tmp ( id , idProject ) as "
                + "(select e." + Project.FIELD_ID + " ,e." + Project.FIELD_IDENTERPRISE
                + " from " + Project.class.getSimpleName() + " e  "
                + "where e." + Project.FIELD_ID + " =  " + idProject
                + " union all  select  e." + Project.FIELD_ID + " ,e." + Project.FIELD_IDENTERPRISE
                + " From " + Project.class.getSimpleName() + " e join tmp t on t.id=e." + Project.FIELD_ID + " )"
                + " select  sum( o." + Operation.FIELD_MONEYAFTERDISCOUNT + " * u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + " ) "
                + " from " + Operation.class.getSimpleName() + " o join  " + UnitMoney.class.getSimpleName() + " u on o." + Operation.FIELD_ID_UNITMONEY + " = u." + UnitMoney.FIELD_ID
                + "  join  tmp t on t.id=o." + Operation.FIELD_IDPROJECT
                + " where o." + Operation.FIELD_DATEEXECUTE + " >= ?2 and o." + Operation.FIELD_DATEEXECUTE + " <= ?3 and o." + Operation.FIELD_CLASSIFICATION + " =1  ";
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
    public float spendingGetByTotalProject(long idProject, Date dateStart, Date dateEnd) {
        String sql = "with tmp ( id , idProject ) as "
                + "(select e." + Project.FIELD_ID + " ,e." + Project.FIELD_IDENTERPRISE
                + " from " + Project.class.getSimpleName() + " e  "
                + " where e." + Project.FIELD_ID + " =  " + idProject
                + " union all  select  e." + Project.FIELD_ID + " ,e." + Project.FIELD_IDENTERPRISE
                + " From " + Project.class.getSimpleName() + " e join tmp t on t.id=e." + Project.FIELD_ID + " )"
                + " select  sum( o." + Operation.FIELD_MONEYAFTERDISCOUNT + " * u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + " ) "
                + " from " + Operation.class.getSimpleName() + " o join  " + UnitMoney.class.getSimpleName() + " u on o." + Operation.FIELD_ID_UNITMONEY + "= u." + UnitMoney.FIELD_ID
                + " join  tmp t on t.id=o." + Operation.FIELD_IDPROJECT
                + " where o." + Operation.FIELD_DATEEXECUTE + " >= ?2 and o." + Operation.FIELD_DATEEXECUTE + " <= ?3 and o." + Operation.FIELD_CLASSIFICATION + " = 0 ";
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
    public float spendingGetByTotalChildrenProject(long idProject, Date dateStart, Date dateEnd) {
        revenue = spendingGetByTotalProject(idProject, dateStart, dateEnd) - spendingGetByProject(idProject, dateStart, dateEnd);
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

    @Override
    public float revenueGetByTotalProject(long idProject, long idDepartment, long idEnterprise, Date dateStart, Date dateEnd) {
        if (idEnterprise > 0) {
            if (idDepartment > 0) {
                String sql = "with tmp ( id , idProject ) as "
                        + "(select e." + Project.FIELD_ID + " ,e." + Project.FIELD_IDENTERPRISE
                        + " from " + Project.class.getSimpleName() + " e  "
                        + "where e." + Project.FIELD_ID + " =  " + idProject
                        + " union all  select  e." + Project.FIELD_ID + " ,e." + Project.FIELD_IDENTERPRISE
                        + " From " + Project.class.getSimpleName() + " e join tmp t on t.id=e." + Project.FIELD_ID + ")"
                        + " select  sum( o." + Operation.FIELD_MONEYAFTERDISCOUNT + " * u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + " ) "
                        + " from " + Operation.class.getSimpleName() + " o join  " + UnitMoney.class.getSimpleName() + " u on o." + Operation.FIELD_ID_UNITMONEY + " = u." + UnitMoney.FIELD_ID
                        + "  join  tmp t on t.id=o." + Operation.FIELD_IDPROJECT
                        + " where o." + Operation.FIELD_DATEEXECUTE + " >= ?2 and o." + Operation.FIELD_DATEEXECUTE + " <= ?3 and o." + Operation.FIELD_CLASSIFICATION + " =1  "
                        + " and o." + Operation.FIELD_IDENTERPRISE + " = ?4 and o." + Operation.FIELD_IDDEPARTMENT + " = ?5  ";
                if (em == null || !em.isOpen()) {
                    em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
                }
                try {
                    result = em.createNativeQuery(sql).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).setParameter(4, idEnterprise).setParameter(5, idDepartment).getResultList();
                    if (result != null && !result.isEmpty()) {
                        revenue = Float.parseFloat(result.get(0).toString());
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }

            } else {
                String sql = "with tmp ( id , idProject ) as "
                        + "(select e." + Project.FIELD_ID + " ,e." + Project.FIELD_IDENTERPRISE
                        + " from " + Project.class.getSimpleName() + " e  "
                        + "where e." + Project.FIELD_ID + " =  " + idProject
                        + " union all  select  e." + Project.FIELD_ID + " ,e." + Project.FIELD_IDENTERPRISE
                        + " From " + Project.class.getSimpleName() + " e join tmp t on t.id=e." + Project.FIELD_ID + " )"
                        + " select  sum( o." + Operation.FIELD_MONEYAFTERDISCOUNT + " * u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + " ) "
                        + " from " + Operation.class.getSimpleName() + " o join  " + UnitMoney.class.getSimpleName() + " u on o." + Operation.FIELD_ID_UNITMONEY + "= u." + UnitMoney.FIELD_ID
                        + "  join  tmp t on t.id=o." + Operation.FIELD_IDPROJECT
                        + " where o." + Operation.FIELD_DATEEXECUTE + " >= ?2 and o." + Operation.FIELD_DATEEXECUTE + " <= ?3 and o." + Operation.FIELD_CLASSIFICATION + " =1  and o." + Operation.FIELD_IDENTERPRISE + " = ?4";
                if (em == null || !em.isOpen()) {
                    em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
                }
                try {
                    result = em.createNativeQuery(sql).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).setParameter(4, idEnterprise).getResultList();
                    if (result != null && !result.isEmpty()) {
                        revenue = Float.parseFloat(result.get(0).toString());
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else {
            if (idDepartment > 0) {
                String sql = "with tmp ( id , idProject ) as "
                        + "(select e." + Project.FIELD_ID + " ,e." + Project.FIELD_IDENTERPRISE
                        + " from " + Project.class.getSimpleName() + " e  "
                        + "where e." + Project.FIELD_ID + " =  " + idProject
                        + " union all  select  e." + Project.FIELD_ID + " ,e." + Project.FIELD_IDENTERPRISE
                        + " From " + Project.class.getSimpleName() + " e join tmp t on t.id=e." + Project.FIELD_ID + " )"
                        + " select  sum( o." + Operation.FIELD_MONEYAFTERDISCOUNT + " * u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + " ) "
                        + " from " + Operation.class.getSimpleName() + " o join  " + UnitMoney.class.getSimpleName() + " u on o." + Operation.FIELD_ID_UNITMONEY + "= u." + UnitMoney.FIELD_ID
                        + "  join  tmp t on t.id=o." + Operation.FIELD_IDPROJECT
                        + " where o." + Operation.FIELD_DATEEXECUTE + " >= ?2 and o." + Operation.FIELD_DATEEXECUTE + " <= ?3 and o." + Operation.FIELD_CLASSIFICATION + " =1 and o." + Operation.FIELD_IDDEPARTMENT + " = ?4";
                if (em == null || !em.isOpen()) {
                    em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
                }
                try {
                    result = em.createNativeQuery(sql).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).setParameter(4, idDepartment).getResultList();
                    if (result != null && !result.isEmpty()) {
                        revenue = Float.parseFloat(result.get(0).toString());
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }

            } else {
                String sql = "with tmp ( id , idProject ) as "
                        + "(select e." + Project.FIELD_ID + " ,e." + Project.FIELD_IDENTERPRISE
                        + " from " + Project.class.getSimpleName() + " e  "
                        + "where e." + Project.FIELD_ID + " =  " + idProject
                        + " union all  select  e." + Project.FIELD_ID + " ,e." + Project.FIELD_IDENTERPRISE
                        + " From " + Project.class.getSimpleName() + " e join tmp t on t.id=e." + Project.FIELD_ID + " )"
                        + " select  sum( o." + Operation.FIELD_MONEYAFTERDISCOUNT + " * u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + " ) "
                        + " from " + Operation.class.getSimpleName() + " o join  " + UnitMoney.class.getSimpleName() + " u on o." + Operation.FIELD_ID_UNITMONEY + " = u." + UnitMoney.FIELD_ID
                        + "  join  tmp t on t.id=o." + Operation.FIELD_IDPROJECT
                        + " where o." + Operation.FIELD_DATEEXECUTE + " >= ?2 and o." + Operation.FIELD_DATEEXECUTE + " <= ?3 and o." + Operation.FIELD_CLASSIFICATION + " =1  ";
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
            }
        }
        return revenue;
    }

    @Override
    public float spendingGetByTotalProject(long idProject, long idDepartment, long idEnterprise, Date dateStart, Date dateEnd) {
        float spending = 0;
        if (idEnterprise > 0) {
            if (idDepartment > 0) {
                String sql = "with tmp ( id , idProject ) as "
                        + "(select e." + Project.FIELD_ID + " ,e." + Project.FIELD_IDENTERPRISE
                        + " from " + Project.class.getSimpleName() + " e  "
                        + "where e." + Project.FIELD_ID + " =  " + idProject
                        + " union all  select  e." + Project.FIELD_ID + " ,e." + Project.FIELD_IDENTERPRISE
                        + " From " + Project.class.getSimpleName() + " e join tmp t on t.id=e." + Project.FIELD_ID + " )"
                        + " select  sum( o." + Operation.FIELD_MONEYAFTERDISCOUNT + " * u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + " ) "
                        + " from " + Operation.class.getSimpleName() + " o join  " + UnitMoney.class.getSimpleName() + " u on o." + Operation.FIELD_ID_UNITMONEY + " = u." + UnitMoney.FIELD_ID
                        + "  join  tmp t on t.id=o." + Operation.FIELD_IDPROJECT
                        + " where o." + Operation.FIELD_DATEEXECUTE + " >= ?2 and o." + Operation.FIELD_DATEEXECUTE + " <= ?3 and o." + Operation.FIELD_CLASSIFICATION + " =1  "
                        + " and o." + Operation.FIELD_IDENTERPRISE + " = ?4 and o." + Operation.FIELD_IDDEPARTMENT + " = ?5  ";
                if (em == null || !em.isOpen()) {
                    em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
                }
                try {
                    result = em.createNativeQuery(sql).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).setParameter(4, idEnterprise).setParameter(5, idDepartment).getResultList();
                    if (result != null && !result.isEmpty()) {
                        spending = Float.parseFloat(result.get(0).toString());
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }

            } else {
                String sql = "with tmp ( id , idProject ) as "
                        + "(select e." + Project.FIELD_ID + " ,e." + Project.FIELD_IDENTERPRISE
                        + " from " + Project.class.getSimpleName() + " e  "
                        + "where e." + Project.FIELD_ID + " =  " + idProject
                        + " union all  select  e." + Project.FIELD_ID + " ,e." + Project.FIELD_IDENTERPRISE
                        + " From " + Project.class.getSimpleName() + " e join tmp t on t.id=e." + Project.FIELD_ID + " )"
                        + " select  sum( o." + Operation.FIELD_MONEYAFTERDISCOUNT + " * u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + " ) "
                        + " from " + Operation.class.getSimpleName() + " o join  " + UnitMoney.class.getSimpleName() + " u on o." + Operation.FIELD_ID_UNITMONEY + " = u." + UnitMoney.FIELD_ID
                        + "  join  tmp t on t.id=o." + Operation.FIELD_IDPROJECT
                        + " where o." + Operation.FIELD_DATEEXECUTE + " >= ?2 and o." + Operation.FIELD_DATEEXECUTE + " <= ?3 and o." + Operation.FIELD_CLASSIFICATION + " =1  and o." + Operation.FIELD_IDENTERPRISE + " = ?4";
                if (em == null || !em.isOpen()) {
                    em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
                }
                try {
                    result = em.createNativeQuery(sql).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).setParameter(4, idEnterprise).getResultList();
                    if (result != null && !result.isEmpty()) {
                        spending = Float.parseFloat(result.get(0).toString());
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else {
            if (idDepartment > 0) {
                String sql = "with tmp ( id , idProject ) as "
                        + "(select e." + Project.FIELD_ID + " ,e." + Project.FIELD_IDENTERPRISE
                        + " from " + Project.class.getSimpleName() + " e  "
                        + "where e." + Project.FIELD_ID + " =  " + idProject
                        + " union all  select  e." + Project.FIELD_ID + " ,e." + Project.FIELD_IDENTERPRISE
                        + " From " + Project.class.getSimpleName() + " e join tmp t on t.id=e." + Project.FIELD_ID + " )"
                        + " select  sum( o." + Operation.FIELD_MONEYAFTERDISCOUNT + " * u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + " ) "
                        + " from " + Operation.class.getSimpleName() + " o join  " + UnitMoney.class.getSimpleName() + " u on o." + Operation.FIELD_ID_UNITMONEY + " = u." + UnitMoney.FIELD_ID
                        + "  join  tmp t on t.id=o." + Operation.FIELD_IDPROJECT
                        + " where o." + Operation.FIELD_DATEEXECUTE + " >= ?2 and o." + Operation.FIELD_DATEEXECUTE + " <= ?3 and o." + Operation.FIELD_CLASSIFICATION + " =1 and o." + Operation.FIELD_IDDEPARTMENT + " = ?4";
                if (em == null || !em.isOpen()) {
                    em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
                }
                try {
                    result = em.createNativeQuery(sql).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).setParameter(4, idDepartment).getResultList();
                    if (result != null && !result.isEmpty()) {
                        spending = Float.parseFloat(result.get(0).toString());
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }

            } else {
                String sql = "with tmp ( id , idProject ) as "
                        + "(select e." + Project.FIELD_ID + " ,e." + Project.FIELD_IDENTERPRISE
                        + " from " + Project.class.getSimpleName() + " e  "
                        + "where e." + Project.FIELD_ID + " =  " + idProject
                        + " union all  select  e." + Project.FIELD_ID + " ,e." + Project.FIELD_IDENTERPRISE
                        + " From " + Project.class.getSimpleName() + " e join tmp t on t.id=e." + Project.FIELD_ID + " )"
                        + " select  sum( o." + Operation.FIELD_MONEYAFTERDISCOUNT + " * u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + " ) "
                        + " from " + Operation.class.getSimpleName() + " o join  " + UnitMoney.class.getSimpleName() + " u on o." + Operation.FIELD_ID_UNITMONEY + " = u." + UnitMoney.FIELD_ID
                        + "  join  tmp t on t.id=o." + Operation.FIELD_IDPROJECT
                        + " where o." + Operation.FIELD_DATEEXECUTE + " >= ?2 and o." + Operation.FIELD_DATEEXECUTE + " <= ?3 and o." + Operation.FIELD_CLASSIFICATION + " =1  ";
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
            }
        }
        return spending;
    }

    @Override
    public float revenueGetByTotalChildrenProject(long idProject, long idDepartment, long idEnterprise, Date dateStart, Date dateEnd) {
        float profit = 0;
        profit = revenueGetByTotalProject(idProject, idDepartment, idEnterprise, dateStart, dateEnd) - revenueGetByProject(idProject, idDepartment, idEnterprise, dateStart, dateEnd);
        return profit;
    }

    @Override
    public float spendingGetByTotalChildrenProject(long idProject, long idDepartment, long idEnterprise, Date dateStart, Date dateEnd) {
        float profit = spendingGetByTotalProject(idProject, idDepartment, idEnterprise, dateStart, dateEnd) - spendingGetByProject(idProject, idDepartment, idEnterprise, dateStart, dateEnd);
        return profit;
    }
}
