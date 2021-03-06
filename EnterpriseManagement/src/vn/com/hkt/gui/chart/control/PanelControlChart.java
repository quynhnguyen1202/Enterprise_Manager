/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelControlChart.java
 *
 * Created on Mar 27, 2013, 11:06:19 AM
 */
package vn.com.hkt.gui.chart.control;

import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import vn.com.hkt.data.entity.Department;
import vn.com.hkt.data.entity.Employee;
import vn.com.hkt.data.entity.Enterprise;
import vn.com.hkt.data.entity.Project;
import vn.com.hkt.gui.chart.panelshow.api.IPanelShowChart;
import vn.com.hkt.gui.chart.control.api.IPanelControlChart;
import vn.com.hkt.provider.api.IProviderPanelShowChartLine;
import vn.com.hkt.provider.spi.ProviderPanelShowChartLine;

/**
 *
 * @author Administrator
 */
public final class PanelControlChart extends javax.swing.JPanel implements IPanelControlChart {

    private long projectID;
    private long enterpriseID;
    private long departmentID;
    private long employeeID;
    private IPanelShowChart panelShowChart;
    private IProviderPanelShowChartLine provider;

    /** Creates new form PanelControlChart */
    public PanelControlChart() {
        initComponents();
        provider = new ProviderPanelShowChartLine();
        cbChoose.setSelectedIndex(0);
        jPanel1.setVisible(true);
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        loadEnterprise();
        //load date
        cbDateTime.setSelectedItem("Day");


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
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        cbEntEnterprise = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cbEmpEnterprise = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cbEmpDepartment = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        cbEmployee = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        cbDepEnterprise = new javax.swing.JComboBox();
        cbDepDepartment = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbProEnterprise = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cbProDepartment = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cbProject = new javax.swing.JComboBox();
        cbChoose = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        cbType = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        cbDateTime = new javax.swing.JComboBox();
        panelDay = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        dcEndDate = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        dcStartDate = new com.toedter.calendar.JDateChooser();
        lbError = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.gray));
        setPreferredSize(new java.awt.Dimension(980, 480));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.gray));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        cbEntEnterprise.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbEntEnterprise.setOpaque(false);
        cbEntEnterprise.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEntEnterpriseItemStateChanged(evt);
            }
        });

        jLabel9.setText("Choose enterprise :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cbEntEnterprise, 0, 195, Short.MAX_VALUE)
                .addGap(520, 520, 520))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(cbEntEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setText("    Enterprise");

        cbEmpEnterprise.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbEmpEnterprise.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEmpEnterpriseItemStateChanged(evt);
            }
        });

        jLabel7.setText("Department :");

        cbEmpDepartment.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEmpDepartmentItemStateChanged(evt);
            }
        });

        jLabel8.setText("Employee :");

        cbEmployee.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEmployeeItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(cbEmpEnterprise, 0, 99, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(cbEmpDepartment, 0, 98, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(cbEmployee, 0, 98, Short.MAX_VALUE)
                .addGap(220, 220, 220))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(cbEmpEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(cbEmpDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(cbEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        cbDepEnterprise.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDepEnterprise.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDepEnterpriseItemStateChanged(evt);
            }
        });

        cbDepDepartment.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDepDepartmentItemStateChanged(evt);
            }
        });

        jLabel1.setText("Department :");

        jLabel2.setText("   Enterprise :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(cbDepEnterprise, 0, 198, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(cbDepDepartment, 0, 197, Short.MAX_VALUE)
                .addGap(240, 240, 240))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(cbDepEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(cbDepDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("    Enterprise");

        cbProEnterprise.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbProEnterprise.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbProEnterpriseItemStateChanged(evt);
            }
        });

        jLabel4.setText("Department :");

        cbProDepartment.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbProDepartmentItemStateChanged(evt);
            }
        });

        jLabel5.setText("Project :");

        cbProject.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbProjectItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(cbProEnterprise, 0, 99, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(cbProDepartment, 0, 98, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(cbProject, 0, 98, Short.MAX_VALUE)
                .addGap(220, 220, 220))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(cbProEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(cbProDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(cbProject, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        cbChoose.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enterprise", "Department", "Employee", "Project" }));
        cbChoose.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbChooseItemStateChanged(evt);
            }
        });

        jLabel10.setText("   Follow :");

        cbType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Parent", "Subsidiary", "Parent & Subsidiary" }));

        jLabel11.setText("Date time :");

        cbDateTime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Day", "Month", "Year" }));
        cbDateTime.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDateTimeItemStateChanged(evt);
            }
        });

        panelDay.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setText("End date :");

        jLabel13.setText("Start date :");

        javax.swing.GroupLayout panelDayLayout = new javax.swing.GroupLayout(panelDay);
        panelDay.setLayout(panelDayLayout);
        panelDayLayout.setHorizontalGroup(
            panelDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDayLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(dcStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(dcEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelDayLayout.setVerticalGroup(
            panelDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(dcStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(dcEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        lbError.setForeground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(cbChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(cbType, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cbDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(panelDay, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lbError, javax.swing.GroupLayout.PREFERRED_SIZE, 954, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbType, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelDay, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lbError, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void cbEntEnterpriseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEntEnterpriseItemStateChanged
    loadCBEnterprise();
}//GEN-LAST:event_cbEntEnterpriseItemStateChanged

private void cbChooseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbChooseItemStateChanged
    if (cbChoose.getSelectedItem() == "Enterprise") {
        jPanel1.setVisible(true);
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        cbType.setVisible(true);
    }
    if (cbChoose.getSelectedItem() == "Department") {
        jPanel1.setVisible(false);
        jPanel2.setVisible(true);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        loadDepEnterprise();
        cbType.setVisible(true);
    }
    if (cbChoose.getSelectedItem() == "Employee") {
        jPanel1.setVisible(false);
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(true);
        loadEmpEnterprise();
        cbType.setVisible(false);
    }
    if (cbChoose.getSelectedItem() == "Project") {
        jPanel1.setVisible(false);
        jPanel2.setVisible(false);
        jPanel3.setVisible(true);
        jPanel4.setVisible(false);
        loadProEnterprise();
        loadProject();
        cbType.setVisible(false);
    }
}//GEN-LAST:event_cbChooseItemStateChanged

private void cbDepEnterpriseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDepEnterpriseItemStateChanged
    loadCBDepEnterprise();
}//GEN-LAST:event_cbDepEnterpriseItemStateChanged

private void cbDepDepartmentItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDepDepartmentItemStateChanged
    loadCBDepDepartment();
}//GEN-LAST:event_cbDepDepartmentItemStateChanged

private void cbEmpEnterpriseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEmpEnterpriseItemStateChanged
    loadCBEmpEnterprise();
}//GEN-LAST:event_cbEmpEnterpriseItemStateChanged

private void cbEmpDepartmentItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEmpDepartmentItemStateChanged
    loadCBEmpDepartment();
}//GEN-LAST:event_cbEmpDepartmentItemStateChanged

private void cbEmployeeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEmployeeItemStateChanged
    loadCBEmployee();
}//GEN-LAST:event_cbEmployeeItemStateChanged

private void cbProEnterpriseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbProEnterpriseItemStateChanged
    loadCBProEnterprise();
}//GEN-LAST:event_cbProEnterpriseItemStateChanged

private void cbProDepartmentItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbProDepartmentItemStateChanged
    loadCBProDepartment();
}//GEN-LAST:event_cbProDepartmentItemStateChanged

private void cbProjectItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbProjectItemStateChanged
    loadCBProject();
}//GEN-LAST:event_cbProjectItemStateChanged

private void cbDateTimeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDateTimeItemStateChanged
}//GEN-LAST:event_cbDateTimeItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbChoose;
    private javax.swing.JComboBox cbDateTime;
    private javax.swing.JComboBox cbDepDepartment;
    private javax.swing.JComboBox cbDepEnterprise;
    private javax.swing.JComboBox cbEmpDepartment;
    private javax.swing.JComboBox cbEmpEnterprise;
    private javax.swing.JComboBox cbEmployee;
    private javax.swing.JComboBox cbEntEnterprise;
    private javax.swing.JComboBox cbProDepartment;
    private javax.swing.JComboBox cbProEnterprise;
    private javax.swing.JComboBox cbProject;
    private javax.swing.JComboBox cbType;
    private com.toedter.calendar.JDateChooser dcEndDate;
    private com.toedter.calendar.JDateChooser dcStartDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbError;
    private javax.swing.JPanel panelDay;
    // End of variables declaration//GEN-END:variables

    @Override
    public void showDefault() {
        if (panelShowChart != null) {
            jScrollPane1.setViewportView((JPanel) panelShowChart);
        }
    }

    @Override
    public void setPanelShow(IPanelShowChart panelChart) {
        this.panelShowChart = panelChart;
    }

    @Override
    public void loadEnterprise() {
        List<Enterprise> enterprises = provider.getListEnterprise();
        if (enterprises != null) {
            cbEntEnterprise.setModel(new DefaultComboBoxModel(enterprises.toArray()));
            loadCBEnterprise();
        } else {
            enterpriseID = 0;
        }
    }

    @Override
    public void loadDepartment() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void loadProject() {
        List<Project> projects = provider.getListProject();
        if (projects != null) {
            cbProject.setModel(new DefaultComboBoxModel(projects.toArray()));
            loadCBProject();
        } else {
            enterpriseID = 0;
        }
    }

    @Override
    public void loadEmployee() {
        if (departmentID > 0) {
            List<Employee> employees = provider.getListEmployeeByIdDep(departmentID);
            cbEmployee.setModel(new DefaultComboBoxModel(employees.toArray()));
        } else {
            cbEmployee.enable(false);
        }
    }

    private void loadCBEnterprise() {
        Enterprise e = (Enterprise) cbEntEnterprise.getSelectedItem();
        if (e != null) {
            if (e.getId() > 0) {
                enterpriseID = e.getId();
            } else {
                enterpriseID = 0;
            }
        }
    }

    private void loadDepEnterprise() {
        List<Enterprise> enterprises = provider.getListEnterprise();
        if (enterprises != null) {
            cbDepEnterprise.setModel(new DefaultComboBoxModel(enterprises.toArray()));
            loadCBDepEnterprise();
        } else {
            enterpriseID = 0;
        }
    }

    private void loadCBDepEnterprise() {
        Enterprise e = (Enterprise) cbDepEnterprise.getSelectedItem();
        if (e != null) {
            if (e.getId() > 0) {
                cbDepDepartment.setEnabled(true);
                enterpriseID = e.getId();
                loadDepDepartment();
                loadCBDepDepartment();
            } else {
                enterpriseID = 0;
            }
        } else {
            cbDepDepartment.setEnabled(false);
        }
    }

    private void loadDepDepartment() {
        if (enterpriseID > 0) {
            List<Department> departments = provider.getListDepartmentByIdEnt(enterpriseID);
            cbDepDepartment.setModel(new DefaultComboBoxModel(departments.toArray()));
        } else {
            cbDepDepartment.enable(false);
        }
    }

    private void loadCBDepDepartment() {
        int index = cbDepEnterprise.getSelectedIndex();
        if (index > 0) {
            Department d = (Department) cbDepDepartment.getSelectedItem();
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

    private void loadEmpEnterprise() {
        List<Enterprise> enterprises = provider.getListEnterprise();
        if (enterprises != null) {
            cbEmpEnterprise.setModel(new DefaultComboBoxModel(enterprises.toArray()));
            loadCBEmpEnterprise();
        }
    }

    private void loadCBEmpEnterprise() {
        Enterprise e = (Enterprise) cbEmpEnterprise.getSelectedItem();
        if (e != null) {
            if (e.getId() > 0) {
                cbEmpDepartment.setEnabled(true);
                enterpriseID = e.getId();
                loadEmpDepartment();
                loadEmployee();
                loadCBEmpDepartment();
            } else {
                enterpriseID = 0;
            }
        } else {
            cbEmpDepartment.setEnabled(false);
            cbEmployee.setEnabled(false);
        }
    }

    private void loadEmpDepartment() {
        if (enterpriseID > 0) {
            List<Department> departments = provider.getListDepartmentByIdEnt(enterpriseID);
            cbEmpDepartment.setModel(new DefaultComboBoxModel(departments.toArray()));
        } else {
            cbEmpDepartment.enable(false);
        }
    }

    private void loadCBEmpDepartment() {
        int index = cbEmpEnterprise.getSelectedIndex();
        if (index > 0) {
            Department d = (Department) cbEmpDepartment.getSelectedItem();
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

    private void loadCBEmployee() {
        int index = cbEmpDepartment.getSelectedIndex();
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

    private void loadProEnterprise() {
        List<Enterprise> enterprises = provider.getListEnterprise();
        if (enterprises != null) {
            cbProEnterprise.setModel(new DefaultComboBoxModel(enterprises.toArray()));
            loadCBProEnterprise();
        }
    }

    private void loadCBProEnterprise() {
        Enterprise e = (Enterprise) cbProEnterprise.getSelectedItem();
        if (e != null) {
            if (e.getId() > 0) {
                cbProDepartment.setEnabled(true);
                enterpriseID = e.getId();
                loadProDepartment();
                loadProjectByidEnt();
                loadCBProDepartment();
                loadCBProject();
            } else {
                cbProDepartment.setEnabled(false);
                enterpriseID = 0;
            }
        } else {
            cbProDepartment.setEnabled(false);
        }
    }

    private void loadProDepartment() {
        if (enterpriseID > 0) {
            List<Department> departments = provider.getListDepartmentByIdEnt(enterpriseID);
            cbProDepartment.setModel(new DefaultComboBoxModel(departments.toArray()));
        } else {
            JOptionPane.showMessageDialog(null, "Not found department");
        }
    }

    private void loadCBProDepartment() {
        int index = cbProEnterprise.getSelectedIndex();
        if (index > 0) {
            Department d = (Department) cbProDepartment.getSelectedItem();
            if (d != null) {
                if (d.getId() > 0) {
                    departmentID = d.getId();
                    loadProjectByIdDep();
                    loadCBProject();
                } else {
                    departmentID = 0;
                }
            } else {
                departmentID = 0;
            }
        } else {
            cbProDepartment.setEnabled(false);
            departmentID = 0;
        }
    }

    private void loadCBProject() {
        Project e = (Project) cbProject.getSelectedItem();
        if (e != null) {
            if (e.getId() > 0) {
                projectID = e.getId();
            } else {
                projectID = 0;
            }
        } else {
            projectID = 0;
        }
    }

    private void loadProjectByidEnt() {
        if (enterpriseID > 0) {
            List<Project> projects = provider.getListProjectIdEnt(enterpriseID);
            cbProject.setModel(new DefaultComboBoxModel(projects.toArray()));
        }
    }

    private void loadProjectByIdDep() {
        if (departmentID > 0) {
            List<Project> projects = provider.getListProjectByIdDep(departmentID);
            cbProject.setModel(new DefaultComboBoxModel(projects.toArray()));
        }
    }

    private void getData() {
        if (cbChoose.getSelectedItem() == "Enterprise") {
            Enterprise e = (Enterprise) cbEntEnterprise.getSelectedItem();
        }
    }

    @Override
    public void viewData() {
        lbError.setText("");
        if (checkChart()) {
            //get object
            if (cbChoose.getSelectedItem().toString().equals("Enterprise")) {
                panelShowChart.setObjectView(getEntEnterprise());
            } else if (cbChoose.getSelectedItem().toString().equals("Department")) {
                panelShowChart.setObjectView(getDepartment());
            } else if (cbChoose.getSelectedItem().toString().equals("Project")) {
                panelShowChart.setObjectView(getProject());
            } else {
                panelShowChart.setObjectView(getEmployee());
            }
            //get type view
            if (cbType.getSelectedItem().toString().equals("Parent")) {
                panelShowChart.setTypeView(1);
            } else if (cbType.getSelectedItem().toString().equals("Subsidiary")) {
                panelShowChart.setTypeView(3);
            } else {
                panelShowChart.setTypeView(2);
            }
            //get type time
            int typeTime = 0;
            if (cbDateTime.getSelectedItem().toString().equals("Day")) {
                typeTime = 1;
            } else if (cbDateTime.getSelectedItem().toString().equals("Month")) {
                typeTime = 2;
            } else if (cbDateTime.getSelectedItem().toString().equals("Year")) {
                typeTime = 3;
            }
            panelShowChart.setTypeDate(typeTime);
            //start date - end date

            panelShowChart.setStartDate(dcStartDate.getDate());
            panelShowChart.setEndDate(dcEndDate.getDate());
            if (panelShowChart != null) {
                panelShowChart.viewData();
            }
        }else{
            return;
        }
    }

    private Enterprise getEntEnterprise() {
        Enterprise e = (Enterprise) cbEntEnterprise.getSelectedItem();
        if (e != null) {
            return e;
        }
        return null;
    }

    private Object getDepartment() {
        Department d = (Department) cbDepDepartment.getSelectedItem();
        Enterprise ent = (Enterprise) cbDepEnterprise.getSelectedItem();
        if (d != null) {
            return d;
        }
        if (ent != null) {
            return ent;
        } else {
            lbError.setText("Choose enterprise !");
        }
        return null;
    }

    private Object getProject() {
        Project p = (Project) cbProject.getSelectedItem();
        Department d = (Department) cbProDepartment.getSelectedItem();
        Enterprise ent = (Enterprise) cbProEnterprise.getSelectedItem();
        if (p != null) {
            System.out.println("aaaaaaaaaaa : "+p);
            return p;
        }
        if (d != null) {
            System.out.println("aaaaaaaaaaab : "+d);
            return d;
        }
        if (ent != null) {
            return ent;
        }
        return null;
    }

    private Object getEmployee() {
        Employee e = (Employee) cbEmployee.getSelectedItem();
        Department d = (Department) cbEmpDepartment.getSelectedItem();
        Enterprise ent = (Enterprise) cbEmpEnterprise.getSelectedItem();
        if (e != null) {
            return e;
        }
        if (d != null) {
            return d;
        }
        if (ent != null) {
            return ent;
        }
        return null;
    }

    private boolean checkChart() {
        try {
            Date date1 = dcStartDate.getDate();
            Date date2 = dcEndDate.getDate();
        } catch (Exception e) {
            lbError.setText("Date format !");
            return false;
        }
        if (dcStartDate.getDate() == null) {
            lbError.setText("Choose start date !");
            return false;
        }
        if (dcEndDate.getDate() == null) {
            lbError.setText("Choose end date !");
            return false;
        }

        return true;
    }
}
