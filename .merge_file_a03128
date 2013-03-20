/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import java.util.List;
import vn.com.hkt.dao.api.IEnterpriseDao;
import vn.com.hkt.dao.spi.EnterpriseDao;
import vn.com.hkt.data.entity.Enterprise;
import vn.com.hkt.provider.api.IProviderPanelShowListEnterprise;

/**
 *
 * @author Administrator
 */
public class ProviderPanelShowListEnterprise implements IProviderPanelShowListEnterprise{

    private IEnterpriseDao enterpriseDao;

    public ProviderPanelShowListEnterprise() {
        enterpriseDao = new EnterpriseDao();
    }
    
    @Override
    public List<Enterprise> getListInformation() {
        List<Enterprise> enterprises = enterpriseDao.selectAll();
        return enterprises;
    }
    
}
