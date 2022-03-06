<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="../include/header.jsp" />

<form method="get" action="/productDisplay">
    <input type="text" name="search" value="${searchInput}">
    <button type="submit">Search</button>
</form>
<hr>
<div class="row">
    <c:forEach items = "${productListKey}" var="product" >

        <div class = "col-sm-4 col-md-3">
            <a href = "<c:url value="/totalProductDisplay/${product.id}" />" class = "thumbnail">
                <img style = "width:250px;height:250px;
 "src="<c:url value="${product.imageUrl}" />" alt = "Generic placeholder thumbnail">
            </a>

            <p align="center"> ${product.productName} </p>
            <p align="center"> Price : $${product.price}/- </p>


        </div>
    </c:forEach>

</div>

<div class=" wrapper">
<br>

<br>
    <br>
<body bgcolor="aqua">
<div class="row">
    <c:forEach items = "${productDisplay}" var="product" >

        <div class = "col-sm-4 col-md-3">
                <img style = "width:200px;height:200px; display: block;
        background: aliceblue;
        padding: 8px;
        border: 1px solid #ccc;
        box-shadow: 10px 10px 10px #ffffff;"

                     src="<c:url value="${product.imageUrl}" />" alt = "Generic placeholder thumbnail">
    <a href="/totalProductDisplay/show?productId=${product.id }" style="margin-top:10px;
    display: inline-block; width:120px;" class="button large hptop">${product.productName}</a>


<%--            <p align="center"> ${product.productName} </p>--%>
            <p class="pt0" align="left"> Price : $${product.price}/- </p>


        </div>
    </c:forEach>

</div>
</body>
<br>

<br>
    <div class="push"></div>
</div>
<div class=" wrapper">
<%--<jsp:include page="../include/footer.jsp" />--%>
</div>
<jsp:include page="../include/footer.jsp" />