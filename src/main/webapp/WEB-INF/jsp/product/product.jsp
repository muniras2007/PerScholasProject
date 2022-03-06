<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="../include/header.jsp" />
<br>
<c:choose>
    <c:when test="${empty productBeanKey.id}">
        <h2>Product Recording Page</h2>
    </c:when>
    <c:otherwise>
        <h1>Edit Product</h1>
    </c:otherwise>
</c:choose>


<form action="/productSubmit" method="post">
    <input type="hidden" name="id" value="${productBeanKey.id}">

    <table align="center" class="table-bordered">

        <tr>
            <td> Product Name </td>
            <td><input type="text" name="productName" value="${productBeanKey.productName}"><td>
        </tr>
        <tr>
            <td> Price </td>
            <td><input type="text" name="price" value="${productBeanKey.price}"><td>
        </tr>
        <tr>
            <td> Product Description </td>
            <td><input type="text" name="productDescription" value="${productBeanKey.productDescription}"><td>
        </tr>
        <tr>
            <td> Product Image </td>
            <td><input type="text" name="imageUrl" value="${productBeanKey.imageUrl}">
        </tr>
    </table>
    <button type="submit" class="btn btn-primary" role="button">Submit</button>


</form>



    <jsp:include page="../include/footer.jsp" />