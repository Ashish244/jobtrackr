## JobTrackr – Quickstart

Requirements: JDK 17+, Maven 3.9+

### Run
```bash
mvn spring-boot:run
```

- Swagger UI: http://localhost:8080/swagger-ui.html
- H2 console: http://localhost:8080/h2  (JDBC: jdbc:h2:mem:jobtrackr)

### Sample requests
Create:
```bash
curl -X POST http://localhost:8080/api/v1/applications  -H 'Content-Type: application/json'  -d '{
   "company":"Amazon",
   "role":"SWE I",
   "source":"LinkedIn",
   "appliedOn":"2025-10-21",
   "status":"APPLIED",
   "notes":"recruiter reached out"
 }'
```
List:
```bash
curl "http://localhost:8080/api/v1/applications?status=APPLIED"
```
Update status:
```bash
curl -X PATCH "http://localhost:8080/api/v1/applications/1/status?status=INTERVIEW"
```
