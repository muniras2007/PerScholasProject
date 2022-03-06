<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="../include/header.jsp" />
<br>
<br>
<br>
<br>

<body background="">
<form action="/checkout" method="get">


<div class="container">
    <table class="table table-bordered">

        <tr class="danger">
            <td colspan="5"><center> Your Cart </center> </td>
        </tr>

        <tr>
            <td> Product Id </td>

            <td> Product Name </td>
            <td> Product Image </td>
        </tr>

        <c:forEach items="${listProducts}" var="cartItem">

<%--            <form action="<c:url value="/updateCartItem/${cartItem.cartItemId }"/>" method="get">--%>
                <tr class="info">
                    <td> ${cartItem.product.id}</td>
                    <td> ${cartItem.product.productName}</td>
                    <td> <img style = "width:100px;height:100px;" src="<c:url value="${cartItem.product.imageUrl}" />" alt = "Generic placeholder thumbnail"></td>
<%--                    <td>--%>
<%--                        <input type="submit" value="CHECKOUT" class="btn btn-success" />--%>
<%--&lt;%&ndash;                        <a href="<c:url value="/deleteCartItem/${cartItem.cartItemId}"/>" class="btn btn-danger"> DELETE </a>&ndash;%&gt;--%>
<%--                    </td>--%>
                </tr>
<%--            </form>--%>
        </c:forEach>
        <td>
            <input  href="/checkout" type="submit" value="CHECKOUT"  class="btn btn-success" />
            <%--                        <a href="<c:url value="/deleteCartItem/${cartItem.cartItemId}"/>" class="btn btn-danger"> DELETE </a>--%>
        </td>
        <td colspan="3">
<%--            <center> <a href="<c:url value="/checkout" />" class="btn btn-success"> Check Out </a> </center>--%>
        </td>

        </tr>

    </table>
</div>
</form>
</body>

