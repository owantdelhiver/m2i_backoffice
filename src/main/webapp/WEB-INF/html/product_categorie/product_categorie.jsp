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
<jsp:include page="/WEB-INF/html/include/head.jsp"/>
<jsp:include page="/WEB-INF/html/include/nav.jsp"/>

<div class="container mt-5">
    <div class="card">
        <div class="card-body">
            <div class="d-flex">
                <h5 class="card-title">Liste des catégories</h5>
                <a class="ms-auto" href="#">New</a>
            </div>

            <!-- Table with stripped rows -->
            <table class="table table-striped table-hover">
                <colgroup>
                    <col class="col-md-1">
                    <col class="col-md-2">
                    <col class="col-md-7">
                    <col class="col-md-2">
                </colgroup>
                <thead>
                <tr>
                    <th>#</th>
                    <th>Nom</th>
                    <th>Description</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${categories}" var="categorie">
                    <tr>
                        <th>${categorie.id}</th>
                        <td>${categorie.name}</td>
                        <td>${categorie.description}</td>
                        <td>
                            <a href="#">edit</a>
                            <a href="#">delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <!-- End Table with stripped rows -->

        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/html/include/footer.jsp"/>

