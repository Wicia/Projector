/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.database.entities.props;

import pl.wicia.projector.database.entities.element.ElementEntity;
import pl.wicia.projector.database.entities.patterns.element.ElementPatternEntity;
import pl.wicia.projector.gui.windows.elements.data.props.PropsTableRow;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class PropEntity implements java.io.Serializable{

    private static final long serialVersionUID = 1L;

    private long id;
    private ElementEntity element;
    private String name;
    private byte count;
    
    public PropEntity(){}
    
    public PropEntity(PropsTableRow row){
        this.name = row.getDesc();
        this.count = (byte) row.getCount();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getCount() {
        return count;
    }

    public void setCount(byte count) {
        this.count = count;
    }

    public ElementEntity getElement() {
        return element;
    }

    public void setElement(ElementEntity element) {
        this.element = element;
    }
}
