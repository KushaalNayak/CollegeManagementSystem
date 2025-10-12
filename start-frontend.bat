@echo off
echo ========================================
echo Starting College Management Frontend
echo ========================================
echo.

cd frontend

echo Installing dependencies (if needed)...
call npm install

echo.
echo Starting development server...
echo The application will open at: http://localhost:3000
echo.

call npm run dev
