<%--
  Created by IntelliJ IDEA.
  User: owenb
  Date: 17/04/2023
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="p-3 text-bg-light">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="${pageContext.request.contextPath}/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                <img src="${pageContext.request.contextPath}/images/logo1200.png" width="100px" height="61px"  alt="Icon">
            </a>
            <ul class="nav col-12 col-lg-auto me-lg mb-2 justify-content-end mb-md-0 ms-auto">
                <li><a href="${pageContext.request.contextPath}/" class="nav-link px-2 text-dark">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/products" class="nav-link px-2 text-dark" >Product</a></li>
                <li><a href="${pageContext.request.contextPath}/categories" class="nav-link px-2 text-dark" >Category</a></li>
                <li><a href="${pageContext.request.contextPath}/" class="nav-link px-2 text-dark" >Logout</a></li>
            </ul>
        </div>
    </div>
</header>
