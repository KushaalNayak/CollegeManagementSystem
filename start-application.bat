@echo off
echo ========================================
echo College Management System
echo ========================================
echo.

echo Checking Docker installation...
docker --version >nul 2>&1
if %errorlevel% neq 0 (
    echo Docker is not installed or not in PATH.
    echo Please install Docker Desktop from: https://www.docker.com/products/docker-desktop/
    echo.
    pause
    exit /b 1
)

echo Docker is available!
echo.

echo Starting College Management System...
echo This will start:
echo - MySQL Database
echo - Spring Boot Backend
echo - React Frontend
echo.

echo Starting services...
docker-compose up -d

echo.
echo ========================================
echo Services Starting...
echo ========================================
echo.

echo Waiting for services to start...
timeout /t 10 /nobreak >nul

echo.
echo ========================================
echo Application Ready!
echo ========================================
echo.
echo Frontend: http://localhost:3000
echo Backend API: http://localhost:8080/api
echo Swagger UI: http://localhost:8080/api/swagger-ui.html
echo.
echo Opening browser...
start http://localhost:3000

echo.
echo To stop the application, run: docker-compose down
echo To view logs, run: docker-compose logs -f
echo.
pause
