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
public class logoutAction extends ActionSupport {

    public logoutAction() {
    }

    public String execute() throws Exception {
        Map session = (Map) ActionContext.getContext().get("session");
        session.remove("usuario");
        return SUCCESS;
    }
}
