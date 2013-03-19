/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.spi;

import java.util.Date;
import java.util.List;
import vn.com.hkt.dao.api.IReceiptDao;
import vn.com.hkt.data.entity.Receipt;

/**
 *
 * @author QuynhNguyen
 */
public class ReceiptDao extends EntityDao<Receipt> implements IReceiptDao {

    public ReceiptDao() {
        setClassName(Receipt.class);
    }

    @Override
    public List<Receipt> getByIdOperation(long idOperation) {
        String sql = "Select tbl from Receipt tbl where tbl." + Receipt.FIELD_IDOPERATION + " =?1 ";
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
    public List<Receipt> getByIdEnterprise(long idEnterprise) {
        String sql = "Select tbl from Receipt tbl where tbl." + Receipt.FIELD_IDENTERPRISE + " =?1 ";
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
    public List<Receipt> getByIdDepartment(long idDepartment) {
        String sql = "Select tbl from Receipt tbl where tbl." + Receipt.FIELD_IDDEPARTMENT + " =?1 ";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            return em.createQuery(sql).setParameter(1, idDepartment).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Receipt> getByIdEmployee(long idEmployee) {
        String sql = "Select tbl from Receipt tbl where tbl." + Receipt.FIELD_IDEMPLOYEE + " =?1 ";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            return em.createQuery(sql).setParameter(1, idEmployee).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Receipt> getByClassification(boolean classification) {
        String sql = "Select tbl from Receipt tbl where tbl." + Receipt.FIELD_CLASSIFICATION + " =?1 ";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            return em.createQuery(sql).setParameter(1, classification).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Receipt> getByCodeReceipt(String code) {
        String sql = "Select tbl from Receipt tbl where tbl." + Receipt.FIELD_CODE_RECEIPT + " =?1 ";
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

    @Override
    public List<Receipt> getByDateProcess(Date date) {
        String sql = "Select tbl from Receipt tbl where tbl." + Receipt.FIELD_DATEPROCESS + " =?1 ";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

            return em.createQuery(sql).setParameter(1, date).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }
}
