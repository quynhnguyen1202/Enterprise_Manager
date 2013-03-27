/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.gui.panel.model.spi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import vn.com.hkt.dao.api.IDepartmentDao;
import vn.com.hkt.dao.api.IEmployeeDao;
import vn.com.hkt.dao.api.IEnterpriseDao;
import vn.com.hkt.dao.api.IProjectDao;
import vn.com.hkt.dao.spi.DepartmentDao;
import vn.com.hkt.dao.spi.EmployeeDao;
import vn.com.hkt.dao.spi.EnterpriseDao;
import vn.com.hkt.dao.spi.ProjectDao;
import vn.com.hkt.data.entity.Department;
import vn.com.hkt.data.entity.Employee;
import vn.com.hkt.data.entity.Enterprise;
import vn.com.hkt.data.entity.Operation;
import vn.com.hkt.data.entity.Project;

/**
 *
 * @author Administrator
 */
public class TableModelOperation extends DefaultTableModel {

    private List<Operation> operations = new ArrayList<Operation>();
    private String[] header = new String[]{"ID", "Project Name", "Employee", "Department", "Enterprise", "Date excute"};
    private List<String[]> data = new ArrayList<String[]>();
    private IEnterpriseDao enterpriseDao = new EnterpriseDao();
    private IDepartmentDao departmentDao = new DepartmentDao();
    private IEmployeeDao employeeDao = new EmployeeDao();
    private IProjectDao projectDao = new ProjectDao();

    public TableModelOperation(List<Operation> operations) {
        this.operations = operations;
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
    public int getRowCount() {
        if (data == null) {
            return 0;
        }
        return data.size();
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    private List<String[]> loadData() {
        List<String[]> list = new ArrayList<String[]>();
        if (operations != null) {
            for (Operation o : operations) {
                long id = o.getId();
                long oProject = o.getIdProject();
                String projectName = "";
                Project ject = projectDao.getById(oProject);
                if (ject != null) {
                    projectName = ject.getName();
                }
                long oEmployee = o.getIdEmployee();
                String employeeName = "";
                Employee emp = employeeDao.getById(oEmployee);
                if (emp != null) {
                    employeeName = emp.getName();
                }
                long oDepartment = o.getIdDepartment();
                String dName = "";
                Department d = departmentDao.getById(oDepartment);
                if (d != null) {
                    dName = d.getName();
                }
                long oEnterprise = o.getIdEnterprise();
                String eName = "";
                Enterprise e = enterpriseDao.getById(oEnterprise);
                if (e != null) {
                    eName = e.getName();
                }
                Date dateExcute = o.getDateExecute();
                String[] row = new String[]{String.valueOf(id), projectName, employeeName, dName, eName, dateExcute == null ? "" : dateExcute.toString()};
                list.add(row);
            }
        }
        return list;
    }
}
