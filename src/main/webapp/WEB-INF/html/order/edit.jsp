<jsp:useBean id="order" scope="request" type="com.groupe4.backoffice.model.order.Order"/>
<%--
  Created by IntelliJ IDEA.
  User: owenb
  Date: 28/05/2023
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../include/head.jsp" />
<jsp:include page="../include/nav.jsp" />

<div class="main-containers row mb-3">
    <div class="container mt-5">
        <div class="card">
            <div class="card-body">
                <h4>Edit Order ${order.id}</h4>
                <form method="post" action="${pageContext.request.contextPath}/order/edit?id=${order.id}">
                    <div class="mb-3">

                        <label for="orderId" class="form-label">Id</label>
                        <input type="text" class="form-control" id="orderId" name="id" value="${order.id}" readonly>

                        <label for="orderDate" class="form-label">Date</label>
                        <input type="date" class="form-control" id="orderDate" name="orderDate" value="${order.date}">


                        <label for="productCategoryId" class="form-label">Category name</label>
                        <select name="productCategoryId" id="productCategoryId">
                            <jsp:useBean id="status" scope="request" type="java.util.List"/>
                            <c:forEach var="state"  items="${status}" >
                                <option value="${state}" <c:if test="${state == order.orderStatus}">selected</c:if>> ${state} </option>
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
