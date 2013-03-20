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
import vn.com.hkt.data.entity.Project;

/**
 *
 * @author Administrator
 */
public class TableModelProject extends DefaultTableModel {

    private List<Project> projects = new ArrayList<Project>();
    private String[] header = new String[]{"", "Project Name", "Date Start", "Date End", "Department", "Enterprise"};
    private List<String[]> data = new ArrayList<String[]>();
    private IEnterpriseDao enterpriseDao = new EnterpriseDao();
    private IDepartmentDao departmentDao = new DepartmentDao();

    public TableModelProject(List<Project> projects) {
        this.projects = projects;
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
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    private List<String[]> loadData() {
        List<String[]> list = new ArrayList<String[]>();
        if (projects != null) {
            for (Project p : projects) {
                String name = p.getName();
                System.out.println("aaaaaaaaaaaaaaaaa" + name);
                long id = p.getId();
                //enterprise
                Enterprise e = enterpriseDao.getById(p.getIdEnterprise());
                String eName = "";
                if (e != null) {
                    e.getName();
                }
                //parent department name
                String deName = "";
                Department de = departmentDao.getById(p.getIdDepartment());
                if (de != null) {
                    deName = de.getName();
                }
                Date dateStart = p.getDateStart();
                Date dateEnd = p.getDateEnd();
                String[] row = new String[]{String.valueOf(id), name, dateStart == null ? "" : dateStart.toString(), dateEnd == null ? "" : dateEnd.toString(), deName, eName};
                list.add(row);
            }
        }
        return list;
    }
}
