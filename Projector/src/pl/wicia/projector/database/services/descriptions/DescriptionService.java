/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.database.services.descriptions;

import java.util.Collection;
import java.util.List;
import pl.wicia.projector.database.entities.description.DescriptionEntity;
import pl.wicia.projector.spring.contexts.ContextMain;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class DescriptionService{
    
    public static DescriptionService getService(){
        String beanName = DescriptionService.class.getSimpleName();
        return (DescriptionService) ContextMain.getApplicationContext().getBean(beanName);
    }
    
    private DescriptionDAO dao;
    
    public DescriptionService(DescriptionDAO dao){
        this.dao = dao;
    }
    
    public void addDescription(DescriptionEntity entity){
        this.dao.add(entity);
    }
    
    public DescriptionEntity getDescriptionByName(String name){
        return this.dao.getByName(name);
    }
    
    public DescriptionEntity getDescriptionByID(Long id){
        return this.dao.get(id);
    }
    
    public List<DescriptionEntity> getAllDescriptions(Long id){
        return this.dao.getAll();
    }
    
    public void deleteDescription(DescriptionEntity entity){
        this.dao.delete(entity);
    }
    
    public void updateDescription(DescriptionEntity entity){
        this.dao.update(entity);
    }

    public void updateCollectionDescriptions(Collection<DescriptionEntity> collection) {
        this.dao.updateCollection(collection);
    }
    
    public void deleteCollectionDescriptions(Collection<DescriptionEntity> collection){
        this.dao.deleteCollection(collection);
    }

    public void addCollectionDescriptions(Collection<DescriptionEntity> collection) {
        this.dao.addCollection(collection);
    }
}