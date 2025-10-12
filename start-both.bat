@echo off
echo ========================================
echo Starting College Management System
echo ========================================
echo.

echo Starting Backend (Spring Boot)...
start "Backend" cmd /k "cd backend && mvn spring-boot:run"

echo Waiting 10 seconds for backend to start...
timeout /t 10 /nobreak >nul

echo Starting Frontend (React)...
start "Frontend" cmd /k "cd frontend && npm run dev"

echo.
echo ========================================
echo Both services are starting!
echo ========================================
echo.
echo Backend: http://localhost:8080/api
echo Frontend: http://localhost:3000
echo.
echo The application will open automatically in your browser.
echo.
pause
