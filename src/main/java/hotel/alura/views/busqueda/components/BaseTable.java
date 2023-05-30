package hotel.alura.views.busqueda.components;

import java.awt.Font;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public abstract class BaseTable extends JTable {

  public BaseTable() {
    this.defineDataSchema(this.getModel());
    this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setFont(new Font("Roboto", Font.PLAIN, 16));
  }

  //Define el esquema de datos de la tabla
  abstract void defineDataSchema(DefaultTableModel model);

  //Lógica base de la obtención de datos
  abstract Object getDataFrom(DefaultTableModel model, int row);

  public Object getDataFrom(int row) {
    return this.getDataFrom(this.getModel(), row);
  }

  public Object getDataFromSelectedRow() {
    return this.getDataFrom(this.getSelectedRow());
  }

  @Override
  public DefaultTableModel getModel() {
    return (DefaultTableModel)super.getModel();
  }
  
}
