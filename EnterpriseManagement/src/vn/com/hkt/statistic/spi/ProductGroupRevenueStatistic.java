/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.statistic.spi;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import vn.com.hkt.dao.spi.EntityManageFactoryTest;
import vn.com.hkt.data.entity.MidleProductGroup;
import vn.com.hkt.data.entity.Operation;
import vn.com.hkt.data.entity.OperationProduct;
import vn.com.hkt.data.entity.Product;
import vn.com.hkt.data.entity.ProductGroup;
import vn.com.hkt.data.entity.UnitMoney;
import vn.com.hkt.statistic.api.IProductGroupRevenueStatistic;

/**
 *
 * @author QuynhNguyen
 */
public class ProductGroupRevenueStatistic implements IProductGroupRevenueStatistic {

    private List<Double> result = null;
    private float revenue = 0,spending =0;
    private EntityManager em;

    @Override
    public float revenueGetByTotalProductGroup(long idProductGroup, Date dateStart, Date dateEnd) {
        String sql = "with tmp ( id , idProductGroup ) as  (select pg." + ProductGroup.FIELD_ID + " ,pg." + ProductGroup.FIELD_IDPRODUCTGROUP
                + " from " + ProductGroup.class.getSimpleName() + " pg  where pg." + ProductGroup.FIELD_ID + " = " + idProductGroup + " union all"
                + "  select  pg." + ProductGroup.FIELD_ID + " ,pg." + ProductGroup.FIELD_IDPRODUCTGROUP
                + " From " + ProductGroup.class.getSimpleName() + " pg join tmp t on pg." + ProductGroup.FIELD_IDPRODUCTGROUP + " = t.id )"
                + " select  sum( o." + Operation.FIELD_MONEYAFTERDISCOUNT + " * u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + " )"
                + "  from " + Operation.class.getSimpleName() + " o, " + UnitMoney.class.getSimpleName() + " u , " + OperationProduct.class.getSimpleName() + " op ," + Product.class.getSimpleName() + " p , " + MidleProductGroup.class.getSimpleName() + " m ,  tmp t "
                + " where o." + Operation.FIELD_DATEEXECUTE + " >= ?2 and o." + Operation.FIELD_DATEEXECUTE + " <= ?3  and o."+Operation.FIELD_CLASSIFICATION+" = 1 "
                + "and o." + Operation.FIELD_ID_UNITMONEY + "=u." + UnitMoney.FIELD_ID + " and o." + Operation.FIELD_ID + "=op." + OperationProduct.FIELD_IDOPERATION + " and op." + OperationProduct.FIELD_IDPRODUCT + "=p." + Product.FIELD_ID
                + " and p." + Product.FIELD_ID + "=m." + MidleProductGroup.FIELD_IDPRODUCT + " and m." + MidleProductGroup.FIELD_IDGROUPPRODUCT + "=t.id";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            result = em.createNativeQuery(sql).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).getResultList();
            if (result != null && !result.isEmpty()) {
                revenue = Float.parseFloat(result.get(0).toString());

            } else {
                revenue = 0;
            }
        } catch (Exception e) {
            revenue = 0;
            System.out.println(e);
        }
        return revenue;
    }

    @Override
    public float revenueGetByProductGroup(long idProductGroup, Date dateStart, Date dateEnd) {
        String sql = "select sum(o." + Operation.FIELD_MONEYAFTERDISCOUNT + ") from " + Operation.class.getSimpleName() + " o," + OperationProduct.class.getSimpleName() + " oP"
                + " where (o." + OperationProduct.FIELD_IDPRODUCTGROUP + "=?1 )"
                + " and oP. " + OperationProduct.FIELD_IDOPERATION + " = o." + Operation.FIELD_ID
                + " and ( o." + Operation.FIELD_DATEEXECUTE + ">= ?2 )"
                + " and (o." + Operation.FIELD_DATEEXECUTE + "<=?3)"
                +" and o";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            result = em.createQuery(sql).setParameter(1, idProductGroup).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).getResultList();
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
    public float revenueGetByTotalChildrenProductGroup(long idProductGroup, Date dateStart, Date dateEnd) {
        revenue = revenueGetByTotalProductGroup(idProductGroup, dateStart, dateEnd) - revenueGetByProductGroup(idProductGroup, dateStart, dateEnd);
        return revenue;
    }

    @Override
    public float spendingGetByTotalProductGroup(long idProductGroup, Date dateStart, Date dateEnd) {
        String sql = "with tmp ( id , idProductGroup ) as  (select pg." + ProductGroup.FIELD_ID + " ,pg." + ProductGroup.FIELD_IDPRODUCTGROUP
                + " from " + ProductGroup.class.getSimpleName() + " pg  where pg." + ProductGroup.FIELD_ID + " = " + idProductGroup + " union all"
                + "  select  pg." + ProductGroup.FIELD_ID + " ,pg." + ProductGroup.FIELD_IDPRODUCTGROUP
                + " From " + ProductGroup.class.getSimpleName() + " pg join tmp t on pg." + ProductGroup.FIELD_IDPRODUCTGROUP + " = t.id )"
                + " select  sum( o." + Operation.FIELD_MONEYAFTERDISCOUNT + " * u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + " )"
                + "  from " + Operation.class.getSimpleName() + " o, " + UnitMoney.class.getSimpleName() + " u , " + OperationProduct.class.getSimpleName() + " op ," + Product.class.getSimpleName() + " p , " + MidleProductGroup.class.getSimpleName() + " m ,  tmp t "
                + " where o." + Operation.FIELD_DATEEXECUTE + " >= ?2 and o." + Operation.FIELD_DATEEXECUTE + " <= ?3  and o."+Operation.FIELD_CLASSIFICATION+" = 0 "
                + "and o." + Operation.FIELD_ID_UNITMONEY + "=u." + UnitMoney.FIELD_ID + " and o." + Operation.FIELD_ID + "=op." + OperationProduct.FIELD_IDOPERATION + " and op." + OperationProduct.FIELD_IDPRODUCT + "=p." + Product.FIELD_ID
                + " and p." + Product.FIELD_ID + "=m." + MidleProductGroup.FIELD_IDPRODUCT + " and m." + MidleProductGroup.FIELD_IDGROUPPRODUCT + "=t.id";
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
    public float spendingGetByProductGroup(long idProductGroup, Date dateStart, Date dateEnd) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public float spendingGetByTotalChildrenProductGroup(long idProductGroup, Date dateStart, Date dateEnd) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
