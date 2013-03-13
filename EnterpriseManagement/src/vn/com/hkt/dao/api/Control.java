/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.api;

import java.util.List;
import vn.com.hkt.data.entity.Enterprise;

/**
 *
 * @author QuynhNguyen
 */
public interface  Control {
    public void insertObject();
    public void updateObject();
    public List<Object> getListObject(String s);// S la dieu kien cua truy van Select , co the null
    public void deleleObject();
   
}
