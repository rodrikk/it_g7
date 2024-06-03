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
public class cancelarAlquilerAction extends ActionSupport {
    
    private Alquileres alquiler;
    private List<Alquileres> alquileres;
    private String idAlquiler = "";
    private String idUsuario = "";
    private String idPropiedad = "";
    private Propiedades propiedad;

    public cancelarAlquilerAction() {
    }

    public Alquileres getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquileres alquiler) {
        this.alquiler = alquiler;
    }

    public List<Alquileres> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(List<Alquileres> alquileres) {
        this.alquileres = alquileres;
    }

    public String getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(String idAlquiler) {
        this.idAlquiler = idAlquiler;
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

    public Propiedades getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedades propiedad) {
        this.propiedad = propiedad;
    }
    
    public String execute() throws Exception {
        DAOAlquileres daoAlquileres = new DAOAlquileres();
        DAOPropiedades daoPropiedades = new DAOPropiedades();
        
        daoAlquileres.remove(idAlquiler);
        
        GenericType<List<Alquileres>> generic_alquileres;
        generic_alquileres = new GenericType<List<Alquileres>> () {};
        alquileres = daoAlquileres.findAll_XML(generic_alquileres);
        
        GenericType<Propiedades> generic_propiedad;
        generic_propiedad = new GenericType<Propiedades> () {};
        
        propiedad = daoPropiedades.find_XML(generic_propiedad, idPropiedad);
        
        Propiedades propiedadElimarInquilino = new Propiedades(propiedad.getId(), propiedad.getTitulo(), propiedad.getDescripcion(), propiedad.getSuperficie(), propiedad.getNumeroHabitaciones(), propiedad.getFoto(), propiedad.getPrecio(), propiedad.getIdPropietario(), null, propiedad.getIdDireccion(), propiedad.getIdOperacion());
        Object obj_propiedad = propiedadElimarInquilino;
        daoPropiedades.edit_XML(obj_propiedad, idPropiedad);
        
        for (int i = 0; i < alquileres.size(); i++) {
            if (alquileres.get(i).getIdAlquilado().getId() != Integer.parseInt(idUsuario)) {
                alquileres.remove(alquileres.get(i));
            }
        }
        
        return SUCCESS;
    }
}
