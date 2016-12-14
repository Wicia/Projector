/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.database.services.common;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.wicia.projector.database.entities.description.DescriptionEntity;

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
    
    public void update(ElementType element) {
        Session session = this.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(element);
            tx.commit();
        } 
        catch (Exception ex) {
            if (tx != null)
                tx.rollback();
        } 
        finally {
            session.close();
        }
    }

    public void delete(ElementType element) {
        Session session = this.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(element);
            tx.commit();
        } 
        catch (Exception ex) {
            if (tx != null)
                tx.rollback();
        } 
        finally {
            session.close();
        }
    }

    public void add(ElementType element){
        Session session = this.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(element);
            tx.commit();
        } 
        catch (Exception ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        } 
        finally {
            session.close();
        }
    }
    
    public void addCollection(Collection<ElementType> collection) {
        Session session = this.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            
            Iterator<ElementType> iterator = collection.iterator();
            int number = 0;
            while(iterator.hasNext()){
                session.save(iterator.next());
                if(number % 10 == 0){
                    session.flush();
                    session.clear();
                }
                number++;
            }
            
            tx.commit();
        } 
        catch (Exception ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        } 
        finally {
            session.close();
        }
    }

    public void updateCollection(Collection<ElementType> collection) {
        Session session = this.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            
            Iterator<ElementType> iterator = collection.iterator();
            int number = 0;
            while(iterator.hasNext()){
                session.update(iterator.next());
                if(number % 10 == 0){
                    session.flush();
                    session.clear();
                }
                number++;
            }
            
            tx.commit();
        } 
        catch (Exception ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        } 
        finally {
            session.close();
        }
    }

    public void deleteCollection(Collection<ElementType> collection) {
        Session session = this.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            
            Iterator<ElementType> iterator = collection.iterator();
            int number = 0;
            while(iterator.hasNext()){
                session.delete(iterator.next());
                if(number % 10 == 0){
                    session.flush();
                    session.clear();
                }
                number++;
            }
            
            tx.commit();
        } 
        catch (Exception ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        } 
        finally {
            session.close();
        }
    }
}