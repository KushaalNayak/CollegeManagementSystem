@echo off
echo ========================================
echo Auto Git Deploy - College Management System
echo ========================================
echo.

echo Adding all changes to Git...
git add .

echo.
echo Committing changes...
git commit -m "Auto-deploy: Update College Management System"

echo.
echo Pushing to GitHub...
git push origin main

echo.
echo ========================================
echo ✅ Changes deployed to GitHub successfully!
echo ========================================
echo.
echo Your changes are now live on:
echo https://github.com/KushaalNayak/CollegeManagementSystem
echo.
pause
