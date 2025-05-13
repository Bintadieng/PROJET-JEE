<%@ page import="sn.isep.dbe.model.Filiere" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">

</head>
<body>
<header>
    <h1>Système de gestion scolaire</h1>
    <nav>
        <ul>
            <li><a href="/accueil">Accueil</a></li>
            <li><a href="">Etudiants</a></li>
            <li><a href="">Cours</a></li>
            <li><a href="../" class="active">Filières</a></li>
            <li><a href="">Notes</a></li>
        </ul>
    </nav>
</header>

<main>
    <section class="student-list">
        <div class="list-header">
            <h2>Liste des filières</h2>
            <a href="/filieres/ajouter" class="btn">+ Nouvelle filière</a>
        </div>

        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Département</th>
                <th>Responsable</th>
                <th>Capacité</th>
                <th>Actions</th>
            </tr>
            </thead>

            <tbody>

<c:forEach items="${filieres}" var="filiere">
    <tr>
        <td>${filiere.id}</td>
        <td>${filiere.code}</td>
        <td>${filiere.nom}</td>
        <td>${filiere.prenomResponsable} ${filiere.nomResponsable}</td>
        <td>${filiere.capacite}</td>
        <td class="actions">
            <a class="btn-details">Details</a>
            <a href="${pageContext.request.contextPath}//filieres/modifier?id=${filiere.id}" class="btn-edit">Modifier</a>
            <a class="btn-delete">Supprimer</a>

        </td>
    </tr>
</c:forEach>



</tbody>
</table>
</section>
</main>
</body>
</html>