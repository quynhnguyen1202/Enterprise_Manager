/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.gui.panel.model.spi;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import vn.com.hkt.dao.api.IUnitProductDao;
import vn.com.hkt.dao.spi.UnitProductDao;
import vn.com.hkt.data.entity.UnitProduct;

/**
 *
 * @author Administrator
 */
public class TableModelUnitProduct extends DefaultTableModel {

    private List<UnitProduct> unitProducts = new ArrayList<UnitProduct>();
    private String[] header = new String[]{"", "Code", "Name", "Ratio with default"};
    private List<String[]> data = new ArrayList<String[]>();
    private IUnitProductDao unitProductDao = new UnitProductDao();
    
    public TableModelUnitProduct(List<UnitProduct> unitProducts) {
        this.unitProducts = unitProducts;
        data = loadTable();
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

    private List<String[]> loadTable() {
        List<String[]> list = new ArrayList<String[]>();
        if (unitProducts != null) {
            for (UnitProduct unit : unitProducts) {
                long id = unit.getId();
                String code = unit.getCode();
                String name = unit.getName();
                float ratio = unit.getRatiowithDefault();
                String[] row = new String[]{String.valueOf(id), code, name, String.valueOf(ratio)};
                list.add(row);
            }
        }
        return list;
    }
}
