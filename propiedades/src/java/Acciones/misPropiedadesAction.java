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
public class misPropiedadesAction extends ActionSupport {
    
    private List<Propiedades> propiedades;
    private String idUsuario = "";

    public misPropiedadesAction() {
    }

    public List<Propiedades> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(List<Propiedades> propiedades) {
        this.propiedades = propiedades;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String execute() throws Exception {
        DAOPropiedades daoPropiedades = new DAOPropiedades();
        GenericType<List<Propiedades>> generic;
        generic = new GenericType<List<Propiedades>> () {};
        propiedades = daoPropiedades.findAll_XML(generic);
        
        for (int i = 0; i < propiedades.size(); i++) {
            if (propiedades.get(i).getIdPropietario().getId() != Integer.parseInt(idUsuario)) {
                propiedades.remove(propiedades.get(i));
            }
        }
        
        return SUCCESS;
    }
}
