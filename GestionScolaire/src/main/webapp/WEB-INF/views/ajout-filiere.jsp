
<%@ page import="sn.isep.dbe.model.Filiere" %>
<%@ page import="java.util.ArrayList" %><%--
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 08/05/2025
  Time: 06:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <li><a href="" class="active">Filières</a></li>
            <li><a href="">Notes</a></li>
        </ul>
    </nav>
</header>

<main>
    <section class="form-container">
        <h2>Ajouter une nouvelle filière</h2>

        <form action="/filieres/ajouter" method="post">
            <div class="form-group">
                <label for="code">Code</label>
                <input type="text" name="code" id="code" placeholder="Code" required>
            </div>

            <div class="form-group">
                <label for="nom">Nom</label>
                <input type="text" name="nom" id="nom" placeholder="Nom" required>
            </div>

            <div class="form-group">
                <label for="nom">Département</label>
                <select id="departement" name="departement">
                    <option value="TIC">TIC</option>
                    <option value="AUTO">Automobile</option>
                </select>
            </div>

            <div class="form-group">
                <label for="nomResponsable">Nom</label>
                <input type="text" name="nomResponsable" id="nomResponsable" placeholder="nomResponsable">
            </div>
            <div class="form-group">
                <label for="prenomResponsable">Prénom</label>
                <input type="text" name="prenomResponsable" id="prenomResponsable" placeholder="prenomResponsable">
            </div>
            <div class="form-group">
                <label for="capacite">Capacité</label>
                <input type="number" name="capacite" id="capacite" placeholder="capacite">
            </div>

            <div class="form-buttons">
                <button type="submit" class="btn btn-primary">Ajouter</button>
                <a class="btn btn-secondary">Annuler</a>
            </div>
        </form>
    </section>
</main>
</body>
</html>
