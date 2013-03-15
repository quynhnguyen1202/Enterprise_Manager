/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Home.java
 *
 * Created on Mar 14, 2013, 8:43:19 AM
 */
package vn.com.hkt.gui.basic;

import javax.swing.JPanel;
import vn.com.hkt.gui.basic.api.IHomePanel;
import vn.com.hkt.gui.control.ControlPanel;
import vn.com.hkt.gui.control.PanelControlShowList;
import vn.com.hkt.gui.control.api.IControlPanel;
import vn.com.hkt.gui.control.api.IPanelControlGeneral;
import vn.com.hkt.gui.control.api.IPanelControlList;
import vn.com.hkt.gui.entity.AddNewProduct;
import vn.com.hkt.gui.entity.AddNewProject;
import vn.com.hkt.gui.entity.api.IShowPanel;
import vn.com.hkt.gui.panel.spi.PanelShowAllParentEnterprise;
import vn.com.hkt.gui.panel.spi.PanelShowListEmployee;
import vn.com.hkt.gui.panel.spi.PanelShowListEnterprise;
import vn.com.hkt.gui.panel.spi.PanelShowListProduct;

/**
 *
 * @author Administrator
 */
public class Home extends javax.swing.JFrame implements IHomePanel {

    private IPanelControlGeneral controlGeneral;

    /** Creates new form Home */
    public Home() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnProject = new javax.swing.JButton();
        btnEnterprise = new javax.swing.JButton();
        btnDepartment = new javax.swing.JButton();
        btnProductGroup = new javax.swing.JButton();
        btnProduct = new javax.swing.JButton();
        btnEmployee = new javax.swing.JButton();
        btnOperation = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnEnterpiseList = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnProject.setBackground(new java.awt.Color(153, 153, 153));
        btnProject.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnProject.setForeground(new java.awt.Color(51, 51, 51));
        btnProject.setText("Project            ");
        btnProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProjectActionPerformed(evt);
            }
        });

        btnEnterprise.setBackground(new java.awt.Color(153, 153, 153));
        btnEnterprise.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnEnterprise.setForeground(new java.awt.Color(51, 51, 51));
        btnEnterprise.setText("Enterprise         ");
        btnEnterprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterpriseActionPerformed(evt);
            }
        });

        btnDepartment.setBackground(new java.awt.Color(153, 153, 153));
        btnDepartment.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnDepartment.setForeground(new java.awt.Color(51, 51, 51));
        btnDepartment.setText("Department      ");

        btnProductGroup.setBackground(new java.awt.Color(153, 153, 153));
        btnProductGroup.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnProductGroup.setForeground(new java.awt.Color(51, 51, 51));
        btnProductGroup.setText("Product Group  ");

        btnProduct.setBackground(new java.awt.Color(153, 153, 153));
        btnProduct.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnProduct.setForeground(new java.awt.Color(51, 51, 51));
        btnProduct.setText("Product           ");
        btnProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductActionPerformed(evt);
            }
        });

        btnEmployee.setBackground(new java.awt.Color(153, 153, 153));
        btnEmployee.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnEmployee.setForeground(new java.awt.Color(51, 51, 51));
        btnEmployee.setText("Employee         ");
        btnEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeActionPerformed(evt);
            }
        });

        btnOperation.setBackground(new java.awt.Color(153, 153, 153));
        btnOperation.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnOperation.setForeground(new java.awt.Color(51, 51, 51));
        btnOperation.setText("Operation        ");

        btnExit.setBackground(new java.awt.Color(153, 153, 153));
        btnExit.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnExit.setForeground(new java.awt.Color(51, 51, 51));
        btnExit.setText("Exit                  ");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnEnterpiseList.setText("Danh sach DN");
        btnEnterpiseList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterpiseListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnProductGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnOperation, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnProject, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnEnterpiseList, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnProductGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnOperation, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnProject, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEnterpiseList, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        scrollPane.setBackground(new java.awt.Color(255, 255, 255));
        scrollPane.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeActionPerformed
//    if (cp != null) {
//        IShowPanel panel = new PanelShowListEmployee();
//        cp.setShowPanel(panel);
//        cp.showDefault();
//    }
    //        ControlPanel cp=new ControlPanel();
//        AddNewEmployee ane=new AddNewEmployee();
//        cp.setShowPanel(ane);
//        this.setPanelControl(cp);
//        this.showDefaut();
}//GEN-LAST:event_btnEmployeeActionPerformed

private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
    System.exit(1);
}//GEN-LAST:event_btnExitActionPerformed

private void btnProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductActionPerformed
//    if (cp != null) {
//        IShowPanel panel = new PanelShowListProduct();
//        cp.setShowPanel(panel);
//        cp.showDefault();
//    }
    //        ControlPanel cp=new ControlPanel();
//        AddNewProduct adp=new AddNewProduct();
//        cp.setShowPanel(adp);
//        this.setPanelControl(cp);
//        this.showDefaut();
}//GEN-LAST:event_btnProductActionPerformed

private void btnProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProjectActionPerformed
    ControlPanel cp = new ControlPanel();
    AddNewProject anp = new AddNewProject();
    cp.setShowPanel(anp);
    this.setPanelControl(cp);
    this.showDefaut();
}//GEN-LAST:event_btnProjectActionPerformed

private void btnEnterpriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterpriseActionPerformed

    IShowPanel anp = new PanelShowAllParentEnterprise();
    IControlPanel controlPanel = new ControlPanel();    
    controlPanel.setShowPanel(anp);
    controlGeneral = controlPanel;
    setPanelControl(controlGeneral);
    showDefaut();

//    if(cp!=null){
//        IShowPanel panel = new PanelShowInsertEnterprise();
//        cp.setShowPanel(panel);
//        cp.showDefault();
//    }

}//GEN-LAST:event_btnEnterpriseActionPerformed

private void btnEnterpiseListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterpiseListActionPerformed

    IPanelControlList panelControlList = new PanelControlShowList();
    panelControlList.setPanelShowList(new PanelShowListEnterprise());
    panelControlList.showDefault();
    controlGeneral = panelControlList;
    setPanelControl(controlGeneral);
    showDefaut();
    
}//GEN-LAST:event_btnEnterpiseListActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Window".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Home().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDepartment;
    private javax.swing.JButton btnEmployee;
    private javax.swing.JButton btnEnterpiseList;
    private javax.swing.JButton btnEnterprise;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnOperation;
    private javax.swing.JButton btnProduct;
    private javax.swing.JButton btnProductGroup;
    private javax.swing.JButton btnProject;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setPanelControl(IPanelControlGeneral p) {
        this.controlGeneral = p;
    }

    @Override
    public void showDefaut() {
        if (controlGeneral != null) {
            scrollPane.setViewportView((JPanel) controlGeneral);
            controlGeneral.showDefault();
        }
    }
}
