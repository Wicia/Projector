/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.database.services.common;

import org.hibernate.Session;

/**
 * @TODO: Add description to: class, fields, methods
 * @author Michał 'Wicia' Wietecha
 */
public class BachMechanism {
    
    private int BATCH_SIZE;
    private int number;
    
    public BachMechanism(int batchSize){
        this.BATCH_SIZE = batchSize;
        this.number = 0;
    }
    
    public void batchUpdate(Session session){
        if (number % BATCH_SIZE == 0 && number > 0) {
            session.flush();
            session.clear();
        }
        number++;
    }
}
