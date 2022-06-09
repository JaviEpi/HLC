package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;
import dao.ColegioDAO;
import excepciones.LongitudDeDatosException;
import modelo.Colegio;

/**
 * Clase que implementa los metodos de la interfaz ColegioDAO
 * @author Javier Epifanio
 */
public class SQLColegioDAO implements ColegioDAO{
    private String url = "jdbc:mysql://localhost:3306/arbitros";
    private String user = "root";
    private String password = "";

    @Override
    public String insert (Colegio colegio){
        try (Connection connection =  DriverManager.getConnection(url,user,password);
        PreparedStatement sentencia = connection.prepareStatement("INSERT INTO colegio (nombre, presidente, numArbitros, lugar) VALUES (?,?,?,?)")){
            connection.setAutoCommit(false);
            Savepoint savepoint = connection.setSavepoint();
            sentencia.setString(1, colegio.getNombre());
            sentencia.setString(2, colegio.getPresidente());
            sentencia.setInt(3, colegio.getNumArbitros());
            sentencia.setString(4, colegio.getLugar());
            sentencia.executeUpdate();
            connection.commit();
            return "Dato añadido correctamente";
        } catch (SQLException e) {
            return "El dato no se ha añadido";
        }
    }

    public String update(Colegio colegio) throws LongitudDeDatosException{
        try(Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement sentencia = connection.prepareStatement("UPDATE colegios SET nombre = ?, presidente = ?, numArbitros = ?, lugar = ? WHERE nombre = ?")){
            connection.setAutoCommit(false);
            Savepoint savepoint = connection.setSavepoint();
            sentencia.setString(1, colegio.getNombre());
            sentencia.setString(2, colegio.getPresidente());
            sentencia.setInt(3, colegio.getNumArbitros());
            sentencia.setString(4, colegio.getLugar());
            
            if(comprobarIntegridad(colegio, connection, savepoint)){
                connection.commit();
                return "Colegio modificado correctamente";
            }
            return "Error al modificar el colegio";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al modificar el colegio";
        }
    }

    @Override
    public String delete (String nombre){
        try(Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement sentencia = connection.prepareStatement("DELETE FROM colegios WHERE nombre = ?")){
            sentencia.setString(1, nombre);
            if(sentencia.executeUpdate() == 1){
                return "Colegio eliminado correctamente";
            }
            return "Error al eliminar el colegio";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al eliminar el colegio";
        }   
    }

    public List<Colegio> getAll() throws LongitudDeDatosException{
        List<Colegio> colegios = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM colegios")){
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                colegios.add(new Colegio(resultado.getString("nombre"), resultado.getString("presidente"), resultado.getInt("numArbitros"), resultado.getString("lugar")));
            }
            return colegios;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String get(String nombre){
        try(Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM colegios WHERE nombre = ?")){
            sentencia.setString(1, nombre);
            ResultSet resultado = sentencia.executeQuery();
            if(resultado.next()){
                return resultado.getString("nombre") + " " + resultado.getString("presidente") + " " + resultado.getInt("numArbitros") + " " + resultado.getString("lugar");
            }
            return "No existe el colegio";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al obtener el colegio";
        }
    }

	private boolean comprobarIntegridad(Colegio colegio, Connection connection, Savepoint savepoint) throws SQLException {
		try(PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM colegios WHERE nombre = ?")){
            sentencia.setString(1, colegio.getNombre());
            ResultSet resultado = sentencia.executeQuery();
            if(resultado.next()){
                return false;
            }
            return true;
        } catch (SQLException e) {
            connection.rollback(savepoint);
            e.printStackTrace();
            return false;
        }
	}

}
