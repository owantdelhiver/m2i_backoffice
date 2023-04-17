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
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/commandes">Commandes</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/produits">Produits</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/categories">Catégories</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/#">Connexion</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/#">Déconnexion</a></li>

<%--            <li class="nav-item dropdown">--%>
<%--                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Produits</a>--%>
<%--                <ul class="dropdown-menu">--%>
<%--                    <li><a class="dropdown-item" href="#">Tous les produits</a></li>--%>
<%--                    <li><a class="dropdown-item" href="#">Another action</a></li>--%>
<%--                    <li>--%>
<%--                        <hr class="dropdown-divider">--%>
<%--                    </li>--%>
<%--                    <li><a class="dropdown-item" href="#">Something else here</a></li>--%>
<%--                </ul>--%>
<%--            </li>--%>

        </ul>
    </div>
</nav>