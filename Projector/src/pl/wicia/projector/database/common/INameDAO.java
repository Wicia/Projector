/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.database.common;

import java.util.List;

/**
 * @param <TypeID>
 * @param <TypeElement>
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public interface INameDAO<TypeID, TypeElement> 
        extends IDataAccessObject<TypeID, TypeElement>{
    public TypeElement getByName(String name) throws Exception;
}
