# Smart Task Manager (SpringBoot + Vue + AI)
基于 AI 的任务管理系统，支持用户登录、任务管理和 AI 自动总结任务。

## 项目截图
<img width="1914" height="884" alt="screenshotplus" src="https://github.com/user-attachments/assets/6198de00-7c27-43ce-8307-d3fd56efc284" />

## 技术栈
后端：
- Java
- Spring Boot
- MyBatis
- MySQL
- JWT

前端：
- Vue 3
- Vite
- Fetch API

AI：
- 大模型 API（任务总结）

---

## 功能

- 用户登录（JWT鉴权）
- 任务增删改查
- AI 自动总结任务
- 前后端分离架构

---

## 项目结构

```
smart-task-manager
│
├─ backend
│  ├─ controller
│  ├─ mapper
│  ├─ service
│  └─ config
│
├─ frontend
│  ├─ src
│  │  ├─ App.vue
│  │  ├─ Login.vue
│  │  └─ main.js
│
└─ README.md
```

---

## API接口

### 用户登录

```
POST /login
```

请求：

```json
{
  "username":"admin",
  "password":"123456"
}
```

返回：

```
JWT Token
```

---

### 获取任务列表

```
GET /tasks
```

Header：

```
Authorization: Bearer token
```

---

### 新增任务

```
POST /tasks
```

```
{
  "title":"学习SpringBoot",
  "done":false
}
```

---

### AI任务总结

```
POST /ai/summary
```

请求：

```
["学习Java","投递简历","准备面试"]
```

返回：

```
AI总结任务内容
```

---

## 本地运行

### 1 启动数据库

创建数据库：

```
CREATE DATABASE task_db;
```

---

### 2 启动后端

运行 Spring Boot 项目：

```
mvn spring-boot:run
```

默认端口：

```
8080
```

---

### 3 启动前端

```
npm install
npm run dev
```

访问：

```
http://localhost:5173
```

---

## 项目亮点

- 前后端分离架构
- JWT 用户认证
- AI 自动总结任务
- 完整 CRUD 任务管理系统

---
