/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddNewProductGroup.java
 *
 * Created on Mar 20, 2013, 9:34:16 AM
 */
package vn.com.hkt.gui.panel.spi;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import vn.com.hkt.data.entity.Enterprise;
import vn.com.hkt.data.entity.ProductGroup;
import vn.com.hkt.gui.control.api.IPanelControlGeneral;
import vn.com.hkt.gui.entity.api.IShowPanel;
import vn.com.hkt.provider.api.IProviderPanelShowProductGroup;
import vn.com.hkt.provider.spi.ProviderPanelShowProductGroup;

/**
 *
 * @author Administrator
 */
public class AddNewProductGroup extends javax.swing.JPanel implements IShowPanel<ProductGroup> {

    private long groupID;
    private long enterpriseID;
    private IProviderPanelShowProductGroup provider;
    private IPanelControlGeneral controlGeneral;

    /** Creates new form AddNewProductGroup */
    public AddNewProductGroup() {
        initComponents();
        provider = new ProviderPanelShowProductGroup();
        loadEnterprise();
//        showDefault();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lbError = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbEnterprise = new javax.swing.JComboBox();
        cbGroup = new javax.swing.JComboBox();
        lbTitle = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.gray));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Choose parent group :");

        lbError.setFont(new java.awt.Font("Tahoma", 0, 12));
        lbError.setForeground(new java.awt.Color(255, 0, 51));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Choose enterprise :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Code :");

        cbEnterprise.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbEnterprise.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEnterpriseItemStateChanged(evt);
            }
        });

        cbGroup.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbGroup.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbGroupItemStateChanged(evt);
            }
        });

        lbTitle.setFont(new java.awt.Font("Tahoma", 1, 18));
        lbTitle.setForeground(new java.awt.Color(102, 102, 102));
        lbTitle.setText("Add New Product Group");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Group name :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(cbEnterprise, 0, 200, Short.MAX_VALUE)
                .addGap(78, 78, 78))
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(cbGroup, 0, 200, Short.MAX_VALUE)
                .addGap(78, 78, 78))
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGap(78, 78, 78))
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtCode, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGap(78, 78, 78))
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(lbError, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(lbError, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void cbEnterpriseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEnterpriseItemStateChanged
    loadCBEnterprise();
}//GEN-LAST:event_cbEnterpriseItemStateChanged
    private void loadCBEnterprise() {
        Enterprise e = (Enterprise) cbEnterprise.getSelectedItem();
        if (e != null) {
            if (e.getId() > 0) {
                System.out.println("----------------" + e.getId());
                cbGroup.setEnabled(true);
                enterpriseID = e.getId();
                System.out.println("+++++" + enterpriseID);
                loadGroup();
                loadCBGroup();
            } else {
                enterpriseID = 0;
            }
        } else {
            cbGroup.setEnabled(false);
        }
    }
private void cbGroupItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbGroupItemStateChanged
    loadCBGroup();
}//GEN-LAST:event_cbGroupItemStateChanged
    private void loadCBGroup() {
        int index = cbEnterprise.getSelectedIndex();
        if (index > 0) {
            ProductGroup d = (ProductGroup) cbGroup.getSelectedItem();
            if (d != null) {
                if (d.getId() > 0) {
                    groupID = d.getId();
                } else {
                    groupID = 0;
                }
            } else {
                groupID = 0;
            }
        } else {
            groupID = 0;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbEnterprise;
    private javax.swing.JComboBox cbGroup;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
        if (txtName.getText().length() == 0) {
            lbError.setText("Enter group name");
            return false;
        }
        if (txtCode.getText().length() == 0) {
            lbError.setText("Enter group code");
            return false;
        }
        if (cbEnterprise.getSelectedIndex() == 0) {
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

    private void loadEnterprise() {
        List<Enterprise> enterprises = provider.getListEnterprise();
        if (enterprises != null) {
            cbEnterprise.setModel(new DefaultComboBoxModel(enterprises.toArray()));
            loadCBEnterprise();
        } else {
            lbError.setText("No enterprise");
        }
    }

    private void loadGroup() {
        if (enterpriseID > 0) {
            List<ProductGroup> departments = provider.getListGroupByEntID(enterpriseID);
            cbGroup.setModel(new DefaultComboBoxModel(departments.toArray()));
        } else {
            cbGroup.enable(false);
        }

    }

    private boolean getData() {
        provider.getDataView().setName(txtName.getText());
        provider.getDataView().setCodeProductGroup(txtCode.getText());
        provider.getDataView().setIdEnterprise(enterpriseID);
        provider.getDataView().setIdProductGroup(groupID);
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
    public void setDataShow(ProductGroup ob) {
        provider.setDataView(ob);
        refreshData();
    }

    @Override
    public void refreshData() {
        lbTitle.setText("Update Product Group");
        txtName.setText(provider.getDataView().getName());
        txtCode.setText(provider.getDataView().getCodeProductGroup());
        //set combobox enterprise
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
        //set combobox group parent
        long idGroup = provider.getDataView().getIdProductGroup();
        for (int i = 0; i < cbGroup.getItemCount();) {
            ProductGroup depart = ((ProductGroup) cbGroup.getItemAt(i));
            if (depart != null && depart.getId() == idGroup) {
                cbGroup.setSelectedIndex(i);
                break;
            } else {
                i++;
            }
        }
        //xoa group khoi combobox
        ProductGroup en = provider.getObjectbyID(provider.getDataView().getId());
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbGroup.getModel();
        for (int i = 0; i < model.getSize();) {
            ProductGroup e = ((ProductGroup) model.getElementAt(i));
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
