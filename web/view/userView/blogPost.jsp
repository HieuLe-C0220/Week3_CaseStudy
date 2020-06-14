<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/06/2020
  Time: 11:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Blog</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="stylesheet" type="text/css" href="bootstrapPostBlog/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="bootstrapPostBlog/font-awesome/css/font-awesome.min.css" />

    <script type="text/javascript" src="bootstrapPostBlog/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="bootstrapPostBlog/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="/userPage">My Blog</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="sign_up_form.jsp"><c:out value="${nickName.nickName}"/></a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="page-header">
        <h1>New Blog Post <small>Bạn đang muốn chia sẻ điều gì?</small></h1>
    </div>

    <!-- New Blog Post - START -->
    <div class="container">
        <div class="row" id="row_style">
            <h4 class="text-center">Chia sẻ là còn mãi</h4>
            <div class="col-md-4   col-md-offset-4">
                <form method="post" action="/userPage?action=postBlog&user=${requestScope['nickName'].getNickName()}">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Tiêu đề" name="header">
                    </div>
                    <textarea id="editor" cols="30" rows="10" placeholder="Nội dung..." name="content"></textarea>
                    <br>
                    <div class="form-group">
                        <select name="category_id">
                            <option value="1">Kiến thức học tập</option>
                            <option value="2">Funny Story</option>
                            <option value="3">Tâm lý - tình cảm</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-primary" id="submit">Submit new post</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <style>
        #row_style {
            margin-top: 30px;
        }

        #submit {
            display: block;
            margin: auto;
        }
    </style>

    <!-- you need to include the shieldui css and js assets in order for the charts to work -->
    <link rel="stylesheet" type="text/css" href="http://www.shieldui.com/shared/components/latest/css/light/all.min.css" />
    <script type="text/javascript" src="http://www.shieldui.com/shared/components/latest/js/shieldui-all.min.js"></script>

    <script>
        $(function () {
            $("#editor").shieldEditor({
                height: 260
            });
        })
    </script>
    <!-- New Blog Post - END -->

</div>

</body>
</html>
