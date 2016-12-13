/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.database.services.common;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @param <ElementType>
 * @TODO: Add description to: class, fields, methods
 * @author Michał 'Wicia' Wietecha
 */
public abstract class ServiceBase<ElementType> {
    
    private SessionFactory factory;
    private Class<?> type; 
    
    public ServiceBase(SessionFactory factory){
        this.factory = factory;
    }
    
    public void setTypeClass(Class<?> type){
        this.type = type;
    }
    
    public SessionFactory getSessionFactory(){
        return this.factory;
    }
    
    public List<ElementType> getAll() {
        List<ElementType> list = null;
        Session session = this.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            list = session.createCriteria(type).list();
            tx.commit();
        } 
        catch (Exception ex) {
            if (tx != null)
                tx.rollback();
        } 
        finally {
            session.close();
        }
        
        return list;
    }
    
}
