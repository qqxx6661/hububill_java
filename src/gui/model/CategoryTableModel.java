package gui.model;

import entity.Category;
import service.CategoryService;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class CategoryTableModel extends AbstractTableModel {

    String[] columnNames = new String[]{"分类名称", "消费次数"};

    public List<Category> cs = new CategoryService().list();

    public int getRowCount() {
        return cs.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }


    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }


    public Object getValueAt(int rowIndex, int columnIndex) {
        Category h = cs.get(rowIndex);
        if(0==columnIndex)
            return h.name;
        if(1==columnIndex)
            return h.recordNumber;
        return null;
    }
}
