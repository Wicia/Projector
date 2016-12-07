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
public class DialogError extends SimpleDialog implements IDialog {

    public DialogError(String title, String message) {
        super(title, message);
    }

    @Override
    public int getMessageType() {
        return JOptionPane.ERROR_MESSAGE;
    }

    @Override
    public int show(JFrame frame) {
        JOptionPane.showMessageDialog(frame, getMessage(),
                getTitle(), getMessageType());
        return -1;
    }
}
