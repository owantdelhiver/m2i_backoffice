<%--
  Created by IntelliJ IDEA.
  User: Aerosson
  Date: 28/04/2023
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="categories" scope="request" type="java.util.List"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/head.jsp" />
<jsp:include page="../include/nav.jsp" />
<div class="main-containers row mb-3">
  <div class="container mt-5">
    <div class="card">
      <div class="card-body">
        <h4>Create new product</h4>
        <form method="post" action="${pageContext.request.contextPath}/create-product" enctype="multipart/form-data">
          <div class="mb-3">
            <label for="productName" class="form-label">Product name</label>
            <input type="text" class="form-control" id="productName" name="name">
          </div>
          <div class="mb-3">
            <label for="productPrice" class="form-label">Price</label>
            <input type="number" step="0.01" class="form-control" id="productPrice" name="price">
          </div>
          <div class="mb-3">
            <label for="productShort" class="form-label">Short description</label>
            <input type="text" class="form-control" id="productShort" name="shortDescription">
          </div>
          <div class="mb-3">
            <label for="productLong" class="form-label">Long description</label>
            <input type="text" class="form-control" id="productLong" name="longDescription">
          </div>
          <div class="mb-3">
            <label for="productStock" class="form-label">Stock</label>
            <input type="text" class="form-control" id="productStock" name="stock">
          </div>
          <div class="mb-3">
            <label for="productPictureUrl" class="form-label">Picture URL</label>
            <input type="file" accept=".image/* " class="form-control" id="productPictureUrl" name="pictureUrl">
          </div>
          <div class="mb-3">
            <label for="productCategoryId" class="form-label">Category name</label>
            <select name="productCategoryId" id="productCategoryId">
              <c:forEach var="category"  items="${categories}" >
                <option value="${category.id}"> ${category.name} </option>
              </c:forEach>
            </select>
          </div>
          <button type="submit" class="btn btn-warning">Submit</button>
        </form>
      </div>
    </div>
  </div>
</div>
<jsp:include page="../include/footer.jsp" />