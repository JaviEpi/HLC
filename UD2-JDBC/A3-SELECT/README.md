## UD2 A3 Consulta SELECT

Responde a las siguientes preguntas:
1. Envía un pantallazo de todas las excepciones manejadas por el paquete java.sql.
2. Envía un pantallazo de la relación de herencia entre las excepciones lanzadas por el método getConnection.
3. La clase DriverManager puede lanzar la SecurityException. Indica cuándo sucede.
4. En java el ARM (Automatic Resource Management) es una característica implementada en Java 7. Permite que los recursos que sean Autocloseable se cierren en el orden inverso al que se definen. Averigua qué clases de java.sql son Autocloseables y qué implica que lo sean a la hora de trabajar con ellas.
5. ResultSet representa una tabla de datos con los resultados de la base de datos. Normalmente se genera al ejecutar una consulta a la base de datos. Indica:
    1. Cursor. Qué es y a qué apunta.
    2. Posición inicial del cursor.
    3. Getters para recuperar los valores de columna de la fila actual.
    4. Indica cómo se identifican las columnas.
6. Ejecuta una consulta Select original y muestra los datos por salida estándar. Para ello utiliza:
    1. Statement statement  = con.createStatement());//Se utiliza para implementar sentencias SQL simples sin parámetros.
    2. ResultSet rs = statement.executeQuery(query);//Ejecuta una consulta y devuelve un objeto ResultSet. Mediante un cursor/puntero se apunta a una fila de datos. 
    3. while (rs.next()) {//mueve el cursor una fila hacia adelante. Cada vez que llama a next, el método genera los datos en la fila donde está posicionado actualmente el cursor.

---------

- [Código](java/Conexion.java).

### 1. Envía un pantallazo de todas las excepciones manejadas por el paquete java.sql
![ScreenShot](https://github.com/iesgrancapitan/ud2-a3-consulta-select-JaviEpi/blob/main/img/exceptions.png)

------

### 2. Envía un pantallazo de la relación de herencia entre las excepciones lanzadas por el método getConnection
![ScreenShot](https://github.com/iesgrancapitan/ud2-a3-consulta-select-JaviEpi/blob/main/img/herencia.png)

------

### 3. La clase DriverManager puede lanzar la SecurityException. Indica cuándo sucede.
Se lanza por el security manager para indicar una violación de seguridad.

![ScreenShot](https://github.com/iesgrancapitan/ud2-a3-consulta-select-JaviEpi/blob/main/img/SecurityException.png)

------

### 4. En java el ARM (Automatic Resource Management) es una característica implementada en Java 7. Permite que los recursos que sean Autocloseable se cierren en el orden inverso al que se definen. Averigua qué clases de java.sql son Autocloseables y qué implica que lo sean a la hora de trabajar con ellas.
Las clases Connection, Statemente, PreparedStatement y ResultSet implementan la interfaz AutoCloseable.

-------

### 5. ResultSet representa una tabla de datos con los resultados de la base de datos. Normalmente se genera al ejecutar una consulta a la base de datos. Indica:
#### 5.1. Cursor. Qué es y a qué apunta.
El cursor te da la posibilidad de apuntar a una fila de la BD, y de esa manera acceder a su información, cuando se crea por primera vez, el cursor se coloca antes de la primera fila.

#### 5.2. Posición inicial del cursor.
La posición inicial del cursor es antes de la primera fila.

#### 5.3. Getters para recuperar los valores de columna de la fila actual.
Existen métodos para recoger la información de las filas. Se componen de get + [tipo de dato], por ejemplo: getString(), getInt(), o getFloat() entre otros ejemplos.

#### 5.4. Indica cómo se identifican las columnas.
Las columnas se pueden identificar por un índice, que avanza hasta n (número de columnas de la tabla): getFloat(2) O también por el nombre de la columna: getInt("id").

------

### 6. Ejecuta una consulta Select original y muestra los datos por salida estándar. Para ello utiliza:

#### 6.1. Statement statement  = con.createStatement());//Se utiliza para implementar sentencias SQL simples sin parámetros.

![ScreenShot](https://github.com/iesgrancapitan/ud2-a3-consulta-select-JaviEpi/blob/main/img/statement.png)

#### 6.2. ResultSet rs = statement.executeQuery(query);//Ejecuta una consulta y devuelve un objeto ResultSet. Mediante un cursor/puntero se apunta a una fila de datos. 

![ScreenShot](https://github.com/iesgrancapitan/ud2-a3-consulta-select-JaviEpi/blob/main/img/resultset.png)

#### 6.3. while (rs.next()) {//mueve el cursor una fila hacia adelante. Cada vez que llama a next, el método genera los datos en la fila donde está posicionado actualmente el cursor.

![ScreenShot](https://github.com/iesgrancapitan/ud2-a3-consulta-select-JaviEpi/blob/main/img/while.png)

----
Trabajo realizado por: -Javier Epifanio López
