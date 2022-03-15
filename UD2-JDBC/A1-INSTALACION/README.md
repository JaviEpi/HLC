## A1. Instalación y primera conexión


**Índice**
 1. Instala el sistema de gestión de bases de datos (DBMS) MySQL
 2. Instala el driver en el proyecto del IDE Eclipse
 3. Partiendo de DriverManager.getConnection() crea una conexión (objeto Connection) que represente la conexión establecida entre la aplicación y la BD
 4. Confirma que todo ha ido bien. Tendrás que capturar las excepciones SQLException y SQLTimeoutException 
------------

### Instala el sistema de gestión de base de datos (DBMS) MySQL
Paso 1:
Descargamos el MySQL-Connector de la siguiente página: https://www.javahelps.com/2015/08/add-mysql-jdbc-driver-to-eclipse.html,tenemos que descargar el .zip MySQL-Connector de plataform independient, una vez descargado, he creado una carpeta en mi usuario para guardar el fichero .jar que necesitamos.
![ScreenShot](https://github.com/iesgrancapitan/ud2-a1-instalacion-y-primera-conexion-JaviEpi/blob/main/img/MySQL-Connector.png)
![ScreenShot](https://github.com/iesgrancapitan/ud2-a1-instalacion-y-primera-conexion-JaviEpi/blob/main/img/zip.png)
![ScreenShot](https://github.com/iesgrancapitan/ud2-a1-instalacion-y-primera-conexion-JaviEpi/blob/main/img/Carpeta-MySQL.png)


### Instala el driver en el proyecto del IDE Eclipse
Una vez ya tenemos instalado el MySQL-connector, abrimos eclipse y creamos un proyecto, una vez tenemos el proyecto creado hacemos click derecho y unos vamos al apartado de buildPath, una vez allí nos vamos a la pestaña libraries y pulsamos en Add Externals Jar y agregamos el jar que nos hemos descargado anteriormente y aplicamos los cambios.
![ScreenShot](https://github.com/iesgrancapitan/ud2-a1-instalacion-y-primera-conexion-JaviEpi/blob/main/img/jar-path.png)
![ScreenShot](https://github.com/iesgrancapitan/ud2-a1-instalacion-y-primera-conexion-JaviEpi/blob/main/img/Path.png)


### Partiendo de DriverManager.getConnection() crea una conexión (objeto Connection) que represente la conexión establecida entre la aplicación y la BD
- [Código]().
Aqui vemos como hemos creado la conexión:
![ScreenShot](https://github.com/iesgrancapitan/ud2-a1-instalacion-y-primera-conexion-JaviEpi/blob/main/img/codigo.png)

### Confirma que todo ha ido bien. Tendrás que capturar las excepciones SQLException y SQLTimeoutException
Una vez tenemos el código, y lo ejecutamos y nos sale que la conexión es exitosa y nos sale una excepción de que la tabla batallas no exite, ya que no la hemos creado, si entraramos en phpmyadmin y creamos la tabla nos saldría que la conexión exitosa sin ninguna excepción y además nos mostraría la tabla.
![ScreenShot](https://github.com/iesgrancapitan/ud2-a1-instalacion-y-primera-conexion-JaviEpi/blob/main/img/exitosa.png)
