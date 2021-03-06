<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 12/06/2020
  Time: 2:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách thành viên</title>
</head>
<body>
<h1>Danh sách thành viên</h1>
<br>
<br>
<div>
    <table border="2">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Tiêu đề</th>
            <th scope="col">Tác giả</th>
            <th scope="col">Ngày đăng</th>
            <th scope="col">Thể loại</th>
            <th scope="col">Trạng thái</th>
            <th colspan="3">Tuỳ chỉnh</th>
        </tr>
        <c:forEach items="${blogList}" var="blog">
            <tr>
                <td>${blog.getId()}</td>
                <td>${blog.getHeader()}</td>
                <td>${blog.getAuthor()}</td>
                <td>${blog.getDate()}</td>
                <td>${blog.getCategory_id()}</td>
                <td>${blog.getstatus()}</td>
                <td><a href="/adminPage?action=edit&id=${blog.id}">Sửa</a>
                    <a href="/adminPage?action=delete&id=${blog.id}">Xoá</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
