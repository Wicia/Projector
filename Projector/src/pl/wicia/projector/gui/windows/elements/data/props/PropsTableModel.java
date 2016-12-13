/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.wicia.projector.gui.windows.elements.data.props;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import pl.wicia.projector.database.entities.props.PropEntity;
import pl.wicia.projector.gui.windows.elements.data.common.ATableData;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class PropsTableModel 
        extends ATableData<PropsTableRow, PropEntity> {

    public static PropsTableModel loadModel(JTable table) {
        return new PropsTableModel(table,
            new String[]{"Ilość", "Rekwizyt"});
    }

    private PropsTableModel(JTable table, String[] columns) {
        super(table, columns);
        table.setModel(this);
        this.initColumnWidth();
    }

    private void initColumnWidth() {
        int defaultTableWidth = super.getTable().getWidth();
        Enumeration<TableColumn> columns = super.getTable().getColumnModel().
                getColumns();
        int colIndex = 0;
        int[] colWidths = new int[]{10, 90};
        while (columns.hasMoreElements()) {
            TableColumn column = columns.nextElement();
            column.setPreferredWidth((defaultTableWidth*colWidths[colIndex])/100);
            colIndex++;
        }
    }
    
    public void addNewRow(PropEntity entity) {
        super.addNewRow(new PropsTableRow(entity));
    }
    
    @Override
    public void addNewRow() {
        super.addNewRow(new PropsTableRow(1, ""));
    }
    
    @Override
    public void setValueAt(Object value, int row, int column) {
        if (value instanceof Integer && column == 0) {
            super.getData().get(row).setCount((Integer) value);
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
            return super.getData().get(rowIndex).getCount();
        case 1:
            return super.getData().get(rowIndex).getDesc();
        default:
            return "";
        }
    }

    @Override
    public List<PropEntity> getListEntities() {
        List<PropEntity> rList = new ArrayList<>();
        super.getData().stream().forEach((prop) -> {
            rList.add(new PropEntity(prop));
        });
        return rList;
    }
}