/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.gui.utils.dialogs.base;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public abstract class SimpleDialog {

    private String title;
    private String message;
    
    public SimpleDialog(String title, String message) {
        this.title = title;
        this.message = message;
    }
    
    public abstract int getMessageType();
    
    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }
}
