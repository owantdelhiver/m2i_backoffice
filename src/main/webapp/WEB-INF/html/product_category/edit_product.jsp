<jsp:useBean id="pictures_url" scope="request" type="java.lang.String"/>
<jsp:useBean id="product" scope="request" type="com.groupe4.backoffice.model.Product"/>
<%--
  Created by IntelliJ IDEA.
  User: Aerosson
  Date: 28/04/2023
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../include/head.jsp" />
<jsp:include page="../include/nav.jsp" />
<div class="main-containers row mb-3">
  <div class="container mt-5">
    <div class="card">
      <div class="card-body">
        <h4>Edit produit</h4>
        <form method="post" action="${pageContext.request.contextPath}/edit-product">
          <div class="mb-3">

            <label for="productId" class="form-label">Id</label>
            <input type="text" class="form-control" id="productId" name="id" value="${product.id}" readonly>

            <label for="productName" class="form-label">Name</label>
            <input type="text" class="form-control" id="productName" name="name" value="${product.name}">

            <label for="price" class="form-label">Price</label>
            <input type="number" step="0.01" class="form-control" id="price" name="price" value="${product.price}">

            <label for="productShort" class="form-label">Short description</label>
            <input type="text" class="form-control" id="productShort" name="shortDescription" value="${product.short_description}">

            <label for="productLong" class="form-label">Long description</label>
            <input type="text" class="form-control" id="productLong" name="longDescription" value="${product.description}">

            <label for="productStock" class="form-label">Stock</label>
            <input type="text" class="form-control" id="productStock" name="stock" value="${product.stock}">

            <label for="productPictureUrl" class="form-label">Picture Url</label>
            <input type="text" class="form-control" id="productPictureUrl" name="pictureUrl" value='${pictures_url}'>

            <label for="productCategoryName" class="form-label">Category Name</label>
            <input type="text" class="form-control" id="productCategoryName" name="categoryName" value="${product.category.name}">

          </div>
          <button type="submit" class="btn btn-warning">Submit</button>
        </form>
      </div>
    </div>
  </div>
</div>
<jsp:include page="../include/footer.jsp" />