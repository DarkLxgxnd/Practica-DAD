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
