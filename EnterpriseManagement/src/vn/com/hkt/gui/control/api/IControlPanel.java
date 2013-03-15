/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.gui.control.api;

import vn.com.hkt.gui.entity.api.IShowPanel;

/**
 *
 * @author Administrator
 */
public interface IControlPanel extends IPanelControlGeneral{

    public void setShowPanel(IShowPanel p);

    public void addData();

    public void editData();

    public void deleteData();

    public void showData();

}
