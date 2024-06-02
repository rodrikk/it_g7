/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import modelo.Alquileres;
import modelo.Favoritos;
import modelo.Propiedades;
import modelo.Usuarios;
import org.apache.struts2.interceptor.ServletRequestAware;
import servicios.DAOAlquileres;
import servicios.DAOFavoritos;
import servicios.DAOPropiedades;
import servicios.DAORoles;
import servicios.DAOUsuarios;

/**
 *
 * @author migue
 */
public class alquilerAction extends ActionSupport {

    private Usuarios propietario;
    private Usuarios alquilado;
    private Propiedades propiedad;
    private String idPropietario = "";
    private String idAlquilado = "";
    private String idPropiedad = "";
    private String fechaInicio = "";
    private String fechaFin = "";
    
    private String mensaje = "";

    public alquilerAction() {
    }

    public Usuarios getPropietario() {
        return propietario;
    }

    public void setPropietario(Usuarios propietario) {
        this.propietario = propietario;
    }

    public Usuarios getAlquilado() {
        return alquilado;
    }

    public void setAlquilado(Usuarios alquilado) {
        this.alquilado = alquilado;
    }

    public Propiedades getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedades propiedad) {
        this.propiedad = propiedad;
    }

    public String getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(String idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getIdAlquilado() {
        return idAlquilado;
    }

    public void setIdAlquilado(String idAlquilado) {
        this.idAlquilado = idAlquilado;
    }

    public String getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(String idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String execute() throws Exception {
        DAOUsuarios daoUsuarios = new DAOUsuarios();
        DAOPropiedades daoPropiedades = new DAOPropiedades();
        DAOAlquileres daoAlquileres = new DAOAlquileres();
        
        GenericType<Usuarios> generic_usuarios;
        generic_usuarios = new GenericType<Usuarios> () {};
        propietario = daoUsuarios.find_XML(generic_usuarios, idPropietario);
        alquilado = daoUsuarios.find_XML(generic_usuarios, idAlquilado);
        
        GenericType<Propiedades> generic_propiedades;
        generic_propiedades = new GenericType<Propiedades> () {};
        propiedad = daoPropiedades.find_XML(generic_propiedades, idPropiedad);
        
        Alquileres alquiler = new Alquileres();
        alquiler.setIdPropietario(propietario);
        alquiler.setIdAlquilado(alquilado);
        alquiler.setIdPropiedad(propiedad);
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fInicio = formatter.parse(fechaInicio);
        Date fFin = formatter.parse(fechaFin);
        
        alquiler.setFechaInicio(fInicio);
        alquiler.setFechaFin(fFin);
        
        Object obj_alquiler = alquiler;
        daoAlquileres.create_XML(obj_alquiler);
        
        Propiedades propiedadAlquilada = new Propiedades(propiedad.getId(), propiedad.getTitulo(), propiedad.getDescripcion(), propiedad.getSuperficie(), propiedad.getNumeroHabitaciones(), propiedad.getFoto(), propiedad.getPrecio(), propiedad.getIdPropietario(), alquilado, propiedad.getIdDireccion(), propiedad.getIdOperacion());
        
        Object obj_propiedad = propiedadAlquilada;
        daoPropiedades.edit_XML(obj_propiedad, idPropiedad);
        
        propiedad = daoPropiedades.find_XML(generic_propiedades, idPropiedad);
        
        return SUCCESS;
    }
}
