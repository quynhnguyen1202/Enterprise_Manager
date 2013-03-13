/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.gui.test;

import vn.com.hkt.dao.spi.DepartmentDao;
import vn.com.hkt.data.entity.Department;

/**
 *
 * @author QuynhNguyen
 */
public class test {

    public test() {
       
    }
    public static void main(String[] args) {
         DepartmentDao control = new DepartmentDao();
        Department d = control.getById(1);
        try {
             System.out.println("abc"+d.getName());
        } catch (Exception e) {
            System.out.println(e);
            
        }
    }
    
   
    
}
