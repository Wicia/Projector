/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.database.services.common;

import java.util.Properties;

/**
 * Class wrapping hibernate properties specified in spring-config.xml.
 * 
 * @author Michał 'Wicia' Wietecha
 */
public class HibernatePropertiesWrapper {
    
    private Properties props;
    
    // Properties names
    private static final String batchSize = "hibernate.jdbc.batch_size";

    public HibernatePropertiesWrapper(Properties properties) {
        this.props = properties;
    }
    
    public int getBatchSize(){
        return Integer.valueOf(props.getProperty(batchSize));
    }
}