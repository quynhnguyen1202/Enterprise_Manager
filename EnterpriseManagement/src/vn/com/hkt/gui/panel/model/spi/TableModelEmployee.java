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

    private List<String[]> loadData() {
        List<String[]> list = new ArrayList<String[]>();
        if (emp != null) {
            for (Employee employ : emp) {
                String name = employ.getName();
                long id = employ.getIdDepartment();
                //department
                Department d = departmentDow.getById(employ.getIdDepartment());
                String dName = "";
                if (d != null) {
                    dName = d.getName();
                }
                //Enterprise
                Enterprise e = enterpriseDow.getById(d.getIdEnterprise());
                String eName = "";
                if (e != null) {
                    eName = e.getName();
                }
                String[] row = new String[]{String.valueOf(id), name, dName, eName};
                list.add(row);
            }
        }
        return list;
    }
}
