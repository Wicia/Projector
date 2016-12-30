/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.database.entities.element;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pl.wicia.projector.database.entities.INameableEntity;
import pl.wicia.projector.database.entities.description.DescriptionEntity;
import pl.wicia.projector.database.entities.props.PropEntity;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class ElementEntity 
        implements java.io.Serializable, INameableEntity<Long>{

    private static final long serialVersionUID = 1L;

    private long id;
    private long idPattern;
    private String name;
    private byte time;
    
    // Relations fields
    private List<DescriptionEntity> descriptions = new ArrayList<>(0);
    private Set<PropEntity> props = new HashSet<>(0);
    
    public ElementEntity(){}
    
    public Long getId() {
        return id;
    }

    public long getIdPattern() {
        return idPattern;
    }

    public String getName() {
        return name;
    }
    
    public byte getTime() {
        return time;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIdPattern(long idPattern) {
        this.idPattern = idPattern;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(byte time) {
        this.time = time;
    }

    public List<DescriptionEntity> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<DescriptionEntity> descriptions) {
        this.descriptions = descriptions;
    }

    public Set<PropEntity> getProps() {
        return props;
    }

    public void setProps(Set<PropEntity> props) {
        this.props = props;
    }
    
    public void linkWithDescriptions(Collection<DescriptionEntity> descriptions){
        descriptions.stream().forEach((DescriptionEntity e) -> (e.setElement(this)));
    }
    
    public void linkWithProps(Collection<PropEntity> props){
        props.stream().forEach((PropEntity e) -> (e.setElement(this)));
    }
}