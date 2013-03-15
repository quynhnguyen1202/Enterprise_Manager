/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import vn.com.hkt.dao.api.IEnterpriseDao;
import vn.com.hkt.dao.spi.EnterpriseDao;
import vn.com.hkt.data.entity.Enterprise;
import vn.com.hkt.provider.api.IProviderPanelShowEnterprise;

/**
 *
 * @author Administrator
 */
public class ProviderPanelShowEnterprise extends ProviderGeneral<Enterprise> implements IProviderPanelShowEnterprise {
    
    public ProviderPanelShowEnterprise() {
        setClassname(Enterprise.class);
    }
}
