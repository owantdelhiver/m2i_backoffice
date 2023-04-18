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
<p>Liste des catégories</p>


<c:forEach items="${categories}" var="categorie">
    <p>${categorie.name}</p>
</c:forEach>

<jsp:include page="/WEB-INF/html/include/footer.jsp" />

