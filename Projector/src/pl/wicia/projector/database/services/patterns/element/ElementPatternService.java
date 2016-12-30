/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.database.services.patterns.element;

import java.util.List;
import pl.wicia.projector.database.entities.patterns.element.ElementPatternEntity;
import pl.wicia.projector.common.exceptions.ExceptionDuplicateEntity;
import pl.wicia.projector.spring.contexts.ContextMain;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class ElementPatternService{
    
    public static ElementPatternService getService(){
        String beanName = ElementPatternService.class.getSimpleName();
        return (ElementPatternService) ContextMain.getApplicationContext().getBean(beanName);
    }
    
    private ElementPatternDAO dao;
    
    public ElementPatternService(ElementPatternDAO dao){
        this.dao = dao;
    }
    
    //TODO Kiedy powinna być walidacja? tutaj czy na pozimie metody wywyłującej?
    public void addPattern(ElementPatternEntity entity) 
            throws ExceptionDuplicateEntity, Exception{
        ElementPatternEntity dbEntity = this.dao.getByName(entity.getName());
        if(dbEntity != null){
            throw new ExceptionDuplicateEntity(ElementPatternEntity.class);
        }
        else{
            this.dao.add(entity);
        }
    }
    
    public ElementPatternEntity getPatternByName(String name){
        return this.dao.getByName(name);
    }
    
    public ElementPatternEntity getPatternByID(Long id){
        return this.dao.getByID(id);
    }
    
    public List<ElementPatternEntity> getAllPatterns(Long id){
        return this.dao.getAll();
    }
    
    public void deletePattern(ElementPatternEntity entity){
        this.dao.delete(entity);
    }
    
    public void updatePattern(ElementPatternEntity entity){
        this.dao.update(entity);
    }
}