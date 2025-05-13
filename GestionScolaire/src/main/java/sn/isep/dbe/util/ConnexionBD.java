package sn.isep.dbe.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBD {
    private  static  final  String  url="jdbc:mysql://localhost:3306/GestionScolaire";
    private  static  final  String  user="root";
    private  static  final  String  password="Mbayangsarr1";
    private  static  final  String  driver="com.mysql.cj.jdbc.Driver";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
