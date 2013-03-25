/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelShowListProduct.java
 *
 * Created on Mar 19, 2013, 9:29:42 AM
 */
package vn.com.hkt.gui.panel.spi;

import java.util.List;
import javax.swing.JOptionPane;
import vn.com.hkt.data.entity.Product;
import vn.com.hkt.gui.basic.Home;
import vn.com.hkt.gui.basic.api.IHomePanel;
import vn.com.hkt.gui.control.ControlPanel;
import vn.com.hkt.gui.control.api.IControlPanel;
import vn.com.hkt.gui.control.api.IPanelControlGeneral;
import vn.com.hkt.gui.entity.api.IPanelShowList;
import vn.com.hkt.gui.entity.api.IShowPanel;
import vn.com.hkt.gui.panel.model.spi.TableModelProduct;
import vn.com.hkt.provider.api.IProviderPanelShowListProduct;
import vn.com.hkt.provider.spi.ProviderPanelShowListProduct;

/**
 *
 * @author Administrator
 */
public class PanelShowListProduct extends javax.swing.JPanel implements  IPanelShowList{
    private IProviderPanelShowListProduct provider;
    private IPanelControlGeneral controlGeneral;
    /** Creates new form PanelShowListProduct */
    public PanelShowListProduct() {
        initComponents();
        provider = new ProviderPanelShowListProduct();
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
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProduct = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.gray));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Search");

        jButton1.setIcon(new javax.swing.ImageIcon("D:\\HKT\\HKT_Team_Project\\Enterprise_Manager\\EnterpriseManagement\\src\\vn\\com\\hkt\\gui\\icon\\smallicon\\24x24\\zoom.png")); // NOI18N

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 12));

        tbProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Department", "Enterprise"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbProduct);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addGap(110, 110, 110)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

private void tbProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductMouseClicked
    if (tbProduct.getSelectedRow() < 0) {
        return;
    }
    if (evt.getClickCount() < 2) {
        return;
    }
    try {
        String id = tbProduct.getValueAt(tbProduct.getSelectedRow(), 0).toString();
        Product e = provider.getByIdProduct(Long.parseLong(id));
        if (e != null) {
            IShowPanel p = new AddNewProduct();
            IControlPanel controlPanel = new ControlPanel();
            controlPanel.setShowPanel(p);
            p.setControlShow(controlPanel);
            p.setDataShow(e);
            IHomePanel homePanel = new Home();
            controlPanel.refresh(p);
            homePanel.setPanelControl(controlPanel);
            homePanel.showDefaut();
            homePanel.setVisible(true);
        }
    } catch (Exception e) {
        JOptionPane.showConfirmDialog(this, e);
    }
}//GEN-LAST:event_tbProductMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tbProduct;
    // End of variables declaration//GEN-END:variables

    @Override
    public void showDefault() {
        loadTable();
    }

    private void loadTable() {
        List<Product> departments=provider.getListInformation();
        tbProduct.setModel(new TableModelProduct(departments));
    }

    @Override
    public void setPanelControShow(IPanelControlGeneral controlGeneral) {
        this.controlGeneral=controlGeneral;
    }
}
