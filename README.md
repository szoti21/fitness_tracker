## Fitness Tracker Backend - README
# Fitness Tracker Backend
A backend service for the Fitness Tracker application, built with Java Spring. This service provides APIs to track users' weight, body fat percentage, and daily food intake. It includes user authentication and secure handling of data via Spring Security.

---

## Features
- **User Authentication**: Secure login and registration with Spring Security.
- **Track Body Metrics**: Record and retrieve weight and body fat changes over time.
- **Food Intake Tracker**: Log foods eaten and calculate their nutritional breakdown (protein, fat, carbs, and kcal).
- **RESTful APIs**: Clean, endpoints for interaction with the frontend.

---

## Tech Stack
- **Backend Framework**: Java Spring Boot
- **Security**: Spring Security
- **Database**: MySQL
- **Tools**: Maven for dependency management

# Setup Instructions

## Clone the Repository
```bash
git clone https://github.com/szoti21/fitness_tracker
cd fitness-tracker
```

## Install Dependencies
```bash
mvn install
```

## Set Up Database
create_tables.sql  contains the sql table codes

## Run the Application
```bash
mvn spring-boot:run
