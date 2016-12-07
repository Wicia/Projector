/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.database.services.pattern;

import java.util.List;
import pl.wicia.projector.database.entities.pattern.PatternEntity;
import pl.wicia.projector.common.exceptions.ExceptionDuplicateEntity;
import pl.wicia.projector.spring.contexts.ContextMain;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class PatternService{
    
    public static PatternService getService(){
        String beanName = PatternService.class.getSimpleName();
        return (PatternService) ContextMain.getApplicationContext().getBean(beanName);
    }
    
    private PatternDAO dao;
    
    public PatternService(PatternDAO dao){
        this.dao = dao;
    }
    
    //TODO Kiedy powinna być walidacja? tutaj czy na pozimie metody wywyłującej?
    public void addPattern(PatternEntity entity) 
            throws ExceptionDuplicateEntity, Exception{
        PatternEntity dbEntity = this.dao.getByName(entity.getName());
        if(dbEntity != null){
            throw new ExceptionDuplicateEntity(PatternEntity.class);
        }
        else{
            this.dao.add(entity);
        }
    }
    
    public PatternEntity getWorkshopByName(String name){
        return this.dao.getByName(name);
    }
    
    public PatternEntity getWorkshopByID(Long id){
        return this.dao.get(id);
    }
    
    public List<PatternEntity> getAllWorkshops(Long id){
        return this.dao.getAll();
    }
    
    public void deleteWorkshop(PatternEntity entity){
        this.dao.delete(entity);
    }
    
    public void updateWorkshop(PatternEntity entity){
        this.dao.update(entity);
    }
}