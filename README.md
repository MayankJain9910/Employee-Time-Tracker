# 🕒 Employee Time Tracker

The **Employee Time Tracker** is a web-based application that helps organizations manage and monitor employee work hours and task assignments. It offers a simple interface for employees to clock in and out, log tasks, and view work summaries. Admins can generate reports, monitor productivity, and manage users and roles.

---

## 🚀 Features

* Clock In / Clock Out system
* Track daily/weekly work hours
* Task and project logging
* Attendance and productivity reports
* Admin panel for user management
* Role-based access control
* Responsive web interface

---

## 🧑‍💻 Tech Stack

* **Backend:** Java, Spring Boot
* **Frontend:** JSP / Thymeleaf, HTML, CSS, JavaScript
* **Database:** MySQL / H2 (for development)
* **ORM:** Hibernate / JPA
* **Build Tool:** Maven
* **Deployment:** WAR on Apache Tomcat

---

## 📂 Project Structure

```
employee-time-tracker/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/employee/timetracker/
│       │       ├── admin/
│       │       │   ├── controllers/
│       │       │   └── repositories/
│       │       ├── controllers/
│       │       ├── entities/
│       │       ├── repositories/
│       │       ├── services/
│       │       ├── user/
│       │       │   ├── controllers/
│       │       │   ├── entities/
│       │       │   ├── repositories/
│       │       │   └── services/
│       │       └── utility/
│       └── resources/
│           ├── static/
│           └── templates/
│           |    ├── admin/
│           |    ├── user/
│           └── application.properties
├── pom.xml
└── README.md
```

---

## ⚙️ Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/employee-time-tracker.git
cd employee-time-tracker
```

### 2. Configure the Database

Edit the file:

```properties
# src/main/resources/application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/employeedb
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
```

### 3. Build and Run

```bash
mvn clean install
mvn spring-boot:run
```

Access the app at: `http://localhost:8080`

---

🙇‍♂️ Author
Mayank Jain 📧 mayankjain9910@gmail.com 🌐 GitHub - MayankJain9910

