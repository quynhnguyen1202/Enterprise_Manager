/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.spi;

import java.util.List;
import vn.com.hkt.dao.api.IDepartmentDao;
import vn.com.hkt.data.entity.Department;

/**
 *
 * @author QuynhNguyen
 */
public class DepartmentDao extends EntityDao<Department> implements IDepartmentDao {

    public DepartmentDao() {
        setClassName(Department.class);

    }

    @Override
    public List<Department> getByEntpriseId(long enterpriseId) {
        String sql="Select tbl from Department tbl where tbl.IdEnterprise = ?1";
        if (em == null || !em.isOpen()) {
            em = EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        }
        try {

           return em.createQuery(sql).setParameter(1, enterpriseId).getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }
}
