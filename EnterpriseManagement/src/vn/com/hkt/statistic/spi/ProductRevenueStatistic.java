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
import vn.com.hkt.data.entity.OperationProduct;
import vn.com.hkt.statistic.api.IProductRevenueStatistic;

/**
 *
 * @author QuynhNguyen
 */
public class ProductRevenueStatistic implements IProductRevenueStatistic {

    private EntityManager em;
    List<Double> result = null;
    private float revenue = 0;

    @Override
    public float revenueGetByProduct(long idProduct, Date dateStart, Date dateEnd) {
        String sql = "select sum(o." + Operation.FIELD_MONEYAFTERDISCOUNT + ") "
                + "from " + Operation.class.getSimpleName() + " o," + OperationProduct.class.getSimpleName() + " oP "
                + " where (oP." + OperationProduct.FIELD_IDPRODUCT + "=?1 )"
                + " and (oP. " + OperationProduct.FIELD_IDOPERATION + " = o." + Operation.FIELD_ID + ")"
                + " and ( o." + Operation.FIELD_DATEEXECUTE + " >= ?2 )"
                + " and (o." + Operation.FIELD_DATEEXECUTE + "<=?3)";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            result = em.createQuery(sql).setParameter(1, idProduct).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).getResultList();
            if (result != null && !result.isEmpty()) {
                try {
                    revenue = Float.parseFloat(result.get(0).toString());
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
        return revenue;
    }
}
