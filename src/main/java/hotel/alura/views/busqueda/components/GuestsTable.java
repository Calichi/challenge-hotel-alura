package hotel.alura.views.busqueda.components;

import javax.swing.table.DefaultTableModel;

import hotel.alura.modelo.GuestDataSchema;

//DTO para tabla de huespedes
public class GuestsTable
					extends BaseTable {

  @Override
  void defineDataSchema(DefaultTableModel model) {
    model.addColumn("Número de Huesped");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Fecha de Nacimiento");
		model.addColumn("Nacionalidad");
		model.addColumn("Telefono");
		model.addColumn("Número de Reserva");
  }

	@Override
	public GuestDataSchema getDataFrom(DefaultTableModel model, int row) {
		return new GuestRow(model, row);
	}

	@Override
	public GuestDataSchema getDataFrom(int row) {
		return (GuestDataSchema)super.getDataFrom(row);
	}

	@Override
	public GuestDataSchema getDataFromSelectedRow() {
		 return (GuestDataSchema)super.getDataFromSelectedRow();
	}

}
