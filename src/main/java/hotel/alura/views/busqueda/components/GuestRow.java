package hotel.alura.views.busqueda.components;

import java.sql.Date;

import javax.swing.table.DefaultTableModel;

import hotel.alura.modelo.GuestDataSchema;

public class GuestRow
        extends BaseRow
          implements GuestDataSchema {

  public GuestRow(DefaultTableModel model, int index) {
    super(model, index);
  }

  @Override
  public long getId() {
    return this.asLong(this.getCellValue(0));
  }
  
  @Override
  public String getName() {
    return this.asString(this.getCellValue(1));
  }

  @Override
  public String getLastName() {
    return this.asString(this.getCellValue(2));
  }
  
  @Override
  public Date getBirthdate() {
    return this.asDate(this.getCellValue(3));
  }

  @Override
  public String getNacionality() {
    return this.asString(this.getCellValue(4));
  }

  @Override
  public String getPhonenumber() {
    return this.asString(this.getCellValue(5));
  }

  @Override
  public long getReservationId() {
    return this.asLong(this.getCellValue(6));
  }

}
