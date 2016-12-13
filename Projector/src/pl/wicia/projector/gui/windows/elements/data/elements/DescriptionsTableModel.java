/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.wicia.projector.gui.windows.elements.data.elements;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import pl.wicia.projector.database.entities.description.DescriptionEntity;
import pl.wicia.projector.gui.windows.elements.data.common.ATableData;
import pl.wicia.projector.gui.windows.elements.data.props.PropsTableRow;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
//TODO: Jakie metody z klas modeli dać do klasy wspólnej?
public class DescriptionsTableModel 
        extends ATableData<DescriptionTableRow, DescriptionEntity> {

    public static DescriptionsTableModel loadModel(JTable table) {
        return new DescriptionsTableModel(table, 
                new String[]{"Nazwa", "Opis"});
    }

    private DescriptionsTableModel(JTable table, String[] cols) {
        super(table, cols);
        table.setModel(this);
        this.initColumnWidth();
    }

    private void initColumnWidth() {
        int defaultTableWidth = super.getTable().getWidth();
        Enumeration<TableColumn> columns = super.getTable().getColumnModel().getColumns();
        int colIndex = 0;
        int[] colWidths = new int[]{30, 70};
        while (columns.hasMoreElements()) {
            TableColumn column = columns.nextElement();
            column.setPreferredWidth((defaultTableWidth*colWidths[colIndex])/100);
            colIndex++;
        }
    }
    
    public void addNewRow(DescriptionEntity entity){
        super.addNewRow(new DescriptionTableRow(entity));
    }
    
    @Override
    public void setValueAt(Object value, int row, int column) {
        if (value instanceof String && column == 0) {
            super.getData().get(row).setName((String) value);
        }
        if (value instanceof String && column == 1) {
            super.getData().get(row).setDesc((String) value);
        }
        fireTableCellUpdated(row, column);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return super.getData().get(rowIndex).getName();
            case 1:
                return super.getData().get(rowIndex).getDesc();
            default:
                return "";
        }
    }

    @Override
    public void addNewRow() {
        super.addNewRow(new DescriptionTableRow("", ""));
    }

    @Override
    public List<DescriptionEntity> getListEntities() {
        List<DescriptionEntity> rList = new ArrayList<>();
        int position = 0;
        for(DescriptionTableRow element : super.getData()){
            rList.add(new DescriptionEntity(element, position));
            position++;
        }
        return rList;
    }
}