<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 10/06/2020
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="bootstrapLogin/images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="bootstrapLogin/vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="bootstrapLogin/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="bootstrapLogin/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="bootstrapLogin/vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="bootstrapLogin/vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="bootstrapLogin/vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="bootstrapLogin/vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="bootstrapLogin/vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="bootstrapLogin/css/util.css">
    <link rel="stylesheet" type="text/css" href="bootstrapLogin/css/main.css">
</head>
<body>
<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100 p-b-160 p-t-50">
            <form class="login100-form validate-form" method="post" action="./login">
					<span class="login100-form-title p-b-43">
						Account Login
					</span>

                <div class="wrap-input100 rs1 validate-input" data-validate = "Username is required">
                    <input class="input100" type="text" name="nickName">
                    <span class="label-input100">NickName</span>
                </div>


                <div class="wrap-input100 rs2 validate-input" data-validate="Password is required">
                    <input class="input100" type="password" name="password">
                    <span class="label-input100">Password</span>
                </div>

                <div class="container-login100-form-btn">
                    <button class="login100-form-btn" name="submit">
                        Sign in
                    </button>
                </div>

                <div class="text-center w-full p-t-23">
                    <a href="#" class="txt1">
                        Forgot password?
                    </a><br/>
                    <a href="http://localhost:8080/" style="color: white"> <- Back to Home Blog</a>
                </div>
            </form>
            <p style="text-align: center">
                <c:if test="${requestScope['mess']!=null}">
                    <span style="color: red; font-size: 24px">${requestScope['mess']}</span>

                </c:if>
            </p>
        </div>
    </div>
</div>





<!--===============================================================================================-->
<script src="bootstrapLogin/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="bootstrapLogin/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="bootstrapLogin/vendor/bootstrap/js/popper.js"></script>
<script src="bootstrapLogin/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="bootstrapLogin/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="bootstrapLogin/vendor/daterangepicker/moment.min.js"></script>
<script src="bootstrapLogin/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="bootstrapLogin/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="bootstrapLogin/js/main.js"></script>
</body>
</html>
