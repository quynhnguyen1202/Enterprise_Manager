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
import vn.com.hkt.data.entity.Enterprise;
import vn.com.hkt.data.entity.Product;

/**
 *
 * @author Administrator
 */
public class TableModelProduct extends DefaultTableModel {
    private  List<Product> products=new ArrayList<Product>();
    private String[] header=new String[]{"ID","Code","Product Name","Department","Enterprise"};
    private List<String[]> data=new ArrayList<String[]>();
    private IEnterpriseDao enterpriseDao = new EnterpriseDao();
    private IDepartmentDao departmentDao = new DepartmentDao();

    public TableModelProduct(List<Product> products) {
        this.products=products;
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
    
    
    
    private List<String[]> loadData() {
        List<String[]> list=new ArrayList<String[]>();
        if(products!=null){
            for(Product p:products){
                String pName=p.getName();
                String pCode=p.getCodeProduct();
                long id=p.getId();
                //department
                String dName="";
                Department d=departmentDao.getById(p.getIdDepartment());
                if(d!=null){
                    dName=d.getName();
                }
                //enterprise
                String eName="";
                Enterprise e=enterpriseDao.getById(p.getIdEnterprise());
                if(e!=null){
                    eName=e.getName();
                }
                String[] row=new String[]{String.valueOf(id),pCode,pName,dName,eName};
                list.add(row);
            }
        }
        return list;
    }
    
     @Override
    public String getColumnName(int column) {
        return header[column];
    }
    
}
