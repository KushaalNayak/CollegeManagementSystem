@echo off
echo ========================================
echo College Management System - Complete Setup
echo ========================================
echo.

echo Step 1: Starting Backend (Spring Boot)...
echo This may take 2-3 minutes for first run...
echo.

start "Backend Server" cmd /k "cd backend && mvn spring-boot:run"

echo Waiting 30 seconds for backend to start...
timeout /t 30 /nobreak >nul

echo.
echo Step 2: Starting Frontend (React)...
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
echo NOTE: Registration will work once backend is fully started.
echo Wait for "Started CollegeManagementSystemApplication" message.
echo.
pause
