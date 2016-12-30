/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.wicia.projector.gui.windows.elements.data.holders;

import java.io.Serializable;
import pl.wicia.projector.database.entities.element.ElementEntity;
import pl.wicia.projector.gui.windows.common.listeners.ChangeListener;
import pl.wicia.projector.gui.windows.elements.WindowElement;

/**
 * Class holding data for Element Window.
 *
 * @author Michał 'Wicia' Wietecha
 */
public class ElementDataHolder 
        implements Serializable {

    private WindowElement frame;
    private ElementEntity choosenElement;
    private long choosenPatternID;
    
    // Listener
    private ChangeListener listener;

    public ElementDataHolder() {
        this.listener = new ChangeListener();
        this.listener.addPropertyListener(new ElementDataHolerListener(this));
    }

    public ElementDataHolder(WindowElement frame) {
        this();
        this.setFrame(frame);
    }

    public WindowElement getFrame() {
        return frame;
    }

    public void setFrame(WindowElement frame) {
        this.frame = frame;
    }

    public ElementEntity getChoosenElement() {
        return choosenElement;
    }

    public void setChoosenElement(ElementEntity choosenElement) {
        this.choosenElement = choosenElement;
    }

    public long getChoosenPatternID() {
        return choosenPatternID;
    }

    public void setChoosenPatternID(long choosenPatternID) {
        long oldID = this.choosenPatternID;
        this.choosenPatternID = choosenPatternID;
        this.listener.firePropertyChanged("patternID", oldID, choosenPatternID);
    }
}
