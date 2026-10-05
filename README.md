
# kuide-api

## Modules

- `api-gateway`: 외부 요청을 각 서비스로 라우팅합니다.
- `tour-service`: 투어 도메인을 담당하는 독립 Spring Boot 서비스입니다.

## tour-service 기술 구성

- Gradle 멀티모듈
- Spring Data JPA: 투어 생성/변경과 영속성 모델
- MyBatis: 조회 전용 SQL 매퍼
- Microsoft SQL Server: 기본 데이터베이스

## 실행

```powershell
gradle :tour-service:bootRun
```

기본 포트는 `8081`이며, 데이터베이스 접속 정보는 `tour-service/src/main/resources/application.yml`에 설정되어 있습니다.

MSSQL 서버에 `kuide` 데이터베이스를 생성해야 합니다. 이후 JPA가 `tours` 테이블을 생성합니다.

## REST API

- `GET /api/v1/tours`: 투어 목록 조회
- `GET /api/v1/tours/{id}`: 투어 단건 조회
- `POST /api/v1/tours`: 투어 생성

```json
{
  "title": "Seoul City Tour",
  "description": "A guided tour around Seoul"
}
```
gradle :services:api-gateway:bootRun
# In another terminal
gradle :services:api-service:bootRun
# In another terminal
gradle :services:notification-service:bootRun
```

Gateway health check: `GET http://localhost:8082/actuator/health`

External API: `http://localhost:8082/api/v1/users`

The example endpoint uses JPA for writes and MyBatis for reads:

```text
GET  /api/v1/users
POST /api/v1/users
{
  "name": "Kim",
  "email": "kim@example.com"
}
```

When a user is created, `api-service` publishes `user.created` to the
`kuide.user.events` exchange. `notification-service` consumes it from the
`notification.user.created` queue.

Add future services under `services/` and keep each service independently deployable. Share only stable contracts or infrastructure modules; avoid sharing entities between services.
