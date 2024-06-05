package Acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;
import modelo.Propiedades;
import servicios.DAOPropiedades;

public class buscarCiudadAction extends ActionSupport {
    
    private String ciudad = "";
    private List<Propiedades> propiedades;
    private List<Propiedades> propiedadesCiudad = new ArrayList<>();

    public buscarCiudadAction() {
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Propiedades> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(List<Propiedades> propiedades) {
        this.propiedades = propiedades;
    }

    public List<Propiedades> getPropiedadesCiudad() {
        return propiedadesCiudad;
    }

    public void setPropiedadesCiudad(List<Propiedades> propiedadesCiudad) {
        this.propiedadesCiudad = propiedadesCiudad;
    }
    
    public String execute() throws Exception {
        DAOPropiedades daoPropiedades = new DAOPropiedades();
        
        GenericType<List<Propiedades>> generic;
        generic = new GenericType<List<Propiedades>> () {};
        
        propiedades = daoPropiedades.findAll_XML(generic);
        
        for (int i = 0; i < propiedades.size(); i++) {
            if (propiedades.get(i).getIdDireccion().getCiudad().equals(ciudad)) {
                propiedadesCiudad.add(propiedades.get(i));
            }
        }
        
        return SUCCESS;
    }
}
