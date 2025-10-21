# 🔐 Spring Security One-Time Token (OTT) Authentication

Enhance your application's security with **passwordless authentication** using Spring Security's **One-Time Token (OTT)** feature. This project demonstrates **magic link authentication**, allowing users to securely log in through **email-delivered tokens** without using a password.

<p align="center"> 
  <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
  <img src="https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=springSecurity&logoColor=white">
  <img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white">
  <img src="https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=jwt&logoColor=white">
</p>

---

## 📖 Overview

This **Spring Boot 3.x** application showcases a modern approach to authentication by implementing **magic links** using Spring Security's OTT functionality.  

**Workflow:**
1. Users request a **One-Time Token (OTT)** by entering their username.
2. The system generates a **secure, unique token** and sends it via email.
3. Users click the **magic link** in the email to log in automatically without a password.
4. Users are redirected to a **confirmation page** or the protected home page upon successful login.

This approach improves **security** and **user experience**, eliminating the need for passwords while ensuring safe access.

---

## 🚀 Features

- ✉️ **Email-based One-Time Token Login**  
- 🔒 **Passwordless Authentication** – secure login without passwords  
- 📧 **Dynamic Email Templates** – modern HTML email with magic link  
- 🛠 **Easy Test Setup** – InMemoryUserDetailsManager for quick testing  
- 🔄 **Custom OTT Success Handler** – redirects after email delivery  

---

---

## ✨ Benefits of Using This Project  

- ✅ **Passwordless Authentication** – Users can log in securely via a one-time token sent to their email, eliminating the need for traditional passwords.  
- ✅ **Enhanced Security** – Reduces the risk of stolen or reused credentials by using time-limited, single-use tokens.  
- ✅ **Modern Spring Security Integration** – Demonstrates how to configure Spring Security for OTT/magic link login flows.  
- ✅ **Email-Driven Login Flow** – Shows practical use of JavaMailSender and template engines (JTE/Thymeleaf) for sending magic links.  
- ✅ **Production-Ready Reference** – Can serve as a blueprint for implementing passwordless authentication in real-world applications.  
- ✅ **Clean & Maintainable Codebase** – Uses best practices with Spring Boot, Lombok, and modular architecture for easy extension.  
- ✅ **Improved User Experience** – Simplifies login for users by removing password management while maintaining strong authentication standards.  


---
## 🖥 Pages / Flow

1. **Home Page (`index.jte`)**  
   - Welcome page for authenticated users.  

2. **Magic Link Sent Page (`sent.jte`)**  
   - Confirmation page indicating that the One-Time Token email has been sent.  

3. **Email Template (`one_time_token_email.html`)**  
   - Clean, modern HTML design for sending magic links via email.  

---


## ⚙️ Project Requirements

- Java 17 or higher  
- Spring Boot 3.5.x  
- Maven or Gradle build tool  
- Email service (MailDev for testing / SendGrid for production)  

---

## 🧩 Dependencies

Key dependencies used in this project:

- **Spring Boot Starter Web** – for building web applications  
- **Spring Boot Starter Security** – handles OTT login flow  
- **JavaMailSender / Spring Boot Starter Mail** – for email delivery  
- **JTE (Java Template Engine)** – renders HTML email templates  
- **Spring Boot Docker Compose** – running local containers for testing (e.g., MailDev)
- **Lombok** – reduces boilerplate code 
- **Spring Boot DevTools** – for hot reloading during development  
- **Spring Boot Actuator** – monitoring and application metrics  
 

---
## 🛡️ Security Considerations  

- 🔑 **Single-Use, Time-Limited Tokens** – Each one-time token (OTT) can only be used once and expires after a short period to prevent replay attacks.  
- 🔒 **Endpoint Protection** – All endpoints, except `/ott/sent` and `/login/ott`, require authentication to access.  
- 🛠️ **Secure Password Storage** – Passwords are stored securely using Spring Security's password encoding mechanisms.  
- 📧 **Email Delivery** – Emails containing magic links are sent via MailDev for testing purposes. 


