/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.gui.panel.model.spi;

import javax.swing.JButton;
import vn.com.hkt.data.entity.Enterprise;

/**
 *
 * @author Administrator
 */
public class MyButton extends JButton {
    private  Enterprise en;
    public MyButton() {
    }

    public Enterprise getEn() {
        return en;
    }

    public void setEn(Enterprise en) {
        this.en = en;
    }
    
}
