/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.database.entities.pattern;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class PatternEntity implements java.io.Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private long id;
    private String name; 
    private String necessary; 
    
    public PatternEntity() {
    }

    public PatternEntity(String name, String necessary){
        this.name = name;
        this.necessary = necessary;
    }
    
    public PatternEntity(int id, String name, String necessary) {
        this(name, necessary);
        this.id = id;
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getNecessary() {
        return necessary;
    }

    public void setNecessary(String necessary) {
        this.necessary = necessary;
    }
}