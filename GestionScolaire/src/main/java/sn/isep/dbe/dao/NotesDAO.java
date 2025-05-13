package sn.isep.dbe.dao;

import sn.isep.dbe.model.Notes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotesDAO {
    private Connection connection;

    // Configuration de la base de données
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/votre_base";
    private static final String JDBC_USER = "votre_utilisateur";
    private static final String JDBC_PASSWORD = "votre_mot_de_passe";

    public NotesDAO() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erreur d'initialisation de la connexion DB", e);
        }
    }

    public Notes ajouterNote(Notes note) {
        String sql = "INSERT INTO notes (prenom, nom, departement, matiere, notes) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, note.getPrenom());
            statement.setString(2, note.getNom());
            statement.setString(3, note.getDepartement());
            statement.setString(4, note.getMatiere());
            statement.setInt(5, note.getNotes());

            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        note.setId(generatedKeys.getInt(1));
                    }
                }
                return note;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } finally {
            super.finalize();
        }
    }

    public List<Notes> listerToutesNotes() {
        NotesDAO notesDAO = null;
        return notesDAO.listerToutesNotes();
    }

    public boolean mettreAJourNote(Notes note) {
        Object notesDAO = null;
        return Boolean.parseBoolean(notesDAO.toString());
    }
}