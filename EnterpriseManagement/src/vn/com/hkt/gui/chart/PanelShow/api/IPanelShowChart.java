/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.gui.chart.panelshow.api;

import java.util.Calendar;

/**
 *
 * @author Administrator
 */
public interface IPanelShowChart {
    public void setControlShow();
    public void setObjectView(Object obj);
    public void setTypeDate(int type);
    public void setTypeView(int type);
    public void setStartDate(Calendar d);
    public void setEndDate(Calendar d);
    public void viewData();
}
