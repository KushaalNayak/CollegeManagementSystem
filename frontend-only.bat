@echo off
echo ========================================
echo College Management System - Frontend Only
echo ========================================
echo.

echo Starting Frontend Only (without backend)...
echo.

cd frontend
npm run dev

echo.
echo ========================================
echo Frontend Started!
echo ========================================
echo.
echo Frontend: http://localhost:3000
echo.
echo Note: Registration won't work without backend.
echo To fix: Deploy backend to Railway or install Maven.
echo.
pause
