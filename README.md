# SERVICIO WEB CON SPRING BOOT: 
## SHIELD DATABASE
Este es el proyecto que contiene todo el código generado durante la sección Servicios Web con Spring Boot.

Este desarrollo es y¡un Servicio Web de tipo REST full que contendrá dos recursos principales: Héroes y Poderes.

[id]:diseño
### SHIELD DATABASE
#### Héroes
##### Obtener a todos los héroes
```
GET /hero
HTTResponseStatus: 200, 404, 500...
```
##### Insertar un nuevo héroe
```
POST /hero
Body: Información del héroe
HttpResponseStatus: 201, 404, 500...
```
##### Obtener a un héroe en concreto
```
GET /hero/{id} --> /hero/1
HttpResponseStatus: 200, 404, 500...
```
##### Borrar a un héroe
```
DELETE /hero/{id} --> /hero/1
HttpResponseStatus: 200, 202, 404, 500...
```

#### Poderes
##### Obtener todos los poderes de un héroe
```
GET /hero/{id}/power
```
##### Añadir un poder a un héroe
```
POST /hero/{id}/power
Body: Detalles del poder a añadir
```
##### Obtener un poder en concreto de un héroe
```
GET /hero/{id}/power/{powerId}
```