package sn.isep.dbe.dao;

import sn.isep.dbe.model.Cours;
import sn.isep.dbe.util.ConnexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoursDAO {
    private final ConnexionBD DatabaseConnection = null;
    private Connection connection;


    // Créer un nouveau cours
    public Cours save(Cours cours) {
        String query = "INSERT INTO cours(departement, cours, salle, professeur, heures) VALUES(?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, cours.getDepartement());
            statement.setString(2, cours.getCours());
            statement.setString(3, cours.getSalle());
            statement.setString(4, cours.getProfesseur());
            statement.setString(5, cours.getHeures());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Échec de la création du cours, aucune ligne affectée.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    cours.setId(generatedKeys.getInt(1));
                    return cours;
                } else {
                    throw new SQLException("Échec de la création du cours, aucun ID obtenu.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Récupérer tous les cours
    public List<Cours> findAll() {
        List<Cours> coursList = new ArrayList<>();
        String query = "SELECT * FROM cours";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Cours cours = mapResultSetToCours(resultSet);
                coursList.add(cours);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coursList;
    }

    // Trouver un cours par son ID
    public Cours findById(int id) {
        String query = "SELECT * FROM cours WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToCours(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Mettre à jour un cours
    public Cours update(Cours cours) {
        String query = "UPDATE cours SET departement = ?, cours = ?, salle = ?, professeur = ?, heures = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cours.getDepartement());
            statement.setString(2, cours.getCours());
            statement.setString(3, cours.getSalle());
            statement.setString(4, cours.getProfesseur());
            statement.setString(5, cours.getHeures());
            statement.setInt(6, cours.getId());

            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                return cours;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Supprimer un cours
    public boolean delete(int id) {
        String query = "DELETE FROM cours WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Trouver les cours par département
    public List<Cours> findByDepartement(String departement) {
        List<Cours> coursList = new ArrayList<>();
        String query = "SELECT * FROM cours WHERE departement = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, departement);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Cours cours = mapResultSetToCours(resultSet);
                    coursList.add(cours);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coursList;
    }

    // Méthode utilitaire pour mapper un ResultSet à un objet Cours
    private Cours mapResultSetToCours(ResultSet resultSet) throws SQLException {
        Cours cours = new Cours();
        cours.setId(resultSet.getInt("id"));
        cours.setDepartement(resultSet.getString("departement"));
        cours.setCours(resultSet.getString("cours"));
        cours.setSalle(resultSet.getString("salle"));
        cours.setProfesseur(resultSet.getString("professeur"));
        cours.setHeures(resultSet.getString("heures"));
        return cours;
    }
}