<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: owenb
  Date: 18/04/2023
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="categories" scope="request" type="java.util.List"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/html/include/head.jsp" />
<jsp:include page="/WEB-INF/html/include/nav.jsp"/>

<div class="container mt-5">
    <h3>Liste des catégories</h3>

    <div class="mt-5">
        <table class="table">
            <thead>
                <tr>
                    <th>Nom</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${categories}" var="categorie">
                    <tr>
                        <td>${categorie.name}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="card">
        <h5 class="card-header">Liste des catégories produits</h5>
        <div class="table-responsive text-nowrap">
            <table class="table">
                <thead>
                <tr>
                    <th>Name</th>
                </tr>
                </thead>
                <tbody class="table-border-bottom-0">
                <c:forEach items="${categories}" var="categorie">
                    <tr>
                        <td class="ms-3">${categorie.name}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/html/include/footer.jsp" />

