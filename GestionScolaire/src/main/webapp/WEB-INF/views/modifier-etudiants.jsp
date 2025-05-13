<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 08/05/2025
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
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
            <li><a href="" class="active">Filières</a></li>
            <li><a href="">Notes</a></li>
        </ul>
    </nav>
</header>

<main>
    <section class="form-container">
        <h2>Modifier une nouvelle filière</h2>

        <form action="/etudiants/modifier" method="post">
            <!-- champ caché pour sauvegader l'id de la filiere -->
            <input type="hidden" name="id" value="${item.id}" >

            <div class="form-group">
                <label for="nom">Nom</label>
                <input value="${item.nom}" type="text" name="nom" id="nom" placeholder="Nom" required>
            </div>

            <div class="form-group">
                <label for="prenom">Prenom</label>
                <input value="${item.prenom}" type="text" name="prenom" id="prenom" placeholder="Prenom" required>
            </div>

            <div class="form-group">
                <label for="nom">Département</label>
                <select value="${item.departement}" id="departement" name="departement">
                    <option value="TIC">TIC</option>
                    <option value="AUTO">Automobile</option>
                </select>
            </div>



            <div class="form-buttons">
                <button type="submit" class="btn btn-primary">Modifier</button>
                <a href="/filieres/lister" class="btn btn-secondary">Annuler</a>
            </div>
        </form>
    </section>
</main>

</body>
</html>
