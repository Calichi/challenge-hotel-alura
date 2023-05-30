package hotel.alura.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.JTable;

import hotel.alura.dao.ReservaDao;
import hotel.alura.modelo.Reserva;
import hotel.alura.modelo.ReservationDataSchema;

public class ReservaController extends BaseController {

  private ReservaDao dao;

  public ReservaController(EntityManager em) {
    this.dao = new ReservaDao(em);
  }

  public void guardar(Reserva r) {
    dao.guardar(r);
  }

  public List<Reserva> listar() {
    return dao.listar();
  }

  public Reserva findBy(long reservaId) {
    return dao.buscarPorId(reservaId);
  }

  public Reserva findIn(JTable table) {
    long id = extractId(table);
    return findBy(id);
  }

  public void updateFrom(ReservationDataSchema data) {
    Reserva reservation = this.findBy(data.getId());
    reservation.setEntrada(data.getEntryDate());
    reservation.setSalida(data.getDepartureDate());
    reservation.setCosto(data.getCost());
    reservation.setFormaDePago(data.getPaymentMethod());
  }

  public void remover(Reserva reservation) {
    this.dao.remover(reservation);
  }

  public void remover(long id) {
    Reserva reservation = this.findBy(id);
    this.remover(reservation);
  }

  //Busca y elimina el elemento actualmente seleccionado en la tabla
  public void remover(JTable table) {
    this.remover(this.findIn(table));
  }
  
}
