@echo off
echo ========================================
echo College Management System - Local Start
echo ========================================
echo.

echo Starting Backend (Spring Boot)...
echo This may take 2-3 minutes for first run...
echo.

start "Backend Server" cmd /k "cd backend && mvn spring-boot:run"

echo Waiting 30 seconds for backend to start...
timeout /t 30 /nobreak >nul

echo.
echo Starting Frontend (React)...
echo.

start "Frontend Server" cmd /k "cd frontend && npm run dev"

echo.
echo ========================================
echo System Starting Complete!
echo ========================================
echo.
echo Backend API: http://localhost:8080/api
echo Frontend App: http://localhost:3000
echo Swagger Docs: http://localhost:8080/api/swagger-ui.html
echo.
echo The application will open automatically.
echo.
pause
