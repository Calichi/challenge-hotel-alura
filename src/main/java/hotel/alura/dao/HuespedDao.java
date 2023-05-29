package hotel.alura.dao;

import java.util.List;

import javax.persistence.EntityManager;

import hotel.alura.modelo.Huesped;
import hotel.alura.modelo.Reserva;

public class HuespedDao {

  private EntityManager em;

  public HuespedDao(EntityManager em) {
    this.em = em;
  }

  public void guardar(Huesped huesped) {
    em.persist(huesped);
  }

  public List<Huesped> listar() {
    String consulta = "SELECT H FROM Huesped AS H";
    return em.createQuery(consulta, Huesped.class).getResultList();
  }

  public List<Huesped> buscarPorApellido(String apellido) {
    return em.createNamedQuery("Huesped.buscarPorApellido", Huesped.class)
              .setParameter("apellido", apellido)
              .getResultList();
  }

  public Huesped buscarPorReserva(Reserva reserva) {
    String consulta = "SELECT h FROM Huesped AS h JOIN h.reserva AS r where r.id = :id";
    return em.createQuery(consulta, Huesped.class)
              .setParameter("id", reserva.getId())
              .getSingleResult();
  }

  public Huesped buscarPorId(long id) {
    return em.find(Huesped.class, id);
  }

  public void remover(Huesped guest) {
    this.em.remove(guest);
  }
  
}
