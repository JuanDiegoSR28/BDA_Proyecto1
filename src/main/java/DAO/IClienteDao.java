package DAO;

import Dominio.Cliente;
import java.util.List;

/**
 *
 * @author Equipo04
 */
public interface IClienteDao {
    
    void crearCliente(Cliente cliente);
    
    void modificarCliente(Cliente cliente);
    
    void eliminarCliente(Cliente cliente);
    
    List<Cliente> obtenerClientes();
    
    Cliente obtenerCliente(int idCliente);
    
}
