# 🚀 AI Career Assistant

An AI-powered career guidance platform built using Spring Boot, Thymeleaf, Bootstrap, OpenRouter AI, and PDF processing.

This application helps students and job seekers improve their career preparation through:

* AI Resume Analysis
* AI Mock Interviews
* AI Career Roadmaps
* AI Chat Assistant
* PDF Report Generation
* User Authentication

---

# 📌 Project Overview

AI Career Assistant is an intelligent web application that assists users in preparing for placements, internships, and job interviews.

The system uses Large Language Models through OpenRouter API to generate personalized career guidance.

---

# ✨ Features

## 🔐 Authentication System

### New User

* Register account
* Login using credentials

### Existing User

* Login directly

### Security Features

* Session based authentication
* Protected dashboard
* Logout functionality

---

# 💬 AI Chat Assistant

Users can interact with AI and ask:

* Java Questions
* Spring Boot Questions
* Machine Learning Questions
* Interview Questions
* Career Guidance

### Flow

User Question

↓

Spring Boot Controller

↓

OpenRouter API

↓

LLM Response

↓

UI Display

---

# 📄 Resume Analyzer

Users can:

### Option 1

Paste Resume Text

### Option 2

Upload PDF Resume

System extracts text using PDFBox.

AI analyzes:

* Resume Score
* Strengths
* Weaknesses
* Suggestions

---

## Resume Analysis Flow

PDF Upload

↓

Apache PDFBox

↓

Text Extraction

↓

OpenRouter AI

↓

Resume Evaluation

↓

Result Display

---

# 📥 PDF Download

After resume analysis:

User can download

Resume Analysis Report PDF

Generated using:

* iText PDF

---

# 🎤 AI Mock Interview

Simulates real interview experience.

### User enters

* Job Role

Examples:

* Java Developer
* AI Engineer
* Data Scientist
* Full Stack Developer

---

## Interview Flow

Role Selection

↓

AI Generates Question

↓

Candidate Answers

↓

AI Evaluates

↓

Score Given

↓

Next Question Generated

↓

5 Questions Completed

↓

Final Score Generated

---

## Evaluation Metrics

AI provides:

### Score

Example:

8/10

### Strengths

* Technical Knowledge
* Communication
* Clarity

### Improvements

* Missing Concepts
* Better Explanation
* Real-world Examples

---

## Mock Interview Features

### Progress Tracking

Question 1/5

Question 2/5

Question 3/5

...

### Live Score Tracking

Current Score

Final Score

Average Score

### Restart Interview

User can restart interview anytime.

### Voice Input

Speech-to-Text functionality allows users to answer using voice.

Uses:

* Web Speech API

---

# 🛣️ Career Roadmap Generator

User enters:

* Career Goal

Examples:

* Java Developer
* AI Engineer
* Data Scientist

AI generates:

* Learning Path
* Technologies
* Project Suggestions
* Career Guidance

---

# 🏗️ Technologies Used

## Backend

* Java 17
* Spring Boot
* Spring MVC
* REST APIs

## Frontend

* HTML
* CSS
* Bootstrap 5
* JavaScript
* Thymeleaf

## AI Integration

* OpenRouter API
* LLM Models

## Database

* MySQL

## PDF Processing

* Apache PDFBox
* iText PDF

## Build Tool

* Maven

---

# 📂 Modules

## Authentication Module

* Login
* Register
* Logout

## Dashboard Module

* Navigation Hub

## Chat Module

* AI Chat

## Resume Module

* Resume Analysis
* PDF Upload
* PDF Download

## Interview Module

* AI Mock Interview
* Voice Input
* Score Tracking

## Roadmap Module

* Career Guidance

---

# 📸 Screenshots

Add screenshots inside screenshots folder.

Example:

Home Page

Dashboard

Resume Analyzer

Mock Interview

Career Roadmap

---

# ⚙️ Installation

## Clone Repository

git clone https://github.com/your-username/AI-Career-Assistant.git

## Open Project

Import as Maven Project

## Configure Database

Update:

application.properties

spring.datasource.url

spring.datasource.username

spring.datasource.password

## Run Application

Run:

CareerAssistantApplication.java

Application starts at:

http://localhost:8080

---

# 🎯 Future Enhancements

Planned Features:

* Interview History
* User Performance Analytics
* AI Voice Interview
* Resume ATS Score
* Job Recommendation System
* Email Reports
* JWT Authentication
* Cloud Deployment
* Docker Support
* Admin Dashboard

---

# ⭐ Project Outcome

This project demonstrates:

* Spring Boot Development
* REST API Design
* AI Integration
* Resume Parsing
* PDF Generation
* Authentication
* Frontend Development
* Problem Solving
