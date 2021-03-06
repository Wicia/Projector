/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.database.entities.patterns.props;

import pl.wicia.projector.database.entities.INameableEntity;
import pl.wicia.projector.database.entities.patterns.element.ElementPatternEntity;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class PropPatternEntity 
        implements java.io.Serializable, INameableEntity<Long>{

    private static final long serialVersionUID = 1L;

    private long id;
    private ElementPatternEntity elementPattern;
    private String name;
    private byte count;
    
    public PropPatternEntity(){}

    @Override
    public Long getId() {
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

    public ElementPatternEntity getElementPattern() {
        return elementPattern;
    }

    public void setElementPattern(ElementPatternEntity elementPattern) {
        this.elementPattern = elementPattern;
    }
}
