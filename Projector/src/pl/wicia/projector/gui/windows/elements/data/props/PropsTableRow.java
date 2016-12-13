/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.gui.windows.elements.data.props;

import pl.wicia.projector.database.entities.props.PropEntity;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class PropsTableRow {

    private long id;
    private int count;
    private String desc;

    public PropsTableRow(int count, String desc) {
        this.count = count;
        this.desc = desc;
    }

    public PropsTableRow(PropEntity entity) {
        this.id = entity.getId();
        this.count = entity.getCount();
        this.desc = entity.getName();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
