<%@ page import="sn.isep.dbe.model.Etudiants" %>
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
            <li><a href="" class="active">Etudiants</a></li>
            <li><a href="">Cours</a></li>
            <li><a href="" >Filières</a></li>
            <li><a href="">Notes</a></li>
        </ul>
    </nav>
</header>

<main>
    <section class="student-list">
        <div class="list-header">
            <h2>Liste des etudiants</h2>
            <a href="/etudiants/ajouter" class="btn">+ Nouveau étudiant</a>
        </div>

        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Prenom</th>
                <th>Département</th>
                <th>Details</th>

            </tr>
            </thead>

            <tbody>
            <c:forEach items="${etudiants}" var="etudiant">
                <tr>
                    <td>${etudiant.id}</td>
                    <td>${etudiant.nom}</td>
                    <td>${etudiant.prenom}</td>
                    <td>${etudiant.departement}</td>
                    <td class="actions">
                        <a class="btn-details">Details</a>
                        <a href="${pageContext.request.contextPath}//etudiants/modifier?id=${etudiant.id}" class="btn-edit">Modifier</a>
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