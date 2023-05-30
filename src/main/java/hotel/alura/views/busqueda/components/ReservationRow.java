package hotel.alura.views.busqueda.components;

import java.math.BigDecimal;
import java.sql.Date;

import javax.swing.table.DefaultTableModel;

import hotel.alura.modelo.ReservationDataSchema;

public class ReservationRow
        extends BaseRow
          implements ReservationDataSchema {

  public ReservationRow(DefaultTableModel model, int index) {
    super(model, index);
  }

  @Override
  public long getId() {
    return this.asLong(this.getCellValue(0));
  }

  @Override
  public Date getEntryDate() {
    return this.asDate(this.getCellValue(1));
  }

  @Override
  public Date getDepartureDate() {
    return this.asDate(this.getCellValue(2));
  }

  @Override
  public BigDecimal getCost() {
    return this.asBigDecimal(this.getCellValue(3));
  }

  @Override
  public String getPaymentMethod() {
    return this.asString(this.getCellValue(4));
  }
  
}
