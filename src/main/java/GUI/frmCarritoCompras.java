
package GUI;

import Controlador.Consultas;
import Dominio.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Equipo 04
 */
public class frmCarritoCompras extends javax.swing.JFrame {

    Cliente c;
    Consultas sql;
    Consultas con = new Consultas();

    public frmCarritoCompras(Cliente c) 
    {
        initComponents();
        sql = new Consultas();
        DefaultTableModel catalogoCarrito = sql.obtenerCarrito();
        this.tablaCarrito.setModel(catalogoCarrito);
        this.c = c;
    }
     private void buscarLibroPorISBN(String isbn) {
    try {
        // Preparamos la consulta SQL para buscar el libro por su ISBN
        String consultaSQL = "SELECT * FROM Libro WHERE isbn = ?";
        PreparedStatement pstmt = con.getConexion().prepareStatement(consultaSQL); // Utiliza la conexión 'con' de la clase
        int opcionElegida = -1;
        pstmt.setString(1, isbn);
        
        // Ejecutamos la consulta
        ResultSet resultado = pstmt.executeQuery();
        
        // Verificamos si se encontraron resultados
        if (resultado.next()) {
            // Aquí puedes mostrar la información del libro encontrado
            String titulo = resultado.getString("titulo");
            String autor = resultado.getString("autor");
            int precio = resultado.getInt("precio");
            
            // Puedes mostrar esta información en un cuadro de diálogo o donde prefieras
            String [] opciones = {"Es el libro que busco","No es el libro que busco"};
             opcionElegida = JOptionPane.showOptionDialog(null, "Libro encontrado:\nTítulo: " + titulo + "\nAutor: " + autor + "\nPrecio: $" + precio, "Libro encontrado", 0, JOptionPane.QUESTION_MESSAGE, null, opciones, "Si");
//            JOptionPane.showMessageDialog(this, "Libro encontrado:\nTítulo: " + titulo + "\nAutor: " + autor + "\nPrecio: $" + precio, "Libro Encontrado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró ningún libro con el ISBN proporcionado.", "Libro no encontrado", JOptionPane.WARNING_MESSAGE);
        }
        
        if(opcionElegida == 0)
        {
            
            Date fecha = new Date();
            String cantidad = JOptionPane.showInputDialog(this, "Ingrese la cantidad de copias:", "Agregar libro al carrito", JOptionPane.QUESTION_MESSAGE);
            sql.agregarOrden(Integer.valueOf(cantidad), (java.sql.Date) fecha, 1, 1);
            
        }
        if(opcionElegida == 1)
        {
           
        }
        {
            
        }
        
        // Cerramos recursos
        resultado.close();
        pstmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al buscar el libro en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCarrito = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnModificar = new javax.swing.JMenuItem();
        btnEliminar = new javax.swing.JMenuItem();
        btnCerrar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        btnMenu = new javax.swing.JMenuItem();
        btnSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBuscar.setText("Buscar libro");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 22)); // NOI18N
        jLabel2.setText("Carrito de compras");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, -1));

        tablaCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaCarrito);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 590, 270));

        jLabel1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Imagenes\\fondoRegistro.png"));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 604, 630));

        jMenu1.setText("Usuario");

        btnModificar.setText("Modificar datos");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jMenu1.add(btnModificar);

        btnEliminar.setText("Eliminar cuenta");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jMenu1.add(btnEliminar);

        btnCerrar.setText("Cerrar sesión");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jMenu1.add(btnCerrar);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Sistema");

        btnMenu.setText("Volver al menú");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        jMenu2.add(btnMenu);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jMenu2.add(btnSalir);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
    this.dispose();
    frmModificar mod = new frmModificar(c);
    mod.setVisible(true);
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
    this.dispose();
    frmEliminar elim = new frmEliminar(c);
    elim.setVisible(true);
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        
    this.dispose();
    frmLogin login = new frmLogin();
    login.setVisible(true);
    
        
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
    this.dispose();
    frmMenu menu = new frmMenu(c);
    menu.setVisible(true);
    
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
    
        this.dispose();
    
    
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
             // Solicitar al usuario que ingrese el ISBN del libro
    String isbn = JOptionPane.showInputDialog(this, "Ingrese el ISBN del libro:", "Agregar libro al carrito", JOptionPane.QUESTION_MESSAGE);
    
    if (isbn != null && !isbn.isEmpty()) {
        // Llamamos a un método que realice la búsqueda en la base de datos
        buscarLibroPorISBN(isbn);
    } else 
    {
        JOptionPane.showMessageDialog(this, "Debes proporcionar un ISBN válido.", "Error", JOptionPane.ERROR_MESSAGE);
    }
 
     
        
        
    }//GEN-LAST:event_btnBuscarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JMenuItem btnCerrar;
    private javax.swing.JMenuItem btnEliminar;
    private javax.swing.JMenuItem btnMenu;
    private javax.swing.JMenuItem btnModificar;
    private javax.swing.JMenuItem btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCarrito;
    // End of variables declaration//GEN-END:variables

}
