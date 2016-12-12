/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.wicia.projector.gui.windows.elements.data.props;

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
import pl.wicia.projector.database.entities.props.PropEntity;
import pl.wicia.projector.gui.windows.elements.data.elements.DescriptionTableRow;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class PropsTableModel extends AbstractTableModel {

    private List<PropsTableRow> data;
    private BiMap<Integer, String> mapColumns;
    private int defaultTableWidth;

    public static PropsTableModel loadModel(JTable table) {
        return new PropsTableModel(table);
    }

    //TODO: Refactoring
    private PropsTableModel(JTable table) {
        this.data = new LinkedList<>();
        this.initColumnsData();
        table.setModel(this);
        this.initColumnWidth(table);
    }

    private void initColumnsData() {
        this.mapColumns = HashBiMap.create();
        this.mapColumns.put(0, "Zaznacz");
        this.mapColumns.put(1, "Ilość");
        this.mapColumns.put(2, "Rekwizyt");
    }

    private void initColumnWidth(JTable table) {
        this.defaultTableWidth = table.getWidth();
        Enumeration<TableColumn> columns = table.getColumnModel().getColumns();
        int colIndex = 0;
        int[] colWidths = new int[]{10, 10, 80};
        while (columns.hasMoreElements()) {
            TableColumn column = columns.nextElement();
            column.setPreferredWidth((defaultTableWidth*colWidths[colIndex])/100);
            colIndex++;
        }
    }
    
    public void clearData(){
        this.data.clear();
        fireTableDataChanged();
    }
    
    public void addNewRow(PropEntity entity){
        this.data.add(new PropsTableRow(entity));
        fireTableDataChanged();
    }
    
    public void addNewRow() {
        this.data.add(new PropsTableRow(false, 1, ""));
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
        if (value instanceof Integer && column == 1) {
            data.get(row).setCount((Integer) value);
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
            return data.get(rowIndex).getCount();
        case 2:
            return data.get(rowIndex).getDesc();
        default:
            return "";
        }
    }
    
    public List<PropEntity> getListEntities(){
        List<PropEntity> rList = new ArrayList<>();
        this.data.stream().forEach((prop) -> {
            rList.add(new PropEntity(prop));
        });
        return rList;
    }
}