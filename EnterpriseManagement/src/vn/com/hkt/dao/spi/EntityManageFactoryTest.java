/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.dao.spi;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author QuynhNguyen
 */
public class EntityManageFactoryTest {

    public static EntityManagerFactory emf;
    public static EntityManageFactoryTest t;

    public static EntityManageFactoryTest getInstance() {
        if (t == null) {
            t = new EntityManageFactoryTest();

        }
        return t;
    }

    public EntityManageFactoryTest() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("EM");
        }

    }

    public EntityManagerFactory getEmf() {
        return emf;
    }
}
