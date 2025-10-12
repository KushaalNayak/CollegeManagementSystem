@echo off
echo ========================================
echo Deploy to Render (FREE)
echo ========================================
echo.

echo Step 1: Go to https://render.com
echo Step 2: Sign up with GitHub
echo Step 3: Connect your repository
echo Step 4: Create Web Service
echo Step 5: Render will deploy!
echo.

echo ========================================
echo Render Deployment Steps:
echo ========================================
echo.
echo 1. Create Render account at https://render.com
echo 2. Click "New" → "Web Service"
echo 3. Connect your GitHub repository
echo 4. Select "backend" folder
echo 5. Build Command: mvn clean install
echo 6. Start Command: java -jar target/college-management-system-1.0.0.jar
echo 7. Render will automatically deploy!
echo.
echo 8. Add PostgreSQL database:
echo    - Click "New" → "PostgreSQL"
echo    - Render will provide connection details
echo.
echo 9. Get your backend URL:
echo    - Render will give you: https://your-app.onrender.com
echo    - Your API will be: https://your-app.onrender.com/api
echo.
echo ========================================
echo Your backend will be live for FREE!
echo ========================================
echo.
pause
