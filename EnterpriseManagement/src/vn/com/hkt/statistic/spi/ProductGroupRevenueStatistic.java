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
import vn.com.hkt.data.entity.ProductGroup;
import vn.com.hkt.data.entity.UnitMoney;
import vn.com.hkt.statistic.api.IProductGroupRevenueStatistic;

/**
 *
 * @author QuynhNguyen
 */
public class ProductGroupRevenueStatistic implements IProductGroupRevenueStatistic {

    private List<Double> result = null;
    private float revenue = 0;
    private EntityManager em;

    @Override
    public float revenueGetByTotalProductGroup(long idProductGroup, Date dateStart, Date dateEnd) {
//        String sql = "with tmp ( id , idProductGroup ) as "
//                + " (select pg." + ProductGroup.FIELD_ID + " ,pg." + ProductGroup.FIELD_IDPRODUCTGROUP
//                + " from " + ProductGroup.class.getSimpleName() + " pg  "
//                + " where pg." + ProductGroup.FIELD_ID + " =  " + idProductGroup
//                + " union all  select  pg." + ProductGroup.FIELD_ID + " ,pg." + ProductGroup.FIELD_IDPRODUCTGROUP
//                + " From " + ProductGroup.class.getSimpleName() + " pg join tmp t on pg.IdProductGroup = t.id )"
//                + " select  sum( o." + Operation.FIELD_MONEYAFTERDISCOUNT + " * u." + UnitMoney.FIELD_RATIO_WITH_DEFAULT + " ) "
//                + " from " + Operation.class.getSimpleName() + " o join  " + UnitMoney.class.getSimpleName() + " u on o.idUnitMoney = u.id "
//                + " join  " + OperationProduct.class.getSimpleName() + " op on o." + Operation.FIELD_ID + "= op." + OperationProduct.FIELD_IDOPERATION
//                + " join  tmp t on t.id=o."+Operation.IdProductGroup "
//                + " where o." + Operation.FIELD_DATEEXECUTE + " >= ?2 and o." + Operation.FIELD_DATEEXECUTE + " < ?3 ";
//        if (em == null || !em.isOpen()) {
//            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
//            System.out.println("creat em success");
//        }
//        try {
//            System.out.println("try try");
//            result = em.createNativeQuery(sql).setParameter(2, dateStart, TemporalType.DATE).setParameter(3, dateEnd, TemporalType.DATE).getResultList();
//            if (result != null && !result.isEmpty()) {
//                revenue = Float.parseFloat(result.get(0).toString());
//                System.out.println("part float");
//            }
//            else
//            {
//                System.out.println("result is null !11111111111111111111111111111111111");
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }

        return revenue;
    }

    @Override
    public float revenueGetByProductGroup(long idProductGroup, Date dateStart, Date dateEnd) {
        String sql = "select sum(o." + Operation.FIELD_MONEYAFTERDISCOUNT + ") from " + Operation.class.getSimpleName() + " o," + OperationProduct.class.getSimpleName() + " oP"
                + " where (o." + OperationProduct.FIELD_IDPRODUCTGROUP + "=?1 )"
                + " and oP. " + OperationProduct.FIELD_IDOPERATION + " = o." + Operation.FIELD_ID
                + " and ( o." + Operation.FIELD_DATEEXECUTE + ">= ?2 )"
                + " and (o." + Operation.FIELD_DATEEXECUTE + "<?3)";
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
}
