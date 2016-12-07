/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.common.settings;

import java.util.Properties;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
// Każdy bean ma mieć implements interfejs IBeanName + metoda getBeanName
public class AppSettings {

    public static final String BEAN = "AppSettings";
    
    private Properties properties;
    
    public static enum PropertyName{
        WorkshopName, WorkshopID
    }
    
    public AppSettings(){
        this.properties = new Properties();
    }
    
    public void addProperty(PropertyName name, Object value){
        this.properties.put(name.toString(), value);
    }
    
    public Object getPropertyValue(PropertyName name){
        return this.properties.get(name.toString());
    }
}