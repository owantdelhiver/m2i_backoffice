<%--
  Created by IntelliJ IDEA.
  User: owenb
  Date: 17/04/2023
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="include/head.jsp" />
<script src="https://cdn.plot.ly/plotly-2.20.0.min.js" charset="utf-8"></script>

<jsp:include page="include/nav.jsp" />

<div id="tester" style="width:600px;height:250px;"></div>

<script>
    TESTER = document.getElementById('tester');
    Plotly.newPlot( TESTER, [{
        x: [1, 2, 3, 4, 5],
        y: [1, 12, 4, 7, 3] }], {
        margin: { t: 0 } } );
</script>

<jsp:include page="include/footer.jsp" />
