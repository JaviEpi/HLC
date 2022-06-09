package modelo;

import excepciones.LongitudDeDatosException;
/**
 * Representacion de datos de arbitros
 * 
 * @author Javier Epifanio
 */

public class Partidos {
    private Integer id;
    private String EquipoLocal;
    private String EquipoVisitante;
    private String nombreArbitro;
    private Double precio;
    private Integer idArbitro;

    public Partidos(Integer id, String EquipoLocal, String EquipoVisitante, String nombreArbitro, Double precio) throws LongitudDeDatosException {
        this.id = id;
        this.EquipoLocal = EquipoLocal;
        this.EquipoVisitante = EquipoVisitante;
        this.nombreArbitro = nombreArbitro;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipoLocal() {
        return EquipoLocal;
    }

    public void setEquipoLocal(String EquipoLocal) throws LongitudDeDatosException {
        if (EquipoLocal.length() > 100) {
            throw new LongitudDeDatosException("El nombre no puede tener mas de 100 caracteres");
        }
        this.EquipoLocal = EquipoLocal;
    }

    public String getEquipoVisitante() {
        return EquipoVisitante;
    }

    public void setEquipoVisitante(String EquipoVisitante) throws LongitudDeDatosException {
        if (EquipoVisitante.length() > 100) {
            throw new LongitudDeDatosException("El nombre no puede tener mas de 100 caracteres");
        }
        this.EquipoVisitante = EquipoVisitante;
    }

    public String getNombreArbitro() {
        return nombreArbitro;
    }

    public void setNombreArbitro(String nombreArbitro) throws LongitudDeDatosException {
        if (nombreArbitro.length() > 120) {
            throw new LongitudDeDatosException("El nombre no puede tener mas de 120 caracteres");
        }
        this.nombreArbitro = nombreArbitro;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getIdArbitro() {
        return idArbitro;
    }

    public void setIdArbitro(Integer idArbitro) {
        this.idArbitro = idArbitro;
    }

	@Override
	public String toString() {
		return "Partidos [id=" + id + ", EquipoLocal=" + EquipoLocal + ", EquipoVisitante=" + EquipoVisitante
				+ ", nombreArbitro=" + nombreArbitro + ", precio=" + precio + ", idArbitro=" + idArbitro + "]";
	}
    
    
    
}
