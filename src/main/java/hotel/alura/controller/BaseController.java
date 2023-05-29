package hotel.alura.controller;

import javax.swing.JTable;

import hotel.alura.views.model.Row;

public abstract class BaseController {

  public long extractId(JTable table) {
    Row row = new Row(table);
    return (long)row.getNextField();
  }
  
}
