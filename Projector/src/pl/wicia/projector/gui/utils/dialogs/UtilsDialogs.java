/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.gui.utils.dialogs;

import pl.wicia.projector.gui.utils.dialogs.base.IDialog;
import javax.swing.JFrame;

/**
 * Klasa do zarządzania pokazywaniem dialogów.
 * 
 * @author Michał 'Wicia' Wietecha
 */
public class UtilsDialogs {
    
    private JFrame frame;
    
    public UtilsDialogs(JFrame frame){
        this.frame = frame;
    }
    
    public int show(IDialog dialog){
        return dialog.show(frame);
    }
}