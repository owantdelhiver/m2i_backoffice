<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="./include/head.jsp" />
<jsp:include page="./include/nav.jsp" />

<div class=" row justify-content-center mt-5">
    <div class="main-block col-md-7 col-lg-5 mt-5">
        <div class="wrap" style="background-color: white; border-radius: 25px">
            <div class="d-flex justify-content-center pt-5">
                <p>Something went wrong :(</p>
            </div>
            <div class="d-flex justify-content-center pb-4">
                <img src="${pageContext.request.contextPath}/images/sad-robot.png" style="height: 150px; width: 150px;">
            </div>
        </div>
    </div>
</div>

<jsp:include page="./include/footer.jsp"/>
