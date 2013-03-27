/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddNewProduct.java
 *
 * Created on Mar 13, 2013, 11:05:56 AM
 */
package vn.com.hkt.gui.panel.spi;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import vn.com.hkt.data.entity.Department;
import vn.com.hkt.data.entity.Enterprise;
import vn.com.hkt.data.entity.MidleProductGroup;
import vn.com.hkt.data.entity.Product;
import vn.com.hkt.data.entity.ProductGroup;
import vn.com.hkt.gui.control.api.IPanelControlGeneral;
import vn.com.hkt.gui.entity.api.IPanelShowList;
import vn.com.hkt.gui.entity.api.IShowPanel;
import vn.com.hkt.provider.api.IProviderPanelShowListDepartment;
import vn.com.hkt.provider.api.IProviderPanelShowListEnterprise;
import vn.com.hkt.provider.api.IProviderPanelShowListProductGroup;
import vn.com.hkt.provider.api.IProviderPanelShowMidleProductGroup;
import vn.com.hkt.provider.api.IProviderPanelShowProduct;
import vn.com.hkt.provider.spi.ProviderPanelShowListDepartment;
import vn.com.hkt.provider.spi.ProviderPanelShowListEnterprise;
import vn.com.hkt.provider.spi.ProviderPanelShowListProductGroup;
import vn.com.hkt.provider.spi.ProviderPanelShowMidleProductGroup;
import vn.com.hkt.provider.spi.ProviderPanelShowProduct;

/**
 *
 * @author Administrator
 */
public class AddNewProduct extends javax.swing.JPanel implements IShowPanel<Product> {
    
    private IProviderPanelShowProduct providerProduct;
    private IPanelControlGeneral controlGeneral;
    private long departmentID;
    private long enterpriseID;
    //group
    private IProviderPanelShowMidleProductGroup providerMidleGroup;

    /** Creates new form AddNewProduct */
    public AddNewProduct() {
        initComponents();
        providerProduct = new ProviderPanelShowProduct();
        providerMidleGroup = new ProviderPanelShowMidleProductGroup();
        loadListGroup();
        loadEnterprise();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbDepartment = new javax.swing.JComboBox();
        cbEnterprise = new javax.swing.JComboBox();
        txtProductName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAddGroup = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listGroup = new javax.swing.JList();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lbError = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.darkGray));

        lbTitle.setFont(new java.awt.Font("Tahoma", 1, 18));
        lbTitle.setForeground(new java.awt.Color(102, 102, 102));
        lbTitle.setText("Add New Product");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Choose department :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Product group :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Choose enterprise :");

        cbDepartment.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDepartment.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDepartmentItemStateChanged(evt);
            }
        });

        cbEnterprise.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbEnterprise.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEnterpriseItemStateChanged(evt);
            }
        });

        txtProductName.setFont(new java.awt.Font("Tahoma", 0, 14));

        jScrollPane1.setViewportView(listAddGroup);

        jScrollPane2.setViewportView(listGroup);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Code :");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon("D:\\HKT\\HKT_Team_Project\\Enterprise_Manager\\EnterpriseManagement\\src\\vn\\com\\hkt\\gui\\icon\\32x32\\back.png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon("D:\\HKT\\HKT_Team_Project\\Enterprise_Manager\\EnterpriseManagement\\src\\vn\\com\\hkt\\gui\\icon\\32x32\\next.png")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lbError.setFont(new java.awt.Font("Tahoma", 0, 14));
        lbError.setForeground(new java.awt.Color(255, 0, 0));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Name :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(cbEnterprise, 0, 148, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtProductName, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(cbDepartment, 0, 148, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtCode, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(lbError, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)))
                .addGap(14, 14, 14)
                .addComponent(lbError, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    //them doi tuong 
    DefaultListModel dlm = new DefaultListModel();
    dlm.addElement(listGroup.getSelectedValue());
    for (int i = 0; i < listAddGroup.getModel().getSize(); i++) {
        dlm.addElement(listAddGroup.getModel().getElementAt(i));
    }
    listAddGroup.setModel(dlm);



    //xoa doi tuong
    DefaultListModel model = (DefaultListModel) listGroup.getModel();
    int selectedIndex = listGroup.getSelectedIndex();
    if (selectedIndex != -1) {
        model.remove(selectedIndex);
    }
    listGroup.setModel(model);
}//GEN-LAST:event_jButton2ActionPerformed
    
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    //them doi tuong
    DefaultListModel dlm = new DefaultListModel();
    dlm.addElement(listAddGroup.getSelectedValue());
    for (int i = 0; i < listGroup.getModel().getSize(); i++) {
        dlm.addElement(listGroup.getModel().getElementAt(i));
    }
    listGroup.setModel(dlm);



    //xoa doi tuong
    DefaultListModel model = (DefaultListModel) listAddGroup.getModel();
    int selectedIndex = listAddGroup.getSelectedIndex();
    if (selectedIndex != -1) {
        model.remove(selectedIndex);
    }
    listAddGroup.setModel(model);
}//GEN-LAST:event_jButton1ActionPerformed
    
private void cbEnterpriseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEnterpriseItemStateChanged
    loabCBEnterprise();
}//GEN-LAST:event_cbEnterpriseItemStateChanged
    
private void cbDepartmentItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDepartmentItemStateChanged
    loadCBDepartment();
}//GEN-LAST:event_cbDepartmentItemStateChanged
    
    private void loadCBDepartment() {
        int index = cbEnterprise.getSelectedIndex();
        if (index > 0) {
            Department d = (Department) cbDepartment.getSelectedItem();
            if (d != null) {
                if (d.getId() > 0) {
                    departmentID = d.getId();
                } else {
                    departmentID = 0;
                }
            } else {
                departmentID = 0;
            }
        } else {
            departmentID = 0;
        }
    }
    
    private void loabCBEnterprise() {
        Enterprise e = (Enterprise) cbEnterprise.getSelectedItem();
        if (e != null) {
            if (e.getId() > 0) {
                cbDepartment.setEnabled(true);
                enterpriseID = e.getId();
                loadDepartment();
                loadCBDepartment();
            } else {
                enterpriseID = 0;
            }
        } else {
            cbDepartment.setEnabled(false);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbDepartment;
    private javax.swing.JComboBox cbEnterprise;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbError;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JList listAddGroup;
    private javax.swing.JList listGroup;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtProductName;
    // End of variables declaration//GEN-END:variables

    @Override
    public boolean checkData() {
        if (txtProductName.getText().length() == 0) {
            lbError.setText("Enter product name !");
            return false;
        }
        int count = listAddGroup.getModel().getSize();
        if (count < 1) {
            lbError.setText("Choose group product !");
            return false;
        }
        if (cbEnterprise.getSelectedIndex() == 0) {
            lbError.setText("Choose enterprise !");
            return false;
        }
        if (cbEnterprise.getSelectedItem() == null) {
            lbError.setText("Choose enterprise !");
            return false;
        }
        return true;
    }
    
    @Override
    public long addData() {
        if (!checkData() || !getData()) {
            return 0;
        } else {
            long iD = providerProduct.addData();
            for (int i = 0; i < listAddGroup.getModel().getSize(); i++) {
                ProductGroup p = (ProductGroup) listAddGroup.getModel().getElementAt(i);
                if (p != null) {
                    providerMidleGroup.getDataView().setIdGroupProduct(p.getId());
                    providerMidleGroup.getDataView().setIdProduct(iD);
                    providerMidleGroup.addData();
                }
            }
            JOptionPane.showMessageDialog(null, "Add new product successful !");
            resetData();
            return iD;
        }
    }
    
    @Override
    public boolean editData() {
        if (JOptionPane.showConfirmDialog(null, "Are you sure !", "Edit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (!checkData() || !getData()) {
                return false;
            }
            long id = providerProduct.updateData();
            for (int i = 0; i < listAddGroup.getModel().getSize(); i++) {
                ProductGroup p = (ProductGroup) listAddGroup.getModel().getElementAt(i);
                if (p != null) {
                    providerMidleGroup.getDataView().setIdGroupProduct(p.getId());
                    providerMidleGroup.updateData();
                }
            }
            if (id < 0) {
                return false;
            }
            return true;
        }
        return false;
    }
    
    @Override
    public boolean deleteData() {
        if (JOptionPane.showConfirmDialog(null, "Are you sure !", "Delete", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            providerProduct.deleteData();
            resetData();
            return true;
        }
        return false;
    }
    
    @Override
    public List listA() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public List listCombo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private void loadListGroup() {
        List<ProductGroup> productGroups = providerProduct.getListGroup();
        DefaultListModel dlm = new DefaultListModel();
        for (ProductGroup p : productGroups) {
            dlm.addElement(p);
        }
        listGroup.setModel(dlm);
    }
    
    private void loadEnterprise() {
        List<Enterprise> enterprises = providerProduct.getListEnterprise();
        if (enterprises != null) {
            cbEnterprise.setModel(new DefaultComboBoxModel(enterprises.toArray()));
            loabCBEnterprise();
        } else {
            lbError.setText("No enterprise");
        }
    }
    
    private void loadDepartment() {
        if (enterpriseID > 0) {
            List<Department> departments = providerProduct.getDepartmentByEntID(enterpriseID);
            cbDepartment.setModel(new DefaultComboBoxModel(departments.toArray()));
        } else {
            cbDepartment.enable(false);
        }
    }
    
    private boolean getData() {
        providerProduct.getDataView().setName(txtProductName.getText());
        providerProduct.getDataView().setIdDepartment(departmentID);
        providerProduct.getDataView().setIdEnterprise(enterpriseID);
        providerProduct.getDataView().setCodeProduct(txtCode.getText());
        return true;
    }
    
    @Override
    public boolean resetData() {
        txtProductName.setText("");
        txtCode.setText("");
        cbEnterprise.setSelectedIndex(0);
        providerProduct.setDataView(null);
        loadListGroup();
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        dcm.addElement(null);
        listAddGroup.setModel(dcm);
        return true;
    }
    
    @Override
    public void setDataShow(Product ob) {
        providerProduct.setDataView(ob);
        refreshData();
    }
    
    @Override
    public void refreshData() {
        lbTitle.setText("Update Product");
        txtProductName.setText(providerProduct.getDataView().getName());
        txtCode.setText(providerProduct.getDataView().getCodeProduct());
        //set combo box enterprise
        long idEnter = providerProduct.getDataView().getIdEnterprise();
        for (int i = 0; i < cbEnterprise.getItemCount();) {
            Enterprise enter = ((Enterprise) cbEnterprise.getItemAt(i));
            if (enter != null && enter.getId() == idEnter) {
                cbEnterprise.setSelectedIndex(i);
                break;
            } else {
                i++;
            }
        }
        // set combo box department
        long idDepart = providerProduct.getDataView().getIdDepartment();
        for (int i = 0; i < cbDepartment.getItemCount();) {
            Department depart = ((Department) cbDepartment.getItemAt(i));
            if (depart != null && depart.getId() == idDepart) {
                cbDepartment.setSelectedIndex(i);
                break;
            } else {
                i++;
            }
        }
        //set list midle group
        List<MidleProductGroup> listMidle = providerMidleGroup.getMidleGroupByProductId(providerProduct.getDataView().getId());
        JOptionPane.showConfirmDialog(null, listMidle);
        DefaultListModel listModel = new DefaultListModel();
        for (MidleProductGroup p : listMidle) {
            long idGroup = p.getIdGroupProduct();
            JOptionPane.showMessageDialog(null, idGroup);
            List<ProductGroup> groups = providerMidleGroup.getProductGroupByIDGroup(idGroup);
            JOptionPane.showMessageDialog(null, groups);
            listModel.addElement(groups);
            
        }
        listAddGroup.setModel(listModel);
        //long idGroup=providerProduct.

        
        controlGeneral.refresh(this);
    }
    
    @Override
    public void setControlShow(IPanelControlGeneral controlGeneral) {
        this.controlGeneral = controlGeneral;
    }
}
