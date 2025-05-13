package sn.isep.dbe.dao;

import sn.isep.dbe.model.Filiere;
import sn.isep.dbe.util.ConnexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FiliereDAO {

    public List<Filiere> findAll() {
        List<Filiere> filieres = new ArrayList<>();

        try (Connection connection = ConnexionBD.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from filiere");

            while (rs.next()) {
                Filiere filiere = new Filiere();
                filiere.setId(rs.getInt("id"));
                filiere.setCode(rs.getString("code"));
                filiere.setNom(rs.getString("nom"));
                filiere.setDepartement(rs.getString("departement"));
                filiere.setNomResponsable(rs.getString("nomResponsable"));
                filiere.setPrenomResponsable(rs.getString("prenomResponsable"));
                filiere.setCapacite(rs.getInt("capacite"));

                filieres.add(filiere);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return filieres;
    }

    public Filiere findById(int id) {
        return null;
    }

    public Filiere save(Filiere filiere) {
        String sql = "insert into filiere (code, nom, Departement, nomResponsable, prenomResponsable, capacite) values (?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnexionBD.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, filiere.getCode());
            statement.setString(2, filiere.getNom());
            statement.setString(3, filiere.getDepartement());
            statement.setString(4, filiere.getNomResponsable());
            statement.setString(5, filiere.getPrenomResponsable());
            statement.setInt(6, filiere.getCapacite());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return filiere;
    }

    public Filiere update(Filiere filiere) {
        String sql = "update filiere set code = ?, nom = ?, departement = ?, nomResponsable = ?, prenomResponsable = ?, capacite = ? where id = ?";
        try (Connection conn = ConnexionBD.getConnection()){
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, filiere.getCode());
            statement.setString(2, filiere.getNom());
            statement.setString(3, filiere.getDepartement());
            statement.setString(4, filiere.getNomResponsable());
            statement.setString(5, filiere.getPrenomResponsable());
            statement.setInt(6, filiere.getCapacite());
            statement.setInt(7, filiere.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return filiere;
    }

    public void delete(Filiere filiere) {

    }
}


