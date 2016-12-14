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
import pl.wicia.projector.database.services.common.ServiceBase;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class DescriptionDAO 
        extends ServiceBase<DescriptionEntity>
        implements INameDAO<Long, DescriptionEntity> {

    private SessionFactory factory;

    public DescriptionDAO(SessionFactory factory) {
        super(factory);
        super.setTypeClass(DescriptionEntity.class); //TODO: refactoring?
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
    public Collection<DescriptionEntity> searchByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}