
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="../include/header.jsp" />

<br>
<br>
<br>
<table class="table-bordered">
    <tr>
        <td> Product Id &nbsp</td>
        <td> Product Name &nbsp</td>
        <td> Price &nbsp</td>
        <td> Product image &nbsp</td>
    </tr>

    <c:forEach items = "${productList}" var="product" >
        <tr>
            <td> <center> ${product.id}  </center> </td>
            <td> <center>  ${product.productName} </center> </td>
            <td>  <center> ${product.price} </center> </td>
            <td><img style = "width:100px;height:50px;" src="${product.imageUrl}"></td>
            <td> <a href="/editProduct?id=${product.id}" class="btn btn-success"> EDIT </a> </td>
            <td> <a href="/deleteProduct?id=${product.id}" class="btn btn-danger"> DELETE </a> </td>
        </tr>
    </c:forEach>
</table>
<%--<jsp:include page="../include/footer.jsp" />--%>
<jsp:include page="../include/footer1.jsp" />