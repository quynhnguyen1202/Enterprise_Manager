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
        String sql = "select sum(tbl." + Operation.FIELD_MONEYAFTERDISCOUNT + ") from" + Operation.class.getSimpleName() + " tbl where tbl." + Operation.FIELD_IDEMPLOYEE + "=?1 "
                + "and (tbl." + Operation.FIELD_DATEEXECUTE + " >= ?2 )"
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
            System.out.println(e);
        } finally {
            em.close();
        }
        return revenue;
    }

    
    /*
     @Override
    public float revenueGetByTotalEmployee(long idEmployee, Date dateStart, Date dateEnd) {
        String sql = "with tmp ( id , idEmployee ) as "
                + "(select d." + Employee.FIELD_ID + " ,d." + Employee.FIELD_IDDEPARTMENT
                + " from " + Employee.class.getSimpleName() + " d  "
                + "where d." + Employee.FIELD_ID + " =  " + idEmployee
                + " union all  select  d." + Employee.FIELD_ID + " ,d." + Employee.FIELD_IDDEPARTMENT
                + " From " + Employee.class.getSimpleName() + " d join tmp t on t.id=d." + Employee.FIELD_ID + " )"
                + "select  sum( o." + Operation.FIELD_MONEYAFTERDISCOUNT + " * u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + " ) "
                + "from " + Operation.class.getSimpleName() + " o join  " + UnitMoney.class.getSimpleName() + " u on o." + Operation.FIELD_ID_UNITMONEY + " = u.id "
                + "join  tmp t on t.id=o." + Operation.FIELD_IDEMPLOYEE
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
     * 
     */
/*
    @Override
    public float revenueGetByTotalChildrenEmployee(long idEmployee, Date dateStart, Date dateEnd) {
        revenue = revenueGetByTotalEmployee(idEmployee, dateStart, dateEnd) - revenueGetByEmployee(idEmployee, dateStart, dateEnd);
        return revenue;
    }

     * 
     */
    @Override
    public float spendingGetByEmployee(long idEmployee, Date dateStart, Date dateEnd) {
        String sql = "select sum(tbl." + Operation.FIELD_MONEYAFTERDISCOUNT + ") from" + Operation.class.getSimpleName() + " tbl where tbl." + Operation.FIELD_IDEMPLOYEE + "=?1) "
                + "and (tbl." + Operation.FIELD_DATEEXECUTE + " >= ?2 )"
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
            System.out.println(e);
        } finally {
            em.close();
        }
        return spending;
    }
/*
    @Override
    public float spendingGetByTotalEmployee(long idEmployee, Date dateStart, Date dateEnd) {
        String sql = "with tmp ( id , idEmployee ) as "
                + "(select d." + Employee.FIELD_ID + " ,d." + Employee.FIELD_IDDEPARTMENT
                + " from " + Employee.class.getSimpleName() + " d  "
                + "where d." + Employee.FIELD_ID + " =  " + idEmployee
                + " union all  select  d." + Employee.FIELD_ID + " ,d." + Employee.FIELD_IDDEPARTMENT
                + " From " + Employee.class.getSimpleName() + " d join tmp t on t.id=d." + Employee.FIELD_ID + ")"
                + "select  sum( o." + Operation.FIELD_MONEYAFTERDISCOUNT + " * u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + " ) "
                + "from " + Operation.class.getSimpleName() + " o join  " + UnitMoney.class.getSimpleName() + " u on o." + Operation.FIELD_ID_UNITMONEY + "= u." + UnitMoney.FIELD_ID
                + "join  tmp t on t.id=o." + Operation.FIELD_IDEMPLOYEE
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

     * 
     */
    /*
    @Override
    public float spendingGetByTotalChildrenEmployee(long idEmployee, Date dateStart, Date dateEnd) {
        spending = spendingGetByTotalEmployee(idEmployee, dateStart, dateEnd) - spendingGetByEmployee(idEmployee, dateStart, dateEnd);
        return spending;
    }

     * 
     */
    @Override
    public float revenueGetByEmployee(long idEmployee, long idDepartment, long idEnterprise, Date dateStart, Date dateEnd) {
        if (idEnterprise > 0) {
            if (idDepartment > 0) {
                String sql = "select sum(tbl." + Operation.FIELD_MONEYAFTERDISCOUNT + ") from" + Operation.class.getSimpleName() + " tbl where tbl." + Operation.FIELD_IDEMPLOYEE + "=?1 "
                        + "and (tbl." + Operation.FIELD_DATEEXECUTE + " >= ?2 )"
                        + " and (tbl." + Operation.FIELD_DATEEXECUTE + "<=?3) and ( tbl." + Operation.FIELD_CLASSIFICATION + "= 1 )"
                        + " and tbl." + Operation.FIELD_IDDEPARTMENT + "=?4 and tbl." + Operation.FIELD_IDENTERPRISE + "=?5 ";
                if (em == null || !em.isOpen()) {
                    em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
                }
                try {
                    result = em.createQuery(sql).setParameter(1, idEmployee).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).setParameter(4, idDepartment).setParameter(5, idEnterprise).getResultList();
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
            } else {
                String sql = "select sum(tbl." + Operation.FIELD_MONEYAFTERDISCOUNT + ") from" + Operation.class.getSimpleName() + " tbl where tbl." + Operation.FIELD_IDEMPLOYEE + "=?1 "
                        + "and (tbl." + Operation.FIELD_DATEEXECUTE + " >= ?2 )"
                        + " and (tbl." + Operation.FIELD_DATEEXECUTE + "<=?3) and ( tbl." + Operation.FIELD_CLASSIFICATION + "= 1 )"
                        + " and tbl." + Operation.FIELD_IDENTERPRISE + "=?4";
                if (em == null || !em.isOpen()) {
                    em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
                }
                try {
                    result = em.createQuery(sql).setParameter(1, idEmployee).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).setParameter(4, idEnterprise).getResultList();
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
            }
        } else {
            if (idDepartment > 0) {
                String sql = "select sum(tbl." + Operation.FIELD_MONEYAFTERDISCOUNT + ") from" + Operation.class.getSimpleName() + " tbl where tbl." + Operation.FIELD_IDEMPLOYEE + "=?1 "
                        + "and (tbl." + Operation.FIELD_DATEEXECUTE + " >= ?2 )"
                        + " and (tbl." + Operation.FIELD_DATEEXECUTE + "<=?3) and ( tbl." + Operation.FIELD_CLASSIFICATION + "= 1 )"
                        + " and tbl." + Operation.FIELD_IDDEPARTMENT + "=?4 ";
                if (em == null || !em.isOpen()) {
                    em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
                }
                try {
                    result = em.createQuery(sql).setParameter(1, idEmployee).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).setParameter(4, idDepartment).getResultList();
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
            } else {
                String sql = "select sum(tbl." + Operation.FIELD_MONEYAFTERDISCOUNT + ") from" + Operation.class.getSimpleName() + " tbl where tbl." + Operation.FIELD_IDEMPLOYEE + "=?1 "
                        + "and (tbl." + Operation.FIELD_DATEEXECUTE + " >= ?2 )"
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
                    System.out.println(e);
                } finally {
                    em.close();
                }
            }
        }
        return revenue;
    }
/*
    @Override
    public float revenueGetByTotalEmployee(long idEmployee, long idDepartment, long idEnterprise, Date dateStart, Date dateEnd) {
        if (idEnterprise > 0) {
            if (idDepartment > 0) {
                String sql = "with tmp ( id , idEmployee ) as "
                        + "(select d." + Employee.FIELD_ID + " ,d." + Employee.FIELD_IDDEPARTMENT
                        + " from " + Employee.class.getSimpleName() + " d  "
                        + "where d." + Employee.FIELD_ID + " =  " + idEmployee
                        + " union all  select  d." + Employee.FIELD_ID + " ,d." + Employee.FIELD_IDDEPARTMENT
                        + " From " + Employee.class.getSimpleName() + " d join tmp t on t.id=d." + Employee.FIELD_ID + " )"
                        + "select  sum( o." + Operation.FIELD_MONEYAFTERDISCOUNT + " * u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + " ) "
                        + "from " + Operation.class.getSimpleName() + " o join  " + UnitMoney.class.getSimpleName() + " u on o." + Operation.FIELD_ID_UNITMONEY + " = u.id "
                        + "join  tmp t on t.id=o." + Operation.FIELD_IDEMPLOYEE
                        + " where o." + Operation.FIELD_DATEEXECUTE + " >= ?2 and o." + Operation.FIELD_DATEEXECUTE + " <= ?3 and o." + Operation.FIELD_CLASSIFICATION + "= 1 "
                        + " and o." + Operation.FIELD_IDDEPARTMENT + "=?4 and o." + Operation.FIELD_IDENTERPRISE + "=?5 ";
                if (em == null || !em.isOpen()) {
                    em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
                }
                try {
                    result = em.createNativeQuery(sql).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).setParameter(4, idDepartment).setParameter(5, idEnterprise).getResultList();
                    if (result != null && !result.isEmpty()) {
                        revenue = Float.parseFloat(result.get(0).toString());
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                String sql = "with tmp ( id , idEmployee ) as "
                        + "(select d." + Employee.FIELD_ID + " ,d." + Employee.FIELD_IDDEPARTMENT
                        + " from " + Employee.class.getSimpleName() + " d  "
                        + "where d." + Employee.FIELD_ID + " =  " + idEmployee
                        + " union all  select  d." + Employee.FIELD_ID + " ,d." + Employee.FIELD_IDDEPARTMENT
                        + " From " + Employee.class.getSimpleName() + " d join tmp t on t.id=d." + Employee.FIELD_ID + " )"
                        + "select  sum( o." + Operation.FIELD_MONEYAFTERDISCOUNT + " * u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + " ) "
                        + "from " + Operation.class.getSimpleName() + " o join  " + UnitMoney.class.getSimpleName() + " u on o." + Operation.FIELD_ID_UNITMONEY + " = u.id "
                        + "join  tmp t on t.id=o." + Operation.FIELD_IDEMPLOYEE
                        + " where o." + Operation.FIELD_DATEEXECUTE + " >= ?2 and o." + Operation.FIELD_DATEEXECUTE + " <= ?3 and o." + Operation.FIELD_CLASSIFICATION + "= 1 "
                        + " and o." + Operation.FIELD_IDENTERPRISE + "=?4";
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
                String sql = "with tmp ( id , idEmployee ) as "
                        + "(select d." + Employee.FIELD_ID + " ,d." + Employee.FIELD_IDDEPARTMENT
                        + " from " + Employee.class.getSimpleName() + " d  "
                        + "where d." + Employee.FIELD_ID + " =  " + idEmployee
                        + " union all  select  d." + Employee.FIELD_ID + " ,d." + Employee.FIELD_IDDEPARTMENT
                        + " From " + Employee.class.getSimpleName() + " d join tmp t on t.id=d." + Employee.FIELD_ID + " )"
                        + "select  sum( o." + Operation.FIELD_MONEYAFTERDISCOUNT + " * u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + " ) "
                        + "from " + Operation.class.getSimpleName() + " o join  " + UnitMoney.class.getSimpleName() + " u on o." + Operation.FIELD_ID_UNITMONEY + " = u.id "
                        + "join  tmp t on t.id=o." + Operation.FIELD_IDEMPLOYEE
                        + " where o." + Operation.FIELD_DATEEXECUTE + " >= ?2 and o." + Operation.FIELD_DATEEXECUTE + " <= ?3 and o." + Operation.FIELD_CLASSIFICATION + "= 1 "
                        + " and o." + Operation.FIELD_IDDEPARTMENT + "=?4";
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
                String sql = "with tmp ( id , idEmployee ) as "
                        + "(select d." + Employee.FIELD_ID + " ,d." + Employee.FIELD_IDDEPARTMENT
                        + " from " + Employee.class.getSimpleName() + " d  "
                        + "where d." + Employee.FIELD_ID + " =  " + idEmployee
                        + " union all  select  d." + Employee.FIELD_ID + " ,d." + Employee.FIELD_IDDEPARTMENT
                        + " From " + Employee.class.getSimpleName() + " d join tmp t on t.id=d." + Employee.FIELD_ID + " )"
                        + "select  sum( o." + Operation.FIELD_MONEYAFTERDISCOUNT + " * u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + " ) "
                        + "from " + Operation.class.getSimpleName() + " o join  " + UnitMoney.class.getSimpleName() + " u on o." + Operation.FIELD_ID_UNITMONEY + " = u.id "
                        + "join  tmp t on t.id=o." + Operation.FIELD_IDEMPLOYEE
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
            }
        }
        return revenue;
    }

     * 
     */
    /*
    @Override
    public float revenueGetByTotalChildrenEmployee(long idEmployee, long idDepartment, long idEnterprise, Date dateStart, Date dateEnd) {
        revenue = revenueGetByTotalEmployee(idEmployee, idDepartment, idEnterprise, dateStart, dateEnd) - revenueGetByEmployee(idEmployee, idDepartment, idEnterprise, dateStart, dateEnd);
        return revenue;
    }
     * 
     */

    @Override
    public float spendingGetByEmployee(long idEmployee, long idDepartment, long idEnterprise, Date dateStart, Date dateEnd) {
        if (idEnterprise > 0) {
            if (idDepartment > 0) {
                String sql = "select sum(tbl." + Operation.FIELD_MONEYAFTERDISCOUNT + ") from" + Operation.class.getSimpleName() + " tbl where tbl." + Operation.FIELD_IDEMPLOYEE + "=?1) "
                        + "and (tbl." + Operation.FIELD_DATEEXECUTE + " >= ?2 )"
                        + " and (tbl." + Operation.FIELD_DATEEXECUTE + "<=?3) and ( tbl." + Operation.FIELD_CLASSIFICATION + "= 0 "
                        + " and tbl." + Operation.FIELD_IDDEPARTMENT + "=?4 and tbl." + Operation.FIELD_IDENTERPRISE + " =?5 ";
                if (em == null || !em.isOpen()) {
                    em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
                }
                try {
                    result = em.createQuery(sql).setParameter(1, idEmployee).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).setParameter(4, idDepartment).setParameter(5, idEnterprise).getResultList();
                    if (result != null && !result.isEmpty()) {
                        spending = Float.parseFloat(result.get(0).toString());
                    } else {
                        spending = 0;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                } finally {
                    em.close();
                }
            } else {
                String sql = "select sum(tbl." + Operation.FIELD_MONEYAFTERDISCOUNT + ") from" + Operation.class.getSimpleName() + " tbl where tbl." + Operation.FIELD_IDEMPLOYEE + "=?1) "
                        + "and (tbl." + Operation.FIELD_DATEEXECUTE + " >= ?2 )"
                        + " and (tbl." + Operation.FIELD_DATEEXECUTE + "<=?3) and ( tbl." + Operation.FIELD_CLASSIFICATION + "= 0 "
                        + " and tbl." + Operation.FIELD_IDENTERPRISE + " =?4";
                if (em == null || !em.isOpen()) {
                    em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
                }
                try {
                    result = em.createQuery(sql).setParameter(1, idEmployee).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).setParameter(4, idEnterprise).getResultList();
                    if (result != null && !result.isEmpty()) {
                        spending = Float.parseFloat(result.get(0).toString());
                    } else {
                        spending = 0;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                } finally {
                    em.close();
                }
            }

        } else {
            if (idDepartment > 0) {
                String sql = "select sum(tbl." + Operation.FIELD_MONEYAFTERDISCOUNT + ") from" + Operation.class.getSimpleName() + " tbl where tbl." + Operation.FIELD_IDEMPLOYEE + "=?1) "
                        + "and (tbl." + Operation.FIELD_DATEEXECUTE + " >= ?2 )"
                        + " and (tbl." + Operation.FIELD_DATEEXECUTE + "<=?3) and ( tbl." + Operation.FIELD_CLASSIFICATION + "= 0 "
                        + " and tbl." + Operation.FIELD_IDDEPARTMENT + " =?4";
                if (em == null || !em.isOpen()) {
                    em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
                }
                try {
                    result = em.createQuery(sql).setParameter(1, idEmployee).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).setParameter(4, idDepartment).getResultList();
                    if (result != null && !result.isEmpty()) {
                        spending = Float.parseFloat(result.get(0).toString());
                    } else {
                        spending = 0;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                } finally {
                    em.close();
                }

            } else {
                String sql = "select sum(tbl." + Operation.FIELD_MONEYAFTERDISCOUNT + ") from" + Operation.class.getSimpleName() + " tbl where tbl." + Operation.FIELD_IDEMPLOYEE + "=?1) "
                        + "and (tbl." + Operation.FIELD_DATEEXECUTE + " >= ?2 )"
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
                    System.out.println(e);
                } finally {
                    em.close();
                }
            }
        }
        return spending;
    }

   /*
    @Override
    public float spendingGetByTotalEmployee(long idEmployee, long idDepartment, long idEnterprise, Date dateStart, Date dateEnd) {
        if (idEnterprise > 0) {
            if (idDepartment > 0) {
                String sql = "with tmp ( id , idEmployee ) as "
                        + "(select d." + Employee.FIELD_ID + " ,d." + Employee.FIELD_IDDEPARTMENT
                        + " from " + Employee.class.getSimpleName() + " d  "
                        + "where d." + Employee.FIELD_ID + " =  " + idEmployee
                        + " union all  select  d." + Employee.FIELD_ID + " ,d." + Employee.FIELD_IDDEPARTMENT
                        + " From " + Employee.class.getSimpleName() + " d join tmp t on t.id=d." + Employee.FIELD_ID + ")"
                        + "select  sum( o." + Operation.FIELD_MONEYAFTERDISCOUNT + " * u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + " ) "
                        + "from " + Operation.class.getSimpleName() + " o join  " + UnitMoney.class.getSimpleName() + " u on o." + Operation.FIELD_ID_UNITMONEY + "= u." + UnitMoney.FIELD_ID
                        + "join  tmp t on t.id=o." + Operation.FIELD_IDEMPLOYEE
                        + " where o." + Operation.FIELD_DATEEXECUTE + " >= ?2 and o." + Operation.FIELD_DATEEXECUTE + " <= ?3 and o." + Operation.FIELD_CLASSIFICATION + "= 0 "
                        + " and o." + Operation.FIELD_IDDEPARTMENT + "= ?4 and o." + Operation.FIELD_IDENTERPRISE + "=?5 ";
                if (em == null || !em.isOpen()) {
                    em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
                }
                try {
                    result = em.createNativeQuery(sql).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).setParameter(4, idDepartment).setParameter(5, idEnterprise).getResultList();
                    if (result != null && !result.isEmpty()) {
                        spending = Float.parseFloat(result.get(0).toString());
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                String sql = "with tmp ( id , idEmployee ) as "
                        + "(select d." + Employee.FIELD_ID + " ,d." + Employee.FIELD_IDDEPARTMENT
                        + " from " + Employee.class.getSimpleName() + " d  "
                        + "where d." + Employee.FIELD_ID + " =  " + idEmployee
                        + " union all  select  d." + Employee.FIELD_ID + " ,d." + Employee.FIELD_IDDEPARTMENT
                        + " From " + Employee.class.getSimpleName() + " d join tmp t on t.id=d." + Employee.FIELD_ID + ")"
                        + "select  sum( o." + Operation.FIELD_MONEYAFTERDISCOUNT + " * u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + " ) "
                        + "from " + Operation.class.getSimpleName() + " o join  " + UnitMoney.class.getSimpleName() + " u on o." + Operation.FIELD_ID_UNITMONEY + "= u." + UnitMoney.FIELD_ID
                        + "join  tmp t on t.id=o." + Operation.FIELD_IDEMPLOYEE
                        + " where o." + Operation.FIELD_DATEEXECUTE + " >= ?2 and o." + Operation.FIELD_DATEEXECUTE + " <= ?3 and o." + Operation.FIELD_CLASSIFICATION + "= 0 "
                        + " and o." + Operation.FIELD_IDENTERPRISE + " =?4";
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
                String sql = "with tmp ( id , idEmployee ) as "
                        + "(select d." + Employee.FIELD_ID + " ,d." + Employee.FIELD_IDDEPARTMENT
                        + " from " + Employee.class.getSimpleName() + " d  "
                        + "where d." + Employee.FIELD_ID + " =  " + idEmployee
                        + " union all  select  d." + Employee.FIELD_ID + " ,d." + Employee.FIELD_IDDEPARTMENT
                        + " From " + Employee.class.getSimpleName() + " d join tmp t on t.id=d." + Employee.FIELD_ID + ")"
                        + "select  sum( o." + Operation.FIELD_MONEYAFTERDISCOUNT + " * u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + " ) "
                        + "from " + Operation.class.getSimpleName() + " o join  " + UnitMoney.class.getSimpleName() + " u on o." + Operation.FIELD_ID_UNITMONEY + "= u." + UnitMoney.FIELD_ID
                        + "join  tmp t on t.id=o." + Operation.FIELD_IDEMPLOYEE
                        + " where o." + Operation.FIELD_DATEEXECUTE + " >= ?2 and o." + Operation.FIELD_DATEEXECUTE + " <= ?3 and o." + Operation.FIELD_CLASSIFICATION + "= 0 "
                        + " and o." + Operation.FIELD_IDDEPARTMENT + " =?4";
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
                String sql = "with tmp ( id , idEmployee ) as "
                        + "(select d." + Employee.FIELD_ID + " ,d." + Employee.FIELD_IDDEPARTMENT
                        + " from " + Employee.class.getSimpleName() + " d  "
                        + "where d." + Employee.FIELD_ID + " =  " + idEmployee
                        + " union all  select  d." + Employee.FIELD_ID + " ,d." + Employee.FIELD_IDDEPARTMENT
                        + " From " + Employee.class.getSimpleName() + " d join tmp t on t.id=d." + Employee.FIELD_ID + ")"
                        + "select  sum( o." + Operation.FIELD_MONEYAFTERDISCOUNT + " * u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + " ) "
                        + "from " + Operation.class.getSimpleName() + " o join  " + UnitMoney.class.getSimpleName() + " u on o." + Operation.FIELD_ID_UNITMONEY + "= u." + UnitMoney.FIELD_ID
                        + "join  tmp t on t.id=o." + Operation.FIELD_IDEMPLOYEE
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
            }
        }
        return spending;
    }

     * 
     */
    /*
    @Override
    public float spendingGetByTotalChildrenEmployee(long idEmployee, long idDepartment, long idEnterprise, Date dateStart, Date dateEnd) {
        spending = spendingGetByTotalEmployee(idEmployee, idDepartment, idEnterprise, dateStart, dateEnd) - spendingGetByEmployee(idEmployee, idDepartment, idEnterprise, dateStart, dateEnd);
        return spending;
    }
     * 
     */
}
