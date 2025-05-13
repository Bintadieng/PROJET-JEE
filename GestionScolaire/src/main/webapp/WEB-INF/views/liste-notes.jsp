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
            <li><a href="">Filières</a></li>
            <li><a href="" class="active">Notes</a></li>
        </ul>
    </nav>
</header>

<main>
    <section class="student-list">
        <div class="list-header">
            <h2>Liste des notes</h2>
        </div>

        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>PRENOM</th>
                <th>NOM</th>
                <th>DEPARTEMENT</th>
                <th>MATIERE</th>
                <th>NOTES</th>
            </tr>
            </thead>

            <tbody>
            <tr>
                <td>1</td>
                <td>Aliou</td>
                <td>Diop</td>
                <td>DBE</td>
                <td>JAVA</td>
                <td>18</td>
            </tr>
            <tr>
                <td>2</td>
                <td>Fallou</td>
                <td>Diouf </td>
                <td>DFE</td>
                <td>INFOGRAPHIE</td>
                <td>15</td>
            </tr>
            <tr>
                <td>3</td>
                <td>Aissatou</td>
                <td>fall </td>
                <td>APD</td>
                <td>HTML/CSS</td>
                <td>17</td>
            </tr>
            <tr>
                <td>4</td>
                <td>Mbaye</td>
                <td>Gueye</td>
                <td>ABD</td>
                <td>SGBD</td>
                <td>14</td>
            </tr>
            <tr>
                <td>5</td>
                <td>Alamine</td>
                <td>Ndiaye</td>
                <td>ASSC</td>
                <td>RESEAUX</td>
                <td>16</td>
            </tr>
            <tr>
                <td>6</td>
                <td>Fama</td>
                <td>Lo </td>
                <td>RSIOT</td>
                <td>IOT</td>
                <td>14,50</td>
            </tr>

            </tbody>
        </table>
    </section>
</main>
</body>
</html>