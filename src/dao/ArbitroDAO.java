package dao;
import modelo.Arbitros;

/**
 * 
 * @author Javier Epifanio
 *
 */

public interface ArbitroDAO extends DAO <Arbitros, Integer>{
	/**
	 * Obtiene un arbitro mediante su clave primaria Id.
	 */
	String get(Integer id);
	
	/**
	 * Borra un arbitro y los partidos que estan asociados a este.
	 */
	String delete(Integer id);
}
