package practica1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	  @SuppressWarnings("unused")
	public static void main(String[] args) throws ClassNotFoundException {
	    Connection connection;
	    Statement statement;
		ResultSet resultSet;
	    try {
			String driverClassName = "com.mysql.jdbc.Driver";
	        String url       = "jdbc:mysql://localhost:3306/prueba";
	        String user      = "root";
	        connection = DriverManager.getConnection(url,
	            user,"");
	        System.out.println("conexion exitosa");
	        statement = connection.createStatement();
	        String query = "SELECT * FROM batallas;";
	        resultSet = statement.executeQuery(query);
	        String valor="";
	        while(resultSet.next()) {
	            valor=resultSet.getString("nombre");
	            System.out.println(valor);
	        }
	    }
	    catch (SQLException e) {
	    System.out.println("Excepcion SQL: " + e.getMessage());
	    System.out.println("Estado SQL: " + e.getSQLState());
	    System.out.println("Código del Error: " + e.getErrorCode());
	    }

	  }

	}

