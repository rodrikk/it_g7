package Acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.ws.rs.core.GenericType;
import modelo.Operaciones;
import modelo.Propiedades;
import modelo.Valoraciones;
import servicios.DAOOperaciones;
import servicios.DAOPropiedades;
import servicios.DAOValoraciones;

public class verPropiedadEditarAction extends ActionSupport {
    
    private Propiedades propiedad;
    private String idPropiedad = "";
    private List<Operaciones> operaciones;
    private List<Valoraciones> valoraciones;
    private String idValoracion = "";

    public verPropiedadEditarAction() {
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
    
    public List<Operaciones> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(List<Operaciones> operaciones) {
        this.operaciones = operaciones;
    }

    public List<Valoraciones> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(List<Valoraciones> valoraciones) {
        this.valoraciones = valoraciones;
    }

    public String getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(String idValoracion) {
        this.idValoracion = idValoracion;
    }
    
    public String execute() throws Exception {
        DAOPropiedades daoPropiedades = new DAOPropiedades();
        DAOOperaciones daoOperaciones = new DAOOperaciones();
        DAOValoraciones daoValoraciones = new DAOValoraciones();
        
        GenericType<Propiedades> generic_propiedades;
        generic_propiedades = new GenericType<Propiedades> () {};
        propiedad = daoPropiedades.find_XML(generic_propiedades, idPropiedad);
        
        GenericType<List<Operaciones>> generic_operaciones;
        generic_operaciones = new GenericType<List<Operaciones>> () {};
        operaciones = daoOperaciones.findAll_XML(generic_operaciones);
        
        GenericType<List<Valoraciones>> generic_valoraciones;
        generic_valoraciones = new GenericType<List<Valoraciones>> () {};
        
        valoraciones = daoValoraciones.findAll_XML(generic_valoraciones);
        
        return SUCCESS;
    }
}