/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.gui.windows.common.tables;

import java.util.Enumeration;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

/**
 * Class representing model for tables initialized dynamically 
 * in WindowChooseList frame.
 * 
 * @author Michał 'Wicia' Wietecha
 */
public final class DynamicTableModel extends AbstractTableModel{

    private final int[] columnsWidth;
    private final String[] colNames;
    
    private int defaultTableWidth;
    private Object[][] data;
    
    public static DynamicTableModel loadModel(JTable table, int[] columnsWidth, String[] colNames) {
        DynamicTableModel model = new DynamicTableModel(columnsWidth, colNames);
        table.setModel(model);
        model.initColumnWidth(table);
        return model;
    }
    
    private DynamicTableModel(int[] columnsWidth, String[] colNames) {
        this.columnsWidth = columnsWidth;
        this.colNames = colNames;
        this.refresh(data);
    }
    
    public void refresh(Object[][] data){
        this.data = data;
    }
    
    public void initColumnWidth(JTable table) {
        this.defaultTableWidth = table.getWidth();
        Enumeration<TableColumn> columns = table.getColumnModel().getColumns();
        int colIndex = 0;
        while (columns.hasMoreElements()) {
            TableColumn column = columns.nextElement();
            column.setPreferredWidth((defaultTableWidth * columnsWidth[colIndex])/100);
            colIndex++;
        }
    }
    
    public void clearData(){
        this.data = new Object[0][0];
        fireTableDataChanged();
    }

    @Override
    public int getColumnCount() {
        return this.colNames.length;
    }

    @Override
    public int getRowCount() {
        if(this.data != null && this.data.length > 0)
            return this.data.length;
        else
            return 0;
    }

    @Override
    public String getColumnName(int col) {
        return this.colNames[col];
    }

    @Override
    public Class getColumnClass(int column) {
        if(this.data != null && this.data.length > 0)
            return this.getValueAt(0, column).getClass();
        else
            return String.class;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
    
    @Override
    public void setValueAt(Object value, int row, int column) {
        this.data[row][column] = value;
        fireTableCellUpdated(row, column);
    }
    
    public void setNewRow(Object[] values, int row) {
        this.data[row] = values;
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int row, int column) {
        return this.data[row][column];
    }
    
    public void setRowsCount(int count){
        this.data = new Object[count][this.colNames.length];
        this.fireTableDataChanged();
    }
}