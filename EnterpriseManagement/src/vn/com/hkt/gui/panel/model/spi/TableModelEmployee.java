/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.gui.panel.model.spi;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import vn.com.hkt.dao.api.IDepartmentDao;
import vn.com.hkt.dao.api.IEnterpriseDao;
import vn.com.hkt.dao.spi.DepartmentDao;
import vn.com.hkt.dao.spi.EnterpriseDao;
import vn.com.hkt.data.entity.Department;
import vn.com.hkt.data.entity.Employee;
import vn.com.hkt.data.entity.Enterprise;

/**
 *
 * @author Administrator
 */
public class TableModelEmployee extends DefaultTableModel {

    private List<Employee> emp = new ArrayList<Employee>();
    private String[] header = new String[]{"", "Name", "Department", "Enterprise"};
    private List<String[]> data = new ArrayList<String[]>();
    private IEnterpriseDao enterpriseDow = new EnterpriseDao();
    private IDepartmentDao departmentDow = new DepartmentDao();

    public TableModelEmployee(List<Employee> emp) {
        this.emp = emp;
        data = loadData();
    }
    
    @Override
    public int getColumnCount() {
        return header.length;
    }

    public String[] getHeader() {
        return header;
    }

    @Override
    public Object getValueAt(int row, int column) {
        return data.get(row)[column];
    }
    @Override
    public String getColumnName(int column) {
        return header[column];
    }
    
    @Override
    public int getRowCount() {
        if (data == null) {
            return 0;
        }
        return data.size();
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    
    
    private List<String[]> loadData() {
        List<String[]> list = new ArrayList<String[]>();
        if (emp != null) {
            for (Employee employ : emp) {
                String name = employ.getName();
                long id = employ.getIdDepartment();
                //department
                Department d = departmentDow.getById(id);
                String dName = "";
                String eName = "";
                if (d != null) {
                    dName = d.getName();
                    System.out.println("        "+dName);
                    //Enterprise
                    Enterprise e = enterpriseDow.getById(d.getIdEnterprise());
                    if (e != null) {
                        eName = e.getName();
                    }
                }
                String[] row = new String[]{"", name,dName,eName};
                list.add(row);
            }
        }
        return list;
    }
}
