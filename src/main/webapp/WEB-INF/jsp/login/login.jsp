<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="../include/header.jsp" />

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login form</title>
    <link rel="stylesheet" type="text/css" href="../pub/css/login.css">
    <style>
        h3 {
            color: hsl(67, 100%, 27%);
            font-family: verdana;
            font-size: 150%;
            align-items: center;
            text-align: center;
            justify-content: center;
            margin-top: -275px;
        }
    </style>
</head>
<body style="background-color: cornsilk;" >

<div class = "login-form">
    <br>
    <br>
    <h3>Login Form</h3>

<form action="/login/loginSecurityPost" method="POST">

    <h1 style="color:red">${errorMessage}</h1>

    Username : <input type="text" name="username">
    <br>
    Password: <input type="password" name="password">
    <br>

    <button type="submit">Submit</button>


</form>
</div>

    <br>
    <br>
    <br>
<%--<div--%>
<%--<jsp:include page="../include/footer.jsp" />--%>

<%--</div>--%>