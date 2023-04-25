<%--
  Created by IntelliJ IDEA.
  User: owenb
  Date: 17/04/2023
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid collapse navbar-collapse">

        <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/">Accueil</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/produits">Produits</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/product_categorie">Catégories</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/connexion">Connexion</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/#">Déconnexion</a></li>
        </ul>
    </div>
</nav>