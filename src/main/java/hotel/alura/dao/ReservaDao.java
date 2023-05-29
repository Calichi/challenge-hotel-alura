package hotel.alura.dao;

import java.util.List;

import javax.persistence.EntityManager;

import hotel.alura.modelo.Reserva;

public class ReservaDao {

  private EntityManager em;

  public ReservaDao(EntityManager em) {
    this.em = em;
  }

  public void guardar(Reserva r) {
    em.persist(r);
  }

  public List<Reserva> listar() {
    String queryString = "SELECT R FROM Reserva AS R";
    return em.createQuery(queryString, Reserva.class).getResultList();
  }

  public Reserva buscarPorId(Long reservaId) {
    String queryString = "SELECT R FROM Reserva AS R WHERE R.id = :id";
    return em.createQuery(queryString, Reserva.class)
             .setParameter("id", reservaId)
             .getSingleResult();
  }

  public void remover(Reserva reservation) {
    this.em.remove(reservation);
  }

}
