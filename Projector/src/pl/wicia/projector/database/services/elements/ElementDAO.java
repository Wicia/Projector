/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.wicia.projector.database.services.elements;

import java.util.Collection;
import org.hibernate.SessionFactory;
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
    public ElementEntity getByID(Long id) {
        return super.get(id, "findElementByID");
    }

    @Override
    public ElementEntity getByName(String name){
        return super.getByName(name, "name", "findElementByName");
    }

    @Override
    public Collection<ElementEntity> searchByName(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
