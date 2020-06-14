<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 10/06/2020
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page Admin</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="nav-item">
        <a class="nav-link active" href="http://localhost:8080/">Trang chủ</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/adminPage?action=blogList&user=${nickName.nickName}">Danh sách bài viết</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/adminPage?action=postBlog&user=${nickName.nickName}">Đăng bài</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/adminPage?action=selectBlog&user=${nickName.nickName}">Tra cứu bài viết</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/adminPage?action=blogWait&user=${nickName.nickName}">Bài viết đang chờ duyệt</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/adminPage?action=userList&user=${nickName.nickName}">Danh sách người dùng</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/adminPage?action=userSearch&user=${nickName.nickName}">Tra cứu người dùng</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/adminPage?action=addUser&user=${nickName.nickName}">Thêm thành viên</a>
    </li>
</ul>
</body>
</html>
