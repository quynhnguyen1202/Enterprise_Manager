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

import java.awt.Toolkit;
import javax.swing.JPanel;
import vn.com.hkt.dao.spi.EntityManageFactoryTest;
import vn.com.hkt.gui.basic.api.IHomePanel;
import vn.com.hkt.gui.control.ControlPanel;
import vn.com.hkt.gui.control.PanelControlShowList;
import vn.com.hkt.gui.control.api.IControlPanel;
import vn.com.hkt.gui.control.api.IPanelControlGeneral;
import vn.com.hkt.gui.control.api.IPanelControlList;
import vn.com.hkt.gui.panel.spi.AddNewProduct;
import vn.com.hkt.gui.entity.api.IShowPanel;
import vn.com.hkt.gui.panel.spi.AddNewDepartment;
import vn.com.hkt.gui.panel.spi.AddNewEmployee;
import vn.com.hkt.gui.panel.spi.AddNewEnterprise;
import vn.com.hkt.gui.panel.spi.AddNewProductGroup;
import vn.com.hkt.gui.panel.spi.AddNewProject;
import vn.com.hkt.gui.panel.spi.AddNewUnitMoney;
import vn.com.hkt.gui.panel.spi.AddNewUnitProduct;
import vn.com.hkt.gui.panel.spi.PanelShowAllParentEnterprise;
import vn.com.hkt.gui.panel.spi.PanelShowListDepartment;
import vn.com.hkt.gui.panel.spi.PanelShowListEmployee;
import vn.com.hkt.gui.panel.spi.PanelShowListEnterprise;
import vn.com.hkt.gui.panel.spi.PanelShowListOperation;
import vn.com.hkt.gui.panel.spi.PanelShowListProduct;
import vn.com.hkt.gui.panel.spi.PanelShowListProductGroup;
import vn.com.hkt.gui.panel.spi.PanelShowListProject;
import vn.com.hkt.gui.panel.spi.PanelShowListUnitMoney;
import vn.com.hkt.gui.panel.spi.PanelShowListUnitProduct;

/**
 *
 * @author Administrator
 */
public class Home extends javax.swing.JFrame implements IHomePanel {

    private IPanelControlGeneral controlGeneral;

    /** Creates new form Home */
    public Home() {
        initComponents();
        EntityManageFactoryTest.getInstance().getEmf().createEntityManager();
        System.out.println("Finished!");

        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());
        int ySize = ((int) tk.getScreenSize().getHeight());
        this.setSize(xSize, ySize - 50);
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
        btnAddDepartment = new javax.swing.JButton();
        btnAddProductGroup = new javax.swing.JButton();
        btnAddProduct = new javax.swing.JButton();
        btnAddEmployee = new javax.swing.JButton();
        btnAddOperation = new javax.swing.JButton();
        btnAddProject = new javax.swing.JButton();
        btnAddEnterprise = new javax.swing.JButton();
        btnUnitProduct = new javax.swing.JButton();
        btnUnitMoney = new javax.swing.JButton();
        btnAddUnitProduct = new javax.swing.JButton();
        btnAddUnitMoney = new javax.swing.JButton();
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
        btnDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepartmentActionPerformed(evt);
            }
        });

        btnProductGroup.setBackground(new java.awt.Color(153, 153, 153));
        btnProductGroup.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnProductGroup.setForeground(new java.awt.Color(51, 51, 51));
        btnProductGroup.setText("Product Group  ");
        btnProductGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductGroupActionPerformed(evt);
            }
        });

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
        btnOperation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperationActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(153, 153, 153));
        btnExit.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnExit.setForeground(new java.awt.Color(51, 51, 51));
        btnExit.setIcon(new javax.swing.ImageIcon("D:\\HKT\\HKT_Team_Project\\Enterprise_Manager\\EnterpriseManagement\\src\\vn\\com\\hkt\\gui\\icon\\32x32\\warning.png")); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnAddDepartment.setBackground(new java.awt.Color(102, 102, 102));
        btnAddDepartment.setIcon(new javax.swing.ImageIcon("D:\\HKT\\HKT_Team_Project\\Enterprise_Manager\\EnterpriseManagement\\src\\vn\\com\\hkt\\gui\\icon\\32x32\\add.png")); // NOI18N
        btnAddDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDepartmentActionPerformed(evt);
            }
        });

        btnAddProductGroup.setBackground(new java.awt.Color(102, 102, 102));
        btnAddProductGroup.setIcon(new javax.swing.ImageIcon("D:\\HKT\\HKT_Team_Project\\Enterprise_Manager\\EnterpriseManagement\\src\\vn\\com\\hkt\\gui\\icon\\32x32\\add.png")); // NOI18N
        btnAddProductGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductGroupActionPerformed(evt);
            }
        });

        btnAddProduct.setBackground(new java.awt.Color(102, 102, 102));
        btnAddProduct.setIcon(new javax.swing.ImageIcon("D:\\HKT\\HKT_Team_Project\\Enterprise_Manager\\EnterpriseManagement\\src\\vn\\com\\hkt\\gui\\icon\\32x32\\add.png")); // NOI18N
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });

        btnAddEmployee.setBackground(new java.awt.Color(102, 102, 102));
        btnAddEmployee.setIcon(new javax.swing.ImageIcon("D:\\HKT\\HKT_Team_Project\\Enterprise_Manager\\EnterpriseManagement\\src\\vn\\com\\hkt\\gui\\icon\\32x32\\add.png")); // NOI18N
        btnAddEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEmployeeActionPerformed(evt);
            }
        });

        btnAddOperation.setBackground(new java.awt.Color(102, 102, 102));
        btnAddOperation.setIcon(new javax.swing.ImageIcon("D:\\HKT\\HKT_Team_Project\\Enterprise_Manager\\EnterpriseManagement\\src\\vn\\com\\hkt\\gui\\icon\\32x32\\add.png")); // NOI18N

        btnAddProject.setBackground(new java.awt.Color(102, 102, 102));
        btnAddProject.setIcon(new javax.swing.ImageIcon("D:\\HKT\\HKT_Team_Project\\Enterprise_Manager\\EnterpriseManagement\\src\\vn\\com\\hkt\\gui\\icon\\32x32\\add.png")); // NOI18N
        btnAddProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProjectActionPerformed(evt);
            }
        });

        btnAddEnterprise.setBackground(new java.awt.Color(102, 102, 102));
        btnAddEnterprise.setIcon(new javax.swing.ImageIcon("D:\\HKT\\HKT_Team_Project\\Enterprise_Manager\\EnterpriseManagement\\src\\vn\\com\\hkt\\gui\\icon\\32x32\\add.png")); // NOI18N
        btnAddEnterprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEnterpriseActionPerformed(evt);
            }
        });

        btnUnitProduct.setBackground(new java.awt.Color(153, 153, 153));
        btnUnitProduct.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnUnitProduct.setForeground(new java.awt.Color(51, 51, 51));
        btnUnitProduct.setText("Unit Product    ");
        btnUnitProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnitProductActionPerformed(evt);
            }
        });

        btnUnitMoney.setBackground(new java.awt.Color(153, 153, 153));
        btnUnitMoney.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnUnitMoney.setForeground(new java.awt.Color(51, 51, 51));
        btnUnitMoney.setText("Money             ");
        btnUnitMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnitMoneyActionPerformed(evt);
            }
        });

        btnAddUnitProduct.setBackground(new java.awt.Color(102, 102, 102));
        btnAddUnitProduct.setIcon(new javax.swing.ImageIcon("D:\\HKT\\HKT_Team_Project\\Enterprise_Manager\\EnterpriseManagement\\src\\vn\\com\\hkt\\gui\\icon\\32x32\\add.png")); // NOI18N
        btnAddUnitProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUnitProductActionPerformed(evt);
            }
        });

        btnAddUnitMoney.setBackground(new java.awt.Color(102, 102, 102));
        btnAddUnitMoney.setIcon(new javax.swing.ImageIcon("D:\\HKT\\HKT_Team_Project\\Enterprise_Manager\\EnterpriseManagement\\src\\vn\\com\\hkt\\gui\\icon\\32x32\\add.png")); // NOI18N
        btnAddUnitMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUnitMoneyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnAddEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnAddDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnProductGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnAddProductGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnAddEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnOperation, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnAddOperation, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnProject, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnAddProject, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnUnitMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnAddUnitMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnUnitProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnAddUnitProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnProductGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddProductGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOperation, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddOperation, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnProject, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddProject, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUnitMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddUnitMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUnitProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddUnitProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeActionPerformed
    IPanelControlList panelControlList = new PanelControlShowList();
    panelControlList.setPanelShowList(new PanelShowListEmployee());
    panelControlList.showDefault();
    controlGeneral = panelControlList;
    setPanelControl(controlGeneral);
    showDefaut();
}//GEN-LAST:event_btnEmployeeActionPerformed

private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
    System.exit(1);
}//GEN-LAST:event_btnExitActionPerformed

private void btnProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductActionPerformed

    IPanelControlList panelControlList = new PanelControlShowList();
    panelControlList.setPanelShowList(new PanelShowListProduct());
    panelControlList.showDefault();
    controlGeneral = panelControlList;
    setPanelControl(controlGeneral);
    showDefaut();
}//GEN-LAST:event_btnProductActionPerformed

private void btnProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProjectActionPerformed
    IPanelControlList panelControlList = new PanelControlShowList();
    panelControlList.setPanelShowList(new PanelShowListProject());
    panelControlList.showDefault();
    controlGeneral = panelControlList;
    setPanelControl(controlGeneral);
    showDefaut();

}//GEN-LAST:event_btnProjectActionPerformed

private void btnEnterpriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterpriseActionPerformed
    IPanelControlList panelControlList = new PanelControlShowList();
    panelControlList.setPanelShowList(new PanelShowListEnterprise());
    panelControlList.showDefault();
    controlGeneral = panelControlList;
    setPanelControl(controlGeneral);
    showDefaut();
}//GEN-LAST:event_btnEnterpriseActionPerformed

private void btnDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepartmentActionPerformed
    IPanelControlList panelControlList = new PanelControlShowList();
    panelControlList.setPanelShowList(new PanelShowListDepartment());
    panelControlList.showDefault();
    controlGeneral = panelControlList;
    setPanelControl(controlGeneral);
    showDefaut();
}//GEN-LAST:event_btnDepartmentActionPerformed

private void btnProductGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductGroupActionPerformed
    IPanelControlList panelControlList = new PanelControlShowList();
    panelControlList.setPanelShowList(new PanelShowListProductGroup());
    panelControlList.showDefault();
    controlGeneral = panelControlList;
    setPanelControl(controlGeneral);
    showDefaut();
}//GEN-LAST:event_btnProductGroupActionPerformed

private void btnOperationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOperationActionPerformed
    IPanelControlList panelControlList = new PanelControlShowList();
    panelControlList.setPanelShowList(new PanelShowListOperation());
    panelControlList.showDefault();
    controlGeneral = panelControlList;
    setPanelControl(controlGeneral);
    showDefaut();
}//GEN-LAST:event_btnOperationActionPerformed

private void btnAddEnterpriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEnterpriseActionPerformed
    IShowPanel anp = new AddNewEnterprise();
    IControlPanel controlPanel = new ControlPanel();
    controlPanel.setShowPanel(anp);
    controlGeneral = controlPanel;
    setPanelControl(controlGeneral);
    showDefaut();
}//GEN-LAST:event_btnAddEnterpriseActionPerformed

private void btnAddDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDepartmentActionPerformed
    IShowPanel anp = new AddNewDepartment();
    IControlPanel controlPanel = new ControlPanel();
    controlPanel.setShowPanel(anp);
    controlGeneral = controlPanel;
    setPanelControl(controlGeneral);
    showDefaut();
}//GEN-LAST:event_btnAddDepartmentActionPerformed

private void btnAddProductGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductGroupActionPerformed
    IShowPanel anp = new AddNewProductGroup();
    IControlPanel controlPanel = new ControlPanel();
    controlPanel.setShowPanel(anp);
    controlGeneral = controlPanel;
    setPanelControl(controlGeneral);
    showDefaut();
}//GEN-LAST:event_btnAddProductGroupActionPerformed

private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
    IShowPanel anp = new AddNewProduct();
    IControlPanel controlPanel = new ControlPanel();
    controlPanel.setShowPanel(anp);
    controlGeneral = controlPanel;
    setPanelControl(controlGeneral);
    showDefaut();
}//GEN-LAST:event_btnAddProductActionPerformed

private void btnAddEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEmployeeActionPerformed
    IShowPanel anp = new AddNewEmployee();
    IControlPanel controlPanel = new ControlPanel();
    controlPanel.setShowPanel(anp);
    controlGeneral = controlPanel;
    setPanelControl(controlGeneral);
    showDefaut();
}//GEN-LAST:event_btnAddEmployeeActionPerformed

private void btnAddProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProjectActionPerformed
    IShowPanel anp = new AddNewProject();
    IControlPanel controlPanel = new ControlPanel();
    controlPanel.setShowPanel(anp);
    controlGeneral = controlPanel;
    setPanelControl(controlGeneral);
    showDefaut();
}//GEN-LAST:event_btnAddProjectActionPerformed

private void btnAddUnitMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUnitMoneyActionPerformed
    IShowPanel anp = new AddNewUnitMoney();
    IControlPanel controlPanel = new ControlPanel();
    controlPanel.setShowPanel(anp);
    controlGeneral = controlPanel;
    setPanelControl(controlGeneral);
    showDefaut();
}//GEN-LAST:event_btnAddUnitMoneyActionPerformed

private void btnAddUnitProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUnitProductActionPerformed
    IShowPanel anp = new AddNewUnitProduct();
    IControlPanel controlPanel = new ControlPanel();
    controlPanel.setShowPanel(anp);
    controlGeneral = controlPanel;
    setPanelControl(controlGeneral);
    showDefaut();
}//GEN-LAST:event_btnAddUnitProductActionPerformed

private void btnUnitMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnitMoneyActionPerformed
    IPanelControlList panelControlList = new PanelControlShowList();
    panelControlList.setPanelShowList(new PanelShowListUnitMoney());
    panelControlList.showDefault();
    controlGeneral = panelControlList;
    setPanelControl(controlGeneral);
    showDefaut();
}//GEN-LAST:event_btnUnitMoneyActionPerformed

private void btnUnitProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnitProductActionPerformed
    IPanelControlList panelControlList = new PanelControlShowList();
    panelControlList.setPanelShowList(new PanelShowListUnitProduct());
    panelControlList.showDefault();
    controlGeneral = panelControlList;
    setPanelControl(controlGeneral);
    showDefaut();
}//GEN-LAST:event_btnUnitProductActionPerformed

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
    private javax.swing.JButton btnAddDepartment;
    private javax.swing.JButton btnAddEmployee;
    private javax.swing.JButton btnAddEnterprise;
    private javax.swing.JButton btnAddOperation;
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnAddProductGroup;
    private javax.swing.JButton btnAddProject;
    private javax.swing.JButton btnAddUnitMoney;
    private javax.swing.JButton btnAddUnitProduct;
    private javax.swing.JButton btnDepartment;
    private javax.swing.JButton btnEmployee;
    private javax.swing.JButton btnEnterprise;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnOperation;
    private javax.swing.JButton btnProduct;
    private javax.swing.JButton btnProductGroup;
    private javax.swing.JButton btnProject;
    private javax.swing.JButton btnUnitMoney;
    private javax.swing.JButton btnUnitProduct;
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
