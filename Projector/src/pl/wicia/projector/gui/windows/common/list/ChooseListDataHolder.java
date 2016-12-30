/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.gui.windows.common.list;

import javax.swing.JFrame;
import pl.wicia.projector.gui.windows.common.listeners.ChangeListener;

/**
 * Data holder for Choose List class.
 * 
 * @author Michał 'Wicia' Wietecha
 */
public final class ChooseListDataHolder {
    
    private Class elementType;
    private JFrame listInvoker; // which window invoked this
    private WindowChooseList baseFrame; // which class uses holder
    
    // Listener
    private ChangeListener listener;
    
    public ChooseListDataHolder(WindowChooseList baseFrame) {
        this.listener = new ChangeListener();
        this.listener.addPropertyListener(new ChooseListListener(this));
        this.setBaseFrame(baseFrame);
    }
    
    public void setListInvoker(JFrame frame) {
        this.listInvoker = frame;
    }

    public JFrame getListInvoker() {
        return this.listInvoker;
    }

    public WindowChooseList getBaseFrame() {
        return this.baseFrame;
    }

    public void setBaseFrame(WindowChooseList baseFrame) {
        this.baseFrame = baseFrame;
    }

    public Class getElementType() {
        return elementType;
    }

    public void setElementType(Class elementType) {
        Class old = this.elementType;
        this.elementType = elementType;
        this.listener.firePropertyChanged("type", old, elementType);
    }

    public boolean isElementType(Class aClass) {
        return this.elementType == aClass;
    }
}
