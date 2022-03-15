## UD2 A2. Primeros pasos con JDBC

Responde a las siguientes preguntas:

1. Qué es la API JDBC y para qué sirve
2. Indica los paquetes que la componen
3. Explica la utilidad de las siguientes clases:
    1. DriverManager
    2. Connection
    3. Statement
    4. PreparedStatement
    5. ResultSet
4. Driver JDBC. Indica ejemplos


---------

### 1. Qué es la API JDBC y para qué sirve
JDBC (Java DataBase Connectivity): Protocolo para utilizar bases de datos relacionales desde Java y se basa en la utilización de drivers que implementan un API predefinido.

------

### 2. Indica los paquetes que la componen
Los paquetes que utilizan son los siguentes:<br>
    - java.sql <br>
    - javax.sql (más avanzado)<br>
La mayor parte de las aplicaciones sólo
requieren java.sql
### 3. Explica la utilidad de las siguientes clases:
    1. DriverManager
    DriverManager es una clase estática de Java™ 2 Plaform, Standard Edition (J2SE) y Java SE Development Kit (JDK). DriverManager gestiona el conjunto de controladores Java Database Connectivity (JDBC) que están disponibles para que los utilice una aplicación.
    Las aplicaciones pueden utilizar varios controladores JDBC simultáneamente si es necesario. Cada aplicación especifica un controlador JDBC mediante la utilización de un URL (Localizador universal de recursos). Pasando un URL de un controlador JDBC específico a DriverManager, la aplicación informa a DriverManager acerca del tipo de conexión JDBC que debe devolverse a la aplicación.
    
    2. Connection
    La clase de conexión JDBC java.sql.Connection, representa una conexión de base de datos a una base de datos relacional. Antes de poder leer o escribir datos desde y hacia una base de datos a través de JDBC, debe abrir una conexión a la base de datos. Este tutorial de conexión JDBC le mostrará cómo hacerlo.

    3. Statement
    Un objeto Statement se usa para enviar sentencias SQL a la base de datos. Actualmente hay tres tipos de objetos Statement, todos los cuales actúan como contenedores para la ejecución de sentencias en una conexión dada: Statement, PreparedStatement que hereda de Statement y CallableStatement que hereda de PreparedStatement. Estas estàn especializadas para enviar tipos particulares de sentencias SQL, Un objeto Statement se usa para ejecutar una sentencia SQL simple sin parámetros.

    4. PreparedStatement
    Un objeto PreparedStatement se usa para ejecutar sentencias SQL precompiladas con o sin parámetros IN; y un objeto CallableStatement se usa para ejecutar un procedimieno de base de datos almacenado.

    5. ResultSet
    El objeto ResultSet proporciona varios métodos para obtener los datos de columna correspondientes a un fila. Todos ellos tienen el formato get<Tipo>, siendo <Tipo> un tipo de datos Java™. Algunos ejemplos de estos métodos son getInt, getLong, getString, getTimestamp y getBlob.
-----

### 4. Driver JDBC. Indica ejemplos
* MySql: 
    - Clase Driver : com.mysql.jdbc.Driver
    - URL de Conexión: jdbc:mysql://host/database
    - Fichero .jar/.zip: mysql-connector-java-5.0.4-bin.jar
* DB2:
    - Clase Driver : com.ibm.db2.jdbc.app.DB2Driver
    - URL de Conexión:: jdbc:db2:database
    - Fichero .jar/.zip: db2java.zip

* Sybase:
    - Clase Driver : com.sybase.jdbc2.jdbc.SybDriver
    - URL de Conexión: jdbc:sybase:Tds:host:port/database
    - Fichero .jar/.zip: jconn2.jar

* Oracle:
    - Clase Driver : oracle.jdbc.driver.OracleDriver
    - URL de Conexión: jdbc:oracle:thin:@ host:port:sid
    - Fichero .jar/.zip: classes12.zip

* SQLServer:
    - Clase Driver : com.microsoft.jdbc.sqlserver.SQLServerDriver
    - URL de Conexión: jdbc:microsoft:sqlserver://localhost:1433
    - Fichero .jar/.zip: mssqlserver.jar, msbase.jar, msutil.jar

* PostgreSQL:
    - Clase Driver: org.postgresql.Driver
    - URL de Conexión: jdbc:postgresql://server:port/database
    - Fichero .jar/.zip: postgresql.jar

----
Trabajo realizado por: -Javier Epifanio López
