/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.database.services.workshop;

import java.util.Collection;
import java.util.List;
import pl.wicia.projector.database.entities.workshop.WorkshopEntity;
import pl.wicia.projector.common.exceptions.ExceptionDuplicateEntity;
import pl.wicia.projector.spring.contexts.ContextMain;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
// Każda klasa service ma mieć implements 
public class WorkshopService{
    
    public static WorkshopService getService(){
        String beanName = WorkshopService.class.getSimpleName();
        return (WorkshopService) ContextMain.getApplicationContext().getBean(beanName);
    }
    
    private WorkshopDAO dao;
    
    public WorkshopService(WorkshopDAO dao){
        this.dao = dao;
    }
    
    //TODO Kiedy powinna być walidacja? tutaj czy na pozimie metody wywyłującej?
    public void addWorkshop(WorkshopEntity entity) 
            throws ExceptionDuplicateEntity, Exception{
        WorkshopEntity dbEntity = this.dao.getByName(entity.getName());
        if(dbEntity != null){
            throw new ExceptionDuplicateEntity(WorkshopEntity.class);
        }
        else{
            this.dao.add(entity);
        }
    }
    
    public WorkshopEntity getWorkshopByName(String name){
        return this.dao.getByName(name);
    }
    
    public Collection<WorkshopEntity> searchWorkshopByName(String name){
        return this.dao.searchByName(name);
    }
    
    public WorkshopEntity getWorkshopByID(Long id){
        return this.dao.get(id);
    }
    
    public List<WorkshopEntity> getAllWorkshops(){
        return this.dao.getAll();
    }
    
    public void deleteWorkshop(WorkshopEntity entity){
        this.dao.delete(entity);
    }
    
    public void updateWorkshop(WorkshopEntity entity){
        this.dao.update(entity);
    }
}