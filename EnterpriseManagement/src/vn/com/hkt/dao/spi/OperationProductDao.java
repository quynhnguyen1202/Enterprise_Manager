/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.spi;

import java.util.List;
import vn.com.hkt.dao.api.IOperationProductDao;
import vn.com.hkt.data.entity.OperationProduct;

/**
 *
 * @author QuynhNguyen
 */
public class OperationProductDao extends EntityDao<OperationProduct> implements IOperationProductDao {

    public OperationProductDao() {
        setClassName(OperationProduct.class);
    }

    @Override
    public List<OperationProduct> getByIdOperation(long idOperation) {
        String sql = "Select tbl from OperationProduct tbl where tbl." + OperationProduct.FIELD_IDOPERATION + " =?1 ";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            return em.createQuery(sql).setParameter(1, idOperation).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<OperationProduct> getByIdProduct(long idProduct) {
        String sql = "Select tbl from OperationProduct tbl where tbl." + OperationProduct.FIELD_IDPRODUCT + " =?1 ";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            return em.createQuery(sql).setParameter(1, idProduct).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<OperationProduct> getByIdProductGroup(long idProductGroup) {
        String sql = "Select tbl from OperationProduct tbl where tbl." + OperationProduct.FIELD_IDPRODUCTGROUP + " =?1 ";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            return em.createQuery(sql).setParameter(1, idProductGroup).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<OperationProduct> getByCodeOperationProduct(String code) {
        String sql = "Select tbl from OperationProduct tbl where tbl." + OperationProduct.FIELD_CODEOPERATIONPRODUCT + " =?1 ";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            return em.createQuery(sql).setParameter(1, code).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }
}
