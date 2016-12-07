/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.database.common;

import java.util.Collection;
import java.util.List;

/**
 * @param <TypeID>
 * @param <TypeElement>
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public interface IDataAccessObject<TypeID, TypeElement> {
    // Single
    public TypeID add(TypeElement element) throws Exception;
    public TypeElement get(TypeID id);
    public void update(TypeElement element);
    public void delete(TypeElement element);
    
    // Collections
    public List<TypeElement> getAll();
    public void addCollection(Collection<TypeElement> collection);
    public void updateCollection(Collection<TypeElement> collection);
}
