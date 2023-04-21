<%--
  Created by IntelliJ IDEA.
  User: owenb
  Date: 17/04/2023
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Backoffice</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>

<div class="row justify-content-center mt-5">
    <div class="col-md-7 col-lg-5 mt-5">
        <div class="wrap">
            <div class="login-wrap p-4 p-md-5">
                <div class="text-center">
                    <h3 class="mb-4">Se connecter</h3>
                </div>
                <form action="${pageContext.request.contextPath}/connexion" method="post">
                    <div class="form-floating mt-5 mb-5">
                        <input id="email" type="email" class="form-control" placeholder="name@example.com" required>
                        <label for="email">email</label>
                    </div>
                    <div class="form-floating mt-5 mb-5">
                        <input id="password" type="password" class="form-control" placeholder="password" required>
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

