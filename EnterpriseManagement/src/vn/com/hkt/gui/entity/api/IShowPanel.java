/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.gui.entity.api;

import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IShowPanel<E> {

    public List<E> listA();

    public boolean checkData();

    public long addData();

    public boolean resetData();

    public boolean editData();

    public boolean deleteData();

    public List<E> listCombo();
}
