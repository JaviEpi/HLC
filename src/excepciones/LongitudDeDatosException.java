package excepciones;
/**
 * Si superas la cantidad de datos maximos establecidos en la BBDD
 * @author Javier Epifanio L�pez
 *
 */
public class LongitudDeDatosException extends Exception {

  private static final long serialVersionUID = 4760983661709172079L;

  public LongitudDeDatosException(String string) {
    super(string);
  }
}
