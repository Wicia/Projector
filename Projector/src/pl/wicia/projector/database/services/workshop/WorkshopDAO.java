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
import pl.wicia.projector.database.services.common.Batcher;
import pl.wicia.projector.database.services.common.DAOBase;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class WorkshopDAO 
        extends DAOBase<WorkshopEntity>
        implements INameDAO<Long, WorkshopEntity> {

    public WorkshopDAO(SessionFactory factory, Class clazz, Batcher batcher) {
        super(factory, clazz, batcher);
    }
    
    @Override
    public WorkshopEntity getByName(String name){
        return super.getByName(name, "name", "findWorkshopByName");
    }

    @Override
    public WorkshopEntity getByID(Long id) {
        return super.get(id, "findWorkshopByID");
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
}