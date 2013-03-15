/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import vn.com.hkt.data.entity.ProjectMember;
import vn.com.hkt.provider.api.IProviderPanelShowProjectMember;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowProjectMember extends ProviderGeneral<ProjectMember> implements IProviderPanelShowProjectMember {
    
    public ProviderPanelShowProjectMember() {
        setClassname(ProjectMember.class);
    }
}
