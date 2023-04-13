# Emperors League
Consiste en una página web de una liga de fútbol profesional en dónde se podrá consultar clasificación, resultados y estadísticas de los diferentes partidos a disputar. 

### Autores:
Raúl Martín<br>
Stefan Gonzales

<br>

## Fase 1

### Entidades:
- **Usuario:** Representa el usuario que utilizará la página web.
  - Tipos de usuario: Aficionado, manager (del equipo) y administrador (de la liga).
- **Equipo:** Representa a los equipos que participan en la liga.
- **Jugador:** Representa a los jugadores que jugarán en sus equipos.
- **Clasificación:** Representa la clasificación general de la liga.
- **Partido:** Representa a los partidos entre los equipos de la liga.

### Funcionalidades:
- **Públicas:** Visualización de la clasificación de la liga, los resultados de los partidos disputados e información de los equipos.
- **Privadas:** 
  - **Aficionado:** Suscribirse/darse de baja a un equipo para recibir o no notificaciones.
  - **Manager:** Subir, editar y quitar información de los jugadores, editar la información de su equipo.
  - **Administrador:** Agregar y editar información y estadísticas de los partidos a disputar o ya disputados.

### Funcionalidades de servicio interno:
- Envío de notificaciones de los equipos a sus aficionados adscritos a éstos.
- Envío de comunicados oficiales de la liga a los equipos.

<br>

## Fase 2

### Capturas:
- **Inicio:** Menú iniciar para navegar por la aplicación web.

![image](https://user-images.githubusercontent.com/117100820/221805089-0190e234-863d-4a3e-84cd-b4857e4f9b2a.png)

<br>

- **Equipos:** Lista de todos los equipos de la liga. Con opción de crear más.

![image](https://user-images.githubusercontent.com/117100820/221815863-f86bb4ab-f4e8-4e5a-aa4c-dc461db9c10a.png)

<br>

- **Equipo:** Información del equipo que se quiera ver con la lista de sus jugadores. Con opción de editar y eliminar el equipo, y añadir nuevos jugadores.

![image](https://user-images.githubusercontent.com/117100820/221807589-a9bcf9c8-0e9f-4788-a00b-9f11b3f1dcc9.png)

<br>

- **Jugador:** Información del jugador que se quiera ver. Con opción de editar y eliminar el jugador.

![image](https://user-images.githubusercontent.com/117100820/221808900-f91bf5da-8e10-4f03-ae16-c3b879cefad5.png)

<br>

- **Partidos:** Lista de todos los partidos disputados en la liga. Con opción de crear más.

![image](https://user-images.githubusercontent.com/117100820/221816117-7e3e4684-7db4-476a-bfce-68cdda1927bb.png)

<br>

- **Partido:** Información del partido que se quiera ver. Con opción de editar y eliminar el partido.

![image](https://user-images.githubusercontent.com/117100820/221810282-98e39b99-5825-412f-ac48-8fb00c701baf.png)

<br>

- **Clasificación:** Información de la clasificación de la liga actualizada.

![image](https://user-images.githubusercontent.com/117100820/221812960-a225a3d5-2768-4f27-adc0-ba5339ff3c42.png)

<br>

### Diagrama de navegación:
<img width="476" alt="2023-02-27 (7)" src="https://user-images.githubusercontent.com/123498958/221691871-b61bb858-cc4f-4055-b3cf-2f922d253f5c.png">

<br>

### Diagrama de clases UML:
<img width="540" alt="2023-02-27 (9)" src="https://user-images.githubusercontent.com/123498958/221692632-91e62c9a-d4b5-4ec6-aba7-8b195900c970.png">

<br>

### Diagrama Entidad/Relación:
<img width="508" alt="2023-02-27 (5)" src="https://user-images.githubusercontent.com/123498958/221692814-a71cc0cf-11aa-49a6-8821-af6affb09d93.png">

<br>

## Fase 3

### Capturas actualizadas:
- **Inicio:** Modificación de la cabecera de la aplicación incluyendo los apartados de iniciar sesión y de registrarse.

![image](https://user-images.githubusercontent.com/117100820/231525800-fac2240b-13d7-4eb5-822f-088f4fb00b2e.png)

<br>

- **Login:** Cabecera de la aplicación cuando inicia sesión un usuario.

![image](https://user-images.githubusercontent.com/117100820/231528936-c49492ab-a4eb-4242-8fcb-4c66969249c7.png)

<br>

- **Error:** Mensaje de error cuando las credenciales introducidas no son correctas.

![image](https://user-images.githubusercontent.com/117100820/231526577-f02b1262-ffab-4a1d-87f3-eccf7801b807.png)

<br>

- **Registro:** Registro de un nuevo usuario.

![image](https://user-images.githubusercontent.com/117100820/231535104-ea74e0fb-e6fe-4404-9d5d-431754cc3bd5.png)

<br>

- **Permisos:** Según el tipo de usuario, tendrá acceso a determinados sitios de la aplicación. Por ejemplo:

![image](https://user-images.githubusercontent.com/117100820/231535692-a0fc1717-09ec-4279-84a3-4ec511319cc0.png)
![image](https://user-images.githubusercontent.com/117100820/231535875-eed668d4-9047-45bd-b5bd-ff0ed2d16bf4.png)

<br>

### Diagrama de navegación actualizado:
<img width="503" alt="2023-03-27 (4)" src="https://user-images.githubusercontent.com/123498958/228159321-d56412fb-34cb-46d3-b893-d7441cd0fe7b.png">

<br>

### Diagrama de clases UML actualizado:
![2023-03-27](https://user-images.githubusercontent.com/123498958/228159741-b2483e75-cf4e-47a4-801e-38a845d346fc.png)

<br>

### Interfaz del servicio interno:
- **Comunicados:** Interfaz del envío de comunicados por parte del administrador de la liga. Se enviará un correo a todos los managers al enviarlo.

![image](https://user-images.githubusercontent.com/117100820/231532711-86d57a83-bf11-48c6-8be5-ed520409239a.png)

<br>

- **Suscripción:** Interfaz para suscribirse al equipo. Dándole al botón autómaticamente se suscribe al equipo.

![image](https://user-images.githubusercontent.com/117100820/231533114-6b56e46b-95a3-4663-890c-369e710198a7.png)

<br>

- **Notificaciones:** Interfaz de la recepción de notificaciones a los aficionados cuando se sube un nuevo partido disputado.

![image](https://user-images.githubusercontent.com/117100820/231534298-1a893588-85d4-4164-bcc4-46cf07819847.png)

<br>

### Instrucciones para despliegue de la aplicación:
**1. Instalar Java:**

sudo apt update

sudo apt install openjdk-17-jdk

sudo apt install openjdk-17-jre

<br>

**2. Instalar MySQL:**

sudo apt update

sudo apt install mysql-server

<br>

**3. Configurar MySQL:**

sudo mysql

mysql> ALTER USER 'root'@'localhost' IDENTIFIED WITH caching_sha2_password BY 'password';

mysql> FLUSH PRIVILEGES;

mysql> exit

<br>

**4. Crear base de datos en MySQL:**

mysql -u root -p password

mysql> CREATE DATABASE league;

mysql> USE league;

mysql> exit

<br>

**5. Instalar RabbitMQ:**

sudo apt-get update

curl -1sLf \ 'https://dl.cloudsmith.io/public/rabbitmq/rabbitmq-erlang/setup.deb.sh' \ | sudo -E bash

curl -1sLf \ 'https://dl.cloudsmith.io/public/rabbitmq/rabbitmq-server/setup.deb.sh' \ | sudo -E bash

sudo apt-get update -y

sudo apt-get install -y erlang-base \ erlang-asn1 erlang-crypto erlang-eldap erlang-ftp erlang-inets \ erlang-mnesia erlang-os-mon erlang-parsetools erlang-public-key \ erlang-runtime-tools erlang-snmp erlang-ssl \ erlang-syntax-tools erlang-tftp erlang-tools erlang-xmerl

sudo apt-get install rabbitmq-server -y --fix-missing

<br>

**6. Iniciar RabbitMQ:**

sudo systemctl start rabbitmq-server

<br>

**7. Ejecutar la aplicación:**

Generar los jar con mvn package

Ejecutar la aplicación con java -jar emperorsleague.jar

Ejecutar el servicio interno con java -jar serviciointerno.jar

Abrir un navegador y comenzar a usar la aplicación con https://localhost:8443/

<br>
