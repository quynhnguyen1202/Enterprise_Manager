/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.gui.panel.model.spi;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import vn.com.hkt.dao.api.IEnterpriseDao;
import vn.com.hkt.dao.api.IProductGroupDao;
import vn.com.hkt.dao.spi.EnterpriseDao;
import vn.com.hkt.dao.spi.ProductGroupDao;
import vn.com.hkt.data.entity.Enterprise;
import vn.com.hkt.data.entity.ProductGroup;

/**
 *
 * @author Administrator
 */
public class TableModelProductGroup extends DefaultTableModel {

    private List<ProductGroup> groups = new ArrayList<ProductGroup>();
    private String[] header = new String[]{"", "Group Name", "Parent Group", "Enterprise"};
    private List<String[]> data = new ArrayList<String[]>();
    private IEnterpriseDao enterpriseDao = new EnterpriseDao();
    private IProductGroupDao groupDao = new ProductGroupDao();

    public TableModelProductGroup(List<ProductGroup> groups) {
        this.groups = groups;
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
        if (groups != null) {
            for (ProductGroup g : groups) {
                String gName = g.getName();
                //enter prise
                String eName = "";
                Enterprise e = enterpriseDao.getById(g.getIdEnterprise());
                if (e != null) {
                    eName = e.getName();
                }
                //parent group
                String pName = "";
                ProductGroup pg = groupDao.getById(g.getIdProductGroup());
                if (pg != null) {
                    pName = pg.getName();
                }
                String[] row = new String[]{"", gName, pName, eName};
                list.add(row);
            }
        }
        return list;
    }
}
