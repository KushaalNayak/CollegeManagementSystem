# College Management System

A comprehensive, modern College Management System built with Spring Boot backend and React frontend, featuring a clean and intuitive UI/UX design.

## 🚀 Features

### Core Modules
- **User Management**: Registration, authentication, and role-based access control
- **Student Management**: Complete student lifecycle management
- **Course Management**: Course creation, enrollment, and tracking
- **Marks Management**: Grade entry, tracking, and reporting
- **Fees Management**: Fee collection, tracking, and financial reporting
- **Dashboard**: Comprehensive analytics and reporting

### Key Features
- 🔐 **JWT Authentication**: Secure token-based authentication
- 👥 **Role-based Access**: Admin, Faculty, HOD, and Student roles
- 📱 **Responsive Design**: Modern, mobile-friendly interface
- 🎨 **Clean UI/UX**: Intuitive and user-friendly design
- 📊 **Analytics**: Comprehensive dashboards and reports
- 🔍 **Search & Filter**: Advanced search and filtering capabilities
- 📈 **Real-time Updates**: Live data updates and notifications

## 🛠️ Technology Stack

### Backend
- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Security** with JWT
- **Spring Data JPA**
- **MySQL 8.0**
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

## 📋 Prerequisites

- Java 17 or higher
- Node.js 16 or higher
- MySQL 8.0 or higher
- Maven 3.6 or higher

## 🚀 Quick Start

### Backend Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd college-management-system
   ```

2. **Navigate to backend directory**
   ```bash
   cd backend
   ```

3. **Configure database**
   - Create a MySQL database named `college_management`
   - Update `src/main/resources/application.yml` with your database credentials

4. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

   The backend will start on `http://localhost:8080`

### Frontend Setup

1. **Navigate to frontend directory**
   ```bash
   cd frontend
   ```

2. **Install dependencies**
   ```bash
   npm install
   ```

3. **Start the development server**
   ```bash
   npm start
   ```

   The frontend will start on `http://localhost:3000`

## 🔧 Configuration

### Backend Configuration

Update `backend/src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/college_management?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
    username: your_username
    password: your_password
    
  security:
    jwt:
      secret: your_jwt_secret_key
      expiration: 86400000 # 24 hours
```

### Frontend Configuration

Update `frontend/src/services/api.ts`:

```typescript
const API_BASE_URL = process.env.REACT_APP_API_URL || 'http://localhost:8080/api';
```

## 📚 API Documentation

Once the backend is running, you can access the Swagger UI at:
- **Swagger UI**: `http://localhost:8080/api/swagger-ui.html`
- **API Docs**: `http://localhost:8080/api/api-docs`

## 🎯 User Roles & Permissions

### Admin
- Full system access
- User management
- System configuration

### Head of Department (HOD)
- Department management
- Faculty oversight
- Student management within department

### Faculty
- Student management
- Marks entry and management
- Course management

### Student
- View personal information
- View marks and grades
- View fees and payments

## 🔐 Authentication

The system uses JWT (JSON Web Tokens) for authentication:

1. **Login**: POST `/api/v1/auth/signin`
2. **Register**: POST `/api/v1/auth/signup`
3. **Token**: Include `Authorization: Bearer <token>` in API requests

## 📊 Dashboard Features

- **Overview Statistics**: Total students, courses, faculty, revenue
- **Charts & Graphs**: Visual representation of data
- **Recent Activities**: Latest system activities
- **Quick Actions**: Common tasks and shortcuts

## 🎨 UI/UX Features

- **Modern Design**: Clean, professional interface
- **Responsive Layout**: Works on all device sizes
- **Dark/Light Theme**: Customizable themes
- **Accessibility**: WCAG compliant design
- **Intuitive Navigation**: Easy-to-use interface

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

## 📦 Deployment

### Docker Deployment

1. **Build backend image**
   ```bash
   cd backend
   docker build -t college-management-backend .
   ```

2. **Build frontend image**
   ```bash
   cd frontend
   docker build -t college-management-frontend .
   ```

3. **Run with Docker Compose**
   ```bash
   docker-compose up -d
   ```

### Production Deployment

1. **Backend**: Deploy Spring Boot JAR to your server
2. **Frontend**: Build and serve static files
3. **Database**: Configure production MySQL instance

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🆘 Support

For support and questions:
- Create an issue in the repository
- Contact the development team

## 🔄 Version History

- **v1.0.0**: Initial release with core features
- **v1.1.0**: Added advanced analytics and reporting
- **v1.2.0**: Enhanced UI/UX and mobile responsiveness

## 📈 Roadmap

- [ ] Mobile app development
- [ ] Advanced reporting features
- [ ] Integration with external systems
- [ ] AI-powered analytics
- [ ] Multi-language support

---

**Built with ❤️ for educational institutions worldwide**
