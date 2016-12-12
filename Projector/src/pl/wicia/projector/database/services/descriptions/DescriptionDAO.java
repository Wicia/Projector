/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.wicia.projector.database.services.descriptions;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.wicia.projector.database.entities.description.DescriptionEntity;
import pl.wicia.projector.database.common.INameDAO;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class DescriptionDAO implements INameDAO<Long, DescriptionEntity> {

    private SessionFactory factory;

    public DescriptionDAO(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<DescriptionEntity> getAll() {
        List<DescriptionEntity> list = null;
        Session session = this.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            list = session.createCriteria(DescriptionEntity.class).list();
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

    @Override
    public DescriptionEntity get(Long id) {
        DescriptionEntity entity = null;
        Session session = this.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query createQuery = session.getNamedQuery("findDescriptionByID");
            createQuery.setLong("id", id);
            List<DescriptionEntity> list = createQuery.list();
            if(list != null && !list.isEmpty())
                entity = list.get(0);
            tx.commit();
        } 
        catch (Exception ex) {
            if (tx != null)
                tx.rollback();
        } 
        finally {
            session.close();
        }
        
        return entity;
    }

    @Override
    public void update(DescriptionEntity element) {
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

    @Override
    public void delete(DescriptionEntity element) {
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

    @Override
    public Long add(DescriptionEntity element){
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
        
        return element.getId();
    }

    @Override
    public DescriptionEntity getByName(String name){
        DescriptionEntity entity = null;
        Session session = this.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query createQuery = session.getNamedQuery("findDescriptionByName");
            createQuery.setString("name", name);
            List<DescriptionEntity> list = createQuery.list();
            if(list != null && !list.isEmpty())
                entity = list.get(0);
            tx.commit();
        } 
        catch (Exception ex) {
            if (tx != null)
                tx.rollback();
        } 
        finally {
            session.close();
        }
        
        return entity;
    }

    @Override
    public void addCollection(Collection<DescriptionEntity> collection) {
        Session session = this.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            
            Iterator<DescriptionEntity> iterator = collection.iterator();
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

    @Override
    public void updateCollection(Collection<DescriptionEntity> collection) {
        Session session = this.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            
            Iterator<DescriptionEntity> iterator = collection.iterator();
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

    public void deleteCollection(Collection<DescriptionEntity> collection) {
        Session session = this.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            
            Iterator<DescriptionEntity> iterator = collection.iterator();
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

    @Override
    public Collection<DescriptionEntity> searchByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}