# CastilloApplication

#  Sistema de Coordinación Estratégica - Castillo Infinito

Sistema de coordinación para el Cuerpo de Cazadores durante la batalla final contra Muzan Kibutsuji en el Castillo Infinito.

## Cómo Ejecutar el Proyecto

### Prerrequisitos
- Java 17 o superior
- MySQL 8.0 o superior
- Maven 3.6 o superior

### Pasos de Instalación

1. **Clonar el repositorio**
   ```bash
   git clone <url-del-repositorio>
   cd castillo-infinito


   Configurar Base de Datos
CREATE DATABASE demon_slayer_db;


Endpoints Disponibles
 1. GET /api/pilares/{id}
Consulta la información completa de un Pilar.

Ejemplo:

bash
curl -X GET http://localhost:8080/api/pilares/1
2. GET /api/inteligencia/triangulacion
Obtiene triangulación estimada del enemigo.

Ejemplo:

bash
curl -X GET http://localhost:8080/api/inteligencia/triangulacion
 3. POST /api/pilares/actualizar-posicion
Registra o actualiza la posición de un Pilar.

Ejemplo:

bash
curl -X POST http://localhost:8080/api/pilares/actualizar-posicion \
  -H "Content-Type: application/json" \
  -d '{
    "pilarId": 1,
    "posX": -480,
    "posY": -210,
    "estado": "Herido"
  }'
4. POST /api/mensajes
Registra mensaje táctico fragmentado.

Ejemplo:

bash
curl -X POST http://localhost:8080/api/mensajes \
  -H "Content-Type: application/json" \
  -d '{
    "pilarId": 3,
    "contenidoFragmentado": "Muz... mov... norte... ata..."
  }'
5. PUT /api/mensajes/{id}/reconstruir
Reconstruye un mensaje táctico.

Ejemplo:

bash
curl -X PUT http://localhost:8080/api/mensajes/1/reconstruir \
  -H "Content-Type: application/json" \
  -d '{
    "contenidoReconstruido": "Muzan se mueve hacia el norte. Preparar ataque."
  }'