/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.gui.entity.api;

import java.util.List;
import vn.com.hkt.gui.control.api.IPanelControlGeneral;

/**
 *
 * @author Administrator
 */
public interface IShowPanel<E> {

    public void setControlShow(IPanelControlGeneral controlGeneral);
    
    public List<E> listA();

    public boolean checkData();

    public long addData();

    public boolean resetData();

    public boolean editData();

    public boolean deleteData();

    public List<E> listCombo();

    public void setDataShow(E ob);

    public void refreshData();
}
