/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import java.util.Date;
import java.util.List;
import vn.com.hkt.dao.api.IEnterpriseDao;
import vn.com.hkt.dao.spi.EnterpriseDao;
import vn.com.hkt.data.entity.Enterprise;
import vn.com.hkt.provider.api.IProviderPanelShowListEnterprise;

/**
 *
 * @author Administrator
 */
public class ProviderPanelShowListEnterprise implements IProviderPanelShowListEnterprise {

    private IEnterpriseDao enterpriseDao;

    public ProviderPanelShowListEnterprise() {
        enterpriseDao = new EnterpriseDao();
    }

    @Override
    public List<Enterprise> getListInformation() {
        List<Enterprise> enterprises = enterpriseDao.selectAll();
        return enterprises;
    }

    @Override
    public List<Enterprise> getByName(String name) {
        List<Enterprise> l = enterpriseDao.getIdByName(name);
        return l;
    }

    @Override
    public List<Enterprise> getByDateActivate(Date date) {
        List<Enterprise> l = enterpriseDao.getByDateActivate(date);
        return l;
    }

    @Override
    public List<Enterprise> getByCodeEnterprise(String code) {
        List<Enterprise> l = enterpriseDao.getByCode(code);
        return l;
    }
}
