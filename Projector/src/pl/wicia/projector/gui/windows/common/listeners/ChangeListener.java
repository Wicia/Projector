/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.gui.windows.common.listeners;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Change Listener mechanism mainly used in data holders.
 * 
 * @author Michał 'Wicia' Wietecha
 */
public final class ChangeListener {
    
    private final PropertyChangeSupport changer = new PropertyChangeSupport(this);
    
    public void addPropertyListener(PropertyChangeListener listener) {
        this.changer.addPropertyChangeListener(listener);
    }

    public void removePropertyListener(PropertyChangeListener listener) {
        this.changer.removePropertyChangeListener(listener);
    }
    
    public void firePropertyChanged(String propID, Object oldValue, Object newValue){
        this.changer.firePropertyChange(propID, oldValue, newValue);
    }
    
    public PropertyChangeSupport getChanger() {
        return changer;
    }
}