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
import servicios.DAOPropiedades;
/**
 *
 * @author migue
 */
public class verPropiedadAction extends ActionSupport {
    
    private Propiedades propiedad;
    private String idPropiedad = "";

    public verPropiedadAction() {
    }

    public Propiedades getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedades propiedad) {
        this.propiedad = propiedad;
    }

    public String getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(String idPropiedad) {
        this.idPropiedad = idPropiedad;
    }
    
    public String execute() throws Exception {
        DAOPropiedades dao = new DAOPropiedades();
        GenericType<Propiedades> generic;
        generic = new GenericType<Propiedades> () {};
        propiedad = dao.find_XML(generic, idPropiedad);
        return SUCCESS;
    }
}
