<%--
  Created by IntelliJ IDEA.
  User: owenb
  Date: 17/04/2023
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="p-3 text-bg">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="${pageContext.request.contextPath}/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                <img src="${pageContext.request.contextPath}/images/LogoBack.png" width="100px" height="61px"  alt="Icon">
            </a>
            <ul class="nav col-12 col-lg-auto me-lg mb-2 justify-content-end mb-md-0 ms-auto">
                <li><a href="${pageContext.request.contextPath}/" class="nav-link px-2">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/orders" class="nav-link px-2" >Orders</a></li>
                <li><a href="${pageContext.request.contextPath}/products" class="nav-link px-2" >Product</a></li>
                <li><a href="${pageContext.request.contextPath}/categories" class="nav-link px-2" >Category</a></li>
                <li><a href="${pageContext.request.contextPath}/logout" class="nav-link px-2" >Logout</a></li>
            </ul>
        </div>
    </div>
</header>
