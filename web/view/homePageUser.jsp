<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/06/2020
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page User</title>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="nav-item">
        <a class="nav-link active" href="http://localhost:8080/">Trang chủ</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/userPage?action=postBlog&nickName=${requestScope['nickName'].getNickName()}">Đăng bài</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/userPage?action=selectBlogByMe">Bài viết của bạn</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/userPage?action=blogWaiting">Bài viết đang chờ duyệt</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/userPage?action=informationMe">Thông tin cá nhân</a>
    </li>
</ul>
</body>
</html>
