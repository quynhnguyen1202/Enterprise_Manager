/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IControlPanel.java
 *
 * Created on Mar 13, 2013, 3:19:50 PM
 */
package vn.com.hkt.gui.control;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import vn.com.hkt.gui.control.api.IControlPanel;
import vn.com.hkt.gui.panel.spi.AddNewProduct;
import vn.com.hkt.gui.entity.api.IShowPanel;

/**
 *
 * @author Administrator
 */
public class ControlPanel extends javax.swing.JPanel implements IControlPanel {
    private IShowPanel showPanel;
    /** Creates new form IControlPanel */
    public ControlPanel() {
        initComponents();
        btnEdit.setVisible(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdd = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        btnEdit = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        btnAdd.setBackground(new java.awt.Color(153, 153, 153));
        btnAdd.setIcon(new javax.swing.ImageIcon("D:\\HKT\\HKT_Team_Project\\Enterprise_Manager\\EnterpriseManagement\\src\\vn\\com\\hkt\\gui\\icon\\smallicon\\24x24\\add.png")); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(153, 153, 153));
        jButton5.setIcon(new javax.swing.ImageIcon("D:\\HKT\\HKT_Team_Project\\Enterprise_Manager\\EnterpriseManagement\\src\\vn\\com\\hkt\\gui\\icon\\smallicon\\24x24\\refresh.png")); // NOI18N
        jButton5.setText("Refresh");

        jButton4.setBackground(new java.awt.Color(153, 153, 153));
        jButton4.setIcon(new javax.swing.ImageIcon("D:\\HKT\\HKT_Team_Project\\Enterprise_Manager\\EnterpriseManagement\\src\\vn\\com\\hkt\\gui\\icon\\smallicon\\24x24\\warning.png")); // NOI18N
        jButton4.setText("Cancel");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        btnEdit.setBackground(new java.awt.Color(153, 153, 153));
        btnEdit.setIcon(new javax.swing.ImageIcon("D:\\HKT\\HKT_Team_Project\\Enterprise_Manager\\EnterpriseManagement\\src\\vn\\com\\hkt\\gui\\icon\\smallicon\\24x24\\edit.png")); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );
    }// </editor-fold>//GEN-END:initComponents

private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        addData();
}//GEN-LAST:event_btnAddActionPerformed

private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
    editData();
}//GEN-LAST:event_btnEditActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setShowPanel(IShowPanel p) {
        this.showPanel= p;
    }

    @Override
    public void addData() {
         if(showPanel!=null){
            if(showPanel.addData()>0){
                JOptionPane.showMessageDialog(null, "Add new data successfully !"); 
            }else{
                JOptionPane.showMessageDialog(null, "Error!");
            }
        }
    }

    @Override
    public void editData() {
        if(showPanel!=null){
            if(showPanel.editData()==true){
                JOptionPane.showMessageDialog(null, "Update data successfully !");
            }else{ 
                JOptionPane.showMessageDialog(null, "Error!");
            }
        }
    }

    @Override
    public void deleteData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void showData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void showDefault() {
        if(showPanel!=null){
            jScrollPane1.setViewportView((JPanel)showPanel);
        }
    }

    @Override
    public void refresh(IShowPanel panel) {
        jScrollPane1.setViewportView((JPanel)panel);
        btnEdit.setVisible(true);
        btnAdd.setVisible(false);
    }

    
}
