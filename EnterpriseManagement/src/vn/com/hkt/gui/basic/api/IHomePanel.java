/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.gui.basic.api;

import vn.com.hkt.gui.control.api.IPanelControlGeneral;

/**
 *
 * @author Administrator
 */
public interface IHomePanel {

    public void setPanelControl(IPanelControlGeneral p);

    public void showDefaut();
    
    public void setVisible(boolean flag);
}
