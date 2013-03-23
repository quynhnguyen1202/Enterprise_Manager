/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.api;

import java.util.Date;
import java.util.List;
import vn.com.hkt.data.entity.Enterprise;

/**
 *
 * @author Administrator
 */
public interface IProviderPanelShowListEnterprise extends IProviderListGeneral<Enterprise> {

    public List<Enterprise> getByName(String name);

    public List<Enterprise> getByDateActivate(Date date);

    public List<Enterprise> getByCodeEnterprise(String code);

    public Enterprise getByEnterpriseId(long idEnterprise);
}
