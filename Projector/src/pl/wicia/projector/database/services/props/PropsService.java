/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.database.services.props;

import java.util.Collection;
import java.util.List;
import pl.wicia.projector.database.entities.props.PropEntity;
import pl.wicia.projector.spring.contexts.ContextMain;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
// Każda klasa service ma mieć implements 
public class PropsService{
    
    public static PropsService getService(){
        String beanName = PropsService.class.getSimpleName();
        return (PropsService) ContextMain.getApplicationContext().getBean(beanName);
    }
    
    private PropsDAO dao;
    
    public PropsService(PropsDAO dao){
        this.dao = dao;
    }
    
    public void addProps(PropEntity entity){
        this.dao.add(entity);
    }
    
    public void addPropsCollection(Collection<PropEntity> collection){
        this.dao.addCollection(collection);
    }
    
    public PropEntity getPropByName(String name){
        return this.dao.getByName(name);
    }
    
    public PropEntity getPropByID(Long id){
        return this.dao.get(id);
    }
    
    public List<PropEntity> getAllProps(){
        return this.dao.getAll();
    }
    
    public void deleteProp(PropEntity entity){
        this.dao.delete(entity);
    }
    
    public void updateProp(PropEntity entity){
        this.dao.update(entity);
    }
    
    public void updatePropsCollection(Collection<PropEntity> collection){
        this.dao.updateCollection(collection);
    }
    
    public void deletePropsCollection(Collection<PropEntity> collection){
        this.dao.deleteCollection(collection);
    }
}