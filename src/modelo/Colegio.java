package modelo;
import excepciones.LongitudDeDatosException;

/**
 * Representacion de datos de arbitros
 * 
 * @author Javier Epifanio
 */
public class Colegio {
    private String nombre;
    private String presidente;
    private Integer numArbitros;
    private String lugar;

    public Colegio(String nombre, String presidente, Integer numArbitros, String lugar) throws LongitudDeDatosException {
        setNombre(nombre);
        setPresidente(presidente);
        setNumArbitros(numArbitros);
        setLugar(lugar);
    }

    public Colegio(Colegio object) throws LongitudDeDatosException {
        setNombre(object.getNombre());
        setPresidente(object.getPresidente());
        setNumArbitros(object.getNumArbitros());
        setLugar(object.getLugar());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws LongitudDeDatosException {
        if (nombre.length() > 256) {
            throw new LongitudDeDatosException("El nombre no puede tener mas de 256 caracteres");
        }
        this.nombre = nombre;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) throws LongitudDeDatosException {
        if (presidente.length() > 80) {
            throw new LongitudDeDatosException("El presidente no puede tener mas de 80 caracteres");
        }
        this.presidente = presidente;
    }

    public Integer getNumArbitros() {
        return numArbitros;
    }

    public void setNumArbitros(Integer numArbitros) {
        this.numArbitros = numArbitros;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) throws LongitudDeDatosException {
        if (lugar.length() > 256) {
            throw new LongitudDeDatosException("El lugar no puede tener mas de 256 caracteres");
        }
        this.lugar = lugar;
    }

    // Método toString
    @Override
    public String toString() {
        return "Colegio{" +
                "nombre='" + nombre + '\'' +
                ", presidente='" + presidente + '\'' +
                ", numArbitros=" + numArbitros +
                ", lugar='" + lugar + '\'' +
                '}';
    }
}
