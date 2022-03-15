#  Base de datos relacionales

**Índice**
 1. Qué es una base de datos
 2.  Características base de datos relacional
 3.  Estructura de base de datos relacional  
 4. Modelo relacional
 5. Manejadores de base de datos
 6. Ventajas y desventajas
 7. Diseño de la base de datos relacionales
 8. Ejemplo base de datos
 9. Bibliografía
------------
## 1.      Qué es una base de datos relacional
La base de datos relacional es un tipo de base de datos que se ajusta al modelo relacional. Es el modelo más utilizado para implementar bases de datos planificadas en la actualidad. Permiten el establecimiento de interconexiones (relaciones) entre datos (almacenados en tablas), y a través de estas conexiones asociar los datos de las dos tablas. De ahí el nombre: "Modelo relacional". 


------------
## 2.      Características base de datos relacional
Resumidamente, las características de una base de datos relacional serián:
- Una base de datos relacional se compone de varias tablas o relaciones.
- No pueden existir dos tablas con el mismo nombre ni registro.
- Cada tabla es a su vez un conjunto de registros (filas y columnas).
- La relación entre una tabla padre y un hijo se lleva a cabo por medio de las claves primarias y ajenas (o foráneas).
- Las claves primarias son la clave principal de un registro dentro de una tabla y éstas deben cumplir con la integridad de los datos.
- Las claves ajenas se colocan en la tabla hija, contienen el mismo valor que la clave primaria del registro padre; por medio de éstas se hacen las relaciones.

------------
## 3.      Estructura de base de datos relacional
La base de datos se organiza en dos secciones diferenciadas, por un lado el esquema y por otro los datos (o instancia).
El esquema es la definición de la estructura de la base de datos y principalmente almacena los siguientes datos:
- El nombre de cada tabla.
- El nombre de cada columna.
- El tipo de dato de cada columna.
- La tabla a la que pertenece cada columna.

------------

## 4.      Modelo relacional
La revolución que supuso el modelo relacional fue enorme debido a que se diseñó para resolver el problema causado por estructuras de datos múltiples y arbitrarias, ya que en los primeros años de las bases de datos, cada aplicación almacena datos en su propia estructura única y cuando los desarrolladores querían crear aplicaciones para usar esos datos, tenían que conocer muy bien esa estructura de datos concreta a fin de encontrar los datos que necesitaban.

------------


## 5.      Manejadores de base de datos
Actualmente existen varios tipos de de gestores de BDR, entre ellos, los más usados son:
- Oracle
- MySQL
- Microsoft SQL Server
- PostgreSQL
- DB2

------------

## 6.      Ventajas y desventajas
Como resumen, tenemos estas ventajas:
- Provee herramientas que garantizan evitar la duplicidad de registros.
- Garantiza la integridad referencial, así, al eliminar un registro elimina todos los registros relacionados dependientes.
- Favorece la normalización por ser más comprensible y aplicable.

Y tenemos estas desventajas:
- Presentan deficiencias con datos gráficos, multimedia, CAD y sistemas de información geográfica.
- No se manipulan de forma manejable los bloques de texto como tipo de dato.
- No se pueden crear subfilas.
- Rendimiento negativo o lento.

------------
## 7.      Diseño de la base de datos relacionales
El primer paso para crear una base de datos, es planificar el tipo de información que se quiere almacenar en la misma, teniendo en cuenta dos aspectos: la información disponible y la información que necesitamos.

La planificación de la estructura de la base de datos, en particular de las tablas, es vital para la gestión efectiva de la misma. El diseño de la estructura de una tabla consiste en una descripción de cada uno de los campos que componen el registro y los valores o datos que contendrá cada uno de esos campos.

Los campos son los distintos tipos de datos que componen la tabla, por ejemplo: nombre,apellido, domicilio. La definición de un campo requiere: el nombre del campo, el tipo de campo, el ancho del campo, etc.

------------
## 8. Ejemplo base de datos relacional
Imaginemos que tenemos una cooperativa que realiza envíos de materiales a clientes, primero tendremos una tabla con la información de estos clientes, en la que cada fila o tupla corresponderá a los datos de cada cliente en concreto, nombre, dirección, datos de facturación… La base de datos asignará una clave única a cada fila, una ID_c (por ejemplo). La segunda tabla contiene información de los pedidos que realizan los clientes. Cada registro incluirá el ID_c del cliente que los hizo el pedido, el producto, la cantidad, etc., pero no especificará el nombre ni los datos del cliente.


## 9. Bibliografía
Wikipedia: 
https://es.wikipedia.org/wiki/Base_de_datos_relacional

Historia las Bases de Datos Relacionales con SQL y SQL Server de Microsoft”:
https://talentodigitalsql.wordpress.com/2018/02/18/historia-las-bases-de-datos-relacionales-con-sql-y-sql-server-de-microsoft/

Tema IV: Teoría de la Normalización”:
http://ocw.uc3m.es/ingenieria-informatica/diseno-de-bases-de-datos/teoria/Tema4(Normalizacion).pdf

Bases de datos relacional ¿Qué es y sus características?”: https://ayudaleyprotecciondatos.es/bases-de-datos/relacional/

------------

**Realizado por:**
- Javier Epifanio López
- Javier Fernández Rubio
------------

