package hotel.alura.views.busqueda.components;

import java.math.BigDecimal;
import java.sql.Date;

import javax.swing.table.DefaultTableModel;

public abstract class BaseRow {
  private int index;
  private DefaultTableModel model;

  public BaseRow(DefaultTableModel model, int index) {
    this.model = model;
    this.index = index;
  }

  protected Object getCellValue(int column) {
    return this.model.getValueAt(index, column);
  }

  protected String asString(Object value) {
    return value.toString();
  }

  protected long asLong(Object value) {
    return (long)value;
  }

  protected Date asDate(Object value) {
    return Date.valueOf(this.asString(value));
  }

  protected BigDecimal asBigDecimal(Object value) {
    return new BigDecimal(this.asString(value));
  }
}
