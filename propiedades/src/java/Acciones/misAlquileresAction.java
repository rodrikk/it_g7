package Acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.ws.rs.core.GenericType;
import modelo.Alquileres;
import modelo.Propiedades;
import servicios.DAOAlquileres;
import servicios.DAOPropiedades;
/**
 *
 * @author migue
 */
public class misAlquileresAction extends ActionSupport {
    
    private List<Alquileres> alquileres;
    private String idUsuario = "";
    private String idPropiedad = "";

    public misAlquileresAction() {
    }

    public List<Alquileres> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(List<Alquileres> alquileres) {
        this.alquileres = alquileres;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(String idPropiedad) {
        this.idPropiedad = idPropiedad;
    }
    
    public String execute() throws Exception {
        DAOAlquileres daoAlquileres = new DAOAlquileres();
        DAOPropiedades daoPropiedades = new DAOPropiedades();
        
        GenericType<List<Alquileres>> generic;
        generic = new GenericType<List<Alquileres>> () {};
        
        alquileres = daoAlquileres.findAll_XML(generic);
        
        for (int i = 0; i < alquileres.size(); i++) {
            if (alquileres.get(i).getIdAlquilado().getId() != Integer.parseInt(idUsuario)) {
                alquileres.remove(alquileres.get(i));
            }
        }
        
        return SUCCESS;
    }
}
