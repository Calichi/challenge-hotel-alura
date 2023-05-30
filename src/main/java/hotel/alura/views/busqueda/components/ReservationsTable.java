package hotel.alura.views.busqueda.components;

import javax.swing.table.DefaultTableModel;

import hotel.alura.modelo.ReservationDataSchema;

public class ReservationsTable extends BaseTable {

  @Override
  void defineDataSchema(DefaultTableModel model) {
    model.addColumn("Numero de Reserva");
		model.addColumn("Fecha Check In");
		model.addColumn("Fecha Check Out");
		model.addColumn("Valor");
		model.addColumn("Forma de Pago");
  }

  @Override
  public ReservationDataSchema getDataFrom(DefaultTableModel model, int row) {
    return new ReservationRow(model, row);
  }

  @Override
  public ReservationDataSchema getDataFrom(int row) {
    return (ReservationDataSchema)super.getDataFrom(row);
  }

  @Override
  public ReservationDataSchema getDataFromSelectedRow() {
    return (ReservationDataSchema)super.getDataFromSelectedRow();
  }
  
}
