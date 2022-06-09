package excepciones;
/**
 * Si superas la cantidad de datos maximos establecidos en la BBDD
 * @author Javier Epifanio L�pez
 *
 */
public class PrecioException extends Exception {
    private static final long serialVersionUID = 4760983661709172079L;
    public PrecioException(double precio) {
        super("El precio " + precio + " no es correcto");
    }
}