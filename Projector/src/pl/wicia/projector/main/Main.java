/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.wicia.projector.main;

import java.util.Set;
import javax.swing.UIManager;
import pl.wicia.projector.database.entities.patterns.element.ElementPatternEntity;
import pl.wicia.projector.database.entities.patterns.props.PropPatternEntity;
import pl.wicia.projector.database.services.patterns.element.ElementPatternService;
import pl.wicia.projector.spring.contexts.ContextMain;
import pl.wicia.projector.spring.contexts.ContextSettings;

/**
 *
 * @author Michał 'Wicia' Wietecha
 */
//TODO Czy bean session factory powinien mieć scope Singleton i jak sie powinno nim zarzadzać?
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        initContexts();
        loadLookAndFeel();
        //WindowMenu.open();
        ElementPatternService s = ElementPatternService.getService();
        ElementPatternEntity patternByID = s.getPatternByID(1L);
        Set<PropPatternEntity> x = patternByID.getProps();
    }
    
    private static void loadLookAndFeel(){
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex){}
    }
    
    private static void initContexts(){
        ContextMain.initialize();
        ContextSettings.initialize();
    }
}