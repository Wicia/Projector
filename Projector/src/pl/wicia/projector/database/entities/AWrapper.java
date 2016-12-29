/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.database.entities;

/**
 * Base class used for wrapping stored entity
 * 
 * @author Michał 'Wicia' Wietecha
 */
public class AWrapper<Entity> {
    
    private Entity entity;
    
    public AWrapper(Entity entity){
        this.entity = entity;
    }
    
    public Entity getEntity(){
        return this.entity;
    }
}