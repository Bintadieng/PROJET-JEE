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
            <li><a href="" class="active">Cours</a></li>
            <li><a href="" >Filières</a></li>
            <li><a href="">Notes</a></li>
        </ul>
    </nav>
</header>

<main>
    <section class="student-list">
        <div class="list-header">
            <h2>Liste des cours</h2>
        </div>

        <table>
            <thead>
            <tr>
                <th>Departement</th>
                <th>Cours</th>
                <th>Salle</th>
                <th>Professeur</th>
                <th>Heures</th>
            </tr>
            </thead>

            <tbody>
            <tr>
                <td>DBE</td>
                <td>DESIGN PATTERN</td>
                <td> 309</td>
                <td>MR. Mbaye</td>
                <td>8h-16h30</td>
            </tr>
            <tr>
                <td>DFE</td>
                <td>INFOGRAPHIE</td>
                <td>307</td>
                <td>MR. Ndiaye</td>
                <td>8h-16h30</td>
            </tr>
            <tr>
                <td>APD</td>
                <td>MARKETING DIGITALE</td>
                <td>310</td>
                <td>MR. Niang</td>
                <td>8h-16h30</td>
            </tr>
            <tr>
                <td>ABD</td>
                <td>BASE DE DONNEES</td>
                <td>302 </td>
                <td>MR. Gueye</td>
                <td>8h-16h30</td>
            </tr>
            <tr>
                <td>ASSC</td>
                <td>LUNIX</td>
                <td>307</td>
                <td>MR. Samb</td>
                <td>8h-16h30</td>
            </tr>
            <tr>
                <td>RSIOT</td>
                <td>IOT</td>
                <td>305 </td>
                <td>MR. Gueye</td>
                <td>8h-16h30</td>
            </tr>

            </tbody>
        </table>
    </section>
</main>
</body>
</html>