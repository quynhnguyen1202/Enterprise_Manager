/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.gui.chart.basic.api;

import vn.com.hkt.gui.chart.control.api.IPanelControlChart;

/**
 *
 * @author Administrator
 */
public interface IBasicDialog {

    public void setPanelControl(IPanelControlChart p);

    public void showDefaut();
    
    public void setVisible(boolean flag);
    
    public void viewData();

}
