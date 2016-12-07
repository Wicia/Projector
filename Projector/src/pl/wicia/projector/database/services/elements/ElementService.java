/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.database.services.elements;

import java.util.List;
import pl.wicia.projector.database.entities.element.ElementEntity;
import pl.wicia.projector.common.exceptions.ExceptionDuplicateEntity;
import pl.wicia.projector.spring.contexts.ContextMain;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class ElementService{
    
    public static ElementService getService(){
        String beanName = ElementService.class.getSimpleName();
        return (ElementService) ContextMain.getApplicationContext().getBean(beanName);
    }
    
    private ElementDAO dao;
    
    public ElementService(ElementDAO dao){
        this.dao = dao;
    }
    
    public void addElement(ElementEntity entity)
        throws ExceptionDuplicateEntity, Exception{
        ElementEntity dbEntity = this.dao.getByName(entity.getName());
        if(dbEntity != null){
            throw new ExceptionDuplicateEntity(ElementEntity.class);
        }
        else{
            this.dao.add(entity);
        }
    }
    
    public ElementEntity getElementByName(String name){
        return this.dao.getByName(name);
    }
    
    public ElementEntity getElementByID(Long id){
        return this.dao.get(id);
    }
    
    public List<ElementEntity> getAllElements(Long id){
        return this.dao.getAll();
    }
    
    public void deleteElement(ElementEntity entity){
        this.dao.delete(entity);
    }
    
    public void updateElement(ElementEntity entity){
        this.dao.update(entity);
    }
}