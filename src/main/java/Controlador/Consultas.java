
package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Equipo 04
 */
public class Consultas extends Conexion
{
    public boolean autenticacion(String id, String pass)
    {
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try
        {
            String consulta = "select * from cliente where id_Cliente=? and contraseña=?";
            
            pst=getConexion().prepareStatement(consulta);
            pst.setString(1, id);
            pst.setString(2, pass);
            System.out.println("Consulta es: "+pst.toString());
            rs=pst.executeQuery();
            
            if(rs.next())
            {
                System.out.println("CONSULTA EXITOSA");
                return true;
                
            }
            
        }
        catch(Exception e)
                {
                    System.out.println("ID o contraseña inválidos");
                }
        finally
        {
            try
            {
                if(getConexion()!=null)
                    getConexion().close();
                if(pst!=null)pst.close();
                if(rs!=null)rs.close();
            }
            catch (Exception e)
                    {
                        System.out.println("ID o contraseña inválidos");
                    }
        }
       return false; 
    }    
}
