# Skill15 - JWT Authentication API Testing Guide

## ✅ Fixed Issues:
1. **Added `/api/register` endpoint** - Now you can create new users
2. **Changed HTTP methods**:
   - `POST /api/admin/add` (was GET)
   - `DELETE /api/admin/delete` (was GET)
3. **Added sample users** - Admin and Employee users will be auto-created on startup
4. **Updated Security Config** - Both `/api/login` and `/api/register` are public

---

## 🚀 Testing Steps in Postman

### **Step 1: Register a New User** (If needed)
```
POST http://localhost:8081/api/register
Content-Type: application/json

{
  "username": "testuser",
  "password": "test123",
  "role": "EMPLOYEE"
}
```

### **Step 2: Login & Get JWT Token**
```
POST http://localhost:8081/api/login
Content-Type: application/json

{
  "username": "admin",
  "password": "admin123"
}
```

**Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9...",
  "role": "ADMIN",
  "username": "admin"
}
```
✅ **Copy the token from response**

### **Step 3: Use Token for Protected Endpoints**

#### Admin Endpoints (Use Admin Token):
```
POST http://localhost:8081/api/admin/add
Authorization: Bearer {YOUR_TOKEN_HERE}
```

```
DELETE http://localhost:8081/api/admin/delete
Authorization: Bearer {YOUR_TOKEN_HERE}
```

#### Employee Endpoints (Use Employee Token):
```
GET http://localhost:8081/api/employee/profile
Authorization: Bearer {YOUR_TOKEN_HERE}
```

---

## 📝 Sample Users (Auto-Created):

| Username | Password | Role     |
|----------|----------|----------|
| admin    | admin123 | ADMIN    |
| employee | emp123   | EMPLOYEE |

---

## 🔧 Configuration:
- **Server Port**: 8081
- **Database**: MySQL - skill15db
- **Database User**: root
- **Database Password**: root

---

## ⚠️ Common Issues & Fixes:

### Issue: 401 Unauthorized
**Solution**: Make sure you're passing the Bearer token correctly:
```
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
```

### Issue: MySQL Connection Error
```xml
<!-- Make sure MySQL is running and pom.xml has: -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>
```

### Issue: 403 Forbidden
**Solution**: You don't have the required role. Login with appropriate user:
- For `/admin/**`: Login with **admin**
- For `/employee/****: Login with **employee**

---

## 📦 Required Dependencies (pom.xml)
```xml
<!-- Spring Boot Security -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

<!-- JWT -->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.12.3</version>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-impl</artifactId>
    <version>0.12.3</version>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-jackson</artifactId>
    <version>0.12.3</version>
    <scope>runtime</scope>
</dependency>

<!-- MySQL -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>
```

---

## ✅ Verification Checklist:
- [ ] MySQL is running
- [ ] Database `skill15db` exists
- [ ] Spring Boot application is running on port 8081
- [ ] Sample users are created (check console logs)
- [ ] Can login and receive JWT token
- [ ] Can access admin endpoints with admin token
- [ ] Can access employee endpoints with employee token
