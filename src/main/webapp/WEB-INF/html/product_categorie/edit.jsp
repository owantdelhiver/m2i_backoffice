<jsp:useBean id="action" scope="request" type="java.lang.String"/>
<jsp:useBean id="title" scope="request" type="java.lang.String"/>
<jsp:useBean id="categorie" scope="request" type="com.groupe4.backoffice.model.ProductCategorie"/>
<%--
  Created by IntelliJ IDEA.
  User: owenb
  Date: 22/04/2023
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/html/include/head.jsp"/>
<jsp:include page="/WEB-INF/html/include/nav.jsp"/>

<div class="container mt-5">
  <h2>${title}</h2>

  <form class="mt-5" method="post" action="${action}">
    <div class="form-floating mb-3">
      <input type="text" class="form-control" id="name" placeholder="categorie" value="${categorie.name}">
      <label for="name">Libelle</label>
    </div>
    <div class="d-flex justify-content-md-end">
      <button type="submit" class="btn btn-light mt-3">
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512"><path d="M433.941 129.941l-83.882-83.882A48 48 0 0 0 316.118 32H48C21.49 32 0 53.49 0 80v352c0 26.51 21.49 48 48 48h352c26.51 0 48-21.49 48-48V163.882a48 48 0 0 0-14.059-33.941zM224 416c-35.346 0-64-28.654-64-64 0-35.346 28.654-64 64-64s64 28.654 64 64c0 35.346-28.654 64-64 64zm96-304.52V212c0 6.627-5.373 12-12 12H76c-6.627 0-12-5.373-12-12V108c0-6.627 5.373-12 12-12h228.52c3.183 0 6.235 1.264 8.485 3.515l3.48 3.48A11.996 11.996 0 0 1 320 111.48z"></path></svg>
        Save
      </button>
    </div>
  </form>
</div>

<jsp:include page="/WEB-INF/html/include/footer.jsp"/>