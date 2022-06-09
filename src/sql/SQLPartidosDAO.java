package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;
import dao.PartidoDAO;
import excepciones.LongitudDeDatosException;
import modelo.Partidos;

/**
 * Clase que implementa los metodos de la interfaz PartidoDAO
 * @author Javier Epifanio
 */
public class SQLPartidosDAO implements PartidoDAO{
    private String url = "jdbc:mysql://localhost:3306/arbitros";
    private String user = "root";
    private String password = "";

    @Override
    public String insert (Partidos partido){
        try(Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement sentencia = connection.prepareStatement("INSERT INTO partidos (id, equipoLocal, equipoVisitante, nombreArbitro, precio, idArbitro) VALUES (?,?,?,?,?,?)")){
            connection.setAutoCommit(false);
            Savepoint savepoint = connection.setSavepoint();
            sentencia.setInt(1, partido.getId());
            sentencia.setString(2, partido.getEquipoLocal());
            sentencia.setString(3, partido.getEquipoVisitante());
            sentencia.setString(4, partido.getNombreArbitro());
            sentencia.setDouble(5, partido.getPrecio());
            sentencia.setInt(6, partido.getIdArbitro());
            
            if(comprobarIntegridad(partido, connection, savepoint)){
                connection.commit();
                return "Partido insertado correctamente";
            }
            return "Error al insertar el partido";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Error al insertar el partido";
    }

    /**
     * Modifica los datos del partido
     * 
     * @param partido
     * @return
     * @throws LongitudDeDatosException 
     */
    public String update(Partidos partido)throws LongitudDeDatosException{
        try(Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement sentencia = connection.prepareStatement("UPDATE partidos SET id = ?, equipoLocal = ?, equipoVisitante = ?, nombreArbitro = ?, precio = ?, idArbitro = ? WHERE id = ?")){
            connection.setAutoCommit(false);
            Savepoint savepoint = connection.setSavepoint();
            sentencia.setInt(1, partido.getId());
            sentencia.setString(2, partido.getEquipoLocal());
            sentencia.setString(3, partido.getEquipoVisitante());
            sentencia.setString(4, partido.getNombreArbitro());
            sentencia.setDouble(5, partido.getPrecio());
            sentencia.setInt(6, partido.getIdArbitro());
          
            if(comprobarIntegridad(partido, connection, savepoint)){
                connection.commit();
                return "Partido modificado correctamente";
            }
            return "Error al modificar el partido";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al modificar el partido";
        }
    }

    private boolean comprobarIntegridad(Partidos partido, Connection connection, Savepoint savepoint) {
		
		return false;
	}

	@Override
    public String delete(Integer id) {
        try(Connection connection = DriverManager.getConnection(url, user, password)){
            PreparedStatement sentencia = connection.prepareStatement("DELETE FROM partidos WHERE id = ?");
            sentencia.setInt(1, id);
            if(sentencia.executeUpdate() == 1){
                return "Partido eliminado correctamente";
            }
            return "Error al eliminar el partido";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al eliminar el partido";
        }
    }

    @Override
    public List<Partidos> getAll() throws LongitudDeDatosException {
        List<Partidos> partidos = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url, user, password)){
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM partidos");
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                partidos.add(new Partidos(resultado.getInt("id"), resultado.getString("equipoLocal"), resultado.getString("equipoVisitante"), resultado.getString("nombreArbitro"), resultado.getDouble("precio")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return partidos;
    }

    public Partidos getById(Integer id) throws LongitudDeDatosException {
        Partidos partido = null;
        try(Connection connection = DriverManager.getConnection(url, user, password)){
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM partidos WHERE id = ?");
            sentencia.setInt(1, id);
            ResultSet resultado = sentencia.executeQuery();
            if(resultado.next()){
                partido = new Partidos(resultado.getInt("id"), resultado.getString("equipoLocal"), resultado.getString("equipoVisitante"), resultado.getString("nombreArbitro"), resultado.getDouble("precio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return partido;
    }

    public List<Partidos> getByEquipoLocal(String equipoLocal) throws LongitudDeDatosException {
        List<Partidos> partidos = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url, user, password)){
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM partidos WHERE equipoLocal = ?");
            sentencia.setString(1, equipoLocal);
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                partidos.add(new Partidos(resultado.getInt("id"), resultado.getString("equipoLocal"), resultado.getString("equipoVisitante"), resultado.getString("nombreArbitro"), resultado.getDouble("precio")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return partidos;
    }

    public List<Partidos> getByEquipoVisitante(String equipoVisitante) throws LongitudDeDatosException {
        List<Partidos> partidos = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url, user, password)){
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM partidos WHERE equipoVisitante = ?");
            sentencia.setString(1, equipoVisitante);
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                partidos.add(new Partidos(resultado.getInt("id"), resultado.getString("equipoLocal"), resultado.getString("equipoVisitante"), resultado.getString("nombreArbitro"), resultado.getDouble("precio")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return partidos;
    }

    public List<Partidos> getByNombreArbitro(String nombreArbitro) throws LongitudDeDatosException {
        List<Partidos> partidos = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url, user, password)){
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM partidos WHERE nombreArbitro = ?");
            sentencia.setString(1, nombreArbitro);
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                partidos.add(new Partidos(resultado.getInt("id"), resultado.getString("equipoLocal"), resultado.getString("equipoVisitante"), resultado.getString("nombreArbitro"), resultado.getDouble("precio")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return partidos;
    }

	@Override
	public String get(Integer id) {
        try (Connection  connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM partidos WHERE id = ?");
            sentencia.setInt(1, id);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                return "Partido encontrado";
            }
            return "Partido no encontrado";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al buscar el partido";
        }
	}

}