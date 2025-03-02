# E-commerce Platform for Cars and Accessories

Car Ecommerce is a Spring Boot-based e-commerce platform that lets users buy cars and car accessories online. The system includes authentication, shopping cart management, order processing, and secure payment integration.

🚀 **Features**

### User Features

#### 🛒 Car & Accessories Shopping

- Browse and search available cars and accessories
- View car details, specifications, and pricing
- Add items to the shopping cart
- Secure checkout and payment processing

#### 👤 User Account Management

- Register and log in using JWT-based authentication
- Manage personal profiles
- View order history
- Receive order confirmation and updates

### Admin Features

#### 📊 Dashboard

- View real-time statistics and sales trends
- Manage cars and accessories
- Monitor user activities

#### 🚗 Car & Accessory Management

- Add, update, or remove cars and accessories
- Manage product inventory

#### 📦 Order Management

- View all orders
- Process cancellations and refunds
- Generate sales reports

🔧 **Technologies Used**

### Backend

- Spring Boot
- Spring Security (JWT Authentication)
- Hibernate
- MySQL Database

### Frontend

- Angular
- TypeScript
- Bootstrap
- HTML5, CSS3

### Tools & Libraries

- Apache Tomcat
- Maven
- Razorpay Payment Gateway
- JWT for Authentication

📋 **Prerequisites**

- JDK 17 or higher
- Apache Tomcat 10.x
- MySQL 8.0 or higher
- Maven (for dependency management)

🏗️ **Project Structure**

```
CarEcommerce/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── CarEcommerce/
│   │   │           ├── config/
│   │   │           ├── controller/
│   │   │           ├── dto/
│   │   │           ├── exception/
│   │   │           ├── model/
│   │   │           ├── repository/
│   │   │           ├── service/
│   │   │           ├── utils/
│   │   │           └── CarEcommerceApplication.java
│   ├── resources/
│   └── webapp/
└── pom.xml
```

👥 **User Roles**

### 🏷️ Regular Users

- Browse and purchase cars and accessories
- Manage orders and profile
- Secure payments and order tracking

### 🔧 Administrators

- Manage products and inventory
- Process orders and refunds
- View sales analytics

🔐 **Security Features**

- JWT-based user authentication
- Role-based access control
- Secure API endpoints with Spring Security
- SQL injection prevention

⭐ **Star this repository if you find it helpful!**

