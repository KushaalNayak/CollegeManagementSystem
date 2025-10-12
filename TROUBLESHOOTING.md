# 🔧 Troubleshooting Guide

## 🚨 **Common Issues & Solutions**

### **Issue 1: "Cannot find path" errors**
**Problem:** Terminal not in correct directory
**Solution:**
```bash
# Navigate to project directory first
cd "C:\Users\R B KUSHAAL NAYAK\Desktop\Projects\MajorProject"

# Then run commands
cd backend && mvn spring-boot:run
cd frontend && npm run dev
```

### **Issue 2: Registration fails**
**Problem:** Backend not running
**Solution:**
1. **Start backend first:** `cd backend && mvn spring-boot:run`
2. **Wait for:** "Started CollegeManagementSystemApplication"
3. **Then start frontend:** `cd frontend && npm run dev`

### **Issue 3: Port already in use**
**Problem:** Ports 3000 or 8080 are occupied
**Solution:**
```bash
# Kill processes on ports
netstat -ano | findstr :3000
taskkill /PID <PID> /F

netstat -ano | findstr :8080
taskkill /PID <PID> /F
```

### **Issue 4: Maven not found**
**Problem:** Maven not installed or not in PATH
**Solution:**
1. **Install Maven:** https://maven.apache.org/download.cgi
2. **Add to PATH:** Add Maven bin directory to system PATH
3. **OR use Docker:** `docker-compose up -d`

### **Issue 5: Node.js not found**
**Problem:** Node.js not installed
**Solution:**
1. **Install Node.js:** https://nodejs.org/
2. **Install dependencies:** `cd frontend && npm install`
3. **Start development:** `npm run dev`

---

## 🚀 **Quick Fix Commands**

### **Start Everything (Recommended)**
```bash
# Use the complete system script
start-complete-system.bat
```

### **Manual Start (Step by Step)**
```bash
# Step 1: Start Backend (Terminal 1)
cd "C:\Users\R B KUSHAAL NAYAK\Desktop\Projects\MajorProject"
cd backend
mvn spring-boot:run

# Step 2: Start Frontend (Terminal 2)
cd "C:\Users\R B KUSHAAL NAYAK\Desktop\Projects\MajorProject"
cd frontend
npm run dev
```

### **Docker Start (Easiest)**
```bash
cd "C:\Users\R B KUSHAAL NAYAK\Desktop\Projects\MajorProject"
docker-compose up -d
```

---

## 🔍 **Check Status**

### **Check if services are running:**
```bash
# Run this script
check-running.bat
```

### **Manual checks:**
- **Backend:** http://localhost:8080/api
- **Frontend:** http://localhost:3000
- **Swagger:** http://localhost:8080/api/swagger-ui.html

---

## 🎯 **Success Indicators**

### **Backend is running when you see:**
```
Started CollegeManagementSystemApplication in X.XXX seconds
```

### **Frontend is running when you see:**
```
webpack compiled successfully
Local:            http://localhost:3000
```

### **Registration works when:**
- Backend is running
- Frontend can connect to backend
- No CORS errors in browser console

---

## 🚨 **Emergency Fixes**

### **If nothing works:**
1. **Restart computer**
2. **Use Docker:** `docker-compose up -d`
3. **Check ports:** Make sure 3000 and 8080 are free

### **If Docker doesn't work:**
1. **Install Docker Desktop**
2. **Restart computer**
3. **Run:** `docker-compose up -d`

---

## 📱 **Final Checklist**

- ✅ **Backend running:** http://localhost:8080/api
- ✅ **Frontend running:** http://localhost:3000
- ✅ **Registration works:** Can create new users
- ✅ **Login works:** Can authenticate users
- ✅ **All modules work:** Students, Courses, Marks, Fees

---

## 🆘 **Still Having Issues?**

1. **Check the logs** in terminal windows
2. **Look for error messages** in browser console
3. **Verify all prerequisites** are installed
4. **Try Docker method** as last resort

**Your College Management System should be working perfectly now!** 🚀
