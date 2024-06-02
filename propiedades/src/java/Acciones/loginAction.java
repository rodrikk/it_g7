/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import modelo.Propiedades;
import modelo.Usuarios;
import modelo.Valoracionestotales;
import servicios.DAOUsuarios;
import servicios.DAOValoracionesTotales;

/**
 *
 * @author migue
 */
public class loginAction extends ActionSupport {

    private String email;
    private String password;
    private List<Valoracionestotales> valoracionesTotales;
    private List<Usuarios> usuarios;
    private Usuarios usuarioRegistrado = null;
    private String error = "";

    public loginAction() {
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

    public List<Valoracionestotales> getValoracionesTotales() {
        return valoracionesTotales;
    }

    public void setValoracionesTotales(List<Valoracionestotales> valoracionesTotales) {
        this.valoracionesTotales = valoracionesTotales;
    }

    public List<Usuarios> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuarios getUsuarioRegistrado() {
        return usuarioRegistrado;
    }

    public void setUsuarioRegistrado(Usuarios usuarioRegistrado) {
        this.usuarioRegistrado = usuarioRegistrado;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String execute() throws Exception {
        DAOUsuarios daoUsuarios = new DAOUsuarios();
        DAOValoracionesTotales daoValoracionesTotales = new DAOValoracionesTotales();

        GenericType<List<Usuarios>> generic_usuarios;
        generic_usuarios = new GenericType<List<Usuarios>>() {};

        usuarios = daoUsuarios.findAll_XML(generic_usuarios);

        for (int i = 0; i < usuarios.size(); i++) {
            Usuarios usuario = usuarios.get(i);

            if (usuario.getEmail().equals(email) && usuario.getPassword().equals(password)) {
                usuarioRegistrado = usuario;
            }
        }

        if (usuarioRegistrado == null) {
            error = "Usuario y/o password incorrectos";
            return ERROR;
        } else {
            Map session = (Map) ActionContext.getContext().get("session");
            session.put("usuario", usuarioRegistrado.getNombre());
            session.put("idUsuario", usuarioRegistrado.getId());
            
            GenericType<List<Valoracionestotales>> generic_valoracionesTotales;
            generic_valoracionesTotales = new GenericType<List<Valoracionestotales>>() {};
            
            valoracionesTotales = daoValoracionesTotales.findAll_XML(generic_valoracionesTotales);
            
            return SUCCESS;
        }
    }
}
