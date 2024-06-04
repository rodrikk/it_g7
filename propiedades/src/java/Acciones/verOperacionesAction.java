/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.ws.rs.core.GenericType;
import modelo.Direcciones;
import modelo.Operaciones;
import modelo.Propiedades;
import servicios.DAODirecciones;
import servicios.DAOOperaciones;
import servicios.DAOPropiedades;

/**
 *
 * @author santi
 */
public class verOperacionesAction extends ActionSupport {

    private List<Operaciones> operaciones;

    public verOperacionesAction() {
    }

    public List<Operaciones> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(List<Operaciones> operaciones) {
        this.operaciones = operaciones;
    }

    public String execute() throws Exception {
        DAOOperaciones daoOperaciones = new DAOOperaciones();

        GenericType<List<Operaciones>> generic_operaciones;
        generic_operaciones = new GenericType<List<Operaciones>>() {
        };
        operaciones = daoOperaciones.findAll_XML(generic_operaciones);

        return SUCCESS;
    }
}
