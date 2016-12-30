/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.wicia.projector.database.services.descriptions;

import java.util.Collection;
import org.hibernate.SessionFactory;
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
    public DescriptionEntity getByID(Long id) {
        return super.get(id, "findDescriptionByID");
    }

    @Override
    public DescriptionEntity getByName(String name){
        return super.getByName(name, "name", "findDescriptionByName");
    }

    @Override
    public Collection<DescriptionEntity> searchByName(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}