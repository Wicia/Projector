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
import pl.wicia.projector.database.services.common.ServiceBase;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class WorkshopDAO 
        extends ServiceBase<WorkshopEntity>
        implements INameDAO<Long, WorkshopEntity> {

    public WorkshopDAO(SessionFactory factory) {
        super(factory);
        super.setTypeClass(WorkshopEntity.class); //TODO: refactoring?
    }
    
    @Override
    public WorkshopEntity getByName(String name){
        WorkshopEntity entity = null;
        Session session = super.getSessionFactory().openSession();
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
        Session session = this.getSessionFactory().openSession();
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
    public Collection<WorkshopEntity> searchByName(String name) {
        List<WorkshopEntity> list = null;
        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query createQuery = session.getNamedQuery("searchWorkshopByName");
            createQuery.setString("name", "%" + name + "%");
            list = createQuery.list();
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
    public void addCollection(Collection<WorkshopEntity> collection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCollection(Collection<WorkshopEntity> collection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}