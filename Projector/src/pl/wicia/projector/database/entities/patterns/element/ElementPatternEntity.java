/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.database.entities.patterns.element;

import java.util.HashSet;
import java.util.Set;
import pl.wicia.projector.database.entities.patterns.props.PropPatternEntity;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class ElementPatternEntity implements java.io.Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private long id;
    private String name; 
    private String necessary; 
    
    // Relations fields
    private Set<PropPatternEntity> props = new HashSet<>(0);
    
    public ElementPatternEntity() {
    }

    public ElementPatternEntity(String name, String necessary){
        this.name = name;
        this.necessary = necessary;
    }
    
    public ElementPatternEntity(int id, String name, String necessary) {
        this(name, necessary);
        this.id = id;
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
    
    public String getNecessary() {
        return necessary;
    }

    public void setNecessary(String necessary) {
        this.necessary = necessary;
    }

    public Set<PropPatternEntity> getProps() {
        return props;
    }

    public void setProps(Set<PropPatternEntity> props) {
        this.props = props;
    }
}