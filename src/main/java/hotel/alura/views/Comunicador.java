package hotel.alura.views;

import java.awt.Component;
import javax.swing.JOptionPane;

public class Comunicador {

  public static void informarNumeroInvalido(Component ventana) {
    String titulo = "Número invalido";
    String mensaje = "¡Solo se permiten caracteres númericos!";
    JOptionPane.showMessageDialog(ventana, mensaje, titulo, JOptionPane.OK_OPTION);
  }

  public static void informarReservaNoEncontrada(Component ventana) {
    String titulo = "Reserva no encontrada";
    String mensaje = "¡No existe ninguna reserva que tenga asignado el número que proporciono!";
    JOptionPane.showMessageDialog(ventana, mensaje, titulo, JOptionPane.OK_OPTION);
  }

  public static void informarModificacionExitosa(Component ventana) {
    String titulo = "Modificación Exitosa";
    String mensaje = "¡Los cambios realizados fueron almacenados exitosamente!";
    JOptionPane.showMessageDialog(ventana, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
  }

  public static void informarEliminacionExistosa(Component window) {
    String titulo = "Eliminación Exitosa";
    String mensaje = "¡El huesped y su correspondiente reserva han sido removidos con exito!";
    JOptionPane.showMessageDialog(window, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
  }

}
