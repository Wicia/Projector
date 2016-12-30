/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.wicia.projector.database.services.patterns.props;

import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.wicia.projector.database.common.INameDAO;
import pl.wicia.projector.database.entities.patterns.props.PropPatternEntity;
import pl.wicia.projector.database.services.common.Batcher;
import pl.wicia.projector.database.services.common.DAOBase;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class PropsPatternDAO 
        extends DAOBase<PropPatternEntity>
        implements INameDAO<Long, PropPatternEntity> {

    public PropsPatternDAO(SessionFactory factory, Class clazz, Batcher batcher) {
        super(factory, clazz, batcher);
    }
    
    @Override
    public PropPatternEntity getByName(String name){
        return super.getByName(name, "name", "findPropPatternByName");
    }

    @Override
    public PropPatternEntity getByID(Long id) {
        return super.get(id, "findPropPatternByID");
    }

    @Override
    public Collection<PropPatternEntity> searchByName(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}