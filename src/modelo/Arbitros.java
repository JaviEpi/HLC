package modelo;
import java.util.Date;
import excepciones.LongitudDeDatosException;
import excepciones.FechaException;

/**
 * Representacion de datos de arbitros
 * @author Javier Epifanio
 */
public class Arbitros {
	private Integer id;
	private String nombre;
	private String apellidos;
	private Date fechaNac;
	private String genero;
	private String colegiacion;
	private String tallaRopa;
	
	/**
	 * 
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param fechaNac
	 * @param genero
	 * @param colegiacion
	 * @param tallaRopa
	 * @throws LongitudDeDatosException
	 */
	public Arbitros(Integer id, String nombre, String apellidos, Date fechaNac, String genero, String colegiacion, String tallaRopa) throws LongitudDeDatosException, FechaException {
		setId(id);
		setNombre(nombre);
		setApellidos(apellidos);
		setFechaNac(fechaNac);
		setGenero(genero);
		setColegiacion(colegiacion);
		setTallaRopa(tallaRopa);
	}

	public Arbitros(Arbitros object)throws LongitudDeDatosException, FechaException{
		setId(object.getId());
		setNombre(object.getNombre());
		setApellidos(object.getApellidos());
		setFechaNac(object.getFechaNac());
		setGenero(object.getGenero());
		setColegiacion(object.getColegiacion());
		setTallaRopa(object.getTallaRopa());
	}
	
	public Integer getId() {
		return id;
	}
	
	private void setId(Integer id)throws LongitudDeDatosException{
		if(id.toString().length()>11){
			throw new LongitudDeDatosException("El id no puede tener mas de 11 digitos");
		}
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) throws LongitudDeDatosException{
		if(nombre.length()>40){
			throw new LongitudDeDatosException("El nombre no puede tener mas de 40 caracteres");
		}
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	private void setApellidos(String apellidos) throws LongitudDeDatosException{
		if(apellidos.length()>80){
			throw new LongitudDeDatosException("Los apellidos no pueden tener mas de 80 caracteres");
		}
		this.apellidos = apellidos;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	private void setFechaNac(Date fechaNac)throws FechaException{
		if(fechaNac.after(new Date())){
			throw new FechaException("La fecha de nacimiento no puede ser posterior a la fecha actual");
		}
		this.fechaNac = fechaNac;
	}

	public String getGenero() {
		return genero;
	}

	private void setGenero(String genero) throws LongitudDeDatosException{
		if(genero.length()>1){
			throw new LongitudDeDatosException("El genero no puede tener mas de 1 caracter");
		}
		this.genero = genero;
	}

	public String getColegiacion() {
		return colegiacion;
	}

	private void setColegiacion(String colegiacion) throws LongitudDeDatosException{
		if(colegiacion.length()>256){
			throw new LongitudDeDatosException("La colegiacion no puede tener mas de 256 caracteres");
		}
		this.colegiacion = colegiacion;
	}

	public String getTallaRopa() {
		return tallaRopa;
	}

	private void setTallaRopa(String tallaRopa) throws LongitudDeDatosException{
		if(tallaRopa.length()>3){
			throw new LongitudDeDatosException("La talla de ropa no puede tener mas de 3 caracter");
		}
		this.tallaRopa = tallaRopa;
	}


	@Override
	public String toString() {
		return "Arbitros [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNac=" + fechaNac
				+ ", genero=" + genero + ", colegiacion=" + colegiacion + ", tallaRopa=" + tallaRopa + "]";
	}
	
}
