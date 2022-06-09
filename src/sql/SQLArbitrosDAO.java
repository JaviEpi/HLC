package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;
import dao.ArbitroDAO;
import excepciones.FechaException;
import excepciones.LongitudDeDatosException;
import modelo.Arbitros;
/**
 * Clase que implementa los metodos de la interfaz ArbitroDAO
 * @author Javier Epifanio
 */
public class SQLArbitrosDAO implements ArbitroDAO{
    private String url = "jdbc:mysql://localhost:3306/arbitros";
    private String user = "root";
    private String password = "";

    @Override
    public String insert(Arbitros arbitro){
        try(Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement sentencia = connection.prepareStatement("INSERT INTO `arbitros`(`id`,`nombre`, `apellidos`, `fechaNac`, `genero`, `colegiacion`, `tallaRopa`) VALUES (?,?,?,?,?,?)")){
            sentencia.setInt(1, arbitro.getId());
            sentencia.setString(2, arbitro.getNombre());
            sentencia.setString(3, arbitro.getApellidos());
            sentencia.setDate(4, new java.sql.Date(arbitro.getFechaNac().getTime()));
            sentencia.setString(5, arbitro.getGenero());
            sentencia.setString(6, arbitro.getColegiacion());
            sentencia.setString(7, arbitro.getTallaRopa());
            sentencia.executeUpdate();
            return "Dato añadido correctamente";
        } catch (SQLException e) {
            return "El dato no se ha añadido";
        }
    } 


	/**
     * Modifica los datos del arbitro
     * 
     * @param arbitro
     * @return
     * @throws LongitudDeDatosException 
     */
    public String update(Arbitros arbitro)throws LongitudDeDatosException{
        try(Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement sentencia = connection.prepareStatement("UPDATE arbitros SET nombre = ?, apellidos = ?, fechaNac = ?, genero = ?, colegiacion = ?, tallaRopa = ? WHERE id = ?")){
            connection.setAutoCommit(false);
            Savepoint savepoint = connection.setSavepoint();
            sentencia.setString(1, arbitro.getNombre());
            sentencia.setString(2, arbitro.getApellidos());
            sentencia.setDate(3, new java.sql.Date(arbitro.getFechaNac().getTime()));
            sentencia.setString(4, arbitro.getGenero());
            sentencia.setString(5, arbitro.getColegiacion());
            sentencia.setString(6, arbitro.getTallaRopa());
            sentencia.executeUpdate();
            connection.commit();
            return "Dato modificado correctamente";
        } catch (SQLException e) {
            return "El dato no se ha modificado";
           }
        }

    @Override
    public String delete(Integer id){
        try (Connection connection =  DriverManager.getConnection(url,user,password); 
            PreparedStatement sentencia = connection.prepareStatement("DELETE FROM arbitros WHERE id = ?")){
            sentencia.setInt(1, id);
            if(sentencia.executeUpdate() == 1){
                return "Arbitro eliminado correctamente";
            }
            return "Error al eliminar el arbitro";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al eliminar el arbitro";
        }
    }

    @Override
    public List<Arbitros> getAll() throws LongitudDeDatosException, FechaException{
        List<Arbitros> arbitros = new ArrayList<>();
        try (Connection connection =  DriverManager.getConnection(url,user,password); 
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM arbitros")){
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                arbitros.add(new Arbitros(resultado.getInt("id"), resultado.getString("nombre"), resultado.getString("apellidos"), resultado.getDate("fechaNac"), resultado.getString("genero"), resultado.getString("colegiacion"), resultado.getString("tallaRopa")));
            }
            return arbitros;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String get(Integer id){
        try (Connection connection =  DriverManager.getConnection(url,user,password); 
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM arbitros WHERE id = ?")){
            sentencia.setInt(1, id);
            ResultSet resultado = sentencia.executeQuery();
            if(resultado.next()){
                return "Arbitro encontrado";
            }
            return "Arbitro no encontrado";
        } catch (SQLException e) {
            e.getMessage();
            return "Error al buscar el arbitro";
        }
    }

    public String getNombreArbitro(Integer id){
        try (Connection connection =  DriverManager.getConnection(url,user,password); 
            PreparedStatement sentencia = connection.prepareStatement("SELECT nombre FROM arbitros WHERE id = ?")){
            sentencia.setInt(1, id);
            ResultSet resultado = sentencia.executeQuery();
            if(resultado.next()){
                return resultado.getString("nombre");
            }
            return "Arbitro no encontrado";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // private Boolean comprobarIntegridad(Arbitros arbitro, Connection connection, Savepoint savepoint){
	// 	try(PreparedStatement sentencia2 = connection.prepareStatement("SELECT * FROM arbitros WHERE nombre = ? AND apellidos = ? AND fechaNac = ? AND genero = ? AND colegiacion = ? AND tallaRopa = ?")){
    //         sentencia2.setString(1, arbitro.getNombre());
    //         sentencia2.setString(2, arbitro.getApellidos());
    //         sentencia2.setDate(3, new java.sql.Date(arbitro.getFechaNac().getTime()));
    //         sentencia2.setString(4, arbitro.getGenero());
    //         sentencia2.setString(5, arbitro.getColegiacion());
    //         sentencia2.setString(6, arbitro.getTallaRopa());
    //         ResultSet resultado = sentencia2.executeQuery();
    //         if(resultado.next()){
    //             return true;
    //         }
    //         return false;
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         return false;
    //     }
    // }
	}

