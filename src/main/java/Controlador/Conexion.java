package Controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author Equipo 04 
 */
public class Conexion 
{
    
    private String username="root";
    private String password="";
    private String host="localhost";
    private String port="3306";
    private String database="ecommercelibros";
    private String classname="com.mysql.cj.jdbc.Driver";
    private String url="jdbc:mysql://"+host+":"+port+"/"+database;
    private Connection con;
    
    public Conexion()
    {
        try
        {
            Class.forName(classname);
            con = DriverManager.getConnection(url,username,password);
            System.out.println("Conexión establecida!");
        }
        catch(ClassNotFoundException | SQLException e)
                {
                    System.err.println("Error en: "+e);
                    
                }
    }
    
    public Connection getConexion()
    {
        return con;
    }
    
    

}
