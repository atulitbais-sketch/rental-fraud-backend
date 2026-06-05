# Smart Rental Fraud Detector Backend

## Overview

Smart Rental Fraud Detector Backend is a Spring Boot REST API that analyzes rental property listings and calculates a fraud risk score based on multiple fraud detection rules.

The system helps identify suspicious rental advertisements by evaluating factors such as unusually low rent, excessive advance payment demands, missing contact information, restricted property visits, and suspicious keywords in property descriptions.

---

## Features

* REST API for rental fraud analysis
* Fraud score calculation
* Risk classification (Low, Medium, High, Very High)
* Suspicious keyword detection
* JSON request/response support
* Dockerized deployment
* Render cloud deployment

---

## Tech Stack

### Backend

* Java 21
* Spring Boot 3.5
* Maven

### Deployment

* Docker
* Render

---

## API Endpoint

### Analyze Rental Listing

**POST**

```http
/api/rentals/analyze
```

### Sample Request

```json
{
  "ownerName": "John Doe",
  "ownerPhone": "9876543210",
  "propertyAddress": "Kothrud",
  "city": "Pune",
  "rent": 2000,
  "advanceAmount": 50000,
  "visitAllowed": false,
  "description": "urgent payment deposit first"
}
```

### Sample Response

```json
{
  "ownerName": "John Doe",
  "ownerPhone": "9876543210",
  "propertyAddress": "Kothrud",
  "city": "Pune",
  "rent": 2000,
  "advanceAmount": 50000,
  "visitAllowed": false,
  "description": "urgent payment deposit first",
  "fraudScore": 95,
  "riskLevel": "Very High Risk",
  "message": "Likely scam. Avoid sending money without verification."
}
```

---

## Fraud Detection Rules

The fraud score is calculated using factors such as:

* Extremely low rent
* High advance deposit requirements
* Missing owner contact information
* Property visit not allowed
* Suspicious phrases in description
* Incomplete listing details

---

## Running Locally

### Clone Repository

```bash
git clone <repository-url>
cd smart-rental-fraud-detector
```

### Start Application

```bash
./mvnw spring-boot:run
```

Application runs at:

```text
http://localhost:8080
```

---

## Docker

### Build Image

```bash
docker build -t rental-fraud-backend .
```

### Run Container

```bash
docker run -p 8080:8080 rental-fraud-backend
```

---

## Deployment

Backend deployed on Render:

https://rental-fraud-backend-updated.onrender.com

---

## Future Enhancements

* Machine Learning based fraud prediction
* Database integration
* Fraud history tracking
* Blacklisted phone number detection
* Admin dashboard
* User authentication


