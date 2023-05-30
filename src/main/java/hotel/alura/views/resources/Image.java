package hotel.alura.views.resources;

import java.net.URL;

import javax.swing.ImageIcon;

import hotel.alura.views.busqueda.View;

public final class Image extends ImageIcon{

  private final static String ROOT_DIRECTORY = "./../../imagenes/";
  private final static String FILE_EXTENSION = ".png";

  //Iconos de la interfaz gráfica
  public final static Image RESERVATIONS = get("reservado");
  public final static Image GUESTS = get("pessoas");
  public final static Image LOGO_100PX = get("Ha-100px");

  public static final URL LUPA2_URL = getUrl("lupa2");

  public static Image get(String filename) {
    URL url = getUrl(filename);
    return new Image(url);
  }

  public static URL getUrl(String filename) {
    String path = ROOT_DIRECTORY + filename + FILE_EXTENSION;
    return View.class.getResource(path);
  }

  public Image(URL url) {
    super(url);
  }
}
