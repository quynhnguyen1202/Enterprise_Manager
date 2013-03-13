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
public interface IControlPanel {
    public void setShowPanel(IShowPanel p);
    public void addData();
    public void editData();
    public void deleteData();
    public void showData();
    public void showDefault();
}
