<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/06/2020
  Time: 11:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyBlog</title>
</head>
<body>
<h1>Danh sách tất cả các bài viết đã duyệt</h1>
<br>
<br>
<div>
    <table border="1">
        <tr>
            <th scope="col">Tiêu đề</th>
            <th scope="col">Tác giả</th>
            <th scope="col">Ngày đăng</th>
            <th scope="col">Thể loại</th>
            <th scope="col">Người duyệt</th>
        </tr>
        <c:forEach items="${listBlogByMe}" var="blog">
            <tr>
                <td>${blog.getHeader()}</td>
                <td>${blog.getAuthor()}</td>
                <td>${blog.getDate()}</td>
                <td>${blog.getCategory_id()}</td>
                <td>${blog.getCensor()}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
