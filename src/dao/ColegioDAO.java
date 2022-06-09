package dao;
import modelo.Colegio;
/**
 * @author Javier Epifanio
 */
public interface ColegioDAO extends DAO <Colegio, String> {
	/**
	 * Obtiene el colegio mediante su nombre
	 * @param nombre
	 * @return
	 */
	String get(String nombre);
	/**
	 * Borra un colegio y los arbitros que tiene asociados al mismo
	 * @param nombre
	 * @return
	 */
	String delete(String nombre);
}
