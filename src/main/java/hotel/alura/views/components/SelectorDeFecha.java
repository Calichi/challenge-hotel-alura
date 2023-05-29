package hotel.alura.views.components;

import java.sql.Date;

import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class SelectorDeFecha extends JDateChooser {
  
  private String obtenerFechaComoString() {
    return ((JTextField)this.getDateEditor().getUiComponent()).getText();
  }

  public Date obtenerFecha() {
    try {
      return Date.valueOf(this.obtenerFechaComoString());
    } catch(IllegalArgumentException e) {
      return null;
    }
  }

}
