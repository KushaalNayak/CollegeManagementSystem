@echo off
echo ========================================
echo College Management System - Status Check
echo ========================================
echo.

echo Checking Docker containers...
docker-compose ps

echo.
echo Checking if services are accessible...
echo.

echo Testing Backend API...
curl -s http://localhost:8080/api/courses >nul 2>&1
if %errorlevel% equ 0 (
    echo ✅ Backend API is running
) else (
    echo ❌ Backend API is not accessible
)

echo Testing Frontend...
curl -s http://localhost:3000 >nul 2>&1
if %errorlevel% equ 0 (
    echo ✅ Frontend is running
) else (
    echo ❌ Frontend is not accessible
)

echo.
echo ========================================
echo Status Check Complete
echo ========================================
echo.
echo If all services show ✅, your application is ready!
echo.
echo Access your application at: http://localhost:3000
echo.
pause
