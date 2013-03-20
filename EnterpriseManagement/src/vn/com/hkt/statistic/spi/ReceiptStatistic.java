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
import vn.com.hkt.data.entity.OperationProduct;
import vn.com.hkt.data.entity.Project;
import vn.com.hkt.statistic.api.IReceiptStatistic;

/**
 *
 * @author QuynhNguyen
 */
public class ReceiptStatistic implements IReceiptStatistic {

    public EntityManager em;
    public OperationProduct operationProduct = new OperationProduct();
    public Operation operation = new Operation();
    public Project project = new Project();
    private float sum = 0;
    private List<Operation> result;

    @Override
    public float receiptGetByEnterprise(long idEnterprise, Date dateStart, Date dateEnd) {
        String sql = "select sum(tbl.MoneyAfterDiscount) from Operation tbl where (Id=?1) "
                + "and ( Operation.DateExecute >= '?2' )"
                + " and (Operation.DateExecute<'?3')";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            result = em.createQuery(sql).setParameter(1, idEnterprise).setParameter(2, dateStart).setParameter(3, dateEnd).getResultList();
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
    public float receiptGetByDepartment(long idDepartment, Date dateStart, Date dateEnd) {
        String sql = "select sum(tbl.MoneyAfterDiscount) from Operation tbl where (Id=?1) "
                + "and ( Operation.DateExecute >= '?2' )"
                + " and (Operation.DateExecute<'?3')";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {
            result = em.createQuery(sql).setParameter(1, idDepartment).setParameter(2, dateStart).setParameter(3, dateEnd).getResultList();
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
    public float receiptGetByEmployee(long idEmployee, Date dateStart, Date dateEnd) {
        String sql = "select sum(tbl.MoneyAfterDiscount) from Operation tbl where (Id=?1) "
                + "and ( Operation.DateExecute >= '?2' )"
                + " and (Operation.DateExecute<'?3')";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {
            result = em.createQuery(sql).setParameter(1, idEmployee).setParameter(2, dateStart).setParameter(3, dateEnd).getResultList();
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
    public float receiptGetByProductGroup(long idProductGroup, Date dateStart, Date dateEnd) {

        String sql = "select sum(o.MoneyAfterDiscount) "
                + "from Operation o,OperationProduct oP"
                + " where (o." + operationProduct.FIELD_IDPRODUCTGROUP + "=?1 )"
                + " and oP. " + operationProduct.FIELD_IDOPERATION + " = o." + operation.FIELD_ID
                + "and ( o.DateExecute >= '?2' )"
                + " and (o.DateExecute<'?3')";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            result = em.createQuery(sql).setParameter(1, idProductGroup).setParameter(2, dateStart).setParameter(3, dateEnd).getResultList();
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
    public float receipGetByProduct(long idProduct, Date dateStart, Date dateEnd) {
        String sql = "select sum(o.MoneyAfterDiscount) "
                + "from Operation o,OperationProduct oP"
                + " where (o." + operationProduct.FIELD_IDPRODUCT + "=?1 )"
                + " and oP. " + operationProduct.FIELD_IDOPERATION + " = o." + operation.FIELD_ID
                + "and ( o.DateExecute >= '?2' )"
                + " and (o.DateExecute<'?3')";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            result = em.createQuery(sql).setParameter(1, idProduct).setParameter(2, dateStart).setParameter(3, dateEnd).getResultList();
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
    public float receiptGetByProject(long idProject, Date dateStart, Date dateEnd) {
        String sql = "select sum(o.MoneyAfterDiscount) from Operation o,"
                + " where (o." + operation.FIELD_IDPROJECT + "=?1 )"
                + "and ( o.DateExecute >= '?2' )"
                + " and (o.DateExecute<'?3')";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            result = em.createQuery(sql).setParameter(1, idProject).setParameter(2, dateStart).setParameter(3, dateEnd).getResultList();
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
