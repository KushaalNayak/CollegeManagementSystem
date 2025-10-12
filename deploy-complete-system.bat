@echo off
echo ========================================
echo Deploy College Management System
echo ========================================
echo.

echo ✅ GitHub Repository: https://github.com/KushaalNayak/CollegeManagementSystem
echo.

echo 🚀 Step 1: Deploy Backend to Railway
echo ========================================
echo.
echo 1. Go to: https://railway.app
echo 2. Sign up with GitHub
echo 3. Click "New Project"
echo 4. Select "Deploy from GitHub repo"
echo 5. Choose: KushaalNayak/CollegeManagementSystem
echo 6. Select "backend" folder
echo 7. Railway will auto-deploy!
echo.
echo 8. Add PostgreSQL database:
echo    - Click "New" → "Database" → "PostgreSQL"
echo.
echo 9. Get your backend URL:
echo    - Railway will give you: https://your-app.railway.app
echo    - Your API will be: https://your-app.railway.app/api
echo.

echo 🎨 Step 2: Deploy Frontend to Vercel
echo ========================================
echo.
echo 1. Go to: https://vercel.com
echo 2. Sign up with GitHub
echo 3. Click "Import Project"
echo 4. Choose: KushaalNayak/CollegeManagementSystem
echo 5. Select "frontend" folder
echo 6. Add Environment Variable:
echo    - Name: REACT_APP_API_URL
echo    - Value: https://your-backend-url.railway.app/api
echo 7. Click "Deploy"
echo.

echo 🎉 Step 3: Your App is Live!
echo ========================================
echo.
echo Frontend: https://your-app.vercel.app
echo Backend: https://your-app.railway.app/api
echo Swagger: https://your-app.railway.app/api/swagger-ui.html
echo.

echo Opening deployment platforms...
start https://railway.app
start https://vercel.com
echo.
pause
