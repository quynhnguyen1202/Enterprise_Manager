/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import java.util.logging.Level;
import java.util.logging.Logger;
import vn.com.hkt.dao.api.IEntityDao;
import vn.com.hkt.dao.spi.EntityDao;
import vn.com.hkt.provider.api.IProviderGeneral;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderGeneral<E> implements IProviderGeneral<E> {

    Class classname;
    private E entity;
    private IEntityDao iEntityDao;

    public ProviderGeneral() {
        iEntityDao= new EntityDao();
    }
  

    @Override
    public void setDataView(E object) {
        this.entity = object;



    }

    @Override
    public E getDataView() {
        if (entity == null) {
            try {
                entity = (E) classname.newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(ProviderGeneral.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ProviderGeneral.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return entity;
    }

    @Override
    public long addData() {
        if (entity != null) {
            iEntityDao.insert(entity);
            return 1;
        }
        return -1;
    }

    @Override
    public long deleteData() {
        if (entity != null) {
            iEntityDao.delete(entity);
            return 1;

        }
        return -1;
    }

    @Override
    public void setClassname(Class classname) {
        this.classname = classname;
    }

    @Override
    public E getObjectbyID(long id) {
        if (id>0) {
            return (E) iEntityDao.getById(id);
            
        }
        return null;
        
    }

    
}
