package dao;
import modelo.Partidos;
/**
 * @author Javier Epifanio
 */

public interface PartidoDAO extends DAO<Partidos,Integer> {
	/**
	 * Obtiene un parido mediante su clave primaria Id.
	 */
	String get(Integer id);
	
	/**
	 * Borra un partido 
	 */
	String delete(Integer id);

}