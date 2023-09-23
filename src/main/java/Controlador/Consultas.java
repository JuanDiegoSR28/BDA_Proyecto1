
package Controlador;

import Dominio.Cliente;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Consultas extends Conexion {
    private Connection conexion = null; // Mantén la conexión abierta durante toda la sesión

    public Consultas() {
        conexion = getConexion();
    }

    public Cliente autentication(String id, String contraseña) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        Cliente c = new Cliente ();
        
        
        try {
            String consulta = "Select * from Cliente where id_Cliente=? and contraseña=? ";
            System.out.println("Consulta es " + consulta);
            pst = conexion.prepareStatement(consulta);
            pst.setString(1, id);
            pst.setString(2, contraseña);
            rs = pst.executeQuery();

            if (rs.next()) 
            {
                
                System.out.println("Usuario Valido");
                // Mostrar mensaje de usuario válido
                JOptionPane.showMessageDialog(null, "Usuario válido", "Autenticación exitosa", JOptionPane.INFORMATION_MESSAGE);
                c.setIdCliente(rs.getString("id_Cliente"));
                c.setNombre(rs.getString("nombre"));
                c.setContrasenia(rs.getString("contraseña"));
                c.setCorreo(rs.getString("correo"));
                c.setTelefono(rs.getString("teléfono"));
                c.setDireccion(rs.getString("dirección"));
                
                return c;
            }
            
            
        } catch (Exception e) {
            System.out.println("Error en " + e);
        } finally {
            try {
                if (pst != null)
                    pst.close();
                if (rs != null)
                    rs.close();
            } catch (Exception e) {
                System.out.println("Error en " + e);
            }
        }
        
        // Mostrar mensaje de usuario no válido
        JOptionPane.showMessageDialog(null, "Usuario no válido", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
        System.out.println("Usuario no válido");
        return c;
    }
    
    public boolean registrar(String nombre, String contraseña , String correo, int teléfono, String dirección) {
    PreparedStatement pst = null;
    try {
        String consulta = "INSERT INTO cliente (nombre, contraseña, correo, teléfono, dirección) VALUES (?, ?, ?, ?, ?)";
        pst = getConexion().prepareStatement(consulta);
        pst.setString(1, nombre);
        pst.setString(2, contraseña);
        pst.setString(3, correo);
        pst.setInt(4, teléfono);
        pst.setString (5,dirección);

        if (pst.executeUpdate() == 1) {
          
           JOptionPane.showMessageDialog(null, "Registro Exitoso", "Todo Correcto", 2);
           return true;
        }
    } catch (Exception e) {
        System.out.println("Error en " + e);
        JOptionPane.showMessageDialog(null, "Usuario no válido", "Error de registro", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (getConexion() != null) getConexion().close();
            if (pst != null) pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuario no válido", "Error de registro", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error en " + e);
        }
    }
    return false;
}

    
}