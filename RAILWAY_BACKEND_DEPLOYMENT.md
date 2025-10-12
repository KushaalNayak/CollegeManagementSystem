# 🚀 **RAILWAY BACKEND DEPLOYMENT - COMPLETE GUIDE**

## 🎯 **STEP-BY-STEP RAILWAY DEPLOYMENT**

### **Step 1: Create Railway Account**
1. **Go to:** [railway.app](https://railway.app)
2. **Sign up** with GitHub
3. **Connect your GitHub account**

### **Step 2: Deploy from GitHub**
1. **Click "New Project"**
2. **Select "Deploy from GitHub repo"**
3. **Choose:** `KushaalNayak/CollegeManagementSystem`
4. **Select "Backend" folder** as root directory

### **Step 3: Configure Build Settings**
1. **Root Directory:** `backend`
2. **Build Command:** `mvn clean package -DskipTests`
3. **Start Command:** `java -jar target/college-management-system-1.0.0.jar`
4. **Port:** `8080` (Railway will auto-detect)

### **Step 4: Add Environment Variables**
1. **Go to Variables tab**
2. **Add these variables:**

```bash
JWT_SECRET=mySecretKey123456789012345678901234567890
SPRING_PROFILES_ACTIVE=railway
DATABASE_URL=postgresql://username:password@host:port/database
```

### **Step 5: Add PostgreSQL Database**
1. **Click "New +"**
2. **Select "Database"**
3. **Choose "PostgreSQL"**
4. **Free tier selected automatically**
5. **Railway will auto-generate DATABASE_URL**

### **Step 6: Deploy**
1. **Click "Deploy"**
2. **Wait for build to complete**
3. **Get your backend URL:** `https://your-app.railway.app`

---

## 🔧 **RAILWAY-SPECIFIC CONFIGURATION**

### **Create railway.json (if needed):**
```json
{
  "build": {
    "builder": "NIXPACKS"
  },
  "deploy": {
    "startCommand": "java -jar target/college-management-system-1.0.0.jar",
    "healthcheckPath": "/api/v1/health"
  }
}
```

### **Update application.yml for Railway:**
```yaml
spring:
  profiles:
    active: railway
  datasource:
    url: ${DATABASE_URL}
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: false
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect

server:
  port: ${PORT:8080}

jwt:
  secret: ${JWT_SECRET}
  expiration: 86400000
```

---

## 🚨 **COMMON RAILWAY ISSUES & FIXES**

### **Issue 1: Build Fails - Maven Not Found**
**Solution:** Railway uses Nixpacks which auto-detects Java/Maven

### **Issue 2: Port Issues**
**Solution:** Railway auto-assigns PORT environment variable

### **Issue 3: Database Connection**
**Solution:** Use Railway's auto-generated DATABASE_URL

### **Issue 4: Memory Issues**
**Solution:** Railway free tier has 512MB RAM limit

---

## ✅ **VERIFICATION STEPS**

### **After Deployment:**
1. **Check build logs** for success
2. **Test health endpoint:** `https://your-app.railway.app/api/v1/health`
3. **Test API:** `https://your-app.railway.app/api/v1/auth/signin`

### **Expected Response:**
```json
{
  "success": true,
  "message": "API is running",
  "data": null
}
```

---

## 🎉 **SUCCESS INDICATORS**

- ✅ **Build Status:** "Deployed"
- ✅ **Health Check:** 200 OK
- ✅ **API Endpoints:** Accessible
- ✅ **Database:** Connected
- ✅ **Logs:** No errors

---

## 🔗 **NEXT STEPS**

1. **Get your Railway backend URL**
2. **Update frontend API URL**
3. **Test complete system**
4. **Deploy frontend to Vercel**

**Your Railway backend will be live and working!** 🚀
