# 🌬️ saviasoft.air.entity – Microservicio de Lecturas de Calidad del Aire

Este microservicio forma parte de una arquitectura basada en microservicios para el monitoreo de calidad del aire en tiempo real. Su propósito es **recibir, almacenar y exponer** las lecturas enviadas por dispositivos IoT que miden distintos parámetros del aire, como el índice de calidad (AQI), ubicación geográfica y timestamp.

---

## 🧱 Arquitectura general

Este servicio interactúa dentro de un ecosistema basado en Spring Cloud:

- 🌐 **Gateway:** Entrada unificada para los microservicios
- 🔍 **Eureka:** Descubrimiento de servicios
- 🔐 **Auth Service:** Proveedor de JWT y control de acceso

---

## 🔄 Flujo de datos

1. El **dispositivo** envía una lectura a este microservicio mediante una API HTTP (`POST /readings`)
2. La lectura incluye:
   - Identificador del dispositivo
   - Latitud / Longitud
   - Valor decimal de calidad del aire (ej. 45.3)
   - Timestamp
3. Se almacena en **MongoDB** para soportar grandes volúmenes y eficiencia en consultas geoespaciales.
4. Las APIs públicas permiten:
   - Consultar historial
   - Obtener valores por rango de tiempo
   - Visualizar ubicaciones y niveles actuales

---

## 🧪 Ejemplo de Payload

```json
{
  "deviceId": "SENSOR-01",
  "lat": 8.983333,
  "lng": -79.516667,
  "quality": 52.7,
  "timestamp": "2025-07-14T13:00:00Z"
}
````

---

## 🧰 Tecnologías

* Spring Boot 3
* Spring Data MongoDB
* MongoDB (base de datos de lecturas)
* JWT + Spring Security (validación de tokens)
* Eureka Client
* OpenAPI/Swagger para documentación

---

## 📂 Endpoints

| Método | Ruta                            | Descripción                                 |
| ------ | ------------------------------- | ------------------------------------------- |
| POST   | /api/readings                   | Registrar una nueva lectura del dispositivo |
| GET    | /api/readings                   | Listar todas las lecturas                   |
| GET    | /api/readings/{id}              | Obtener detalle de una lectura              |
| GET    | /api/readings/range?from\&to    | Lecturas por rango de tiempo                |
| GET    | /api/readings/device/{deviceId} | Lecturas por dispositivo                    |

---

## 🧑‍💻 Autor / Colaborador

Desarrollado por: jagudo2514@gmail.com
