# 📝 Blog Backend Application (Java + PostgreSQL)

This project is a backend system for a blogging platform built with **Java** and **PostgreSQL**. It handles user registration, blog management, post creation, comments, and follower functionality. The system follows a well-structured relational database schema and includes advanced SQL features like **transactions**, **triggers**, **views**, and **indexes**.

---

## 🚀 Features

### 🔐 User and Authentication
- Registration of blog users with a transactional function to prevent duplicate `login_id`.
- Separation of login data (`LoginInfo`) and user profile data (`BUser`).

### 🗂️ Blog & Post Management
- Blogs can have multiple administrators and owners.
- Each blog has posts authored by administrators.
- Posts include title, content, time, and date.

### 💬 Comments
- Users can comment on posts.
- Comments are linked to both the post and the user who wrote them.

### 👥 Followers System
- Users can follow blogs.
- Followers are tracked and counted via indexed views.

### 📊 Views & Queries
- Views showing:
  - Blogs with owner names
  - Blogs and number of posts
  - Comments with author emails
  - Post details with authors
- SQL queries to:
  - Filter posts by author/owner roles
  - Retrieve users, admins, followers
  - Analyze blog activity and comment lengths
  - Paginate blog and post results

### ⚠️ Data Integrity & Safety
- `SERIALIZABLE` transaction isolation for safe concurrent user registration.
- Triggers to prevent duplicate blog names.
- Constraints on emails, passwords, and unique fields.

### ⚡ Performance
- Indexed `Post.blog_id` column for fast post retrieval.
- Optimized views to reduce query time (10–30ms improvements).

---

## 🧱 Database Schema Overview

**Key Tables**:
- `LoginInfo`: Stores credentials and email.
- `BUser`: Stores user personal data.
- `Administrator`: Connects a user to administrative roles.
- `Blog`, `Post`, `Comment`: Core content entities.
- `BlogFollower`: Tracks which users follow which blogs.
- `OwnerBlog`, `AdminBlog`, `OwnerAdmin`: Handle many-to-many blog ownership and administration relationships.

![image](https://github.com/user-attachments/assets/8106d20e-10e6-4c6d-937e-bb181ce26636)
![image](https://github.com/user-attachments/assets/aebd4d29-cf78-4023-a4a5-4e7a6176f249)

---

## 📄 Technologies

- **Java** – Backend logic (REST API layer assumed)
- **PostgreSQL** – Relational database
- **PL/pgSQL** – Stored procedures and triggers
- **SQL** – Views, indexes, data constraints

---

