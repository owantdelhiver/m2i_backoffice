<%--
  Created by IntelliJ IDEA.
  User: Aerosson
  Date: 28/04/2023
  Time: 14:39
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
                    <h4>Create new category</h4>
                    <form method="post" action="${pageContext.request.contextPath}/create-category">
                        <div class="mb-3">
                            <label for="categoryName" class="form-label">Category name</label>
                            <input type="text" class="form-control" id="categoryName" aria-describedby="emailHelp" name="name">
                            <div id="emailHelp" class="form-text">Ex: Processors...</div>
                        </div>
                        <button type="submit" class="btn btn-warning">Submit</button>
                    </form>
                </div>
            </div>
        </div>
</div>
<jsp:include page="../include/footer.jsp" />