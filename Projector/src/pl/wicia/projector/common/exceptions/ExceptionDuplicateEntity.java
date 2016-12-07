/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.common.exceptions;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class ExceptionDuplicateEntity extends Exception{
    
    public ExceptionDuplicateEntity(Class clazz){
        super("Obiekt " + clazz.getName() + " już istneje w bazie.");
    }
}
