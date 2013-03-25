/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.gui.panel.model.spi;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import vn.com.hkt.dao.api.IUnitMoneyDao;
import vn.com.hkt.dao.spi.UnitMoneyDao;
import vn.com.hkt.data.entity.UnitMoney;

/**
 *
 * @author Administrator
 */
public class TableModelUnitMoney extends DefaultTableModel {
     private  List<UnitMoney> unitMoneys=new ArrayList<UnitMoney>();
    private String[] header=new String[]{"","Code","Name","Ratio with default"};
    private List<String[]> data=new ArrayList<String[]>();
    private IUnitMoneyDao unitMoneyDao = new UnitMoneyDao();

    public TableModelUnitMoney(List<UnitMoney> unitMoneys) {
        this.unitMoneys=unitMoneys;
        data=loadData();
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
        List<String[]> list=new ArrayList<String[]>();
        if(unitMoneys!=null){
            for (UnitMoney unit : unitMoneys) {
                long id=unit.getId();
                String code=unit.getCode();
                String name=unit.getName();
                float ratio=unit.getRatiowithDefault();
                String[] row=new String[]{String.valueOf(id),code,name,String.valueOf(ratio)};
                list.add(row);
            }
        }
        return list;
    }
    
}
