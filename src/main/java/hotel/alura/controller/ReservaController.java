package hotel.alura.controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import hotel.alura.dao.ReservaDao;
import hotel.alura.modelo.Reserva;

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

  public void updateFromTable(JTable table) {
    int rowIndex = table.getSelectedRow();
    TableModel model = table.getModel();

    //Extraer los datos de la tabla
    long id = (Long)model.getValueAt(rowIndex, 0);
    Date fechaDeEntrada = Date.valueOf(model.getValueAt(rowIndex, 1).toString());
    Date fechaDeSalida = Date.valueOf(model.getValueAt(rowIndex, 2).toString());
    BigDecimal costo = new BigDecimal(model.getValueAt(rowIndex, 3).toString());
    String formaDePago = model.getValueAt(rowIndex, 4).toString();

    //Recuperar la entidad y actualizar sus datos
    Reserva reservation = findBy(id);
    reservation.setEntrada(fechaDeEntrada);
    reservation.setSalida(fechaDeSalida);
    reservation.setCosto(costo);
    reservation.setFormaDePago(formaDePago);
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
