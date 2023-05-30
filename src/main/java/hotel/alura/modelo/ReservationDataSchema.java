package hotel.alura.modelo;

import java.math.BigDecimal;
import java.sql.Date;

public interface ReservationDataSchema {
  long getId();
  Date getEntryDate();
  Date getDepartureDate();
  BigDecimal getCost();
  String getPaymentMethod();
}
