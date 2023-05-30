package hotel.alura.modelo;

import java.sql.Date;

public interface GuestDataSchema {
  long getId();
  String getName();
  String getLastName();
  Date getBirthdate();
  String getNacionality();
  String getPhonenumber();
  long getReservationId();
}
