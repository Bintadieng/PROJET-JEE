package sn.isep.dbe.dao;

import sn.isep.dbe.model.Etudiants;
import sn.isep.dbe.util.ConnexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDAO {
    public List<Etudiants> findAll() {
        List<Etudiants> etudiants = new ArrayList<>();

        try (Connection connection = ConnexionBD.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from etudiant");

            while (rs.next()) {
                Etudiants etudiant = new Etudiants(1, "Dieng", "Bineta", "TIC");
                etudiant.setId(rs.getInt("id"));
                etudiant.setNom(rs.getString("nom"));
                etudiant.setPrenom(rs.getString("prenom"));
                etudiant.setDepartement(rs.getString("departement"));


                etudiants.add(etudiant);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return etudiants;
    }

    public Etudiants findById(int id) {
        return null;
    }

    public Etudiants save(Etudiants etudiants) {
        String sql = "insert into etudiant ( nom,prenom, departement) values (?, ?, ?)";
        try (Connection connection = ConnexionBD.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, etudiants.getNom());
            statement.setString(2, etudiants.getPrenom());
            statement.setString(3,etudiants.getDepartement());


            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return etudiants;
    }

    public Etudiants update(Etudiants etudiants) {
        String sql = "update etudiant set nom = ?, prenom = ?, Departement = ? where id = ?";
        try (Connection conn = ConnexionBD.getConnection()){
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(2, etudiants.getNom());
            statement.setString(3, etudiants.getPrenom());
            statement.setString(3, etudiants.getDepartement());
            statement.setInt(4, etudiants.getId());


            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return etudiants;
    }



    public void delete(Etudiants etudiants) {

    }
}
