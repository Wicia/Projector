/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.database.services.props;

import java.util.Collection;
import java.util.List;
import pl.wicia.projector.common.exceptions.ExceptionDuplicateEntity;
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
    
    //TODO Kiedy powinna być walidacja? tutaj czy na pozimie metody wywyłującej?
    public void addProps(PropEntity entity) 
            throws ExceptionDuplicateEntity, Exception{
        PropEntity dbEntity = this.dao.getByName(entity.getName());
        if(dbEntity != null){
            throw new ExceptionDuplicateEntity(PropEntity.class);
        }
        else{
            this.dao.add(entity);
        }
    }
    
    public void addListProps(List<PropEntity> list){
        this.dao.addCollection(list);
    }
    
    public void deleteAll(long elementID){
        
    }
    
    public PropEntity getWorkshopByName(String name){
        return this.dao.getByName(name);
    }
    
    public PropEntity getWorkshopByID(Long id){
        return this.dao.get(id);
    }
    
    public List<PropEntity> getAllProps(){
        return this.dao.getAll();
    }
    
    public void deleteWorkshop(PropEntity entity){
        this.dao.delete(entity);
    }
    
    public void updateWorkshop(PropEntity entity){
        this.dao.update(entity);
    }
    
    public void updatePropsCollection(Collection<PropEntity> collection){
        this.dao.updateCollection(collection);
    }
}