/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.wicia.projector.database.services.workshop;

import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.wicia.projector.database.entities.workshop.WorkshopEntity;
import pl.wicia.projector.database.common.INameDAO;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class WorkshopDAO implements INameDAO<Long, WorkshopEntity> {

    private SessionFactory factory;

    public WorkshopDAO(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<WorkshopEntity> getAll() {
        List<WorkshopEntity> list = null;
        Session session = this.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            list = session.createCriteria(WorkshopEntity.class).list();
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
    
    // TODO: Gdzie umieścić metody uzywajace named query?
    @Override
    public WorkshopEntity getByName(String name){
        WorkshopEntity entity = null;
        Session session = this.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query createQuery = session.getNamedQuery("findWorkshopByName");
            createQuery.setString("name", name);
            List<WorkshopEntity> list = createQuery.list();
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
    public WorkshopEntity get(Long id) {
        WorkshopEntity entity = null;
        Session session = this.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query createQuery = session.getNamedQuery("findWorkshopByID");
            createQuery.setLong("id", id);
            List<WorkshopEntity> list = createQuery.list();
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
    public void update(WorkshopEntity element) {
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
    public void delete(WorkshopEntity element) {
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
    public Long add(WorkshopEntity element) throws Exception{
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
    public void addCollection(Collection<WorkshopEntity> collection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCollection(Collection<WorkshopEntity> collection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}