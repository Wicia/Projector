/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.wicia.projector.gui.windows.elements.data.tab_elements;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import pl.wicia.projector.database.entities.description.DescriptionEntity;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
//TODO: Jakie metody z klas modeli dać do klasy wspólnej?
public class DescriptionsTableModel extends AbstractTableModel {

    private List<DescriptionTableRow> data;
    private BiMap<Integer, String> mapColumns;
    private int defaultTableWidth;

    public static DescriptionsTableModel loadModel(JTable table) {
        return new DescriptionsTableModel(table);
    }

    //TODO: Refactoring
    private DescriptionsTableModel(JTable table) {
        this.data = new LinkedList<>();
        this.initColumnsData();
        table.setModel(this);
        this.initColumnWidth(table);
    }

    private void initColumnsData() {
        this.mapColumns = HashBiMap.create();
        this.mapColumns.put(0, "Zaznacz");
        this.mapColumns.put(1, "Nazwa");
        this.mapColumns.put(2, "Opis");
    }

    private void initColumnWidth(JTable table) {
        this.defaultTableWidth = table.getWidth();
        Enumeration<TableColumn> columns = table.getColumnModel().getColumns();
        int colIndex = 0;
        int[] colWidths = new int[]{10, 30, 60};
        while (columns.hasMoreElements()) {
            TableColumn column = columns.nextElement();
            column.setPreferredWidth((defaultTableWidth*colWidths[colIndex])/100);
            colIndex++;
        }
    }
    
    public void addNewRow(DescriptionEntity entity){
        this.data.add(new DescriptionTableRow(entity));
        fireTableDataChanged();
    }
    
    public void addNewRow() {
        this.data.add(new DescriptionTableRow(false, "", ""));
        fireTableDataChanged();
    }
    
    public void clearData(){
        this.data.clear();
        fireTableDataChanged();
    }

    @Override
    public int getColumnCount() {
        return mapColumns.size();
    }

    @Override
    public int getRowCount() {
        return this.data.size();
    }

    @Override
    public String getColumnName(int col) {
        return this.mapColumns.get(col);
    }

    @Override
    public Class getColumnClass(int column) {
        return this.getValueAt(0, column).getClass();
    }
    
    public void removeRow(int row) {
        data.remove(row);
        fireTableRowsDeleted(row, row);
    }

    public void removeSelectedRows() {
        for (int index = data.size() - 1; index >= 0; --index) {
            if (data.get(index).isSelected()) {
                this.removeRow(index);
            }
        }
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return true;
    }
    
    @Override
    public void setValueAt(Object value, int row, int column) {
        if (value instanceof Boolean && column == 0) {
            data.get(row).setSelected((boolean) value);
        }
        if (value instanceof String && column == 1) {
            data.get(row).setName((String) value);
        }
        if (value instanceof String && column == 2) {
            data.get(row).setDesc((String) value);
        }
        fireTableCellUpdated(row, column);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
        case 0:
            return data.get(rowIndex).isSelected();
        case 1:
            return data.get(rowIndex).getName();
        case 2:
            return data.get(rowIndex).getDesc();
        default:
            return "";
        }
    }
    
    public List<DescriptionEntity> getListEntities(){
        List<DescriptionEntity> rList = new ArrayList<>();
        int position = 0;
        for(DescriptionTableRow element : this.data){
            rList.add(new DescriptionEntity(element, position));
            position++;
        }
        return rList;
    }
}