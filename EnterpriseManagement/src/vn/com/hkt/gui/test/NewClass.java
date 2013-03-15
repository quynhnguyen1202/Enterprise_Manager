/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.gui.test;

import java.util.List;
import vn.com.hkt.dao.spi.EnterpriseDao;
import vn.com.hkt.data.entity.Enterprise;

/**
 *
 * @author QuynhNguyen
 */
public class NewClass {

    static EnterpriseDao en = new EnterpriseDao();

    public static void main(String[] args) {
        try {
            List<Enterprise> l = en.getListByIdEnterprise(1);
            if (l != null && !l.isEmpty()) {
                for (Enterprise object : l) {
                    System.out.println(object.getId());
                }
            }
        } catch (Exception e) {
            System.out.println("ngoai le" + e);
        }

    }
}
