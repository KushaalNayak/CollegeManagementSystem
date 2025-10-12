# 🚀 College Management System - Startup Guide

## Quick Start (Recommended)

### Option 1: Using Setup Scripts

**Windows:**
```bash
# Run the setup script
setup.bat
```

**Linux/Mac:**
```bash
# Make script executable and run
chmod +x setup.sh
./setup.sh
```

### Option 2: Manual Setup

## Prerequisites

- **Java 17** or higher
- **Node.js 16** or higher  
- **MySQL 8.0** or higher
- **Maven 3.6** or higher

## Step-by-Step Setup

### 1. Database Setup

1. **Install MySQL** (if not already installed)
2. **Create Database:**
   ```sql
   CREATE DATABASE college_management;
   ```
3. **Update Database Configuration:**
   - Edit `backend/src/main/resources/application.yml`
   - Update database credentials if needed

### 2. Backend Setup

```bash
# Navigate to backend directory
cd backend

# Install dependencies and build
mvn clean install

# Start the backend server
mvn spring-boot:run
```

**Backend will start on:** `http://localhost:8080`

### 3. Frontend Setup

```bash
# Navigate to frontend directory (in a new terminal)
cd frontend

# Install dependencies
npm install

# Start the development server
npm start
```

**Frontend will start on:** `http://localhost:3000`

## 🐳 Docker Setup (Alternative)

If you prefer using Docker:

```bash
# Build and start all services
docker-compose up -d

# Check logs
docker-compose logs -f
```

## 🔧 Configuration

### Backend Configuration

Update `backend/src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/college_management?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
    username: your_username
    password: your_password
```

### Frontend Configuration

Update `frontend/src/services/api.ts` if needed:

```typescript
const API_BASE_URL = process.env.REACT_APP_API_URL || 'http://localhost:8080/api';
```

## 🎯 Access Points

- **Frontend Application:** http://localhost:3000
- **Backend API:** http://localhost:8080/api
- **Swagger Documentation:** http://localhost:8080/api/swagger-ui.html
- **API Documentation:** http://localhost:8080/api/api-docs

## 👤 Default Users

The system will create default users on first run. You can register new users through the registration page.

### Test Credentials (if seeded):
- **Admin:** admin@college.com / admin123
- **Student:** student@college.com / student123
- **Faculty:** faculty@college.com / faculty123

## 🚨 Troubleshooting

### Common Issues:

1. **Port Already in Use:**
   ```bash
   # Kill process on port 8080 (backend)
   netstat -ano | findstr :8080
   taskkill /PID <PID> /F
   
   # Kill process on port 3000 (frontend)
   netstat -ano | findstr :3000
   taskkill /PID <PID> /F
   ```

2. **Database Connection Issues:**
   - Ensure MySQL is running
   - Check database credentials
   - Verify database exists

3. **Node Modules Issues:**
   ```bash
   cd frontend
   rm -rf node_modules package-lock.json
   npm install
   ```

4. **Maven Issues:**
   ```bash
   cd backend
   mvn clean
   mvn install
   ```

## 📱 Features to Test

1. **User Registration & Login**
2. **Dashboard Analytics**
3. **Student Management**
4. **Course Management**
5. **Marks Entry & Viewing**
6. **Fees Management**
7. **Profile Management**

## 🔍 API Testing

Use Swagger UI at `http://localhost:8080/api/swagger-ui.html` to test API endpoints.

## 📊 Database Schema

The application will automatically create the required tables on first run.

## 🎨 UI/UX Features

- **Responsive Design:** Works on desktop, tablet, and mobile
- **Modern Interface:** Clean, professional design
- **Interactive Charts:** Real-time data visualization
- **Role-based Access:** Different views for different user types
- **Search & Filter:** Advanced data filtering capabilities

## 🆘 Support

If you encounter any issues:

1. Check the console logs
2. Verify all prerequisites are installed
3. Ensure ports 3000 and 8080 are available
4. Check database connectivity

## 🎉 Success!

Once everything is running, you should see:
- ✅ Backend running on port 8080
- ✅ Frontend running on port 3000
- ✅ Database connected
- ✅ All services healthy

**Happy Coding! 🚀**
