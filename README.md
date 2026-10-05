# kuide-api

## Modules

- `api-gateway`: 외부 요청을 각 서비스로 라우팅합니다.
- `tour-service`: 관광지 및 공영주차장 조회를 담당하는 Spring Boot 서비스입니다.

## 실행

`tour-service`는 기본 설정에서 데이터베이스 연결 없이 실행됩니다.

```powershell
.\gradlew.bat :tour-service:bootRun
```

`tour-service`는 포트 `8080`, `api-gateway`는 포트 `8082`를 사용합니다.
관광지와 주차장 조회 API는 외부 공공 API를 호출하므로, 해당 기능 사용 시 공공 API 설정이 필요합니다.

## Docker 실행

저장소 루트에서 `tour-service` 이미지를 빌드하고 실행합니다.

```powershell
docker build -t kuide-tour-service .
docker run --rm -p 8080:8080 kuide-tour-service
```

컨테이너는 데이터베이스 없이 실행되며 포트 `8080`을 사용합니다.

## REST API

- `GET /api/v1/visit/ldong`: 법정동 코드 조회
- `GET /api/v1/visit/lclsSystm`: 분류체계 코드 조회
- `GET /api/v1/visit/area`: 지역 기반 관광지 조회
- `GET /api/v1/visit/keyword`: 키워드 기반 관광지 조회
- `GET /api/v1/visit/location`: 위치 기반 관광지 조회
- `GET /api/v1/visit/detail`: 관광지 상세 조회
- `GET /api/v1/parking/list`: 공영주차장 목록 조회

Gateway health check: `GET http://localhost:8082/actuator/health`
