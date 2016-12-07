/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.database.entities.description;

import pl.wicia.projector.database.entities.element.ElementEntity;
import pl.wicia.projector.gui.windows.elements.data.tab_elements.DescriptionTableRow;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class DescriptionEntity implements java.io.Serializable{

    private static final long serialVersionUID = 1L;

    private long id;
    private ElementEntity element;
    private byte position;
    private String name;
    private String text;

    public DescriptionEntity() {
    }

    public DescriptionEntity(long id, ElementEntity element, byte position, 
            String name, String text) {
        this.id = id;
        this.element = element;
        this.position = position;
        this.name = name;
        this.text = text;
    }

    public DescriptionEntity(DescriptionTableRow element, int position) {
        this.text = element.getDesc();
        this.name = element.getName();
        this.position = (byte)position;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte getPosition() {
        return position;
    }

    public void setPosition(byte position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ElementEntity getElement() {
        return element;
    }

    public void setElement(ElementEntity element) {
        this.element = element;
    }
}