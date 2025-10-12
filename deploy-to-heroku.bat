@echo off
echo ========================================
echo Deploy College Management System to Heroku
echo ========================================
echo.

echo Step 1: Installing Heroku CLI (if not installed)...
echo Please download from: https://devcenter.heroku.com/articles/heroku-cli
echo.

echo Step 2: Login to Heroku...
heroku login

echo.
echo Step 3: Creating Heroku app for backend...
cd backend
heroku create college-management-backend

echo.
echo Step 4: Adding MySQL database...
heroku addons:create cleardb:ignite

echo.
echo Step 5: Deploying backend...
git init
git add .
git commit -m "Deploy backend to Heroku"
git push heroku main

echo.
echo Step 6: Getting backend URL...
heroku apps:info

echo.
echo ========================================
echo Backend Deployed Successfully!
echo ========================================
echo.
echo Your backend is now live at: https://college-management-backend.herokuapp.com/api
echo.
echo Next: Deploy frontend to Vercel with backend URL
echo.
pause
