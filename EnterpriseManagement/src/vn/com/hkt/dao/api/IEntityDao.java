/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.api;

import java.util.List;

/**
 *
 * @author QuynhNguyen
 */
public interface IEntityDao<E> {

    public boolean insert(E object);

    public boolean update(E object);

    public boolean delete(E object);

    public E getById(long id);

    public List<E> query(String sql);
    
    public void setClassName(Class clsName);
}
