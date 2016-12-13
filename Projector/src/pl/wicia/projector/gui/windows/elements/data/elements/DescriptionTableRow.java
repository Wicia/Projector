/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.gui.windows.elements.data.elements;

import pl.wicia.projector.database.entities.description.DescriptionEntity;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class DescriptionTableRow {

    private long id;
    private String name;
    private String desc;

    public DescriptionTableRow(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public DescriptionTableRow(DescriptionEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.desc = entity.getText();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
