<%--
  Created by IntelliJ IDEA.
  User: owenb
  Date: 17/04/2023
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="include/head.jsp" />

<div class="row justify-content-center mt-5">
    <div class="col-md-7 col-lg-5 mt-5">
        <div class="wrap" style="background-color: white; border-radius: 25px">
            <div class="d-flex justify-content-center pt-5">
                <img src="${pageContext.request.contextPath}/images/logo1200.png">
            </div>
            <div class="login-wrap p-4 p-md-5">
                <div class="text-center">
                    <h3 class="mb-4">Se connecter</h3>
                </div>
                <form action="${pageContext.request.contextPath}/login" method="post">
                    <div class="form-floating mt-5 mb-5">
                        <input id="email" type="email" name="email" class="form-control" placeholder="name@example.com" required>
                        <label for="email">Email</label>
                    </div>
                    <div class="form-floating mt-5 mb-5">
                        <input id="password" type="password" name ="password" class="form-control" placeholder="password" required>
                        <label class="form-control-placeholder" for="password">Password</label>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="form-control btn btn-primary rounded submit px-3">Se connecter</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<jsp:include page="include/footer.jsp"/>

