# 🔐 **COLLEGE MANAGEMENT SYSTEM - LOGIN CREDENTIALS**

## 🎯 **DEFAULT LOGIN CREDENTIALS**

### **After Backend Deployment, You Can Use These Default Accounts:**

---

## 👨‍💼 **ADMIN ACCOUNT**
- **Email:** `admin@college.com`
- **Password:** `admin123`
- **Role:** ADMIN
- **Access:** Full system access, all features

---

## 👨‍🎓 **STUDENT ACCOUNT**
- **Email:** `student@college.com`
- **Password:** `student123`
- **Role:** STUDENT
- **Access:** View marks, fees, courses, profile

---

## 👨‍🏫 **FACULTY ACCOUNT**
- **Email:** `faculty@college.com`
- **Password:** `faculty123`
- **Role:** FACULTY
- **Access:** Manage students, marks, courses

---

## 👨‍💻 **HOD (HEAD OF DEPARTMENT) ACCOUNT**
- **Email:** `hod@college.com`
- **Password:** `hod123`
- **Role:** HOD
- **Access:** Department management, faculty oversight

---

## 🚀 **HOW TO LOGIN:**

### **1. Frontend Login:**
1. **Go to your deployed frontend URL**
2. **Click "Login"**
3. **Enter any of the credentials above**
4. **Click "Sign In"**

### **2. API Login (for testing):**
```bash
POST https://your-backend.railway.app/api/v1/auth/signin
Content-Type: application/json

{
  "email": "admin@college.com",
  "password": "admin123"
}
```

### **3. Expected Response:**
```json
{
  "accessToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "id": 1,
  "username": "admin@college.com",
  "role": "ADMIN"
}
```

---

## 🔧 **AUTOMATIC USER CREATION:**

### **Default Users Are Created Automatically:**
- ✅ **When backend starts** - DataInitializer runs
- ✅ **Only if users don't exist** - Prevents duplicates
- ✅ **Encrypted passwords** - Secure storage
- ✅ **All roles available** - Complete system access

---

## 🎯 **FEATURES BY ROLE:**

### **ADMIN (admin@college.com):**
- ✅ **User Management** - Create/edit users
- ✅ **System Settings** - Configure system
- ✅ **All Data Access** - View everything
- ✅ **Reports** - Generate reports

### **STUDENT (student@college.com):**
- ✅ **View Marks** - Check grades
- ✅ **View Fees** - Check fee status
- ✅ **View Courses** - Browse courses
- ✅ **Profile** - Update personal info

### **FACULTY (faculty@college.com):**
- ✅ **Student Management** - Add/edit students
- ✅ **Marks Entry** - Enter grades
- ✅ **Course Management** - Manage courses
- ✅ **Reports** - Generate reports

### **HOD (hod@college.com):**
- ✅ **Department Management** - Manage department
- ✅ **Faculty Oversight** - Manage faculty
- ✅ **Course Approval** - Approve courses
- ✅ **Reports** - Department reports

---

## 🚨 **IMPORTANT NOTES:**

### **Security:**
- 🔒 **Passwords are encrypted** - Stored securely
- 🔒 **JWT tokens** - Secure authentication
- 🔒 **Role-based access** - Proper authorization

### **First Time Setup:**
- ✅ **Default users created automatically**
- ✅ **No manual setup required**
- ✅ **Ready to use immediately**

### **Custom Users:**
- ✅ **Register new users** - Use signup endpoint
- ✅ **Email must be unique** - No duplicates
- ✅ **Role assignment** - Choose appropriate role

---

## 🎉 **READY TO USE!**

**Once your backend is deployed, you can immediately login with any of these credentials and start using the College Management System!** 🚀

**The system is fully functional with all features available based on user roles!** ✅
