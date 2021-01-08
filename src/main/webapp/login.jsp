<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 1/6/2021
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"--%>
<%--      integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">--%>
<%--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css"--%>
<%--      integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">--%>
<%--<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"--%>
<%--        integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>--%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

<link rel="stylesheet" href="login-form/fonts/icomoon/style.css">

<link rel="stylesheet" href="login-form/css/owl.carousel.min.css">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="login-form/css/bootstrap.min.css">

<!-- Style -->
<link rel="stylesheet" href="login-form/css/style.css">
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
    <div class="content">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <img src="login-form/images/undraw_remotely_2j6y.svg" alt="Image" class="img-fluid">
        </div>
        <div class="col-md-6 contents">
          <div class="row justify-content-center">
            <div class="col-md-8">
              <div class="mb-4">
                <h3>Sign In</h3>
                <p class="mb-4">Lorem ipsum dolor sit amet elit. Sapiente sit aut eos consectetur adipisicing.</p>
              </div>
              <form action="#" method="post">
                <div class="form-group first">
                  <label for="username">Username</label>
                  <input type="text" class="form-control" id="username">

                </div>
                <div class="form-group last mb-4">
                  <label for="password">Password</label>
                  <input type="password" class="form-control" id="password">

                </div>

                <div class="d-flex mb-5 align-items-center">
                  <label class="control control--checkbox mb-0"><span class="caption">Remember me</span>
                    <input type="checkbox" checked="checked"/>
                    <div class="control__indicator"></div>
                  </label>
                  <span class="ml-auto"><a href="#" class="forgot-pass">Forgot Password</a></span>
                </div>

                <input type="submit" value="Log In" class="btn btn-block btn-primary">

                <span class="d-block text-left my-4 text-muted">&mdash; or login with &mdash;</span>

                <div class="social-login">
                  <a href="#" class="facebook">
                    <span class="icon-facebook mr-3"></span>
                  </a>
                  <a href="#" class="twitter">
                    <span class="icon-twitter mr-3"></span>
                  </a>
                  <a href="#" class="google">
                    <span class="icon-google mr-3"></span>
                  </a>
                </div>
              </form>
            </div>
          </div>

        </div>

      </div>
    </div>
  </div>
  </body>
</html>
