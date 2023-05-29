package hotel.alura.modelo;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
public interface RowDataProvider {
  
  public static List<RowDataProvider> from(List<?> list) {
    List<RowDataProvider> result = new ArrayList<>();
    list.forEach(item -> {
      if(item instanceof RowDataProvider) {
        result.add((RowDataProvider)item);
      }
    });
    return result;
  }
  
  Object[] toArray();
}
