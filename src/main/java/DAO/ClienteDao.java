package DAO;

import Controlador.Conexion;
import Dominio.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Equipo04
 */
public class ClienteDao implements IClienteDao {

    Conexion con = new Conexion();

    @Override
    public void crearCliente(Cliente cliente) {
        PreparedStatement pst = null;
        try {
            String consulta = "INSERT INTO cliente (nombre, contraseña, correo, teléfono, dirección) VALUES (?, ?, ?, ?, ?)";
            pst = con.getConexion().prepareStatement(consulta);
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getContrasenia());
            pst.setString(3, cliente.getCorreo());
            pst.setString(4, cliente.getTelefono());
            pst.setString(5, cliente.getDireccion());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                if (con.getConexion() != null) {
                    con.getConexion().close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
    }

    @Override
    public void modificarCliente(Cliente cliente) {
        PreparedStatement pst = null;
        try {
            String consulta = "CALL ActualizarPerfilCliente (? , ? , ? , ? , ? , ?)";
            pst = con.getConexion().prepareStatement(consulta);
            pst.setString(1, cliente.getIdCliente());
            pst.setString(2, cliente.getNombre());
            pst.setString(3, cliente.getContrasenia());
            pst.setString(4, cliente.getCorreo());
            pst.setString(5, cliente.getTelefono());
            pst.setString(6, cliente.getDireccion());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                if (con.getConexion() != null) {
                    con.getConexion().close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        PreparedStatement pst = null;
        try {
            String consulta = "DELETE FROM cliente WHERE id_Cliente = ?";
            pst = con.getConexion().prepareStatement(consulta);
            pst.setString(1, cliente.getIdCliente());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                if (con.getConexion() != null) {
                    con.getConexion().close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
    }

    @Override
    public List<Cliente> obtenerClientes() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Cliente> lista = new ArrayList<>();
        try {
            String consulta = "SELECT * FROM cliente";
            pst = con.getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();

            while (rs.next()) {
                lista.add(
                        new Cliente(
                                rs.getString("id_Cliente"),
                                rs.getString("nombre"),
                                rs.getString("contraseña"),
                                rs.getString("correo"),
                                rs.getString("teléfono"),
                                rs.getString("dirección")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                if (con.getConexion() != null) {
                    con.getConexion().close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return lista;
    }

    @Override
    public Cliente obtenerCliente(int idCliente) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        Cliente cliente = null;
        try {
            String consulta = "SELECT * FROM cliente WHERE id_Cliente = ?";
            pst = con.getConexion().prepareStatement(consulta);
            pst.setInt(1, idCliente);
            rs = pst.executeQuery();

            if (rs.next()) 
            {
                cliente = new Cliente(
                        rs.getString("id_Cliente"),
                        rs.getString("nombre"),
                        rs.getString("contraseña"),
                        rs.getString("correo"),
                        rs.getString("teléfono"),
                        rs.getString("dirección")
                );
            }
            else
            {
                System.out.println("NO HAY CLIENTE CON ESE ID");
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try 
            {
                if (con.getConexion() != null) {
                    con.getConexion().close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return cliente;
    }
    

    public boolean verificacionEliminar(String pass, String idCliente)
    {
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        
        try
        {
            String consulta = "SELECT * FROM cliente WHERE id_Cliente = ?";
            pst = con.getConexion().prepareStatement(consulta);
            pst.setString(1, idCliente);
            rs = pst.executeQuery();  
            
            if(rs.next())
            {
                if(pass.equals(rs.getString("contraseña")))
                {
                    return true;
                }
            }
            else
            {
                return false;
            }
            
        }
        catch(SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try 
            {
                if (con.getConexion() != null) {
                    con.getConexion().close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return false;
    }
    
    
}
