# StreamSpace — Video Streaming Microservices

A ready-to-import Spring Boot multi-module project for a student submission. It demonstrates video selection, a real bundled MP4 demo clip for each selection, Eureka service registration/discovery, and routing through Spring Cloud Gateway.

## Services and ports

| Module | Port | Responsibility |
|---|---:|---|
| `eureka-server` | 8761 | Service registry dashboard |
| `video-service` | 8081 | Video catalogue and web UI |
| `streaming-service` | 8082 | Serves the selected MP4 clip |
| `api-gateway` | 8080 | Single entry point; routes with `lb://` service names |

## Open in Spring Tool Suite (STS)

1. Extract `VideoStreamingSystem.zip` to your Desktop.
2. In STS choose **File → Import → Maven → Existing Maven Projects**.
3. For **Root Directory**, choose the extracted `VideoStreamingSystem` folder (the one containing the parent `pom.xml`).
4. Ensure the root project and four modules are detected, then click **Finish**. Wait for Maven dependencies to finish downloading.
5. Ensure STS is using JDK 17 or newer. Internet access is needed the first time Maven downloads dependencies.
6. In Project Explorer, run each class below with **Right-click → Run As → Spring Boot App**, in this order:
   - `EurekaServerApplication.java` in `eureka-server`
   - `VideoServiceApplication.java` in `video-service`
   - `StreamingServiceApplication.java` in `streaming-service`
   - `ApiGatewayApplication.java` in `api-gateway`
7. Wait until all four consoles report that the applications started.
8. Open **http://localhost:8080** to use the video player. Open **http://localhost:8761** to see the Eureka dashboard and registered services.

## Test endpoints

- `http://localhost:8080/api/videos` — video catalogue JSON
- `http://localhost:8080/api/stream/1` — Ocean Escape MP4
- `http://localhost:8080/api/stream/2` — Forest Morning MP4
- `http://localhost:8080/api/stream/3` — Sunset Sky MP4

The gateway removes the `/api` prefix before routing. Its `lb://VIDEO-SERVICE` and `lb://STREAMING-SERVICE` destinations are resolved through Eureka rather than hardcoded service host/ports.

## Optional: run from Terminal

If Maven is installed, open Terminal in this folder and run each command in a separate Terminal tab/window:

```bash
mvn -pl eureka-server spring-boot:run
mvn -pl video-service spring-boot:run
mvn -pl streaming-service spring-boot:run
mvn -pl api-gateway spring-boot:run
```

Then visit `http://localhost:8080`.

## Notes

- The clips are short, locally generated demo MP4s included in `streaming-service/src/main/resources/videos/`; no external video download is required.
- If a port is already in use, stop the other application using it before starting this project.
- If Maven dependency downloads fail, check the internet connection and retry **Maven → Update Project** in STS.
