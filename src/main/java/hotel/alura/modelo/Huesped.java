package hotel.alura.modelo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity @Table(name="huespedes")
@NamedQuery(name = "Huesped.buscarPorApellido", query = "SELECT h FROM Huesped h WHERE apellido = :apellido")
public class Huesped implements RowDataProvider {

  public static final String TITULO = "Huéspedes";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String nombre;
  private String apellido;
  @Temporal(TemporalType.DATE)
  private Date nacimiento;
  private String nacionalidad;
  private String telefono;
  @OneToOne
  private Reserva reserva;

  public Huesped() {}

  public Huesped(String nombre, String apellido, Date nacimiento, String nacionalidad,String telefono, Reserva reserva) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.nacimiento = nacimiento;
    this.nacionalidad = nacionalidad;
    this.telefono = telefono;
    this.reserva = reserva;
  }

  public String getNacionalidad() {
    return nacionalidad;
  }

  public void setNacionalidad(String nacionalidad) {
    this.nacionalidad = nacionalidad;
  }
  
  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public String getApellido() {
    return apellido;
  }
  public void setApellido(String apellido) {
    this.apellido = apellido;
  }
  public Date getNacimiento() {
    return nacimiento;
  }
  public void setNacimiento(Date nacimiento) {
    this.nacimiento = nacimiento;
  }
  public String getTelefono() {
    return telefono;
  }
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }
  public Reserva getReserva() {
    return reserva;
  }
  public void setReserva(Reserva reserva) {
    this.reserva = reserva;
  }

  public Object[] toArray() {
    return new Object[] {
      id,
      nombre,
      apellido,
      nacimiento,
      nacionalidad,
      telefono,
      reserva.getId()
    };
  }
}
