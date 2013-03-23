/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddNewEmployee.java
 *
 * Created on Mar 14, 2013, 11:02:28 AM
 */
package vn.com.hkt.gui.panel.spi;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import vn.com.hkt.data.entity.Department;
import vn.com.hkt.data.entity.Employee;
import vn.com.hkt.data.entity.Enterprise;
import vn.com.hkt.gui.control.api.IPanelControlGeneral;
import vn.com.hkt.gui.entity.api.IShowPanel;
import vn.com.hkt.provider.api.IProviderPanelShowEmployee;
import vn.com.hkt.provider.api.IProviderPanelShowListDepartment;
import vn.com.hkt.provider.api.IProviderPanelShowListEnterprise;
import vn.com.hkt.provider.spi.ProviderPanelShowEmployee;
import vn.com.hkt.provider.spi.ProviderPanelShowListDepartment;
import vn.com.hkt.provider.spi.ProviderPanelShowListEnterprise;

/**
 *
 * @author Administrator
 */
public class AddNewEmployee extends javax.swing.JPanel implements IShowPanel<Employee> {

    private IProviderPanelShowListEnterprise providerEnterprise;
    private IProviderPanelShowListDepartment providerDepartment;
    private long departmentID;
    private long enterpriseID;
    private IProviderPanelShowEmployee provider;

    /** Creates new form AddNewEmployee */
    public AddNewEmployee() {
        initComponents();
        provider = new ProviderPanelShowEmployee();
        providerEnterprise = new ProviderPanelShowListEnterprise();
        providerDepartment = new ProviderPanelShowListDepartment();
//        showDefault();
        loadCBEnterprise();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbDepartment = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cbEnterprise = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        lbError = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.gray));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Add New Employee");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Code :");

        cbDepartment.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDepartment.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDepartmentItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Choose enterprise :");

        cbEnterprise.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbEnterprise.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEnterpriseItemStateChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Choose department :");

        lbError.setFont(new java.awt.Font("Tahoma", 0, 12));
        lbError.setForeground(new java.awt.Color(255, 0, 51));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Employee name :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(cbEnterprise, 0, 196, Short.MAX_VALUE)
                .addGap(110, 110, 110))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(cbDepartment, 0, 196, Short.MAX_VALUE)
                .addGap(110, 110, 110))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addGap(110, 110, 110))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtCode, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addGap(110, 110, 110))
            .addGroup(layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(lbError, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(lbError, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void cbEnterpriseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEnterpriseItemStateChanged
    loadCBEnterprise();
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

    private void loadCBEnterprise() {
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lbError;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

    @Override
    public boolean checkData() {
        if (txtCode.getText().length() == 0) {
            lbError.setText("Enter employee name !");
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
        if (cbDepartment.getSelectedIndex() == 0) {
            lbError.setText("Choose department !");
            return false;
        }
        if (cbDepartment.getSelectedItem() == null) {
            lbError.setText("Choose department !");
            return false;
        }
        return true;
    }

    @Override
    public long addData() {
        if (!checkData() || !getData()) {
            return 0;
        }
        long id=provider.addData();
        resetData();
        return id;
    }

    @Override
    public boolean editData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean deleteData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List listA() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List listCombo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
//
//    @Override
//    public void showDefault() {
//        loadEnterprise();
//
//    }

    private void loadEnterprise() {
        List<Enterprise> enterprises = providerEnterprise.getListInformation();
        if (enterprises != null) {
            cbEnterprise.setModel(new DefaultComboBoxModel(enterprises.toArray()));
            loadCBEnterprise();
        } else {
            enterpriseID = 0;
        }
    }

    private void loadDepartment() {
        if (enterpriseID > 0) {
            List<Department> departments = providerDepartment.getByIDEnt(enterpriseID);
            cbDepartment.setModel(new DefaultComboBoxModel(departments.toArray()));
        } else {
            cbDepartment.enable(false);
        }
    }

    private boolean getData() {
        provider.getDataView().setName(txtName.getText());
        provider.getDataView().setIdDepartment(departmentID);
        provider.getDataView().setCodeEmployee(txtCode.getText());
        return true;
    }

    @Override
    public boolean resetData() {
        txtName.setText("");
        txtCode.setText("");
        cbEnterprise.setSelectedIndex(0);
        provider.setDataView(null);
        return true;
    }

    @Override
    public void setDataShow(Employee ob) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void refreshData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setControlShow(IPanelControlGeneral controlGeneral) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
