
package com.mycompany.proyectoparcial01_equipo04;

import Controlador.Conexion;
import DAO.ClienteDao;
import Dominio.Cliente;
import java.util.List;

/**
 *
 * @author Equipo 04
 */
public class Proyectoparcial01_Equipo04 {

    public static void main(String[] args) 
    {
        Conexion cn = new Conexion();
        
        ClienteDao cd = new ClienteDao();
        
        
        Cliente cliente = cd.obtenerCliente(50);
        
        
        
//        cd.modificarCliente(new Cliente(2, "Adolfo", "234", "antonio234@mail.com", "1122334455", "Carlos Quinto No. 15"));
        
//        cd.eliminarCliente(new Cliente(6, "Adolfo", "234", "antonio234@mail.com", "1122334455", "Carlos Quinto No. 15"));

//        List<Cliente> lista = cd.obtenerClientes();
//        
//        for (int i = 0; i < lista.size(); i++) {
//            System.out.println(lista.get(i));
//        }
//        
//        System.out.println(cd.obtenerCliente(3));
    }
}
