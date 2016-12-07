/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.wicia.projector.gui.windows.elements;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pl.wicia.projector.gui.windows.elements.data.tab_elements.DescriptionsTableModel;
import javax.swing.SwingUtilities;
import pl.wicia.projector.database.entities.description.DescriptionEntity;
import pl.wicia.projector.database.entities.element.ElementEntity;
import pl.wicia.projector.database.entities.props.PropEntity;
import pl.wicia.projector.database.services.descriptions.DescriptionService;
import pl.wicia.projector.database.services.elements.ElementService;
import pl.wicia.projector.database.services.props.PropsService;
import pl.wicia.projector.gui.windows.elements.data.tab_props.PropsTableModel;

/**
 *
 * @author Michał 'Wicia' Wietecha
 */
public class WindowElements extends javax.swing.JFrame {

    /**
     * Creates new form WindowAddWorkshop
     */
    public WindowElements() {
        this.initComponents();
        this.fillComponents();
    }
    
    public WindowElements(long choosenElemenID) {
        this.initElement(choosenElemenID);
        this.initComponents();
        this.fillComponents();
    }

    private void fillComponents() {
        this.initTableDescriptions();
        this.initTableProps();
    }
    
    private void initElement(long elementID){
        ElementService service = ElementService.getService();
        this.choosenElement = service.getElementByID(elementID);
    }
    
    private void initTableDescriptions(){
        this.modelElements = DescriptionsTableModel.loadModel(tableDescriptions);
        if(this.choosenElement != null){
            List<DescriptionEntity> descriptions = this.choosenElement.getDescriptions();
            for(DescriptionEntity desc : descriptions){
                this.modelElements.addNewRow(desc);
            }
        }
    }
    
    private void initTableProps(){
        this.modelProps = PropsTableModel.loadModel(tableProps);
        if(this.choosenElement != null){
            Set<PropEntity> descriptions = this.choosenElement.getProps();
            this.modelProps.setRowsCount(descriptions.size());
            int index = 0;
            for(PropEntity prop : descriptions){
                this.modelProps.setNewRow(prop, index);
                index++;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        fieldElementName = new javax.swing.JTextField();
        fieldTime = new javax.swing.JTextField();
        comboPatterns = new javax.swing.JComboBox<>();
        buttonSave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDescriptions = new javax.swing.JTable();
        buttonAddElement = new javax.swing.JButton();
        buttonDeleteChoosen = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableProps = new javax.swing.JTable();
        buttonAddProp = new javax.swing.JButton();
        buttonDeleteProp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(40, 120, 115));

        comboPatterns.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{}));

        buttonSave.setBackground(new java.awt.Color(40, 120, 115));
        buttonSave.setText("Zapisz");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Wzór");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Czas");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nazwa elementu");

        tableDescriptions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Zaznacz", "Nazwa", "Opis"
            }
        ));
        jScrollPane2.setViewportView(tableDescriptions);

        buttonAddElement.setBackground(new java.awt.Color(40, 120, 115));
        buttonAddElement.setText("Dodaj");
        buttonAddElement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddElementActionPerformed(evt);
            }
        });

        buttonDeleteChoosen.setBackground(new java.awt.Color(40, 120, 115));
        buttonDeleteChoosen.setText("Usuń");
        buttonDeleteChoosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteChoosenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(buttonAddElement)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDeleteChoosen)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonDeleteChoosen)
                    .addComponent(buttonAddElement))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Treść", jPanel3);

        tableProps.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Zaznacz", "Nazwa", "Opis"
            }
        ));
        jScrollPane4.setViewportView(tableProps);

        buttonAddProp.setBackground(new java.awt.Color(255, 102, 0));
        buttonAddProp.setText("Dodaj");
        buttonAddProp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddPropActionPerformed(evt);
            }
        });

        buttonDeleteProp.setBackground(new java.awt.Color(255, 102, 0));
        buttonDeleteProp.setText("Usuń");
        buttonDeleteProp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeletePropActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(buttonAddProp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDeleteProp)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonDeleteProp)
                    .addComponent(buttonAddProp))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Rekwizyty", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(fieldTime, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboPatterns, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(fieldElementName)))
                    .addComponent(jTabbedPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonSave)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboPatterns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldElementName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonSave)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        if(this.choosenElement != null){
            this.updateExistingElement();
        }
        else{
            this.addNewElement();
        }
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void updateExistingElement() {
        // Update entity
        ElementService service = ElementService.getService();
        service.updateElement(this.choosenElement);
        
        // Update DESCRIPTIONS
        List<DescriptionEntity> listDescs = modelElements.getListEntities();
        HashSet<DescriptionEntity> setDesc = new HashSet<>(listDescs);
        setDesc.stream().forEach((DescriptionEntity e) -> (e.setElement(choosenElement)));
        DescriptionService.getService().updateCollectionDescriptions(setDesc);
        
        // Update PROPS
        List<PropEntity> listProps = modelProps.getListEntities();
        HashSet<PropEntity> setProp = new HashSet<>(listProps);
        setProp.stream().forEach((PropEntity e) -> (e.setElement(choosenElement)));
        PropsService.getService().updatePropsCollection(setProp);

    }

    private void addNewElement() {
        //TODO: Walidacja, potem wstawianie
        String elementName = this.fieldElementName.getText();
        byte time = Byte.valueOf(this.fieldTime.getText());

        // Update DESCRIPTIONS
        List<DescriptionEntity> listDescs = modelElements.getListEntities();

        // Update PROPS
        List<PropEntity> listProps = modelProps.getListEntities();
    }
    
    private void buttonDeleteChoosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteChoosenActionPerformed
        this.modelElements.removeSelectedRows();
    }//GEN-LAST:event_buttonDeleteChoosenActionPerformed

    private void buttonAddElementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddElementActionPerformed
        this.modelElements.addNewRow();
    }//GEN-LAST:event_buttonAddElementActionPerformed

    private void buttonAddPropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddPropActionPerformed
        this.modelProps.addNewRow();
    }//GEN-LAST:event_buttonAddPropActionPerformed

    private void buttonDeletePropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeletePropActionPerformed
        this.modelProps.removeSelectedRows();
    }//GEN-LAST:event_buttonDeletePropActionPerformed

    //TODO: Jak to profesjonalnie zorganizować + refactroring innych metod tego typu
    public static void open() {
        SwingUtilities.invokeLater(() -> {
            WindowElements window = new WindowElements();
            window.setVisible(true);
            window.setLocationRelativeTo(null);
        });
    }
    
    //TODO: opakować to element ID w jakiś obiekt z ustawieniami + do innych metod też to zastosować
    public static void open(long elementID) {
        SwingUtilities.invokeLater(() -> {
            WindowElements window = new WindowElements(elementID);
            window.setVisible(true);
            window.setLocationRelativeTo(null);
        });
    }

    private DescriptionsTableModel modelElements;
    private PropsTableModel modelProps;
    private ElementEntity choosenElement;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddElement;
    private javax.swing.JButton buttonAddProp;
    private javax.swing.JButton buttonDeleteChoosen;
    private javax.swing.JButton buttonDeleteProp;
    private javax.swing.JButton buttonSave;
    private javax.swing.JComboBox<String> comboPatterns;
    private javax.swing.JTextField fieldElementName;
    private javax.swing.JTextField fieldTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tableDescriptions;
    private javax.swing.JTable tableProps;
    // End of variables declaration//GEN-END:variables

}