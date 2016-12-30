/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.database.common;

import java.util.Collection;
import java.util.List;

/**
 * Interface defining functionallities for all DAO classes.
 * 
 * @param <TypeID> type of entity ID property
 * @param <TypeElement> type of entity
 * 
 * @author Michał 'Wicia' Wietecha
 */
public interface IDataAccessObject<TypeID, TypeElement> {
    
    // Single
    public TypeElement getByID(TypeID id);
    public void add(TypeElement element) throws Exception;
    public void update(TypeElement element);
    public void delete(TypeElement element);
    
    // Collections
    public List<TypeElement> getAll();
    public void deleteCollection(Collection<TypeElement> collection);
    public void addCollection(Collection<TypeElement> collection);
    public void updateCollection(Collection<TypeElement> collection);
}
