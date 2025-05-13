<%--
  Created by IntelliJ IDEA.
  User: bmd tech
  Date: 10/05/2025
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Ajouter un Cours</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<header>
    <h1>Système de gestion scolaire</h1>
    <nav>
        <ul>
            <li><a href="/accueil">Accueil</a></li>
            <li><a href="/etudiants/lister">Etudiants</a></li>
            <li><a href="/cours/lister" class="active">Cours</a></li>
            <li><a href="/filieres/lister">Filières</a></li>
            <li><a href="/notes/lister">Notes</a></li>
        </ul>
    </nav>
</header>

<main>
    <section class="form-container">
        <h2>Ajouter un nouveau cours</h2>

        <c:if test="${not empty errorMessage}">
            <div class="alert error">
                    ${errorMessage}
            </div>
        </c:if>

        <form action="${pageContext.request.contextPath}/cours/ajouter" method="post">
            <div class="form-group">
                <label for="departement">Département:</label>
                <input type="text" id="departement" name="departement"
                       value="${not empty departement ? departement : ''}" required>
            </div>

            <div class="form-group">
                <label for="cours">Nom du cours:</label>
                <input type="text" id="cours" name="cours"
                       value="${not empty cours ? cours : ''}" required>
            </div>

            <div class="form-group">
                <label for="salle">Salle:</label>
                <input type="text" id="salle" name="salle"
                       value="${not empty salle ? salle : ''}" required>
            </div>

            <div class="form-group">
                <label for="professeur">Professeur:</label>
                <input type="text" id="professeur" name="professeur"
                       value="${not empty professeur ? professeur : ''}" required>
            </div>

            <div class="form-group">
                <label for="heures">Heures (Format: JJ-HH:MM):</label>
                <input type="text" id="heures" name="heures"
                       value="${not empty heures ? heures : ''}"
                       placeholder="Ex: Lundi-14:00" required>
            </div>

            <div class="form-actions">
                <button type="submit" class="btn btn-primary">Enregistrer</button>
                <a href="${pageContext.request.contextPath}/cours/lister" class="btn btn-secondary">Annuler</a>
            </div>
        </form>
    </section>
</main>

<footer>
    <p>&copy; 2023 Système de Gestion Scolaire - ISEP</p>
</footer>
</body>
</html>