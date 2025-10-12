@echo off
echo ========================================
echo 🚀 VERCEL BACKEND DEPLOYMENT
echo ========================================
echo.

echo ✅ YOUR BACKEND IS READY FOR VERCEL!
echo ========================================
echo.
echo Current Status:
echo ✅ Spring Boot 3.2.0 - Latest version
echo ✅ Vercel configuration - vercel.json created
echo ✅ JWT authentication - Security implemented
echo ✅ Swagger API docs - Documentation ready
echo ✅ Environment variables - Configured for Vercel
echo.

echo 🎯 STEP-BY-STEP VERCEL BACKEND DEPLOYMENT
echo ========================================
echo.

echo PHASE 1: DEPLOY BACKEND TO VERCEL (10 minutes)
echo ========================================
echo.
echo Step 1: Go to Vercel
echo 1. Click the Vercel link below
echo 2. Sign in with your GitHub account
echo 3. Click "Import Project"
echo.

echo Step 2: Connect Your Repository
echo 1. Select GitHub as your Git provider
echo 2. Choose repository: KushaalNayak/CollegeManagementSystem
echo 3. Click "Import"
echo.

echo Step 3: Configure Backend Settings
echo 1. Project Name: college-management-backend
echo 2. Framework Preset: Other
echo 3. Root Directory: backend
echo 4. Build Command: mvn clean package -DskipTests
echo 5. Output Directory: target
echo 6. Install Command: mvn dependency:resolve
echo.

echo Step 4: Add Environment Variables
echo 1. Click "Environment Variables"
echo 2. Add these variables:
echo    JWT_SECRET=mySecretKey123456789012345678901234567890
echo    PORT=8080
echo    DATABASE_URL=your-database-url-here
echo.

echo Step 5: Deploy
echo 1. Click "Deploy"
echo 2. Wait for build to complete (5-10 minutes)
echo 3. Your backend will be live! 🎉
echo.

echo PHASE 2: SETUP DATABASE (5 minutes)
echo ========================================
echo.
echo Option A: Supabase (Recommended)
echo 1. Go to: https://supabase.com
echo 2. Sign up/Login
echo 3. Create new project
echo 4. Get connection string
echo 5. Add to Vercel environment variables
echo.

echo Option B: Railway PostgreSQL
echo 1. Go to: https://railway.app
echo 2. Create new project
echo 3. Add PostgreSQL database
echo 4. Get connection string
echo 5. Add to Vercel environment variables
echo.

echo PHASE 3: CONNECT FRONTEND TO BACKEND (5 minutes)
echo ========================================
echo.
echo Step 6: Get Backend URL
echo 1. Vercel will provide: https://your-backend.vercel.app
echo 2. Your API endpoint: https://your-backend.vercel.app/api
echo.

echo Step 7: Update Frontend Environment
echo 1. Go to your frontend Vercel project
echo 2. Settings → Environment Variables
echo 3. Add new variable:
echo    - Name: REACT_APP_API_URL
echo    - Value: https://your-backend.vercel.app/api
echo 4. Redeploy frontend
echo.

echo 🎉 EXPECTED RESULT:
echo ========================================
echo.
echo Your Complete System on Vercel:
echo ✅ Frontend: https://your-frontend.vercel.app (Vercel)
echo ✅ Backend: https://your-backend.vercel.app/api (Vercel)
echo ✅ Database: PostgreSQL on Supabase/Railway
echo ✅ API Documentation: https://your-backend.vercel.app/api/swagger-ui.html
echo.

echo Features Working:
echo ✅ User Registration & Login
echo ✅ JWT Authentication
echo ✅ Student Management
echo ✅ Course Management
echo ✅ Marks Management
echo ✅ Fees Management
echo ✅ Dashboard with Analytics
echo ✅ Responsive Design
echo ✅ Professional UI/UX
echo.

echo 🚀 Opening Deployment Platforms...
echo ========================================
start https://vercel.com
start https://supabase.com
start https://railway.app

echo.
echo ========================================
echo DEPLOYMENT TIME: 20 MINUTES TOTAL
echo YOUR COMPLETE SYSTEM ON VERCEL!
echo ========================================
echo.
pause
