/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.gui.utils.dialogs.types;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import pl.wicia.projector.gui.utils.dialogs.base.IDialog;
import pl.wicia.projector.gui.utils.dialogs.base.SimpleDialog;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class DialogQuestion extends SimpleDialog implements IDialog{
    
    private Object[] options;

    public DialogQuestion(String title, String message, String... options) {
        super(title, message);
        this.loadOptions(options);
    }
    
    private void loadOptions(String... options){
        this.options = new Object[options.length];
        for(int i = 0 ; i < options.length; i++){
            this.options[i] = options[i];
        }
    }

    @Override
    public int getMessageType() {
        return JOptionPane.QUESTION_MESSAGE;
    }
    
    public Object[] getOptions() {
        return options;
    }

    @Override
    public int show(JFrame frame) {
        return JOptionPane.showOptionDialog(frame, getMessage(),
                getTitle(),
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                getOptions(),
                getOptions()[0]);
    }
}
