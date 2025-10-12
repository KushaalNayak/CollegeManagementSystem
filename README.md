# 🎓 College Management System

A modern, comprehensive College Management System built with **React** frontend and **Spring Boot** backend, featuring a clean and intuitive UI/UX design.

## 🚀 Features

- **User Authentication** - JWT-based secure login/registration
- **Student Management** - Complete student lifecycle management
- **Course Management** - Course creation, enrollment, and tracking
- **Marks Management** - Grade entry, tracking, and reporting
- **Fees Management** - Fee collection, tracking, and financial reporting
- **Dashboard** - Comprehensive analytics and reporting
- **Responsive Design** - Works perfectly on all devices
- **Modern UI/UX** - Clean, professional Material-UI design

## 🛠️ Technology Stack

### Backend
- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Security** with JWT
- **Spring Data JPA**
- **MySQL/PostgreSQL**
- **Maven**
- **Swagger/OpenAPI 3**

### Frontend
- **React 18**
- **TypeScript**
- **Material-UI (MUI)**
- **React Router**
- **Axios**
- **Recharts** for analytics
- **React Hook Form**
- **React Toastify**

## 🚀 Quick Start

### Prerequisites
- Java 17 or higher
- Node.js 16 or higher
- MySQL 8.0 or higher
- Maven 3.6 or higher

### Local Development

#### Option 1: Docker (Recommended)
```bash
# Start everything with Docker
docker-compose up -d
```

#### Option 2: Manual Setup
```bash
# Terminal 1 - Start Backend
cd backend
mvn spring-boot:run

# Terminal 2 - Start Frontend
cd frontend
npm install
npm run dev
```

### Access Points
- **Frontend:** http://localhost:3000
- **Backend API:** http://localhost:8080/api
- **Swagger UI:** http://localhost:8080/api/swagger-ui.html

## 🌐 Deployment (Vercel)

### Complete Vercel Deployment
1. **Frontend & Backend:** Deploy both to Vercel
2. **Database:** Use Supabase (free PostgreSQL)
3. **Quick Setup:** Run `vercel-deploy.bat` for guided deployment

### Quick Deploy Steps:
1. Go to [Vercel](https://vercel.com) and sign in with GitHub
2. Import your repository: `KushaalNayak/CollegeManagementSystem`
3. Deploy frontend first (select `frontend` folder)
4. Deploy backend second (select `backend` folder)
5. Add database at [Supabase](https://supabase.com)
6. Configure environment variables
7. Your website is live! 🎉

**For detailed steps, see:** `VERCEL_DEPLOYMENT_GUIDE.md`

## 📱 User Roles

- **Admin** - Full system access
- **Head of Department (HOD)** - Department management
- **Faculty** - Student and course management
- **Student** - View personal information and grades

## 🎨 UI/UX Features

- **Modern Design** - Clean, professional interface
- **Responsive Layout** - Works on desktop, tablet, mobile
- **Interactive Charts** - Real-time data visualization
- **Intuitive Navigation** - Easy-to-use interface
- **Role-based Access** - Different views for different users
- **Search & Filter** - Advanced data filtering capabilities

## 📊 API Documentation

Once the backend is running, access Swagger UI at:
- **Swagger UI:** http://localhost:8080/api/swagger-ui.html
- **API Docs:** http://localhost:8080/api/api-docs

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
Update `frontend/src/services/api.ts`:
```typescript
const API_BASE_URL = process.env.REACT_APP_API_URL || 'http://localhost:8080/api';
```

## 🧪 Testing

### Backend Testing
```bash
cd backend
mvn test
```

### Frontend Testing
```bash
cd frontend
npm test
```

## 📦 Project Structure

```
college-management-system/
├── backend/                 # Spring Boot backend
│   ├── src/main/java/     # Java source code
│   ├── src/main/resources/ # Configuration files
│   └── pom.xml            # Maven dependencies
├── frontend/               # React frontend
│   ├── src/               # React source code
│   ├── public/            # Static files
│   └── package.json       # Node.js dependencies
├── docker-compose.yml     # Docker configuration
└── README.md              # This file
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## 📄 License

This project is licensed under the MIT License.

## 🆘 Support

For support and questions:
- Create an issue in the repository
- Contact the development team

---

**Built with ❤️ for educational institutions worldwide**