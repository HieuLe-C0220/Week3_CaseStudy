<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 10/06/2020
  Time: 11:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách bài viết</title>
</head>
<body>
<h1>Danh sách tất cả các bài viết đã duyệt</h1>
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
            <th scope="col">Người duyệt</th>
            <th scope="col">Trạng thái</th>
            <th colspan="3">Tuỳ chỉnh</th>
        </tr>
        <c:forEach items="${blogApprovedList}" var="blog">
            <tr>
                <td><c:out value="${blog.getId()}"/></td>
                <td><c:out value="${blog.getHeader()}"/></td>
                <td><c:out value="${blog.getAuthor()}"/></td>
                <td><c:out value="${blog.getDate()}"/></td>
                <td><c:out value="${blog.getCategory_id()}"/></td>
                <td><c:out value="${blog.getCensor()}"/></td>
                <td><c:out value="Đã duyệt"/></td>
                <td><a href="/adminPage?action=editBlog&id=${blog.id}">Sửa</a>
                    <a href="/adminPage?action=delete&id=${blog.id}">Xoá</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
