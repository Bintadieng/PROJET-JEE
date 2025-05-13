<%--
  Created by IntelliJ IDEA.
  User: bmd tech
  Date: 10/05/2025
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Modifier Note</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<header>
    <h1>Système de gestion scolaire</h1>
    <nav>
        <ul>
            <li><a href="/accueil">Accueil</a></li>
            <li><a href="/etudiants/lister">Étudiants</a></li>
            <li><a href="/cours/lister">Cours</a></li>
            <li><a href="/filieres/lister">Filières</a></li>
            <li><a href="/notes/lister" class="active">Notes</a></li>
        </ul>
    </nav>
</header>

<main>
    <section class="form-container">
        <h2>Modifier la note</h2>

        <c:if test="${not empty errorMessage}">
            <div class="alert error">
                    ${errorMessage}
            </div>
        </c:if>

        <form action="${pageContext.request.contextPath}/notes/modifier" method="post">
            <input type="hidden" name="id" value="${note.id}">

            <div class="form-group">
                <label for="prenom">Prénom:</label>
                <input type="text" id="prenom" name="prenom" value="${note.prenom}" required>
            </div>

            <div class="form-group">
                <label for="nom">Nom:</label>
                <input type="text" id="nom" name="nom" value="${note.nom}" required>
            </div>

            <div class="form-group">
                <label for="departement">Département:</label>
                <input type="text" id="departement" name="departement" value="${note.departement}" required>
            </div>

            <div class="form-group">
                <label for="matiere">Matière:</label>
                <input type="text" id="matiere" name="matiere" value="${note.matiere}" required>
            </div>

            <div class="form-group">
                <label for="note">Note (0-20):</label>
                <input type="number" id="note" name="note" min="0" max="20"
                       value="${note.notes}" required>
            </div>

            <div class="form-actions">
                <button type="submit" class="btn btn-primary">Enregistrer</button>
                <a href="${pageContext.request.contextPath}/notes/lister" class="btn btn-secondary">Annuler</a>
            </div>
            <div class="form-buttons">
                <button type="submit" class="btn btn-primary">Modifier</button>
                <a href="/notes/lister" class="btn btn-secondary">Annuler</a>
            </div>
        </form>
    </section>
</main>

<footer>
    <p>&copy; 2023 Système de Gestion Scolaire - ISEP</p>
</footer>
</body>
</html>