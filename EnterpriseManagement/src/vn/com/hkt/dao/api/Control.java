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
    public List<Object> getListObject(long id);
    public void deleleObject();
    public void updateObject(long id);
    
   
}
