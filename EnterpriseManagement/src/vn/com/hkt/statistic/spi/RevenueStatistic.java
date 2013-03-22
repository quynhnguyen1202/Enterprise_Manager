/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.statistic.spi;

import java.util.Date;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import vn.com.hkt.dao.spi.EntityManageFactoryTest;
import vn.com.hkt.data.entity.Operation;
import vn.com.hkt.data.entity.OperationProduct;
import vn.com.hkt.data.entity.Project;
import vn.com.hkt.statistic.api.IRevenueStatistic;

/**
 *
 * @author QuynhNguyen
 */
public class RevenueStatistic implements IRevenueStatistic {

    public EntityManager em;
    public OperationProduct operationProduct = new OperationProduct();
    public Operation operation = new Operation();
    public Project project = new Project();
    private float sum = 0;
    private List<Double> result;

    @Override
    public float revenueGetByEnterprise(long idEnterprise, Date dateStart, Date dateEnd) {
        String sql = "select sum(tbl."+Operation.FIELD_MONEYAFTERDISCOUNT+") from "+Operation.class.getSimpleName()+" tbl where (tbl."+Operation.FIELD_ID +"=?1) "
                + " and ( tbl."+Operation.FIELD_DATEEXECUTE+" >= ?2 )"
                + " and (tbl."+Operation.FIELD_DATEEXECUTE+"<?3)";
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
                }
            } else {
                sum = 0;
            }
        } catch (Exception e) {
            return 0;
        } finally {
            em.close();
        }
        return sum;
    }

    @Override
    public float revenueGetByDepartment(long idDepartment, Date dateStart, Date dateEnd) {
        String sql = "select sum(tbl."+Operation.FIELD_MONEYAFTERDISCOUNT+") from "+Operation.class.getSimpleName()+" tbl where (tbl."+Operation.FIELD_ID+"=?1) "
                + "and ( tbl."+Operation.FIELD_DATEEXECUTE+" >= ?2)"
                + " and (tbl."+Operation.FIELD_DATEEXECUTE+"<?3)";
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
    public float revenueGetByEmployee(long idEmployee, Date dateStart, Date dateEnd) {
        String sql = "select sum(tbl.MoneyAfterDiscount) from"+ Operation.class.getSimpleName()+" tbl where (Id=?1) "
                + "and (tbl."+Operation.FIELD_DATEEXECUTE+" >= ?2 )"
                + " and (tbl."+Operation.FIELD_DATEEXECUTE+"<?3)";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {
            result = em.createQuery(sql).setParameter(1, idEmployee).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).getResultList();
            if (result != null && !result.isEmpty()) {
                sum = Float.parseFloat(result.get(0).toString());
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
    public float revenueGetByProductGroup(long idProductGroup, Date dateStart, Date dateEnd) {

        String sql = "select sum(o."+Operation.FIELD_MONEYAFTERDISCOUNT+") from "+Operation.class.getSimpleName()+" o,"+OperationProduct.class.getSimpleName()+" oP"
                + " where (o." + operationProduct.FIELD_IDPRODUCTGROUP + "=?1 )"
                + " and oP. " + operationProduct.FIELD_IDOPERATION + " = o." + operation.FIELD_ID
                + "and ( o."+Operation.FIELD_DATEEXECUTE +">= ?2 )"
                + " and (o."+Operation.FIELD_DATEEXECUTE+"<?3)";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            result = em.createQuery(sql).setParameter(1, idProductGroup).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).getResultList();
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
            return 0;
        } finally {
            em.close();
        }
        return sum;
    }

    @Override
    public float revenueGetByProduct(long idProduct, Date dateStart, Date dateEnd) {
        String sql = "select sum(o."+Operation.FIELD_MONEYAFTERDISCOUNT+") "
                + "from "+Operation.class.getSimpleName()+" o,"+OperationProduct.class.getSimpleName()+" oP "
                + " where (oP." + operationProduct.FIELD_IDPRODUCT + "=?1 )"
                + " and (oP. " + operationProduct.FIELD_IDOPERATION + " = o." + operation.FIELD_ID+")"
                + " and ( o."+Operation.FIELD_DATEEXECUTE+" >= ?2 )"
                + " and (o."+Operation.FIELD_DATEEXECUTE+"<?3)";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            result = em.createQuery(sql).setParameter(1, idProduct).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).getResultList();
            if (result != null && !result.isEmpty()) {
                try {
                    sum = Float.parseFloat(result.get(0).toString());
                    System.out.println("abc");
                } catch (Exception e) {
                    System.out.println(e);
                }

            } 

        } catch (Exception e) {
            
            System.out.println(e);
            return 0;
            
        } finally {
            em.close();
        }
        return sum;
    }

    @Override
    public float revenueGetByProject(long idProject, Date dateStart, Date dateEnd) {
        String sql = "select sum(o."+Operation.FIELD_MONEYAFTERDISCOUNT+") from "+ Operation.class.getSimpleName()+" o,"
                + " where (o." + Operation.FIELD_IDPROJECT + "=?1 )"
                + "and ( o."+Operation.FIELD_DATEEXECUTE+" >= ?2 )"
                + " and (o."+Operation.FIELD_DATEEXECUTE+"<?3)";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            result = em.createQuery(sql).setParameter(1, idProject).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).getResultList();
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
            return 0;
        } finally {
            em.close();
        }
        return sum;
    }
}
