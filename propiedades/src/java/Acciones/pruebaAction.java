/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.ws.rs.core.GenericType;
import modelo.Propiedades;
import modelo.Usuarios;
import servicios.DAOPropiedades;
import servicios.DAOUsuarios;

/**
 *
 * @author migue
 */
public class pruebaAction extends ActionSupport {

    private List<Usuarios> usuarios;

    public pruebaAction() {
    }

    public List<Usuarios> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }

    public String execute() throws Exception {
        DAOUsuarios dao = new DAOUsuarios();
        GenericType<List<Usuarios>> generic;
        generic = new GenericType<List<Usuarios>>() {};
        usuarios = dao.findAll_XML(generic);
        return SUCCESS;
    }
}
