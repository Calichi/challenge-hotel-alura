package hotel.alura.views.model;

import javax.swing.JTable;

public class Row {

  private JTable table;
  private int index;
  private int fieldIndex;

  public Row(JTable table, int index) {
    this.table = table;
    this.index = index;
    this.fieldIndex = 0;
  }

  public Row(JTable table) {
    this(table, table.getSelectedRow());
  }

  public Object getNextField() {
    return table.getModel().getValueAt(index, fieldIndex++);
  }
  
}
