/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.wicia.projector.database.services.patterns.element;

import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.wicia.projector.database.entities.patterns.element.ElementPatternEntity;
import pl.wicia.projector.database.common.INameDAO;
import pl.wicia.projector.database.services.common.Batcher;
import pl.wicia.projector.database.services.common.DAOBase;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class ElementPatternDAO  
        extends DAOBase<ElementPatternEntity>
        implements INameDAO<Long, ElementPatternEntity> {

    public ElementPatternDAO(SessionFactory factory, Class clazz, Batcher batcher) {
        super(factory, clazz, batcher);
    }

    @Override
    public ElementPatternEntity getByID(Long id) {
        return super.get(id, "findElementPatternByID");
    }

    @Override
    public ElementPatternEntity getByName(String name){
        return super.getByName(name, "name", "findElementPatternByName");
    }

    @Override
    public Collection<ElementPatternEntity> searchByName(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
