/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.database.entities.patterns.element;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pl.wicia.projector.database.entities.INameableEntity;
import pl.wicia.projector.database.entities.patterns.props.PropPatternEntity;
import pl.wicia.projector.database.entities.workshop.WorkshopEntity;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class ElementPatternEntity 
        implements java.io.Serializable, INameableEntity<Long>{
    
    private static final long serialVersionUID = 1L;

    private long id;
    private String name; 
    
    // Relations fields
    private Set<PropPatternEntity> props = new HashSet<>(0);
    
    public ElementPatternEntity() {
    }

    public ElementPatternEntity(String name){
        this.name = name;
    }
    
    public ElementPatternEntity(int id, String name, String necessary) {
        this(name);
        this.id = id;
    }
    
    @Override
    public Long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PropPatternEntity> getProps() {
        return props;
    }

    public void setProps(Set<PropPatternEntity> props) {
        this.props = props;
    }
    
    public static Collection<INameableEntity> toCollection(
            Collection<ElementPatternEntity> collection){
        List<INameableEntity> listEntities = new ArrayList<>(); 
        collection.forEach((ElementPatternEntity e) -> listEntities.add(e));
        return listEntities;
    }
}