package excepciones;

import java.util.Date;

/**
 * Si superas la cantidad de datos maximos establecidos en la BBDD
 * @author Javier Epifanio L�pez
 *
 */
public class FechaException extends Exception {
    // ecepcion de fecha 
    private static final long serialVersionUID = 4760983661709172079L;
    public FechaException(Date fechaNac) {
        super("La fecha " + fechaNac + " no es correcta");
    }
    public FechaException(String string) {
        super(string);
    }
}