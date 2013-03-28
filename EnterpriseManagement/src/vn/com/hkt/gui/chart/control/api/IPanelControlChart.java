/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.gui.chart.control.api;

import vn.com.hkt.gui.chart.panelshow.api.IPanelShowChart;

/**
 *
 * @author Administrator
 */
public interface IPanelControlChart {
    public void showDefault();
    public void setPanelShow(IPanelShowChart panelChart);
    public void loadEnterprise();
    public void loadDepartment();
    public void loadProject();
    public void loadEmployee();
    public void viewData();
}
