/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.wicia.projector.database.services.props;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.wicia.projector.database.entities.props.PropEntity;
import pl.wicia.projector.database.common.INameDAO;
import pl.wicia.projector.database.services.common.ServiceBase;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class PropsDAO 
        extends ServiceBase<PropEntity>
        implements INameDAO<Long, PropEntity> {

    public PropsDAO(SessionFactory factory) {
        super(factory);
        super.setTypeClass(PropEntity.class);
    }
    
    @Override
    public PropEntity getByName(String name){
        PropEntity entity = null;
        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query createQuery = session.getNamedQuery("findPropByName");
            createQuery.setString("name", name);
            List<PropEntity> list = createQuery.list();
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
    public PropEntity get(Long id) {
        PropEntity entity = null;
        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query createQuery = session.getNamedQuery("findWPropByID");
            createQuery.setLong("id", id);
            List<PropEntity> list = createQuery.list();
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
    public void update(PropEntity element) {
        Session session = this.getSessionFactory().openSession();
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
    public void delete(PropEntity element) {
        Session session = this.getSessionFactory().openSession();
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
    public Long add(PropEntity element){
        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(element);
            tx.commit();
        } 
        catch (Exception ex) {
            if (tx != null)
                tx.rollback();
        } 
        finally {
            session.close();
        }
        
        return element.getId();
    }

    @Override
    public void addCollection(Collection<PropEntity> collection) {
        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            
            Iterator<PropEntity> iterator = collection.iterator();
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
    public void updateCollection(Collection<PropEntity> collection) {
        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            
            Iterator<PropEntity> iterator = collection.iterator();
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

    public void deleteCollection(Collection<PropEntity> collection) {
        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            
            Iterator<PropEntity> iterator = collection.iterator();
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
    public Collection<PropEntity> searchByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}