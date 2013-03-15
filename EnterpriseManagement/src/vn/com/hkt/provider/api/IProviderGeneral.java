/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.api;

import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IProviderGeneral<E> {
    public void setClassname( Class classname);
    
    public void setDataView(E object);
    
    public E getDataView();
    
    public long addData();
    
    public long deleteData();
    
    
        
}
