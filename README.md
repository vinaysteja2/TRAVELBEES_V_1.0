"# TRAVEL-BEES Project(v1.0)" 
![Travel Bees Logo](https://github.com/vinaysteja2/TRAVELBEES_V_1.0/blob/master/IMAGES_OVERVIEW/Screenshot%202025-05-18%20122041.png?raw=true)
![Travel Bees](https://github.com/vinaysteja2/TRAVELBEES_V_1.0/blob/master/IMAGES_OVERVIEW/Screenshot%202025-05-18%20122041.png?raw=true)

🐝TRAVEL BEes - Tourist Guide Application (v1.0)
TRAVEL BEes is a comprehensive tourist guide application designed to connect travelers with local tourist guides across multiple destinations. This application is built using a microservices architecture to ensure scalability, flexibility, and maintainability.

Overview
The platform currently consists of 8 microservices:

Service Registry — For managing service discovery across microservices.

API Gateway — To route requests to appropriate microservices securely.

User Service — Manages user authentication and profiles.

Tour Service — Handles tour information and updates.

Tourist Guide Service — Manages tourist guide profiles and their assigned places.

Booking Service — Processes user bookings for tours.

Review Service — Manages user reviews and ratings for tours and guides.

Payment Service — Integrates payment processing for bookings.

How It Works
Admin Management
The admin assigns multiple tourist guides to various locations such as Karnataka, Pune, etc. Each location can have several tourist guides, and each guide offers tours covering multiple places.

User Experience
Users first register and log in to the application. After authentication, users can search for a destination (e.g., Bengaluru). The application then displays all tourist guides available in that area.

Tour Guide Selection
Once a user selects a tourist guide, the application presents a detailed list of places that guide covers. Users can browse tours offered by that guide.

Booking & Payment
Users can book a tour with the chosen guide and complete payment through the integrated Razorpay payment gateway. The system supports multiple payment modes including debit cards, credit cards, and net banking.

Post Booking Features
After booking, users can view their booking history, cancel bookings if needed, and even download detailed PDF reports containing tour and guide information for future reference.

Technology Stack
Backend: Java, Spring Boot, Spring Data JPA

Database: PostgreSQL

Security: Spring Security with JWT (JSON Web Tokens)

Payment Integration: Razorpay (supporting debit, credit, and net banking)

Architecture: Microservices with Service Registry and API Gateway

 Additional Features
✅ OTP system for secure admin login

🔔 Notification boxes on the frontend for status updates and confirmations

⏭️ Sliding window UI components for smooth navigation and modern UX
![Travel Bees](https://github.com/vinaysteja2/TRAVELBEES_V_1.0/blob/master/IMAGES_OVERVIEW/Screenshot%20(102).png?raw=true)
