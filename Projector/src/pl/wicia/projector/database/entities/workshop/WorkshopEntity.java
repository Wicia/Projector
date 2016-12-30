/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.database.entities.workshop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import pl.wicia.projector.database.entities.INameableEntity;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class WorkshopEntity 
        implements java.io.Serializable, INameableEntity{

    private static final long serialVersionUID = 1L;

    private long id;
    private String name; 
    
    public WorkshopEntity() {
    }

    public WorkshopEntity(String name){
        this.name = name;
    }
    
    public WorkshopEntity(int id, String name) {
        this.id = id;
        this.name = name;
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
    
    public static Collection<INameableEntity> toCollection(
            Collection<WorkshopEntity> collection){
        List<INameableEntity> listEntities = new ArrayList<>(); 
        collection.forEach((WorkshopEntity e) -> listEntities.add(e));
        return listEntities;
    }
}