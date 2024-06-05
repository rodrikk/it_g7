package Acciones;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;
import modelo.Propiedades;
import modelo.Usuarios;
import servicios.DAOVisitas;
import modelo.Visitas;
import servicios.DAOPropiedades;
import servicios.DAOUsuarios;

public class VisitasAction extends ActionSupport {
    private List<Visitas> visitas;
    private DAOVisitas daoVisitas;
    private int id;
    private Visitas visita;
    private int duracion;
    private int idPropiedad;
    private int idVisitante;

    public VisitasAction() {
        daoVisitas = new DAOVisitas();
        visitas = new ArrayList<>();
    }

    @Override
    public String execute() {
        try {
            GenericType<List<Visitas>> genericType = new GenericType<List<Visitas>>() {};
            visitas = daoVisitas.findAll_XML(genericType);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public List<Visitas> getVisitas() {
        return visitas;
    }

    public void setVisitas(List<Visitas> visitas) {
        this.visitas = visitas;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(int idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public int getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(int idVisitante) {
        this.idVisitante = idVisitante;
    }

    public Visitas getVisita() {
        return visita;
    }

    public void setVisita(Visitas visita) {
        this.visita = visita;
    }
    
    public String edit() {
        GenericType<Visitas> generic_visita = new GenericType<Visitas>() {};
        visita = daoVisitas.find_XML(generic_visita, String.valueOf(id));
        
        visita.setDuracion(duracion);
        
        DAOPropiedades daoPropiedades = new DAOPropiedades();
        GenericType<Propiedades> generic_propiedad = new GenericType<Propiedades>() {};
        Propiedades propiedad = daoPropiedades.find_XML(generic_propiedad, String.valueOf(idPropiedad));
        visita.setIdPropiedad(propiedad);
        
        DAOUsuarios daoUsuarios = new DAOUsuarios();
        GenericType<Usuarios> generic_usuario = new GenericType<Usuarios>() {};
        Usuarios visitante = daoUsuarios.find_XML(generic_usuario, String.valueOf(idVisitante));
        visita.setIdVisitante(visitante);
        
        Object visita_editada = visita;
        daoVisitas.edit_XML(visita_editada, String.valueOf(id));
        
        return SUCCESS;
    }
    
    public String viewEdit() {
        GenericType<Visitas> generic_visita = new GenericType<Visitas>() {};
        visita = daoVisitas.find_XML(generic_visita, String.valueOf(id));
        return SUCCESS;
    }

    public String delete() {
        try {
            daoVisitas.remove(String.valueOf(id));
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    // Method to display the form to create a new visit
    public String createView() {
        return SUCCESS;
    }

    // Method to create a new visit
    public String create() {
        try {
            Visitas newVisita = new Visitas();
            newVisita.setDuracion(duracion);

            DAOPropiedades daoPropiedades = new DAOPropiedades();
            GenericType<Propiedades> generic_propiedad = new GenericType<Propiedades>() {};
            Propiedades propiedad = daoPropiedades.find_XML(generic_propiedad, String.valueOf(idPropiedad));
            newVisita.setIdPropiedad(propiedad);

            DAOUsuarios daoUsuarios = new DAOUsuarios();
            GenericType<Usuarios> generic_usuario = new GenericType<Usuarios>() {};
            Usuarios visitante = daoUsuarios.find_XML(generic_usuario, String.valueOf(idVisitante));
            newVisita.setIdVisitante(visitante);

            daoVisitas.create_XML(newVisita);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }
}
