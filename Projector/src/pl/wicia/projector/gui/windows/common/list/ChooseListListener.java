/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.gui.windows.common.list;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Listener for {@link ChooseListDataHolder}
 * 
 * @author Michał 'Wicia' Wietecha
 */
public class ChooseListListener implements PropertyChangeListener{

    private ChooseListDataHolder holder;
    
    public ChooseListListener(ChooseListDataHolder holder) {
        this.holder = holder;
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String propertyName = evt.getPropertyName();
        if(propertyName.equals("type")){
            WindowChooseList window = (WindowChooseList)holder.getBaseFrame();
            window.onTableLoad();
        }
    }
}