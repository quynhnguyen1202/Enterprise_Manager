/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import java.util.List;
import vn.com.hkt.dao.api.IEnterpriseDao;
import vn.com.hkt.dao.spi.EnterpriseDao;
import vn.com.hkt.data.entity.Enterprise;
import vn.com.hkt.provider.api.IProviderPanelShowEnterprise;

/**
 *
 * @author Administrator
 */
public class ProviderPanelShowEnterprise implements IProviderPanelShowEnterprise {

    private Enterprise enterprise;
    private IEnterpriseDao enterpriseDao;

    public ProviderPanelShowEnterprise() {
        enterpriseDao = new EnterpriseDao();
    }

    @Override
    public void setDataView(Enterprise object) {
        this.enterprise = object;
    }

    @Override
    public Enterprise getDataView() {
        if (enterprise == null) {
            enterprise = new Enterprise();
        }
        return enterprise;
    }

    @Override
    public long addData() {
        if (enterprise != null) {
            if (enterpriseDao.insert(enterprise)) {
                return enterprise.getId();
            } else {
                return -1;
            }
        }
        return -1;
    }

    @Override
    public long deleteData() {
        if (enterprise != null) {
            enterpriseDao.delete(enterprise);
            return 1;

        }
        return 0;
    }

    @Override
    public List<Enterprise> getDataListView() {
        String sql = null;
        long idEnterprise =enterprise.getIdEnterprise();
        
        return enterpriseDao.query(sql);
        
    }
}
