/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.ws.rs.core.GenericType;
import modelo.Usuarios;
import modelo.Valoraciones;
import servicios.DAOUsuarios;
import servicios.DAOValoraciones;
/**
 *
 * @author migue
 */
public class verUsuarioAction extends ActionSupport {
    
    private Usuarios usuario;

    public verUsuarioAction() {
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    
    public String execute() throws Exception {
        DAOUsuarios dao = new DAOUsuarios();
        GenericType<Usuarios> generic;
        generic = new GenericType<Usuarios> () {};
        usuario = dao.find_XML(generic, "1");
        return SUCCESS;
    }
}
