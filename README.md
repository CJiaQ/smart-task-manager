# Smart Task Manager

基于 SpringBoot + Vue 的任务管理系统，实现任务增删改查、JWT认证、Redis缓存。

## 技术栈

- SpringBoot
- MyBatis
- Redis
- JWT
- Vue3
- MySQL

## 项目功能

- 用户登录 (JWT认证)
- 任务增删改查
- 任务状态切换
- Redis缓存任务列表
- 分页查询任务

## 项目截图
<img width="1920" height="939" alt="screenshot" src="https://github.com/user-attachments/assets/889e388b-4e73-41df-9575-0b70a21631e3" />

## API 示例

GET /tasks

POST /tasks

PUT /tasks/{id}

DELETE /tasks/{id}

## 技术难点

在实现 JWT 认证时遇到 CORS 跨域问题。

浏览器发送请求前会进行 **OPTIONS 预检请求**，该请求不会携带 Authorization 头，导致 JWT 拦截器返回 401。

解决方案是在拦截器中放行 OPTIONS 请求：if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
    return true;
}
记录：通过该问题加深了对 CORS 跨域机制与 JWT 认证流程的理解。
