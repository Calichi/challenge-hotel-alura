package hotel.alura.views.busqueda.components;

import javax.swing.table.DefaultTableModel;

public class ReservationsTable extends BaseTable {

  @Override
  void defineDataSchema(DefaultTableModel model) {
    model.addColumn("Numero de Reserva");
		model.addColumn("Fecha Check In");
		model.addColumn("Fecha Check Out");
		model.addColumn("Valor");
		model.addColumn("Forma de Pago");
  }
  
}
