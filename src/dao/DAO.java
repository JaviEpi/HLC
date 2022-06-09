package dao;
import java.util.List;

import excepciones.FechaException;
import excepciones.LongitudDeDatosException;

/**
 * 
 * @author Javier Epifanio L�pez
 *
 * @param <T>
 * @param <K>
 */
public interface DAO<T, K> {
  String insert(T a);

  List<T> getAll() throws LongitudDeDatosException, FechaException;

  String get(K String);

}
