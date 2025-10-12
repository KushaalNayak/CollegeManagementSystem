# 🎓 College Management System - Complete Setup Guide

## 🚨 Prerequisites Installation

### Option 1: Quick Setup with Docker (Recommended)

If you don't have Java/Node.js installed, Docker is the easiest way to get started:

#### 1. Install Docker Desktop
- Download from: https://www.docker.com/products/docker-desktop/
- Install and restart your computer
- Verify installation: `docker --version`

#### 2. Run the Application
```bash
# Navigate to your project directory
cd "C:\Users\R B KUSHAAL NAYAK\Desktop\Projects\MajorProject"

# Start all services with Docker
docker-compose up -d

# Check if services are running
docker-compose ps
```

**That's it!** Your application will be available at:
- **Frontend:** http://localhost:3000
- **Backend:** http://localhost:8080/api
- **Swagger:** http://localhost:8080/api/swagger-ui.html

---

### Option 2: Manual Installation (If you want to develop locally)

#### 1. Install Java 17
- Download from: https://adoptium.net/
- Install and add to PATH
- Verify: `java -version`

#### 2. Install Maven
- Download from: https://maven.apache.org/download.cgi
- Extract and add to PATH
- Verify: `mvn -version`

#### 3. Install Node.js
- Download from: https://nodejs.org/
- Install LTS version
- Verify: `node -version` and `npm -version`

#### 4. Install MySQL
- Download from: https://dev.mysql.com/downloads/
- Install and create database:
  ```sql
  CREATE DATABASE college_management;
  ```

#### 5. Run the Application

**Backend:**
```bash
cd backend
mvn clean install
mvn spring-boot:run
```

**Frontend (in new terminal):**
```bash
cd frontend
npm install
npm start
```

---

## 🎯 Quick Start (Docker Method)

### Step 1: Start the Application
```bash
# In your project directory
docker-compose up -d
```

### Step 2: Wait for Services to Start
```bash
# Check logs
docker-compose logs -f
```

### Step 3: Access the Application
- Open browser and go to: **http://localhost:3000**
- You should see the College Management System login page

### Step 4: Register a New User
1. Click "Sign up here" on the login page
2. Fill in the registration form
3. Choose your role (Student, Faculty, HOD, Admin)
4. Click "Create Account"
5. Login with your credentials

---

## 🔧 Configuration

### Database Configuration (if using manual setup)
Update `backend/src/main/resources/application.yml`:
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/college_management?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
    username: root
    password: your_password
```

### Frontend Configuration
The frontend is already configured to connect to the backend at `http://localhost:8080/api`.

---

## 🎨 Features to Explore

### 1. **Dashboard**
- View statistics and analytics
- Interactive charts and graphs
- Recent activities feed
- Quick action buttons

### 2. **Student Management**
- Add new students
- View student list with search/filter
- Edit student information
- Assign students to courses

### 3. **Course Management**
- Create new courses
- View course details
- Manage course fees
- Track course enrollment

### 4. **Marks Management**
- Enter student marks
- View grade reports
- Track academic performance
- Generate mark sheets

### 5. **Fees Management**
- Track fee payments
- View payment history
- Generate fee reports
- Manage outstanding balances

### 6. **Profile Management**
- Update personal information
- Change password
- View role-based dashboard

---

## 🚨 Troubleshooting

### Docker Issues
```bash
# If containers fail to start
docker-compose down
docker-compose up -d

# If you get port conflicts
docker-compose down
# Change ports in docker-compose.yml
docker-compose up -d
```

### Database Issues
```bash
# Reset database
docker-compose down -v
docker-compose up -d
```

### Frontend Issues
```bash
# Clear browser cache
# Or restart containers
docker-compose restart frontend
```

### Backend Issues
```bash
# Check backend logs
docker-compose logs backend

# Restart backend
docker-compose restart backend
```

---

## 📱 User Roles & Permissions

### **Admin**
- Full system access
- User management
- System configuration
- All CRUD operations

### **Head of Department (HOD)**
- Department management
- Faculty oversight
- Student management within department
- Course management

### **Faculty**
- Student management
- Marks entry and management
- Course management
- View student progress

### **Student**
- View personal information
- View marks and grades
- View fees and payments
- Limited access to own data

---

## 🎯 Testing the Application

### 1. **User Registration**
- Go to http://localhost:3000
- Click "Sign up here"
- Register with different roles
- Test login functionality

### 2. **Student Management**
- Login as Admin/Faculty
- Navigate to Students
- Add new students
- Test search and filter

### 3. **Course Management**
- Navigate to Courses
- Create new courses
- View course details
- Test course enrollment

### 4. **Marks Management**
- Navigate to Marks
- Enter student marks
- View grade reports
- Test different exam types

### 5. **Fees Management**
- Navigate to Fees
- Add fee records
- Track payments
- View financial reports

---

## 🎉 Success Indicators

You'll know everything is working when you see:

✅ **Backend running:** http://localhost:8080/api  
✅ **Frontend running:** http://localhost:3000  
✅ **Database connected:** No connection errors  
✅ **Login working:** Can register and login  
✅ **Dashboard loading:** Shows statistics and charts  
✅ **All modules accessible:** Students, Courses, Marks, Fees  

---

## 🆘 Need Help?

If you encounter any issues:

1. **Check Docker status:** `docker-compose ps`
2. **View logs:** `docker-compose logs -f`
3. **Restart services:** `docker-compose restart`
4. **Reset everything:** `docker-compose down -v && docker-compose up -d`

---

## 🚀 Next Steps

Once everything is running:

1. **Explore the UI:** Navigate through all modules
2. **Test functionality:** Add students, courses, marks, fees
3. **Check responsiveness:** Test on different screen sizes
4. **Review code:** Examine the clean, well-structured codebase
5. **Customize:** Modify colors, add features, extend functionality

**Happy Learning! 🎓**
