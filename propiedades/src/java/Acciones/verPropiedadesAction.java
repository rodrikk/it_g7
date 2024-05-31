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
public class verPropiedadesAction extends ActionSupport {
    
    private List<Propiedades> propiedades;

    public verPropiedadesAction() {
    }

    public List<Propiedades> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(List<Propiedades> propiedades) {
        this.propiedades = propiedades;
    }
    
    public String execute() throws Exception {
        DAOPropiedades dao = new DAOPropiedades();
        GenericType<List<Propiedades>> generic;
        generic = new GenericType<List<Propiedades>> () {};
        propiedades = dao.findAll_XML(generic);
        return SUCCESS;
    }
}
