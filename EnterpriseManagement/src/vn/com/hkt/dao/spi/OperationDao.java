/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.spi;

import java.util.Date;
import java.util.List;
import vn.com.hkt.dao.api.IOperationDao;
import vn.com.hkt.data.entity.Operation;

/**
 *
 * @author QuynhNguyen
 */
public class OperationDao extends EntityDao<Operation> implements IOperationDao {

    public OperationDao() {
        setClassName(Operation.class);
    }

    @Override
    public List<Operation> getByIdProject(long id) {
        String sql = "Select tbl from Operation tbl where tbl." + Operation.FIELD_IDPROJECT + " =?1 ";
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
    public List<Operation> getByDateExecute(Date date) {
        String sql = "Select tbl from Operation tbl where tbl." + Operation.FIELD_DATEEXECUTE + " =?1 ";
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

    @Override
    public List<Operation> getByIdEmployee(long id) {
        String sql = "Select tbl from Operation tbl where tbl." + Operation.FIELD_IDEMPLOYEE + " =?1 ";
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
    public List<Operation> getByIdDepartment(long id) {
        String sql = "Select tbl from Operation tbl where tbl." + Operation.FIELD_IDDEPARTMENT + " =?1 ";
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
    public List<Operation> getByCode(String code) {
        String sql = "Select tbl from Operation tbl where tbl." + Operation.FIELD_CODEOPERATION + " =?1 ";
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
    public List<Operation> getByClassification(boolean  classification) {
        String sql = "Select tbl from Operation tbl where tbl." + Operation.FIELD_CLASSIFICATION + " =?1 ";
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
    public List<Operation> getByIdEnterprise(long id) {
        String sql = "Select tbl from Operation tbl where tbl." + Operation.FIELD_IDENTERPRISE + " =?1 ";
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
}
