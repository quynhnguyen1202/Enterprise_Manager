/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddNewOperation.java
 *
 * Created on Mar 20, 2013, 11:45:00 AM
 */
package vn.com.hkt.gui.panel.spi;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import vn.com.hkt.data.entity.Department;
import vn.com.hkt.data.entity.Employee;
import vn.com.hkt.data.entity.Enterprise;
import vn.com.hkt.data.entity.Operation;
import vn.com.hkt.data.entity.Project;
import vn.com.hkt.data.entity.UnitMoney;
import vn.com.hkt.gui.control.api.IPanelControlGeneral;
import vn.com.hkt.gui.entity.api.IShowPanel;
import vn.com.hkt.provider.api.IProviderPanelShowOperation;
import vn.com.hkt.provider.spi.ProviderPanelShowOperation;

/**
 *
 * @author Administrator
 */
public class AddNewOperation extends javax.swing.JPanel implements IShowPanel<Operation> {

    private long departmentID;
    private long enterpriseID;
    private long projectID;
    private long employeeID;
    private long unitMoneyID;
    private IProviderPanelShowOperation provider;
    private IPanelControlGeneral controlGeneral;

    /** Creates new form AddNewOperation */
    public AddNewOperation() {
        initComponents();
        provider = new ProviderPanelShowOperation();
        loadEnterprise();
        loadUnitMoney();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lbTitle = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbEnterprise = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cbUnitMoney = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cbDepartment = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        cbEmployee = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        txtMoneyAfterDiscount = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtMoneyAfterTax = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtMoneyTotal = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        dcDateExecute = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        cbProject = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        rbSale = new javax.swing.JRadioButton();
        rbBuy = new javax.swing.JRadioButton();
        lbError = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.gray));

        lbTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(102, 102, 102));
        lbTitle.setText("Add New Operation");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Classification :");

        cbEnterprise.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbEnterprise.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEnterpriseItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Code :");

        cbUnitMoney.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbUnitMoney.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbUnitMoneyItemStateChanged(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Choose department :");

        cbDepartment.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDepartment.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDepartmentItemStateChanged(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Choose employee :");

        cbEmployee.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbEmployee.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEmployeeItemStateChanged(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Choose project :");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Money total :");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Money after tax :");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Choose enterprise :");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Money after discount :");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Date execute :");

        cbProject.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbProject.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbProjectItemStateChanged(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Unit money :");

        buttonGroup1.add(rbSale);
        rbSale.setSelected(true);
        rbSale.setText("Sale");
        rbSale.setOpaque(false);

        buttonGroup1.add(rbBuy);
        rbBuy.setText("Buy");
        rbBuy.setOpaque(false);

        lbError.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtCode, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGap(128, 128, 128))
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cbEnterprise, 0, 200, Short.MAX_VALUE)
                .addGap(128, 128, 128))
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cbDepartment, 0, 200, Short.MAX_VALUE)
                .addGap(128, 128, 128))
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cbEmployee, 0, 200, Short.MAX_VALUE)
                .addGap(128, 128, 128))
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cbProject, 0, 200, Short.MAX_VALUE)
                .addGap(128, 128, 128))
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtMoneyTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGap(128, 128, 128))
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtMoneyAfterTax, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGap(128, 128, 128))
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtMoneyAfterDiscount, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGap(128, 128, 128))
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(dcDateExecute, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGap(128, 128, 128))
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cbUnitMoney, 0, 200, Short.MAX_VALUE)
                .addGap(128, 128, 128))
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(rbBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(rbSale, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(lbError, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbProject, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMoneyTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMoneyAfterTax, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMoneyAfterDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dcDateExecute, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbUnitMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbBuy)
                    .addComponent(rbSale))
                .addGap(17, 17, 17)
                .addComponent(lbError, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void cbEnterpriseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEnterpriseItemStateChanged
    loadCBEnterprise();
}//GEN-LAST:event_cbEnterpriseItemStateChanged

private void cbUnitMoneyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbUnitMoneyItemStateChanged
    loadCBUnitMoney();
}//GEN-LAST:event_cbUnitMoneyItemStateChanged

private void cbDepartmentItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDepartmentItemStateChanged
    loadCBDepartment();
}//GEN-LAST:event_cbDepartmentItemStateChanged

private void cbEmployeeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEmployeeItemStateChanged
    loadCBEmployee();
}//GEN-LAST:event_cbEmployeeItemStateChanged

private void cbProjectItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbProjectItemStateChanged
    loadCBProject();
}//GEN-LAST:event_cbProjectItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbDepartment;
    private javax.swing.JComboBox cbEmployee;
    private javax.swing.JComboBox cbEnterprise;
    private javax.swing.JComboBox cbProject;
    private javax.swing.JComboBox cbUnitMoney;
    private com.toedter.calendar.JDateChooser dcDateExecute;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbError;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JRadioButton rbBuy;
    private javax.swing.JRadioButton rbSale;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtMoneyAfterDiscount;
    private javax.swing.JTextField txtMoneyAfterTax;
    private javax.swing.JTextField txtMoneyTotal;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setControlShow(IPanelControlGeneral controlGeneral) {
        this.controlGeneral = controlGeneral;
    }

    @Override
    public List<Operation> listA() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean checkData() {
        if (txtCode.getText().length() == 0) {
            lbError.setText("Enter code operation !");
            return false;
        }
        if (txtMoneyTotal.getText().length() == 0) {
            lbError.setText("Enter money total operation !");
            return false;
        }
        if (txtMoneyAfterDiscount.getText().length() == 0) {
            lbError.setText("Enter money after discount operation !");
            return false;
        }
        if (cbEnterprise.getSelectedItem() == null) {
            lbError.setText("Choose enterprise !");
            return false;
        }
        if (dcDateExecute.getDate() == null) {
            lbError.setText("Choose date execute !");
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
    public boolean resetData() {
        txtCode.setText("");
        txtMoneyAfterDiscount.setText("");
        txtMoneyTotal.setText("");
        txtMoneyAfterTax.setText("");
        cbEnterprise.setSelectedIndex(0);
        cbUnitMoney.setSelectedIndex(0);
        rbSale.setSelected(true);
        return true;
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
    public List<Operation> listCombo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setDataShow(Operation ob) {
        provider.setDataView(ob);
        refreshData();
    }

    @Override
    public void refreshData() {
        lbTitle.setText("Update Operation");
        txtCode.setText(provider.getDataView().getCodeOperation());
        txtMoneyTotal.setText(String.valueOf(provider.getDataView().getMoneyTotal()));
        txtMoneyAfterTax.setText(String.valueOf(provider.getDataView().getMoneyAfterTax()));
        txtMoneyAfterDiscount.setText(String.valueOf(provider.getDataView().getMoneyAfterDiscount()));
        dcDateExecute.setDate(provider.getDataView().getDateExecute());
        //set combobox enrterprise
        long idEnter = provider.getDataView().getIdEnterprise();
        if (idEnter != 0) {
            for (int i = 0; i < cbEnterprise.getItemCount();) {
                Enterprise enter = ((Enterprise) cbEnterprise.getItemAt(i));
                if (enter != null && enter.getId() == idEnter) {
                    cbEnterprise.setSelectedIndex(i);
                    break;
                } else {
                    i++;
                }
            }
        }
        //set combobox department
        long idDepart = provider.getDataView().getIdDepartment();
        if (idDepart != 0) {
            for (int i = 0; i < cbDepartment.getItemCount();) {
                Department depart = ((Department) cbDepartment.getItemAt(i));
                if (depart != null && depart.getId() == idDepart) {
                    cbDepartment.setSelectedIndex(i);
                    break;
                } else {
                    i++;
                }
            }
        }
        //set combobox employee
        long idEmp = provider.getDataView().getIdEmployee();
        if (idEmp != 0) {
            for (int i = 0; i < cbEmployee.getItemCount();) {
                Employee emp = ((Employee) cbEmployee.getItemAt(i));
                if (emp != null && emp.getId() == idEmp) {
                    cbEmployee.setSelectedIndex(i);
                    break;
                } else {
                    i++;
                }
            }
        }
        //set combobox project
        long idPro = provider.getDataView().getIdProject();
        for (int i = 0; i < cbProject.getItemCount();) {
            Project pro = ((Project) cbProject.getItemAt(i));
            if (pro != null && pro.getId() == idPro) {
                cbProject.setSelectedIndex(i);
                break;
            } else {
                i++;
            }
        }
        controlGeneral.refresh(this);
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

    private void loadDepartment() {
        if (enterpriseID > 0) {
            List<Department> departments = provider.getListDepartmentByIDEnt(enterpriseID);
            cbDepartment.setModel(new DefaultComboBoxModel(departments.toArray()));
        } else {
            cbDepartment.enable(false);
        }
    }

    private void loadCBEnterprise() {
        Enterprise e = (Enterprise) cbEnterprise.getSelectedItem();
        if (e != null) {
            if (e.getId() > 0) {
                cbProject.setEnabled(true);
                cbDepartment.setEnabled(true);
                enterpriseID = e.getId();
                loadDepartment();
                loadProject();
                loadCBDepartment();
                loadCBProject();
            } else {
                enterpriseID = 0;
            }
        } else {
            cbProject.setEnabled(false);
            cbDepartment.setEnabled(false);
            cbEmployee.setEnabled(false);
        }
    }

    private void loadCBDepartment() {
        int index = cbEnterprise.getSelectedIndex();
        if (index > 0) {
            Department d = (Department) cbDepartment.getSelectedItem();
            if (d != null) {
                if (d.getId() > 0) {
                    cbEmployee.setEnabled(true);
                    departmentID = d.getId();
                    loadEmployee();
                    loadCBEmployee();
                } else {
                    departmentID = 0;
                }
            } else {
                cbEmployee.setEnabled(false);
                departmentID = 0;
            }
        } else {
            departmentID = 0;
        }
    }

    private void loadUnitMoney() {
        List<UnitMoney> unitMoneys = provider.getListUnitMoney();
        if (unitMoneys != null) {
            cbUnitMoney.setModel(new DefaultComboBoxModel(unitMoneys.toArray()));
            loadCBUnitMoney();
        } else {
            lbError.setText("No unit money");
        }
    }

    private void loadCBUnitMoney() {
        UnitMoney u = (UnitMoney) cbUnitMoney.getSelectedItem();
        if (u != null) {
            if (u.getId() > 0) {
                unitMoneyID = u.getId();
            } else {
                unitMoneyID = 0;
            }
        }
    }

    private void loadEmployee() {
        if (departmentID > 0) {
            List<Employee> employees = provider.getListEmployeeByIDDep(departmentID);
            cbEmployee.setModel(new DefaultComboBoxModel(employees.toArray()));
        } else {
            cbEmployee.enable(false);
        }
    }

    private void loadCBEmployee() {
        int index = cbDepartment.getSelectedIndex();
        if (index > 0) {
            Employee e = (Employee) cbEmployee.getSelectedItem();
            if (e != null) {
                if (e.getId() > 0) {
                    employeeID = e.getId();
                } else {
                    employeeID = 0;
                }
            } else {
                employeeID = 0;
            }
        } else {
            employeeID = 0;
        }
    }

    private void loadProject() {
        if (enterpriseID > 0) {
            List<Project> projects = provider.getListProjectByIDEnt(enterpriseID);
            cbProject.setModel(new DefaultComboBoxModel(projects.toArray()));
        } else {
            cbProject.enable(false);
        }
    }

    private void loadCBProject() {
        int index = cbEnterprise.getSelectedIndex();
        if (index > 0) {
            Project p = (Project) cbProject.getSelectedItem();
            if (p != null) {
                if (p.getId() > 0) {
                    projectID = p.getId();
                } else {
                    projectID = 0;
                }
            } else {
                projectID = 0;
            }
        } else {
            projectID = 0;
        }
    }

    private boolean getData() {
        provider.getDataView().setIdEnterprise(enterpriseID);
        provider.getDataView().setCodeOperation(txtCode.getText());
        provider.getDataView().setIdDepartment(departmentID);
        provider.getDataView().setIdEmployee(employeeID);
        provider.getDataView().setIdProject(projectID);
        provider.getDataView().setIdUnitMoney(unitMoneyID);
        provider.getDataView().setMoneyTotal(Float.parseFloat(txtMoneyTotal.getText()));
        provider.getDataView().setMoneyAfterTax(Float.parseFloat(txtMoneyAfterTax.getText()));
        provider.getDataView().setMoneyAfterDiscount(Float.parseFloat(txtMoneyAfterDiscount.getText()));
        provider.getDataView().setDateExecute(dcDateExecute.getDate());
        boolean classification = false;
        if (rbSale.isSelected()) {
            classification = true;
        }
        provider.getDataView().setClassification(classification);
        return true;
    }
}
