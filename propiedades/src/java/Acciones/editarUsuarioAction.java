/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import static com.opensymphony.xwork2.Action.SUCCESS;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ws.rs.core.GenericType;
import modelo.Usuarios;
import servicios.DAOUsuarios;

/**
 *
 * @author santi
 */
public class editarUsuarioAction {
    
    
    private String nombre = "";
    private String apellidos = "";
    private String email = "";
    private String password = "";
    private String telefono = "";
    private String fechaNacimiento = "";
    private String idUsuario = "";
    private Usuarios usuario; 

    public editarUsuarioAction() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
            
    public String execute() throws Exception {
        DAOUsuarios daoUsuarios = new DAOUsuarios();

        // Obtener el usuario actual
        GenericType<Usuarios> generic_usuario = new GenericType<Usuarios>() {
        };
        usuario = daoUsuarios.find_XML(generic_usuario, idUsuario);

        // Modificar los atributos del usuario con los valores recibidos del formulario
        usuario.setNombre(nombre);
        usuario.setApellidos(apellidos);
        usuario.setEmail(email);
        usuario.setPassword(password);
        usuario.setTelefono(telefono);
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        Date fecha = formatter.parse(fechaNacimiento);
        usuario.setFechaNacimiento(fecha);

        // Actualizar el usuario en la base de datos
        Object obj_usuario = usuario;
        daoUsuarios.edit_XML(obj_usuario, idUsuario);
        
        DAOUsuarios dao = new DAOUsuarios();
        GenericType<Usuarios> generic;
        generic = new GenericType<Usuarios>() {};
        usuario = dao.find_XML(generic, (idUsuario));

        return SUCCESS;
    }    
    
}
