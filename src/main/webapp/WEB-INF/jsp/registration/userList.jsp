<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="../include/header.jsp" />

<form method="get" action="/registration-url-path/userList">
    <input type="text" name="search" value="${searchInput}">
    <button type="submit">Search</button>
</form>
<hr>
<form method="get" action="/registration-url-path/userList">
    First Name <input type="text" name="firstName">
    <br>
    Last Name <input type="text" name="lastName">
    <button type="submit">Search</button>
</form>
<hr>

<table border="1">
    <tr>
        <td><b>Id</b></td>
        <td><b>Username</b></td>
        <td><b>Email</b></td>
        <td><b>First Name</b></td>
        <td><b>Last Name</b></td>
        <td><b>Password</b></td>
        <td><b>Edit</b></td>
        <td><b>Delete</b></td>
    </tr>
    <c:forEach items="${userListKey}" var="user">
        <tr>
            <td>${User.id}</td>
            <td>${User.username}</td>
            <td>${User.email}</td>
            <td>${User.firstName}</td>
            <td>${User.lastName}</td>
            <td>${User.password}</td>
            <td><a class="btn btn-primary"  role="button" href="/registration-url-path/userRegistration?id=${User.id}">Edit</a></td>
            <td><a class="btn btn-danger" role="button" href="/registration-url-path/deleteUser?id=${User.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<br>


<jsp:include page="../include/footer.jsp" />