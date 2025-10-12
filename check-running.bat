@echo off
echo ========================================
echo Checking College Management System Status
echo ========================================
echo.

echo Checking if services are running...
echo.

echo Backend API (Spring Boot):
curl -s http://localhost:8080/api/courses >nul 2>&1
if %errorlevel% equ 0 (
    echo ✅ Backend API is running at http://localhost:8080/api
) else (
    echo ❌ Backend API is not running
)

echo.
echo Frontend (React):
curl -s http://localhost:3000 >nul 2>&1
if %errorlevel% equ 0 (
    echo ✅ Frontend is running at http://localhost:3000
) else (
    echo ❌ Frontend is not running
)

echo.
echo ========================================
echo Status Check Complete
echo ========================================
echo.
echo If both show ✅, your application is ready!
echo.
echo Access your application at: http://localhost:3000
echo.
pause
