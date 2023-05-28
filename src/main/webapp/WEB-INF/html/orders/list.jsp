<%--
  Created by IntelliJ IDEA.
  User: owenb
  Date: 17/04/2023
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../include/head.jsp" />
<jsp:include page="../include/nav.jsp" />
<div class="main-containers row mb-3">
  <div class="col-md-4 themed-grid-col">
    <div class="container mt-5">
      <div class="card">
        <div class="card-body">
          <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search" action="${pageContext.request.contextPath}/products" method="post">
            <div class="d-flex">
              <input type="search" class="form-control form-control-dark text-bg-light" name="search" placeholder="Search by keyword..." aria-label="Search">
              <button class="search-button">
                                <span class="search-icon">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                                    <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/></svg>
                                </span>
              </button>
            </div>
          </form>
          <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search" action="${pageContext.request.contextPath}/products-filtered" method="post">
            <c:forEach items="${categories}" var="category">
              <div class="form-check">
                <div class="row align-items-center">
                  <div class="col">
                    <label class="form-check-label justify-content-start" for="checkbox${category.id}">${category.name}</label>
                  </div>
                  <div class="col-auto">
                    <input class="form-check-input" type="checkbox" value="${category.id}" name="category" id="checkbox${category.id}">
                  </div>
                </div>
              </div>
            </c:forEach>
            <button type="submit" class="btn btn-primary">Filter</button>
          </form>
        </div>
      </div>
    </div>
  </div>
  <div class="col-md-8 themed-grid-col">
    <div class="container mt-5">
      <div class="card">
        <div class="card-body">
          <div class="product-list-header d-flex">
            <h4 class="card-title">Order list</h4>
          </div>

          <!-- Table with stripped rows -->
          <table class="table table-striped table-hover">
            <colgroup>
              <col class="col-1">
              <col class="col-2">
              <col class="col-6">
              <col class="col-3">
            </colgroup>
            <thead>
            <tr>
              <th>#</th>
              <th>Date</th>
              <th>Status</th>
              <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${orders}" var="order">
              <tr>
                <th>${order.id}</th>
                <th>${order.date}</th>
                <td>${order.orderStatus}</td>
                <td class="edit-button">
                  <div class="btn-group">
                    <a href="${pageContext.request.contextPath}/edit-product?id=${order.id}" class="btn btn-warning">
                      <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                           class="bi bi-pencil-square" viewBox="0 0 16 16">
                        <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"></path>
                        <path fill-rule="evenodd"
                              d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"></path>
                      </svg>
                      Edit
                    </a>
                  </div>
                </td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
          <!-- End Table with stripped rows -->

        </div>
      </div>
    </div>
  </div>
</div>
<jsp:include page="../include/footer.jsp" />
