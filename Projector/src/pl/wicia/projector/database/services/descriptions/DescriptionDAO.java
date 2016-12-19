/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.wicia.projector.database.services.descriptions;

import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.wicia.projector.database.entities.description.DescriptionEntity;
import pl.wicia.projector.database.common.INameDAO;
import pl.wicia.projector.database.services.common.Batcher;
import pl.wicia.projector.database.services.common.DAOBase;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class DescriptionDAO 
        extends DAOBase<DescriptionEntity>
        implements INameDAO<Long, DescriptionEntity> {

    public DescriptionDAO(SessionFactory factory, Class clazz, Batcher batcher) {
        super(factory, clazz, batcher);
    }

    @Override
    public DescriptionEntity get(Long id) {
        DescriptionEntity entity = null;
        Session session = this.getSessionFactory().openSession();
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
    public DescriptionEntity getByName(String name){
        DescriptionEntity entity = null;
        Session session = this.getSessionFactory().openSession();
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
    public Collection<DescriptionEntity> searchByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}