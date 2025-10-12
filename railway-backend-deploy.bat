@echo off
echo ========================================
echo    RAILWAY BACKEND DEPLOYMENT GUIDE
echo ========================================
echo.
echo This script will help you deploy your backend to Railway
echo.
echo STEP 1: Open Railway
echo ========================================
echo Opening Railway in your browser...
start https://railway.app
echo.
echo STEP 2: Create New Project
echo ========================================
echo 1. Click "New Project"
echo 2. Select "Deploy from GitHub repo"
echo 3. Choose: KushaalNayak/CollegeManagementSystem
echo 4. Select "Backend" folder as root directory
echo.
echo STEP 3: Configure Build Settings
echo ========================================
echo Root Directory: backend
echo Build Command: mvn clean package -DskipTests
echo Start Command: java -jar target/college-management-system-1.0.0.jar
echo Port: 8080 (auto-detected)
echo.
echo STEP 4: Add Environment Variables
echo ========================================
echo Go to Variables tab and add:
echo JWT_SECRET=mySecretKey123456789012345678901234567890
echo SPRING_PROFILES_ACTIVE=railway
echo.
echo STEP 5: Add PostgreSQL Database
echo ========================================
echo 1. Click "New +"
echo 2. Select "Database"
echo 3. Choose "PostgreSQL"
echo 4. Free tier selected automatically
echo 5. Railway will auto-generate DATABASE_URL
echo.
echo STEP 6: Deploy
echo ========================================
echo 1. Click "Deploy"
echo 2. Wait for build to complete
echo 3. Get your backend URL: https://your-app.railway.app
echo.
echo ========================================
echo    DEPLOYMENT COMPLETE!
echo ========================================
echo.
echo Your backend will be available at:
echo https://your-app.railway.app
echo.
echo Test your API:
echo https://your-app.railway.app/api/v1/auth/signin
echo.
pause
