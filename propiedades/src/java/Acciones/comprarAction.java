package Acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import modelo.Alquileres;
import modelo.Compras;
import modelo.Favoritos;
import modelo.Operaciones;
import modelo.Propiedades;
import modelo.Usuarios;
import org.apache.struts2.interceptor.ServletRequestAware;
import servicios.DAOAlquileres;
import servicios.DAOCompras;
import servicios.DAOFavoritos;
import servicios.DAOOperaciones;
import servicios.DAOPropiedades;
import servicios.DAORoles;
import servicios.DAOUsuarios;

/**
 *
 * @author migue
 */
public class comprarAction extends ActionSupport {
    
    private String idPropiedad = "";
    private String idPropietario = "";
    private String idComprador = "";
    private Propiedades propiedad;
    private Usuarios propietario;
    private Usuarios comprador;
    
    public comprarAction() {
    }

    public String getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(String idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public String getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(String idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(String idComprador) {
        this.idComprador = idComprador;
    }

    public Propiedades getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedades propiedad) {
        this.propiedad = propiedad;
    }

    public Usuarios getPropietario() {
        return propietario;
    }

    public void setPropietario(Usuarios propietario) {
        this.propietario = propietario;
    }

    public Usuarios getComprador() {
        return comprador;
    }

    public void setComprador(Usuarios comprador) {
        this.comprador = comprador;
    }
    
    public String execute() throws Exception {
        DAOUsuarios daoUsuarios = new DAOUsuarios();
        DAOPropiedades daoPropiedades = new DAOPropiedades();
        DAOCompras daoCompras = new DAOCompras();
        DAOOperaciones daoOperaciones = new DAOOperaciones();
        
        GenericType<Usuarios> generic_usuarios;
        generic_usuarios = new GenericType<Usuarios> () {};
        propietario = daoUsuarios.find_XML(generic_usuarios, idPropietario);
        comprador = daoUsuarios.find_XML(generic_usuarios, idComprador);
        
        GenericType<Propiedades> generic_propiedades;
        generic_propiedades = new GenericType<Propiedades> () {};
        propiedad = daoPropiedades.find_XML(generic_propiedades, idPropiedad);
        
        Compras compra = new Compras();
        compra.setIdVendedor(propietario);
        compra.setIdComprador(comprador);
        compra.setIdPropiedad(propiedad);
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String fechaFormateada = formatter.format(date);
        Date fecha = formatter.parse(fechaFormateada);
        compra.setFecha(fecha);
        
        Object obj_compra = compra;
        daoCompras.create_XML(obj_compra);
        
        GenericType<Operaciones> geenric_operacion;
        geenric_operacion = new GenericType<Operaciones> () {};
        Operaciones operacion = daoOperaciones.find_XML(geenric_operacion, "3");
        
        Propiedades propiedadComprada = new Propiedades(propiedad.getId(), propiedad.getTitulo(), propiedad.getDescripcion(), propiedad.getSuperficie(), propiedad.getNumeroHabitaciones(), propiedad.getFoto(), propiedad.getPrecio(), comprador, null, propiedad.getIdDireccion(), operacion);
        
        Object obj_propiedad = propiedadComprada;
        daoPropiedades.edit_XML(obj_propiedad, idPropiedad);
        
        propiedadComprada = daoPropiedades.find_XML(generic_propiedades, idPropiedad);
        
        propiedad = daoPropiedades.find_XML(generic_propiedades, idPropiedad);
        
        return SUCCESS;
    }
}
