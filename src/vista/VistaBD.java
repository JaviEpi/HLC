package vista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import excepciones.LongitudDeDatosException;
import excepciones.NumeroException;
import excepciones.PrecioException;
import excepciones.FechaException;
import modelo.Arbitros;
import modelo.Colegio;
import modelo.Partidos;
import sql.SQLArbitrosDAO;
import sql.SQLColegioDAO;
import sql.SQLPartidosDAO;
import utiles.Menu;

/**
 * Vista que permite al usuario interactuar con la base de datos    
 * @author Javier Epifanio
 * @version 1.0
 */
public class VistaBD{
    public static void main(String[] args)throws LongitudDeDatosException, FechaException{
        int opcion;
        Scanner s = new Scanner(System.in);
        Menu menu = new Menu("Base de datos de Arbitros", "Poblar BD", "Añadir Arbitro", "Añadir colegio", "Añadir partido", "Mostrar Arbitros", "Mostrar colegios", "Mostrar partidos", "Buscar Arbitro", "Buscar colegio", "Buscar partido", "Modificar Arbitro", "Modificar colegio", "Modificar partido", "Borrar Arbitro", "Borrar colegio", "Borrar partido", "Salir");
        SQLArbitrosDAO sqlArbitros = new SQLArbitrosDAO();
        SQLPartidosDAO sqlPartidos = new SQLPartidosDAO();
        SQLColegioDAO sqlColegio = new SQLColegioDAO();
        
        do{
            opcion = menu.elegir(s);
            switch(opcion){
                case 1:
                    poblarBD();
                    System.out.println("La base de datos ha sido poblada");
                    break;
                case 2:
                    System.out.println(sqlArbitros.insert(new Arbitros(pedirId(),pedirNombre(),pedirApellidos(),pedirFechaNac(),pedirGenero(),pedirColegiacion(),pedirTallaRopa())));
                    break;
                case 3:
                    System.out.println(sqlColegio.insert(new Colegio(pedirNombreColegio(),pedirNombrePresidente(),pedirNumArbitros(),pedirLugar())));
                    break;
                case 4:
                    System.out.println(sqlPartidos.insert(new Partidos(pedirId(),pedirEquipoLocal(),pedirEquipoVisitante(),pedirNombreArbitro(), pedirPrecio())));
                    break;
                case 5:
                    listar(sqlArbitros.getAll());
                    break;
                case 6:
                    listar(sqlColegio.getAll());
                    break;
                case 7:
                    listar(sqlPartidos.getAll());
                    break;
                case 8:
                    System.out.println(sqlArbitros.get(pedirId()));
                    break;
                case 9:
                    System.out.println(sqlColegio.get(pedirNombre()));
                    break;
                case 10:
                    System.out.println(sqlPartidos.get(pedirId()));
                    break;
                case 11:
                    System.out.println(sqlArbitros.update(new Arbitros(pedirId(),pedirNombre(),pedirApellidos(),pedirFechaNac(),pedirGenero(),pedirColegiacion(),pedirTallaRopa())));
                    break;
                case 12:
                    System.out.println(sqlColegio.update(new Colegio(pedirNombre(),pedirNombre(),pedirNumArbitros(),pedirLugar())));
                    break;
                case 13:
                    System.out.println(sqlPartidos.update(new Partidos(pedirId(),pedirEquipoLocal(),pedirEquipoVisitante(),pedirNombreArbitro(), pedirPrecio())));
                    break;
                case 14:
                    System.out.println(sqlArbitros.delete(pedirId()));
                    break;
                case 15:
                    System.out.println(sqlColegio.delete(pedirNombre()));
                    break;
                case 16:
                    System.out.println(sqlPartidos.delete(pedirId()));
                    break;
                case 17:
                    System.out.println("Gracias por usar nuestra aplicacion");
                    break;

            }
        } while(opcion != 17);
    }

    private static String pedirNombrePresidente() {
        Scanner s = new Scanner(System.in);
        System.out.println("Introduce el nombre del presidente");
        return s.nextLine();
    }

	private static String pedirNombreColegio() {
        Scanner s = new Scanner(System.in);
        System.out.println("Introduce el nombre del colegio");
        return s.nextLine();
	}

	/**
     * Método para listar cualquier lista
     * @param <K>
     * @param lista Lista a listar
     */
    private static <K> void listar(List<K> lista){
        lista.forEach(System.out::println);
    }

    private static void poblarBD(){
        // Borrar tablas
        final String QUERYBORRARARBITROS = "DROP TABLE IF EXISTS arbitros";
        final String QUERYBORRARCOLEGIOS = "DROP TABLE IF EXISTS colegios";
        final String QUERYBORRARPARTIDOS = "DROP TABLE IF EXISTS partidos";

        // Crear tablas de nuevo
        final String QUERYCREARARBITROS = "CREATE TABLE arbitros (`id` int(11) NOT NULL, `nombre` varchar(40) NOT NULL, `apellidos` varchar(80) NOT NULL, `fechaNac` date NOT NULL, `genero` varchar(1) NOT NULL, `colegiacion` varchar(256) NOT NULL, `tallaRopa` varchar(3) NOT NULL, PRIMARY KEY (`id`));";
        final String QUERYCREARCOLEGIOS = "CREATE TABLE colegios (`nombre` varchar(256) NOT NULL,`presidente` varchar(80) NOT NULL,`numArbitros` int(11) NOT NULL,`lugar` varchar(256) NOT NULL,PRIMARY KEY (`nombre`));";
        final String QUERYCREARPARTIDOS = "CREATE TABLE partidos (`id` int(11) NOT NULL,`equipoLocal` varchar(100) NOT NULL,`equipoVisitante` varchar(100) NOT NULL,`nombreArbitro` varchar(120) NOT NULL,`precio` double(4,2) NOT NULL,`idArbitro` int(11) NOT NULL,PRIMARY KEY (`id`));";

        // Insertar datos
        final String QUERYARBITRO = "INSERT INTO arbitros (id, nombre, apellidos, fechaNac, genero, colegiacion, tallaRopa) VALUES (1, 'Javier', 'Epifanio López', '2000-10-15', 'M', 'Córdoba', 'M');";
        final String QUERYCOLEGIO = "INSERT INTO colegios (nombre, presidente, numArbitros, lugar) VALUES ('Córdoba', 'Pedro Benitez Lara', '200', 'Avenida Zafiro S/N, Córdoba');";
        final String QUERYPARTIDO = "INSERT INTO partidos (id, equipoLocal, equipoVisitante, nombreArbitro, precio, idArbitro) VALUES (1, 'Don Bosco', 'Apademar', 'Javier Epifanio', '27.50', 1);";
        
  
        // Datos BD 
        final String URL = "jdbc:mysql://localhost:3306/arbitros";
        final String USER = "root";
        final String PASSWORD = "";
        try(Connection connection = DriverManager.getConnection(URL, USER,PASSWORD);
            Statement sentencia = connection.createStatement();
            Statement sentencia2 = connection.createStatement();
            Statement sentencia3 = connection.createStatement();
            Statement sentencia4 = connection.createStatement();
            Statement sentencia5 = connection.createStatement();
            Statement sentencia6 = connection.createStatement();
            Statement sentencia7 = connection.createStatement();
            Statement sentencia8 = connection.createStatement();
            Statement sentencia9 = connection.createStatement();){
                sentencia.executeUpdate(QUERYBORRARARBITROS);
                sentencia2.executeUpdate(QUERYBORRARCOLEGIOS);
                sentencia3.executeUpdate(QUERYBORRARPARTIDOS);
                sentencia4.executeUpdate(QUERYCREARARBITROS);
                sentencia5.executeUpdate(QUERYCREARCOLEGIOS);
                sentencia6.executeUpdate(QUERYCREARPARTIDOS);
                sentencia7.executeUpdate(QUERYARBITRO);
                sentencia8.executeUpdate(QUERYCOLEGIO);
                sentencia9.executeUpdate(QUERYPARTIDO);
            } catch (SQLException e) {
                e.getMessage();
            }
    }

    // Método para pedir la Id
    private static Integer pedirId(){
        Scanner s = new Scanner(System.in);
        System.out.println("Introduce la Id: ");
        return s.nextInt();
    }

    // Método para pedir el nombre
    private static String pedirNombre(){
        Scanner s = new Scanner(System.in);
        System.out.println("Introduce el nombre: ");
        return s.nextLine();
    }
    
    private static String pedirApellidos(){
        Scanner s = new Scanner(System.in);
        System.out.println("Introduce los apellidos: ");
        return s.nextLine();
    }

    // Método para pedir fecha de nacimiento
    private static Date pedirFechaNac() throws FechaException{
        // FechaException
        Scanner s = new Scanner(System.in);
        System.out.println("Introduce la fecha de nacimiento: ");
        String fecha = s.nextLine();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNac = null;
        try {
            fechaNac = formato.parse(fecha);
        } catch (ParseException e) {
            throw new FechaException("Error en la fecha");
        }
		return fechaNac;
    }

    // Método para pedir el género
    private static String pedirGenero(){
        Scanner s = new Scanner(System.in);
        System.out.println("Introduce el genero (M/F): ");
        return s.nextLine();
    }

    // Método para pedir la colegiación
    private static String pedirColegiacion(){
        Scanner s = new Scanner(System.in);
        System.out.println("Introduce la colegiacion: ");
        return s.nextLine();
    }

    // Método para pedir la talla de ropa
    private static String pedirTallaRopa(){
        Scanner s = new Scanner(System.in);
        System.out.println("Introduce la talla de ropa: ");
        return s.nextLine();
    }

    // Método para pedir numero de arbitros
    private static Integer pedirNumArbitros(){
        Scanner s = new Scanner(System.in);
        System.out.println("Introduce el numero de arbitros: ");
        int numArbitros = s.nextInt();
        try {
            if(numArbitros < 0){
                throw new NumeroException("Error en el numero de arbitros");
            }
        } catch (NumeroException e) {
            System.out.println(e.getMessage());
        }
		return numArbitros;
    }

    // Método para pedir el lugar de la colegiación
    private static String pedirLugar(){
        Scanner s = new Scanner(System.in);
        System.out.println("Introduce el lugar de la colegiacion: ");
        return s.nextLine();
    }

    // Método para pedir el equipo local
    private static String pedirEquipoLocal(){
        Scanner s = new Scanner(System.in);
        System.out.println("Introduce el equipo local: ");
        return s.nextLine();
    }

    // Método para pedir el equipo visitante
    private static String pedirEquipoVisitante(){
        Scanner s = new Scanner(System.in);
        System.out.println("Introduce el equipo visitante: ");
        return s.nextLine();
    }

    // Método para pedir el nombre del árbitro
    private static String pedirNombreArbitro(){
        Scanner s = new Scanner(System.in);
        System.out.println("Introduce el nombre del arbitro: ");
        return s.nextLine();
    }

    // Método para pedir el precio
    private static Double pedirPrecio(){
        @SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
        System.out.println("Introduce el precio: ");
        double precio = s.nextDouble();
        try {
            if(precio < 0){
                throw new NumeroException("Error en el precio");
            }
        } catch (NumeroException e) {
            System.out.println(e.getMessage());
        }
		return precio;

}
}