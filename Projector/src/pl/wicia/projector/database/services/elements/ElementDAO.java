/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.wicia.projector.database.services.elements;

import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.wicia.projector.database.entities.element.ElementEntity;
import pl.wicia.projector.database.common.INameDAO;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class ElementDAO implements INameDAO<Long, ElementEntity> {

    private SessionFactory factory;

    public ElementDAO(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<ElementEntity> getAll() {
        List<ElementEntity> list = null;
        Session session = this.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            list = session.createCriteria(ElementEntity.class).list();
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
    public ElementEntity get(Long id) {
        ElementEntity entity = null;
        Session session = this.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query createQuery = session.getNamedQuery("findElementByID");
            createQuery.setLong("id", id);
            List<ElementEntity> list = createQuery.list();
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
    public void update(ElementEntity element) {
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
    public void delete(ElementEntity element) {
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
    public Long add(ElementEntity element) throws Exception{
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
    public ElementEntity getByName(String name){
        ElementEntity entity = null;
        Session session = this.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query createQuery = session.getNamedQuery("findElementByName");
            createQuery.setString("name", name);
            List<ElementEntity> list = createQuery.list();
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
    public void addCollection(Collection<ElementEntity> collection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCollection(Collection<ElementEntity> collection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
