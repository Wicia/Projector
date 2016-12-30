/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.database.services.common;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.metadata.ClassMetadata;

/**
 * Class representing core for all DAO classes.
 * 
 * @param <ElementType>
 * 
 * @author Michał 'Wicia' Wietecha
 */
public abstract class DAOBase<ElementType> {
    
    private SessionFactory factory;
    private Class<?> type; 
    private Batcher batcher;
    
    public DAOBase(SessionFactory factory, Class type, Batcher batcher){
        this.factory = factory;
        this.type = type;
        this.batcher = batcher;
    }
    
    public ClassMetadata getMetadata(){
        return getSessionFactory().getClassMetadata(type);
    }
    
    public SessionFactory getSessionFactory(){
        return this.factory;
    }

    public Batcher getBatchMechanism() {
        return batcher;
    }
    
    public ElementType get(Long id, String queryName) {
        ElementType entity = null;
        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query createQuery = session.getNamedQuery(queryName);
            createQuery.setLong(getMetadata().getIdentifierPropertyName(), id);
            List<ElementType> list = createQuery.list();
            if(list != null && !list.isEmpty())
                entity = list.get(0);
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
        
        return entity;
    }
    
    public ElementType getByName(String name, String colName, String queryName){
        ElementType entity = null;
        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query createQuery = session.getNamedQuery(queryName);
            createQuery.setString(colName, name);
            List<ElementType> list = createQuery.list();
            if(list != null && !list.isEmpty())
                entity = list.get(0);
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
        
        return entity;
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
            throw ex;
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
            throw ex;
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
            throw ex;
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
            this.batcher.beginWork();
            while(iterator.hasNext()){
                session.save(iterator.next());
                this.batcher.batchUpdate(session);
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
            this.batcher.beginWork();
            while(iterator.hasNext()){
                session.update(iterator.next());
                this.batcher.batchUpdate(session);
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
            this.batcher.beginWork();
            while(iterator.hasNext()){
                session.delete(iterator.next());
                this.batcher.batchUpdate(session);
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