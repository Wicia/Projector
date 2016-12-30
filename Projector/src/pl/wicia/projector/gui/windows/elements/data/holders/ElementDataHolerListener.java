/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.wicia.projector.gui.windows.elements.data.holders;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import pl.wicia.projector.gui.windows.elements.WindowElement;

/**
 * Listener for data changing in Window Element.
 * 
 * @author Michał 'Wicia' Wietecha
 */
public class ElementDataHolerListener implements PropertyChangeListener {

    private ElementDataHolder holder;

    public ElementDataHolerListener(ElementDataHolder holder) {
        this.holder = holder;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String propertyName = evt.getPropertyName();
        if(propertyName == null || propertyName.isEmpty())
            return;
        if(propertyName.equals("patternID")){
            this.onPatternIDChange(evt);
        }
    }
    
    private void onPatternIDChange(PropertyChangeEvent evt){
        WindowElement frame = this.holder.getFrame();
        frame.onPatternIDChange((long) evt.getNewValue());
    }
}
