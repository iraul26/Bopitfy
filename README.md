# Bopify 🎵

## Overview
Bopify is a music library service that allows users to interact with a music database by registering an account, logging in, and creating, updating, or removing playlists in their personal library. The application is designed with a simple, responsive UI to ensure ease of use across various devices.

<img src="./images/App%20Overview.png" alt="App Overview" width="500" height="400"/>

## Objectives 🎯
- Create a service for users to interact with a music library.
- Allow users to register an account and log in.
- Enable users to create, update, or remove playlists in their library.
- Ensure a simple and responsive user interface.

## Technical Overview 🛠️
Bopify is built using an N-layer architecture to separate concerns and enhance maintainability. The following technologies and practices were utilized:
- **Thymeleaf Templates:** Used for rendering dynamic web pages on the front end.
- **Bootstrap:** Ensures the UI is responsive and visually appealing.
- **Dependency Injection (IOC):** Achieved using Spring to manage object creation and dependencies.
- **Spring JDBC:** Facilitates database interactions with MySQL.
- **Spring Security:** Provides authentication and encodes user passwords for enhanced security.
- **REST APIs:** Allow seamless communication with the database.

## Object-Oriented Programming Techniques 💻
### Encapsulation
Encapsulation is utilized by hiding the class variables from other classes, making them accessible only through class-specific methods.

### Polymorphism
Polymorphism allows a single interface to have multiple implementations, enhancing flexibility and reusability of code.

## Tools and Methodologies 🔧
- **Agile Software Development:** The project followed a loosely adapted Agile approach.
- **SCRUM:** Used to divide work and set completion goals.
- **Discord:** Served as the primary communication tool.
- **Loom:** Used for recording and sharing videos among team members.

## Teamwork and Collaboration 🤝
The team divided work based on milestone assignment requirements. Collaborative problem-solving was a key aspect, with members stepping in to assist with issues such as:
- Fixing a bug in the product delete method by altering the method syntax.
- Resolving an authorization issue caused by a typo in the URI.

## Known Issues and Improvements 🚧
- **Database Hosting:** The database is currently hosted locally using MySQL, leading to inconsistencies when accessed from different devices.
- **Playlist Table:** There is only one table for all user playlists, meaning all users share the same library.
- **Navbar Responsiveness:** The size of the navbar changes according to the body size of the page, which may not be ideal.

### Improvements 🔄
- **Procrastination:** Starting tasks earlier could prevent last-minute rushes.
- **Communication:** Enabling timely notifications would enhance team communication.

## Demonstration 🎥
A demonstration of Bopify is available to showcase the application's capabilities; 
https://www.loom.com/share/d69462d5fc804e89a98af777c37cd11c?sid=c032c817-898c-4061-8517-2069cd348167

## Credits 🙌
This project was developed by Group 8:
- Marko Van Zyl
- Raul Sanchez
- Kyle Long
