# Emperors League
Consiste en una página web de una liga de fútbol profesional en dónde se podrá consultar clasificación, resultados y estadísticas de los diferentes partidos a disputar. 

### Autores:
Raúl Martín<br>
Stefan Gonzales

## Fase 1

### Entidades:
- **Usuario:** Representa el usuario que utilizará la página web.
  - Tipos de usuario: Aficionado, manager (del equipo) y administrador (de la liga).
- **Equipo:** Representa a los equipos que participan en la liga.
- **Jugador:** Representa a los jugadores que jugarán en sus equipos.
- **Clasificación:** Representa la clasificación general de la liga.
- **Partido:** Representa a los partidos entre los equipos de la liga.

### Funcionalidades:
- **Públicas:** Visualización de la clasificación de la liga, los resultados y estadísticas de los partidos disputados.
- **Privadas:** 
  - **Aficionado:** Suscribirse/darse de baja a un equipo para recibir o no actualizaciones.
  - **Manager:** Subir, editar y quitar información de los jugadores, editar la información de su equipo.
  - **Administrador:** Agregar y editar información y estadísticas de los partidos a disputar o ya disputados.

### Funcionalidades de servicio interno:
- Envío de novedades de los equipos a sus aficionados adscritos a éstos.
- Envío de comunicaciones oficiales de la liga a los equipos.

## Fase 2

### Capturas:
- **Inicio:** Menú iniciar para navegar por la aplicación web.

![image](https://user-images.githubusercontent.com/117100820/221805089-0190e234-863d-4a3e-84cd-b4857e4f9b2a.png)

- **Equipos:** Lista de todos los equipos de la liga. Con opción de crear más.

![image](https://user-images.githubusercontent.com/117100820/221815863-f86bb4ab-f4e8-4e5a-aa4c-dc461db9c10a.png)

- **Equipo:** Información del equipo que se quiera ver con la lista de sus jugadores. Con opción de editar y eliminar el equipo, y añadir nuevos jugadores.

![image](https://user-images.githubusercontent.com/117100820/221807589-a9bcf9c8-0e9f-4788-a00b-9f11b3f1dcc9.png)

- **Jugador:** Información del jugador que se quiera ver. Con opción de editar y eliminar el jugador.

![image](https://user-images.githubusercontent.com/117100820/221808900-f91bf5da-8e10-4f03-ae16-c3b879cefad5.png)

- **Partidos:** Lista de todos los partidos disputados en la liga. Con opción de crear más.

![image](https://user-images.githubusercontent.com/117100820/221816117-7e3e4684-7db4-476a-bfce-68cdda1927bb.png)

- **Partido:** Información del partido que se quiera ver. Con opción de editar y eliminar el partido.

![image](https://user-images.githubusercontent.com/117100820/221810282-98e39b99-5825-412f-ac48-8fb00c701baf.png)

- **Clasificación:** Información de la clasificación de la liga actualizada.

![image](https://user-images.githubusercontent.com/117100820/221812960-a225a3d5-2768-4f27-adc0-ba5339ff3c42.png)

### Diagrama de navegación:
<img width="476" alt="2023-02-27 (7)" src="https://user-images.githubusercontent.com/123498958/221691871-b61bb858-cc4f-4055-b3cf-2f922d253f5c.png">

### Diagrama de clases UML:
<img width="540" alt="2023-02-27 (9)" src="https://user-images.githubusercontent.com/123498958/221692632-91e62c9a-d4b5-4ec6-aba7-8b195900c970.png">

### Diagrama Entidad/Relación:
<img width="508" alt="2023-02-27 (5)" src="https://user-images.githubusercontent.com/123498958/221692814-a71cc0cf-11aa-49a6-8821-af6affb09d93.png">

## Fase 3

### Capturas:
- **Esquemas:** Modificaciones respectos a la fase 2 para incluir el login y la parte de seguridad.

### Diagrama de navegación:
<img width="503" alt="2023-03-27 (4)" src="https://user-images.githubusercontent.com/123498958/228159321-d56412fb-34cb-46d3-b893-d7441cd0fe7b.png">

### Diagrama de clases UML:
![2023-03-27](https://user-images.githubusercontent.com/123498958/228159741-b2483e75-cf4e-47a4-801e-38a845d346fc.png)



