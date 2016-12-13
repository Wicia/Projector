/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.gui.windows.elements.data.common;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 * @TODO: Add description to: class, fields, methods
 * @author Michał 'Wicia' Wietecha
 */
public abstract class ATableData<Row, Entity> extends AbstractTableModel {
    
    private JTable table;
    private List<Row> data;
    private String[] columnsNames;
    
    public ATableData(JTable table, String[] columnsNames){
        this.data = new LinkedList<>();
        this.table = table;
        this.columnsNames = columnsNames;
    }
    
    public void clearData(){
        this.data.clear();
        fireTableDataChanged();
    }
    
    public void addNewRow(Row entity){
        this.data.add(entity);
        fireTableDataChanged();
    }
    
    public abstract void addNewRow();
    
    @Override
    public int getColumnCount() {
        return columnsNames.length;
    }

    @Override
    public int getRowCount() {
        return this.data.size();
    }

    @Override
    public String getColumnName(int col) {
        return this.columnsNames[col];
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
        int selectedRow = this.table.getSelectedRow();
        this.removeRow(selectedRow);
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
        return true;
    }
    
    @Override
    public abstract void setValueAt(Object value, int row, int column);
    
    @Override
    public abstract Object getValueAt(int rowIndex, int columnIndex);

    public void downSelectedRow() {
        int selectedRow = this.table.getSelectedRow();
        if(selectedRow > 0){
            Collections.swap(this.data, selectedRow, selectedRow - 1);
            this.fireTableDataChanged();
        }
    }

    public void upSelectedRow() {
        int selectedRow = this.table.getSelectedRow();
        if(selectedRow != this.data.size() - 1){
            Collections.swap(this.data, selectedRow, selectedRow + 1);
            this.fireTableDataChanged();
        }
    }

    public JTable getTable() {
        return table;
    }

    public List<Row> getData() {
        return data;
    }

    public String[] getColumnsNames() {
        return columnsNames;
    }
    
    public abstract List<Entity> getListEntities();
}