@echo off
echo ========================================
echo Git Setup for College Management System
echo ========================================
echo.

echo Initializing Git repository...
git init

echo.
echo Adding all files to Git...
git add .

echo.
echo Creating initial commit...
git commit -m "Initial commit: College Management System with React frontend and Spring Boot backend"

echo.
echo ========================================
echo Git Setup Complete!
echo ========================================
echo.
echo Next steps:
echo 1. Create a repository on GitHub
echo 2. Run: git remote add origin YOUR_GITHUB_URL
echo 3. Run: git push -u origin main
echo.
echo Or use GitHub Desktop for easier setup.
echo.
pause
