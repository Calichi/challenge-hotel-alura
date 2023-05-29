package hotel.alura.views.busqueda.components;

import javax.swing.table.DefaultTableModel;

public class GuestsTable extends BaseTable {
  
  public GuestsTable() {
    this.defineDataSchema();
  }

  //Define el esquema de datos de la tabla
  private void defineDataSchema() {
    DefaultTableModel model = (DefaultTableModel)this.getModel();
    model.addColumn("Número de Huesped");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Fecha de Nacimiento");
		model.addColumn("Nacionalidad");
		model.addColumn("Telefono");
		model.addColumn("Número de Reserva");
  }

}
