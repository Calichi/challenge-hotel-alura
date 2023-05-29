package hotel.alura.controller;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.JTable;

import hotel.alura.dao.HuespedDao;
import hotel.alura.modelo.Huesped;
import hotel.alura.modelo.Reserva;
import hotel.alura.views.model.Row;

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
  
  public void updateFromTable(JTable table) {
    Row row = new Row(table);

    //Extraer los datos de la tabla
    long id = (long)row.getNextField();
    String name = row.getNextField().toString();
    String lastName = row.getNextField().toString();
    Date birthdate = Date.valueOf(row.getNextField().toString());
    String nationality = row.getNextField().toString();
    String phonenumber = row.getNextField().toString();

    //Recuperar la entidad y actualizar sus datos
    Huesped guest = this.findBy(id);
    guest.setNombre(name);
    guest.setApellido(lastName);
    guest.setNacimiento(birthdate);
    guest.setNacionalidad(nationality);
    guest.setTelefono(phonenumber);
  }

  public void remover(Huesped guest) {
    this.dao.remover(guest);
  }

}
