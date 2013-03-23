/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import java.util.ArrayList;
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
    private IEnterpriseDao iEnterpriseDao;

    public ProviderPanelShowEnterprise() {
        iEnterpriseDao = new EnterpriseDao();
    }

    @Override
    public void setClassname(Class classname) {
        setClassname(Enterprise.class);
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
            iEnterpriseDao.insert(enterprise);
            return enterprise.getId();
        }
        return -1;
    }

    @Override
    public long deleteData() {
        if (enterprise != null) {
            iEnterpriseDao.delete(enterprise);
            return 1;
        }
        return -1;
    }

    @Override
    public long updateData() {
        if (enterprise != null) {
            iEnterpriseDao.update(enterprise);
            return enterprise.getId();
        }
        return -1;
    }

    @Override
    public void resetData() {
        enterprise = new Enterprise();
    }

    @Override
    public void refreshData() {
        enterprise = iEnterpriseDao.getById(getDataView().getId());
    }

    @Override
    public boolean checkData() {
        if (enterprise == null) {
            return true;
        }
        return false;
    }

    @Override
    public Enterprise getObjectbyID(long id) {
        Enterprise e=iEnterpriseDao.getById(id);
        return e;
    }

    @Override
    public List<Enterprise> getListEnterprise() {
        List<Enterprise> enterprises=iEnterpriseDao.selectAll();
        if(enterprises==null){
            enterprises=new ArrayList<Enterprise>();
        }
        enterprises.add(0, null);
        return enterprises;
    }
}
