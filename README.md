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
  - **Administrador:** Agregar y editar información y estadísticas de la clasificación y de los partidos a disputar o ya disputados.

### Funcionalidades de servicio interno:
- Envío de novedades de los equipos a sus aficionados adscritos a éstos.
- Envío de comunicaciones oficiales de la liga a los equipos.

### Diagrama de navegacion
<img width="476" alt="2023-02-27 (7)" src="https://user-images.githubusercontent.com/123498958/221691871-b61bb858-cc4f-4055-b3cf-2f922d253f5c.png">

### Diagraa de clases UML
<img width="540" alt="2023-02-27 (9)" src="https://user-images.githubusercontent.com/123498958/221692632-91e62c9a-d4b5-4ec6-aba7-8b195900c970.png">

### DiagramaEntidad/Relación
<img width="508" alt="2023-02-27 (5)" src="https://user-images.githubusercontent.com/123498958/221692814-a71cc0cf-11aa-49a6-8821-af6affb09d93.png">
