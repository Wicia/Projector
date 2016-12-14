/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.wicia.projector.spring.contexts;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.wicia.projector.common.settings.AppSettings;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
//TODO Czy można jakoś inaczej pogrupować klasy w programie w context aby od razu wszystkich nie wczytywać?
public class ContextSettings 
        extends AContext
        implements ApplicationContextAware {

    public static final String FILE_NAME = "app-settings.xml";
    private static ClassPathXmlApplicationContext context;

    public static void initialize(){
        new ClassPathXmlApplicationContext(PATH + FILE_NAME);
    }
    
    @Override
    public void setApplicationContext(ApplicationContext aContext) throws BeansException {
        context = (ClassPathXmlApplicationContext)aContext;
        ((ConfigurableApplicationContext)context).registerShutdownHook();
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }
    
    public static AppSettings getAppSettings(){
        return (AppSettings)context.getBean(AppSettings.BEAN);
    }
}