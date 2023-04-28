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
        <h4>Edit category</h4>
        <form method="post" action="${pageContext.request.contextPath}/edit-product">
          <div class="mb-3">

            <label for="productId" class="form-label">Id</label>
            <input type="text" class="form-control" id="productId" name="id">

            <label for="productName" class="form-label">Name</label>
            <input type="text" class="form-control" id="productName" name="name">

            <label for="productPrice" class="form-label">Price</label>
            <input type="text" class="form-control" id="productPrice" name="price">

            <label for="productShort" class="form-label">Short description</label>
            <input type="text" class="form-control" id="productShort" name="shortDescription">

            <label for="productLong" class="form-label">Long description</label>
            <input type="text" class="form-control" id="productLong" name="longDescription">

            <label for="productStock" class="form-label">Stock</label>
            <input type="text" class="form-control" id="productStock" name="stock">

            <label for="productPictureUrl" class="form-label">Picture Url</label>
            <input type="text" class="form-control" id="productPictureUrl" name="pictureUrl">

            <label for="productCategoryName" class="form-label">Category Name</label>
            <input type="text" class="form-control" id="productCategoryName" name="categoryName">

          </div>
          <button type="submit" class="btn btn-warning">Submit</button>
        </form>
      </div>
    </div>
  </div>
</div>
<jsp:include page="../include/footer.jsp" />