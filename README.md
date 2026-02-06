# TP JAVA
## Cine Management
### Alumnos: Lucio Pecoraro - Legajo: 50239 ; Leandro Berto - Legajo: 45368 ; Juan Ignacio Condori Sosa - Legajo: 49499

> Este trabajo está enfocado en un sistema de gestión de un cine. Los usuarios realizan la compra de un ticket a través del sistema y solo pueden realizarlo si se encuentran registrados. El usuario tendrá la posibilidad de mirar la cartelera, donde se le mostrarán todas las categorías y eligiendo una se le listara la película de dicha categoría. 
>Al elegir la película, podrá ver las reseñas de la misma y una vez tomada la decisión, podrá ver las funciones disponibles. Al seleccionar una, se verificará la disponibilidad de la sala y si la cumple, se confirma la compra del ticket.
>Además de esto, el usuario podrá configurar su perfil, revisar sus reseñas y eliminarlas y cancelar la compra de las entradas hechas.
>Desde el lado del administrador, este podrá gestionar las películas en cartelera y moderar las reseñas que se hallan en una película
>> Algunas reglas de negocio que son de relevancia en el negocio son:
>>>- RN1: El id de cliente será auto generado por el sistema, al igual que el de reseña y entrada.
>>>- RN2: El administrador será el encargado de gestionar la cartela, las reseñas hechas por los usuarios.
>>>- RN3: El usuario sólo podra comprar una entrada por película.
>>>- RN4: Se le brindará la posiblidad al usuario de cancelar la entrada.

##Regularidad
|Requerimiento|cantidad|Detalle/Listado de casos incluidos|
|:-|-:|:-|
|ABMC simple|4|1. Categoría 2. Sala 3. Usuario 4. Administrador|
|ABMC dependiente|2|1. Película depende de Categoría 2. Funciones depende de sala y película|
|CU NO-ABMC|3|1. Mostrar detalles de película 2. Comprar una entrada 3. Reembolsar entrada|
|Listado simple|3|
|Listado complejo|1|1. Lista de peliculas por categoria|

##Aprobacion directa
|Requerimiento|cantidad|Detalle/Listado de casos incluidos|
|:-|-:|:-|
|ABMC simple|4|1. Categoría 2. Sala 3. Usuario 4. Administrador|
|ABMC dependiente|3|1. Película depende de Categoría 2. Funciones depende de sala y película 3. Reseña depende de Película|
|CU resumen|2|1. Compra de entrada 2. Manejo de reseña|
|CU usuario|6|1. Mostrar detalles de película 2. Comprar una entrada 3. Reembolsar entrada 4. Realizar una reseña 5. Borrado de reseñas 6. Borrado de reseñas por administrador|
|Nivel de acceso|2|1. Usuario 2. Administración(Admin)|
|Listado complejo|3|1. Lista de peliculas por categoria 2. Lista de funciones por película 3. Lista de reseñas del cliente|
|requerimiento extra obligatorio |1|manejo de archivo|

<!--[image](https://github.com/pecorarolucio/tpjava/assets/103197168/66f91fc6-8486-4e60-bbbb-cdabbacf8bd1)-->

Cuentas:
Usuario: cliente@cliente
Clave: cliente

Administrador: admin@admin
Clave: admin
