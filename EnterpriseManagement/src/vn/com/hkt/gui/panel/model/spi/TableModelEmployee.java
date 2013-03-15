/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.gui.panel.model.spi;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import vn.com.hkt.data.entity.Employee;

/**
 *
 * @author Administrator
 */
public class TableModelEmployee extends DefaultTableModel {
    private List<Employee> emp=new ArrayList<Employee>();
    private String[] header=new String[]{"Name","Department"};
    private List<String[]> data=new ArrayList<String[]>();
    public TableModelEmployee(List<Employee> emp){
        this.emp=emp;
        data=loadData();
    }

    private List<String[]> loadData() {
        List<String[]> list=new ArrayList<String[]>();
        if(emp!=null){
            for (Employee employ : emp) {
                String name=employ.getName();
                long id=employ.getIdDepartment();
                String[] row = new String[]{String.valueOf(id), name};
                list.add(row);
            }
        }
        return list;
    }
}
