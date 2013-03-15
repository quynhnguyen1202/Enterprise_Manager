/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import vn.com.hkt.data.entity.Project;
import vn.com.hkt.provider.api.IProviderPanelShowProject;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowProject extends ProviderGeneral<Project> implements IProviderPanelShowProject {

    public ProviderPanelShowProject() {
        setClassname(Project.class);
    }
}
