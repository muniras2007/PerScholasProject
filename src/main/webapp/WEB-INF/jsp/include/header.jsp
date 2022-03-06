<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<html lang="en">

<head >
    <title>Case Study</title>

    <script
            src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
            crossorigin="anonymous"></script>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>

</head>
<body>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<%--<div class="container">--%>
    <nav class="navbar navbar-expand-lg navbar-light fixed-top bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">
                <img src="images/logo.png" alt="">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">

                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/homepage">Home</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link " href="/productDisplay">View Products</a>
                    </li>


                    </li>

                    <sec:authorize access="isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link " href="/cart">Cart</a>
                    </li>
                   </sec:authorize>

                        <sec:authorize access="hasAnyAuthority('ADMIN', 'USER')">

<%--                     <sec:authorize access="hasAnyAuthority('ADMIN', 'USER')">--%>
                    <li class="nav-item"><a class="nav-link " href="/login/logout">Logout</a></li>
                     </sec:authorize>

                    <sec:authorize access="!isAuthenticated()">
                    <li class="nav-item"><a class="nav-link " href="/login/login">Login</a></li>
                    </sec:authorize>

                        <sec:authorize access="hasAuthority('ADMIN')">
                    <li class="nav-item"><a class="nav-link " href="/productList">Product List</a></li>
                    </sec:authorize>

                    <li class="nav-item"><a class="nav-link" href="/registration-url-path/register">User
                        Registration</a></li>
                    <%--                        <td>|</td>--%>
<%--                    <li class="nav-item"><a class="nav-link" href="/registration-url-path/userList">User Search</a></li>--%>
                    <%--                        <td>|</td>--%>
            <sec:authorize access="hasAuthority('ADMIN')">
                    <li class="nav-item"><a class="nav-link" href="/product">Register Product</a></li>
                </sec:authorize>

                    <sec:authorize access="hasAuthority('ADMIN')">
                    <li class="nav-item"><a class="nav-link" href="/admin/home">Admin Home</a></li>
                    </sec:authorize>
                </ul>

            </div>
        </div>
    </nav>
<%--</div>--%>

<!--End Header	-->


<!-- implement any html you need to show on every page as a header here -->


<%--<table cellpadding="5">--%>
<%--    <tr>--%>
        <%--        <td><a href="/login/logout">Logout</a></td>--%>
        <%--        <td>|</td>--%>
        <%--        <td><a href="/registration-url-path/register">User Registration</a></td>--%>
        <%--        <td>|</td>--%>
        <%--        <td><a href="/registration-url-path/userList">User Search</a></td>--%>
        <%--        <td>|</td>--%>
        <%--        <td><a href="/admin/home">Admin Home</a></td>--%>

<%--    </tr>--%>
<%--</table>--%>

<%--<hr>--%>

<%--<div class="container"></div>--%>