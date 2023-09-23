package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Equipo 04
 */
public class Conexion {

    private String username = "root";
    private String password = "90020San";
    private String host = "localhost";
    private String port = "3306";
    private String database = "ecommercelibros";
    private String classname = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
    private Connection con;

    public Conexion() {
    }

    public Connection getConexion() {
        try {
            Class.forName(classname);
            return con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error en: " + e);
        }

        return null;
    }

}
