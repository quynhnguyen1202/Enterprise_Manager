/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.provider.spi;

import vn.com.hkt.data.entity.Operation;
import vn.com.hkt.provider.api.IProviderPanelShowOperation;

/**
 *
 * @author QuynhNguyen
 */
public class ProviderPanelShowOperation extends ProviderGeneral<Operation> implements IProviderPanelShowOperation {

    public ProviderPanelShowOperation() {
        setClassname(Operation.class);
    }

    
}
