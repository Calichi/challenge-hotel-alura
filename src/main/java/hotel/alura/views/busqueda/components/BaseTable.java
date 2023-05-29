package hotel.alura.views.busqueda.components;

import java.awt.Font;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public abstract class BaseTable extends JTable {

  public BaseTable() {
    this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setFont(new Font("Roboto", Font.PLAIN, 16));
  }
  
}
