package Dominio;

/**
 *
 * @author Equipo04
 */
public class Cliente {

    private String idCliente;
    private String nombre;
    private String contrasenia;
    private String correo;
    private String telefono;
    private String direccion;
    
    public Cliente() {
    }

    public Cliente(String nombre, String contrasenia, String correo, String telefono, String direccion) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Cliente(String idCliente, String nombre, String contrasenia, String correo, String telefono, String direccion) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", contrasenia=" + contrasenia + ", correo=" + correo + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }

}
