package Acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;
import modelo.Propiedades;
import servicios.DAOPropiedades;

/**
 *
 * @author migue
 */
public class borrarPropiedadAction extends ActionSupport {

    private List<Propiedades> propiedades;
    private String idPropiedad = "";
    private String idUsuario = "";
    private String boton = "";
    private List<Propiedades> misPropiedades = new ArrayList<>();

    public borrarPropiedadAction() {
    }

    public List<Propiedades> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(List<Propiedades> propiedades) {
        this.propiedades = propiedades;
    }

    public String getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(String idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String getBoton() {
        return boton;
    }

    public void setBoton(String boton) {
        this.boton = boton;
    }

    public List<Propiedades> getMisPropiedades() {
        return misPropiedades;
    }

    public void setMisPropiedades(List<Propiedades> misPropiedades) {
        this.misPropiedades = misPropiedades;
    }

    public String execute() throws Exception {
        DAOPropiedades daoPropiedades = new DAOPropiedades();
        GenericType<List<Propiedades>> generic;
        generic = new GenericType<List<Propiedades>>() {};
        
        daoPropiedades.remove(idPropiedad);
        
        propiedades = daoPropiedades.findAll_XML(generic);
        
        for (int i = 0; i < propiedades.size(); i++) {
            if (propiedades.get(i).getIdPropietario().getId() == Integer.parseInt(idUsuario)) {
                misPropiedades.add(propiedades.get(i));
            }
        }
        
        return SUCCESS;
    }
}