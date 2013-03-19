/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.spi;

import java.util.List;
import vn.com.hkt.dao.api.IProductDao;
import vn.com.hkt.data.entity.Product;

/**
 *
 * @author QuynhNguyen
 */
public class ProductDao extends EntityDao<Product> implements IProductDao {

    public ProductDao() {
        setClassName(Product.class);
    }

    @Override
    public List<Product> getByIdEnterprise(long id) {
        String sql = "Select tbl from Product tbl where tbl." + Product.FIELD_IDENTERPRISE + " =?1 ";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            return em.createQuery(sql).setParameter(1, id).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Product> getByIdDepartment(long id) {
        String sql = "Select tbl from Product tbl where tbl." + Product.FIELD_IDDEPARTMENT + " =?1 ";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            return em.createQuery(sql).setParameter(1, id).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Product> getByName(String name) {
        String sql = "Select tbl from Product tbl where tbl." + Product.FIELD_NAME + " =?1 ";
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
    public List<Product> getByCode(String code) {
        String sql = "Select tbl from Product tbl where tbl." + Product.FIELD_CODEPRODUCT + " =?1 ";
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
