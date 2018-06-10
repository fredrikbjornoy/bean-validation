# Simple Spring Boot 2 application showing JSR-380 internationalization

## How to run
````mvn spring-boot:run````

```
curl -X POST \
  http://localhost:8080/persons/ \
  -H 'Accept-Language: no' \
  -H 'Content-Type: application/json' \
  -d '{
        "birthDate": "2019-05-03",
        "name": ""
}'
```
or
```
curl -X POST \
  http://localhost:8080/persons/ \
  -H 'Accept-Language: en' \
  -H 'Content-Type: application/json' \
  -d '{
        "birthDate": "2019-05-03",
        "name": ""
}'
```