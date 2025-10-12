@echo off
echo ========================================
echo Complete Website Deployment to Vercel
echo ========================================
echo.

echo 🚀 Step 1: Deploy Frontend to Vercel
echo ========================================
echo.
echo 1. Go to: https://vercel.com
echo 2. Sign up/Login with GitHub
echo 3. Click "Import Project"
echo 4. Choose: KushaalNayak/CollegeManagementSystem
echo 5. Select "frontend" folder
echo 6. Framework Preset: Create React App
echo 7. Build Command: npm run build
echo 8. Output Directory: build
echo 9. Click "Deploy"
echo.

echo 🎯 Step 2: Deploy Backend to Vercel
echo ========================================
echo.
echo 1. Create new project in Vercel
echo 2. Choose: KushaalNayak/CollegeManagementSystem
echo 3. Select "backend" folder
echo 4. Framework Preset: Other
echo 5. Build Command: mvn clean package -DskipTests
echo 6. Output Directory: target
echo 7. Click "Deploy"
echo.

echo 🗄️ Step 3: Add Database
echo ========================================
echo.
echo 1. Go to: https://supabase.com
echo 2. Create new project (free PostgreSQL)
echo 3. Get connection string
echo 4. Add to backend environment variables
echo.

echo 🎉 Step 4: Your Website is Live!
echo ========================================
echo.
echo Frontend: https://your-app.vercel.app
echo Backend: https://your-backend.vercel.app/api
echo.
echo All features will work:
echo ✅ User Registration & Login
echo ✅ Student Management
echo ✅ Course Management
echo ✅ Marks Management
echo ✅ Fees Management
echo ✅ Dashboard with Analytics
echo.

echo Opening deployment platforms...
start https://vercel.com
start https://supabase.com

echo.
echo ========================================
echo Your Complete Website Will Be Live!
echo ========================================
echo.
pause
