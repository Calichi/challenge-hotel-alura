package hotel.alura.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.JTable;

import hotel.alura.dao.HuespedDao;
import hotel.alura.modelo.GuestDataSchema;
import hotel.alura.modelo.Huesped;
import hotel.alura.modelo.Reserva;

public class HuespedController extends BaseController {

  private HuespedDao dao;

  public HuespedController(EntityManager em) {
    this.dao = new HuespedDao(em);
  }

  public void guardar(Huesped huesped) {
    dao.guardar(huesped);
  }

  public List<Huesped> listar() {
    return dao.listar();
  }

  public List<Huesped> buscarPorApellido(String apellido) {
    return dao.buscarPorApellido(apellido);
  }

  public Huesped findBy(long id) {
    return this.dao.buscarPorId(id);
  }
  
  public Huesped findBy(Reserva reservation) {
    return this.dao.buscarPorReserva(reservation);
  }
  
  public Huesped findIn(JTable table) {
    long id = extractId(table);
    return findBy(id);
  }

  public void remover(Huesped guest) {
    this.dao.remover(guest);
  }

  public void updateFrom(GuestDataSchema data) {
    Huesped guest = this.findBy(data.getId());
    guest.setNombre(data.getName());
    guest.setApellido(data.getLastName());
    guest.setNacimiento(data.getBirthdate());
    guest.setNacionalidad(data.getNacionality());
    guest.setTelefono(data.getPhonenumber());
  }

}
