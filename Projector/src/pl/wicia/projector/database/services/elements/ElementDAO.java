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
import pl.wicia.projector.database.services.common.Batcher;
import pl.wicia.projector.database.services.common.DAOBase;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class ElementDAO 
        extends DAOBase<ElementEntity>
        implements INameDAO<Long, ElementEntity> {

    public ElementDAO(SessionFactory factory, Class clazz, Batcher batcher) {
        super(factory, clazz, batcher);
    }

    @Override
    public ElementEntity get(Long id) {
        ElementEntity entity = null;
        Session session = this.getSessionFactory().openSession();
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
    public ElementEntity getByName(String name){
        ElementEntity entity = null;
        Session session = this.getSessionFactory().openSession();
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
    public Collection<ElementEntity> searchByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
