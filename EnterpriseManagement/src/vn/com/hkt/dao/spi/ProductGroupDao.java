/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.spi;

import java.util.List;
import vn.com.hkt.dao.api.IProductGroupDao;
import vn.com.hkt.data.entity.ProductGroup;

/**
 *
 * @author QuynhNguyen
 */
public class ProductGroupDao extends EntityDao<ProductGroup> implements IProductGroupDao {

    public ProductGroupDao() {
        setClassName(ProductGroup.class);
    }

    @Override
    public List<ProductGroup> getByName(String name) {
        String sql = "Select tbl from ProductGroup tbl where tbl." + ProductGroup.FIELD_NAME + " =?1 ";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            return em.createQuery(sql).setParameter(1, name).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<ProductGroup> getByIdProductGroup(long idProductGroup) {
        String sql = "Select tbl from ProductGroup tbl where tbl." + ProductGroup.FIELD_IDPRODUCTGROUP + " =?1 ";
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
    public List<ProductGroup> getByIdEnterprise(long idEnterprise) {
        String sql = "Select tbl from ProductGroup tbl where tbl." + ProductGroup.FIELD_IDENTERPRISE + " =?1 ";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            return em.createQuery(sql).setParameter(1, idEnterprise).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<ProductGroup> getByCodeProductGroup(String code) {
        String sql = "Select tbl from ProductGroup tbl where tbl." + ProductGroup.FIELD_CODEPRODUCTGROUP + " =?1 ";
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
