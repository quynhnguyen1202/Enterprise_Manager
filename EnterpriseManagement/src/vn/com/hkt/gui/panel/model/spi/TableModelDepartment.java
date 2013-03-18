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
import vn.com.hkt.dao.api.IEnterpriseDao;
import vn.com.hkt.dao.spi.DepartmentDao;
import vn.com.hkt.dao.spi.EnterpriseDao;
import vn.com.hkt.data.entity.Department;
import vn.com.hkt.data.entity.Enterprise;

/**
 *
 * @author Administrator
 */
public class TableModelDepartment extends DefaultTableModel {

    private List<Department> departments = new ArrayList<Department>();
    private String[] header = new String[]{"", "Name", "DateActivate", "Parent Department", "Enterprise"};
    private List<String[]> data = new ArrayList<String[]>();
    private IEnterpriseDao enterpriseDao = new EnterpriseDao();
    private IDepartmentDao departmentDao = new DepartmentDao();

    public TableModelDepartment(List<Department> departments) {
        this.departments = departments;
        data = LoadData();
    }

    private List<String[]> LoadData() {
        List<String[]> list = new ArrayList<String[]>();
        if (departments != null) {
            for (Department d : departments) {
                String name = d.getName();
                long id = d.getId();
                //enterprise
                Enterprise e = enterpriseDao.getById(d.getIdEnterprise());
                String eName = e.getName();
                //parent department name
                String deName = "";
                Department de = departmentDao.getById(d.getIdDepartment());
                if (de != null) {
                    deName = de.getName();
                }
                Date datectivate = d.getDateActivate();
                String[] row = new String[]{String.valueOf(id), name, datectivate == null ? "" : datectivate.toString(), deName, eName};
                list.add(row);
            }
        }
        return list;
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
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }
}
