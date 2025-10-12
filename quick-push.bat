@echo off
echo ========================================
echo Quick Git Push - College Management System
echo ========================================
echo.

git add .
git commit -m "Update: %date% %time%"
git push origin main

echo.
echo ✅ Pushed to GitHub successfully!
echo.
pause
