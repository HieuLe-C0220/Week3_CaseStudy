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

<div class="container">

    <div class="page-header">
        <h1>New Blog Post <small>A responsive blog post template</small></h1>
    </div>

    <!-- New Blog Post - START -->
    <div class="container">
        <div class="row" id="row_style">
            <h4 class="text-center">Submit new post</h4>
            <div class="col-md-4   col-md-offset-4">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Title">
                </div>
                <textarea id="editor" cols="30" rows="10">Submit your text post here...</textarea>
                <br>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Tags">
                </div>
                <div class="form-group">
                    <button class="btn btn-primary" id="submit">Submit new post</button>
                </div>
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
