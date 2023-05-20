<%--
  Created by IntelliJ IDEA.
  User: owenb
  Date: 19/05/2023
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/test-image" enctype="multipart/form-data">
    <div class="mb-3">
        <label for="image" class="form-label">Picture URL</label>
        <input type="file" accept=".image/* " class="form-control" id="image" name="image">
    </div>
    <button type="submit" class="btn btn-warning">Submit</button>
</form>
</body>
</html>
