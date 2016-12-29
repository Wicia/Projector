/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.database.services.patterns.props;

import java.util.Collection;
import java.util.List;
import pl.wicia.projector.database.entities.patterns.props.PropPatternEntity;
import pl.wicia.projector.spring.contexts.ContextMain;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
// Każda klasa service ma mieć implements 
public class PropsPatternService{
    
    public static PropsPatternService getService(){
        String beanName = PropsPatternService.class.getSimpleName();
        return (PropsPatternService) ContextMain.getApplicationContext().getBean(beanName);
    }
    
    private PropsPatternDAO dao;
    
    public PropsPatternService(PropsPatternDAO dao){
        this.dao = dao;
    }
    
    public void addProps(PropPatternEntity entity){
        this.dao.add(entity);
    }
    
    public void addPropsCollection(Collection<PropPatternEntity> collection){
        this.dao.addCollection(collection);
    }
    
    public PropPatternEntity getPropByName(String name){
        return this.dao.getByName(name);
    }
    
    public PropPatternEntity getPropByID(Long id){
        return this.dao.get(id);
    }
    
    public List<PropPatternEntity> getAllProps(){
        return this.dao.getAll();
    }
    
    public void deleteProp(PropPatternEntity entity){
        this.dao.delete(entity);
    }
    
    public void updateProp(PropPatternEntity entity){
        this.dao.update(entity);
    }
    
    public void updatePropsCollection(Collection<PropPatternEntity> collection){
        this.dao.updateCollection(collection);
    }
    
    public void deletePropsCollection(Collection<PropPatternEntity> collection){
        this.dao.deleteCollection(collection);
    }
}