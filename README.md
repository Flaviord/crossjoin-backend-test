# Backend Test

Welcome to the backend test. This project was created under [Spring Boot](https://spring.io/projects/spring-boot)

## Local development environment

### 1. Running Database
On the root run `docker-compose up --build -d db`.

### 2. Running Services

- Go to /product-service and run `./mvnw spring-boot:run`

### 3. Migrations

For migrations was used [Flywaydb](https://flywaydb.org).

When you run the services initial structure will be created.

If you need to load some data. You will need to create a file following nomenclature `V{version_number}__{file_name}.sql`
and add it inside of folder `./resources/db/migration`.

### 4. API

[resquet api product](http://localhost:9001/product)
[resquet api store](http://localhost:9001/store)
