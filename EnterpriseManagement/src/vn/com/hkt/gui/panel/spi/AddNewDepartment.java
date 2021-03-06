/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddNewDepartment.java
 *
 * Created on Mar 16, 2013, 9:09:49 AM
 */
package vn.com.hkt.gui.panel.spi;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import vn.com.hkt.data.entity.Department;
import vn.com.hkt.data.entity.Enterprise;
import vn.com.hkt.gui.control.api.IPanelControlGeneral;
import vn.com.hkt.gui.entity.api.IShowPanel;
import vn.com.hkt.provider.api.IProviderPanelShowDepartment;
import vn.com.hkt.provider.api.IProviderPanelShowEnterprise;
import vn.com.hkt.provider.spi.ProviderPanelShowDepartment;
import vn.com.hkt.provider.spi.ProviderPanelShowEnterprise;

/**
 *
 * @author Administrator
 */
public class AddNewDepartment extends javax.swing.JPanel implements IShowPanel<Department> {

    private long departmentID;
    private long enterpriseID;
    private IProviderPanelShowDepartment provider;
    private IProviderPanelShowEnterprise providerEnterprise;
    private IPanelControlGeneral controlGeneral;

    /** Creates new form AddNewDepartment */
    public AddNewDepartment() {
        initComponents();
        provider = new ProviderPanelShowDepartment();
        providerEnterprise = new ProviderPanelShowEnterprise();
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dcDateActivate = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        cbDepartment = new javax.swing.JComboBox();
        cbEnterprise = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        lbError = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, java.awt.Color.darkGray));

        lbTitle.setFont(new java.awt.Font("Tahoma", 1, 18));
        lbTitle.setForeground(new java.awt.Color(102, 102, 102));
        lbTitle.setText("Add New Department");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Parent department :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Department name :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Code :");

        txtCode.setFont(new java.awt.Font("Tahoma", 0, 12));

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

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Choose enterprise :");

        lbError.setFont(new java.awt.Font("Tahoma", 0, 12));
        lbError.setForeground(new java.awt.Color(255, 0, 0));

        txtName.setFont(new java.awt.Font("Tahoma", 0, 12));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Date activate :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(cbEnterprise, 0, 200, Short.MAX_VALUE)
                .addGap(118, 118, 118))
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(cbDepartment, 0, 200, Short.MAX_VALUE)
                .addGap(118, 118, 118))
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGap(118, 118, 118))
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(dcDateActivate, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGap(118, 118, 118))
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtCode, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGap(118, 118, 118))
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(lbError, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dcDateActivate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(lbError, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

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

private void cbEnterpriseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEnterpriseItemStateChanged
    loadCBEnterprise();
}//GEN-LAST:event_cbEnterpriseItemStateChanged

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
    private com.toedter.calendar.JDateChooser dcDateActivate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbError;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

    @Override
    public List listA() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean checkData() {
        if (txtCode.getText().length() == 0) {
            lbError.setText("Enter department name !");
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
        }
        long id = provider.addData();
        resetData();
        return id;
    }

    @Override
    public boolean editData() {
       if (JOptionPane.showConfirmDialog(null, "Are you sure !", "Edit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (!checkData() || !getData()) {
                return false;
            }
            long id = provider.updateData();
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
            provider.deleteData();
            resetData();
            return true;
        }
        return false;
    }

    @Override
    public List listCombo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
//
//    @Override
//    public void showDefault() {
//        loadEnterprise();
//    }

    private void loadEnterprise() {
        List<Enterprise> enterprises = provider.getListEnterprise();
        if (enterprises != null) {
            cbEnterprise.setModel(new DefaultComboBoxModel(enterprises.toArray()));
            loadCBEnterprise();
        } else {
            lbError.setText("No enterprise");
        }
    }

    private void loadDepartment() {
        if (enterpriseID > 0) {
            List<Department> departments = provider.getListDepartmentByIDEnt(enterpriseID);
            cbDepartment.setModel(new DefaultComboBoxModel(departments.toArray()));
        } else {
            cbDepartment.enable(false);
        }
    }

    private boolean getData() {
        provider.getDataView().setName(txtName.getText());
        provider.getDataView().setIdEnterprise(enterpriseID);
        provider.getDataView().setIdDepartment(departmentID);
        provider.getDataView().setDateActivate(dcDateActivate.getDate());
        provider.getDataView().setCodeDepartment(txtCode.getText());
        return true;
    }

    @Override
    public boolean resetData() {
        txtName.setText("");
        txtCode.setText("");
        cbEnterprise.setSelectedIndex(0);
        dcDateActivate.setDateFormatString("");
        provider.setDataView(null);
        return true;
    }

    @Override
    public void setDataShow(Department ob) {
        provider.setDataView(ob);
        refreshData();
    }

    @Override
    public void refreshData() {
        lbTitle.setText("Update Department");
        txtName.setText(provider.getDataView().getName());
        txtCode.setText(provider.getDataView().getCodeDepartment());
        dcDateActivate.setDate(provider.getDataView().getDateActivate());
        controlGeneral.refresh(this);
        //set combo box enterprise
        long idEnter = provider.getDataView().getIdEnterprise();
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
        long idDepart = provider.getDataView().getIdDepartment();
        for (int i = 0; i < cbDepartment.getItemCount();) {
            Department depart = ((Department) cbDepartment.getItemAt(i));
            if (depart != null && depart.getId() == idDepart) {
                cbDepartment.setSelectedIndex(i);
                break;
            } else {
                i++;
            }
        }
       // xoa ten trong parent combo box
        Department en = provider.getObjectbyID(provider.getDataView().getId());
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbDepartment.getModel();
        for (int i = 0; i < model.getSize();) {
            Department e = ((Department) model.getElementAt(i));
            if (e != null && e.getId() == en.getId()) {
                model.removeElementAt(i);
            } else {
                i++;
            }
        }
        controlGeneral.refresh(this);
    }

    @Override
    public void setControlShow(IPanelControlGeneral controlGeneral) {
        this.controlGeneral = controlGeneral;
    }
}
