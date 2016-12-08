/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.gui.windows.elements.data.tab_elements;

import pl.wicia.projector.database.entities.description.DescriptionEntity;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class DescriptionTableRow {

    private long id;
    private boolean selected;
    private String name;
    private String desc;

    public DescriptionTableRow(boolean selected, String name, String desc) {
        this.selected = selected;
        this.name = name;
        this.desc = desc;
    }

    public DescriptionTableRow(DescriptionEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.desc = entity.getText();
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
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
}
