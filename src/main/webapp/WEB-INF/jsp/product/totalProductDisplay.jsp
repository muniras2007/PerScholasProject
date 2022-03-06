<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="../include/header.jsp" />
<br>
<br>
<%--<body background="">--%>


<form action="<c:url value="/addToCart/${product.id}" />" >
    <table class="table-bordered" align="center">
        <tr>
            <td rowspan="8">
                <img style = "width:200px;height:200px;" src="<c:url value="${product.imageUrl}" />" alt = "Generic placeholder thumbnail">
            </td>
            <td> Product Id </td>
            <td> ${product.id}</td>
        </tr>

        <tr>
            <td> Product Name </td>
            <td> ${product.productName}</td>
        </tr>

        <tr>
            <td> Price </td>
            <td> $ ${product.price}/-</td>
        </tr>
        <tr>
            <td> Description </td>
            <td> ${product.productDescription}</td>
        </tr>

<%--        <tr>--%>
<%--            <td> Quantity--%>
<%--                <select name="quantity">--%>
<%--                    <option value="1"> 1 </option>--%>
<%--                    <option value="2"> 2 </option>--%>
<%--                    <option value="3"> 3 </option>--%>
<%--                </select>--%>
<%--            </td>--%>
            <td> <input type="submit" value ="Add To Cart" class="btn btn-success"> </td>
        </tr>

    </table>
</form>

</body>
<jsp:include page="../include/footer.jsp" />