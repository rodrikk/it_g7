/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import modelo.Usuarios;
import modelo.Valoracionestotales;
import servicios.DAOUsuarios;
import servicios.DAOValoracionesTotales;

public class registrarUsuarioAction extends ActionSupport {

    private String nombre = "";
    private String apellidos = "";
    private String email = "";
    private String password = "";
    private String telefono = "";
    private String fechaNacimiento = "";
    private Usuarios usuarioRegistrado;
    private List<Valoracionestotales> valoracionesTotales;

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

    public Usuarios getUsuarioRegistrado() {
        return usuarioRegistrado;
    }

    public void setUsuarioRegistrado(Usuarios usuarioRegistrado) {
        this.usuarioRegistrado = usuarioRegistrado;
    }

    public List<Valoracionestotales> getValoracionesTotales() {
        return valoracionesTotales;
    }

    public void setValoracionesTotales(List<Valoracionestotales> valoracionesTotales) {
        this.valoracionesTotales = valoracionesTotales;
    }
    

    @Override
    public String execute() throws Exception {
        DAOUsuarios daoUsuarios = new DAOUsuarios();
        DAOValoracionesTotales daoValoracionesTotales = new DAOValoracionesTotales();
        Usuarios usuarioRegistrado = new Usuarios();

        usuarioRegistrado = new Usuarios();
        usuarioRegistrado.setNombre(nombre);
        usuarioRegistrado.setApellidos(apellidos);
        usuarioRegistrado.setEmail(email);
        usuarioRegistrado.setPassword(password);
        usuarioRegistrado.setTelefono(telefono);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = formatter.parse(fechaNacimiento);
        usuarioRegistrado.setFechaNacimiento(fecha);

        Object obj_usuario = usuarioRegistrado;
        daoUsuarios.create_XML(obj_usuario);

        Map session = (Map) ActionContext.getContext().get("session");
        session.put("usuario", usuarioRegistrado.getNombre());
        session.put("idUsuario", usuarioRegistrado.getId());

        GenericType<List<Valoracionestotales>> generic_valoracionesTotales;
        generic_valoracionesTotales = new GenericType<List<Valoracionestotales>>() {
        };

        valoracionesTotales = daoValoracionesTotales.findAll_XML(generic_valoracionesTotales);

        return SUCCESS;
    }
}
