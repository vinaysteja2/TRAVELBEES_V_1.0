"# TRAVEL-BEES Project(v1.0)" 
![Travel Bees Logo](https://github.com/vinaysteja2/TRAVELBEES_V_1.0/blob/master/IMAGES_OVERVIEW/Screenshot%20(94).png?raw=true)

TRAVEL BEes is a comprehensive tourist guide application designed to bridge the gap between travelers and local tourist guides across various destinations. The application adopts a microservices architecture, enabling improved scalability, flexibility, and maintainability as the platform grows and evolves.

The current version of TRAVEL BEes comprises eight dedicated microservices, each responsible for specific functionalities within the system. These include:

The Service Registry, which manages service discovery across the microservices;

The API Gateway, which securely routes incoming requests to the appropriate services;

The User Service, which handles user registration, authentication, and profile management;

The Tour Service, which manages tour-related information and updates;

The Tourist Guide Service, which manages profiles of tourist guides and the places they are assigned to;

The Booking Service, which handles user tour bookings;

The Review Service, where users can submit and view reviews and ratings; and

The Payment Service, which integrates with Razorpay for secure online payments.

From the admin perspective, TRAVEL BEes provides a system where multiple tourist guides can be assigned to different regions such as Karnataka, Pune, and others. Each region may have several tourist guides, and each guide can conduct tours covering multiple tourist destinations. The admin also has the authority to update tour and tourist guide information at any time.

From the user perspective, the experience begins with registration and login. Once authenticated, users can search for any location, such as "Bengaluru," and view a list of tourist guides available in that area. After selecting a tourist guide, the user is presented with a detailed view of the places that the selected guide covers, along with available tours.

Users can then proceed to book tours through an integrated payment system powered by Razorpay, which supports debit cards, credit cards, and net banking. Once the payment is successful, the booking is confirmed, and the details are stored securely in the user’s booking history. If needed, users also have the option to cancel bookings. Additionally, the application provides functionality for users to download PDF reports summarizing their tour and guide information for future reference or offline use.

The application is built using Java, Spring Boot, and Spring Data JPA for the backend, with PostgreSQL as the relational database. Spring Security with JWT (JSON Web Tokens) is employed to secure user sessions and APIs. Payment integration is handled through Razorpay, allowing for multiple modes of payment. The system’s architecture is designed using the microservices pattern, with a Service Registry and API Gateway facilitating efficient communication and service orchestration.

Additional Features
Beyond core functionalities, TRAVEL BEes includes several user experience enhancements. An OTP system ensures secure admin logins, preventing unauthorized access. The frontend includes notification boxes that provide real-time feedback for user actions such as bookings, cancellations, and errors. Additionally, sliding window UI components contribute to a modern and interactive user interface, enhancing the overall usability and appeal of the application.

