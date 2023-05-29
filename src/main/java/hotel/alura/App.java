package hotel.alura;

import hotel.alura.controller.HuespedController;
import hotel.alura.controller.ReservaController;
import hotel.alura.views.MenuPrincipal;
import java.awt.EventQueue;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class App implements Runnable {

  private final static EntityManager ENTITY_MANAGER;
  private final static HuespedController HUESPED_CONTROLLER;
  private final static ReservaController RESERVA_CONTROLLER;

  public static EntityManager getEntityManager() {
    return ENTITY_MANAGER;
  }

  public static HuespedController getHuespedController() {
    return HUESPED_CONTROLLER;
  }

  public static ReservaController getReservaController() {
    return RESERVA_CONTROLLER;
  }

  static {
    ENTITY_MANAGER = Persistence.createEntityManagerFactory("hotel_alura")
                                  .createEntityManager();
    HUESPED_CONTROLLER = new HuespedController(ENTITY_MANAGER);
    RESERVA_CONTROLLER = new ReservaController(ENTITY_MANAGER);
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(new App());
  }

  public static void iniciarTransaccion() {
    ENTITY_MANAGER.getTransaction().begin();
  }

  public static void confirmarTransaccion() {
    ENTITY_MANAGER.getTransaction().commit();
  }

  @Override
  public void run() {
    new MenuPrincipal();
  }
  
}