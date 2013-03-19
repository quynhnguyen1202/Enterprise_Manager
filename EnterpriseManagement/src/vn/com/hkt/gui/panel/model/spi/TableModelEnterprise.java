/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.gui.panel.model.spi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import vn.com.hkt.data.entity.Enterprise;

/**
 *
 * @author Administrator
 */
public class TableModelEnterprise extends DefaultTableModel {

    private List<Enterprise> enterprises = new ArrayList<Enterprise>();
    private String[] header = new String[]{"Ma DN", "Ten DN", "Ngay thanh lap"};
    private List<String[]> data = new ArrayList<String[]>();

    public TableModelEnterprise(List<Enterprise> enterprises) {
        this.enterprises = enterprises;
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
        if (enterprises != null) {
            for (int i = 0; i < enterprises.size(); i++) {
                if (enterprises.get(i) != null) {
                    Enterprise e = enterprises.get(i);
                    long id = e.getId();
                    String name = e.getName();
                    Date dateActive = e.getDateActivative();
                    String[] row = new String[]{String.valueOf(id), name, dateActive == null ? "" : dateActive.toString()};
                    list.add(row);
                }
            }
        }
        return list;
    }
}
