@echo off
echo ========================================
echo College Management System Setup
echo ========================================

echo.
echo Setting up Backend...
cd backend

echo Installing Maven dependencies...
call mvn clean install -DskipTests

echo.
echo Setting up Frontend...
cd ..\frontend

echo Installing Node.js dependencies...
call npm install

echo.
echo ========================================
echo Setup Complete!
echo ========================================
echo.
echo To start the application:
echo 1. Start Backend: cd backend && mvn spring-boot:run
echo 2. Start Frontend: cd frontend && npm start
echo.
echo Or use Docker: docker-compose up -d
echo.
pause
