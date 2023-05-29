package hotel.alura.modelo;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.concurrent.TimeUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="reservas")
public class Reserva implements RowDataProvider {

  public static final String TITULO = "Reservas";
  private static final int CUOTA_DIARIA = 200;

  public static BigDecimal calcularCosto(Date entrada, Date salida) {
    long diferencia = salida.getTime() - entrada.getTime();
    long dias = TimeUnit.DAYS.convert(diferencia, TimeUnit.MILLISECONDS) + 1;
    return new BigDecimal(dias * CUOTA_DIARIA);
  }
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Temporal(TemporalType.DATE)
  private Date entrada;
  @Temporal(TemporalType.DATE)
  private Date salida;
  private BigDecimal costo;
  private String formaDePago;

  public Reserva() {}
  
  public Reserva(Date entrada, Date salida, BigDecimal costo, String formaDePago) {
    this.entrada = entrada;
    this.salida = salida;
    this.costo = costo;
    this.formaDePago = formaDePago;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
  public Date getEntrada() {
    return entrada;
  }

  public void setEntrada(Date entrada) {
    this.entrada = entrada;
  }

  public Date getSalida() {
    return salida;
  }

  public void setSalida(Date salida) {
    this.salida = salida;
  }

  public BigDecimal getCosto() {
    return costo;
  }

  public void setCosto(BigDecimal costo) {
    this.costo = costo;
  }

  public String getFormaDePago() {
    return formaDePago;
  }

  public void setFormaDePago(String formaDePago) {
    this.formaDePago = formaDePago;
  }

  public Object[] toArray() {
    return new Object[] {
      id,
      entrada,
      salida,
      costo,
      formaDePago
    };
  }

}
