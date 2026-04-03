
# Automotive JavaEE / Jakarta EE

Aplicație Jakarta EE refăcută de la zero, cu:
- JAX-RS resources
- JPA / Hibernate
- DTO-uri + mappere
- service interfaces + implementări
- Flyway migration history
- OpenAPI + Swagger UI
- Docker / Docker Compose
- MySQL, Prometheus și Grafana pe porturi diferite de proiectele Quarkus și Spring Boot

## Porturi
- App: `8087`
- MySQL: `3311`
- Prometheus: `9094`
- Grafana: `3004`

## Bază de date
```sql
CREATE DATABASE IF NOT EXISTS automotiveJavaEE;
USE automotiveJavaEE;
```

În mod normal, Docker o creează automat prin variabilele de mediu.

## Rulare
```bash
docker compose up --build
```

## Endpoint-uri
- API base: `http://localhost:8087/api`
- OpenAPI: `http://localhost:8087/openapi`
- Swagger UI: `http://localhost:8087/swagger-ui/`
- Metrics: `http://localhost:8087/metrics`
- Health: `http://localhost:8087/health`
- Prometheus: `http://localhost:9094`
- Grafana: `http://localhost:3004`

## Credențiale default
- MySQL user: `automotive`
- MySQL password: `Automotive123!`
- MySQL root password: `root`
- Grafana: `admin / admin`
