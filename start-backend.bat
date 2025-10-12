@echo off
echo ========================================
echo Starting College Management Backend
echo ========================================
echo.

cd backend

echo Installing dependencies and building...
call mvn clean install -DskipTests

echo.
echo Starting Spring Boot application...
echo The API will be available at: http://localhost:8080/api
echo Swagger UI will be at: http://localhost:8080/api/swagger-ui.html
echo.

call mvn spring-boot:run
