/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import modelo.Direcciones;
import modelo.Operaciones;
import modelo.Propiedades;
import servicios.DAODirecciones;
import servicios.DAOOperaciones;
import servicios.DAOPropiedades;

/**
 *
 * @author migue
 */
public class editarPropiedadAction extends ActionSupport {
    
    private String idPropiedad = "";
    private String idDireccion = "";
    private String titulo = "";
    private String descripcion = "";
    private String superficie = "";
    private String numeroHabitaciones = "";
    private String precio = "";
    private String calle = "";
    private String numero = "";
    private String codigoPostal = "";
    private String ciudad = "";
    private String provincia = "";
    private String pais = "";
    private String idOperacion;
    private Propiedades propiedad;
    private Direcciones direccion;
    private Operaciones operacion;
    private List<Propiedades> propiedades;
    private String idUsuario = "";

    public editarPropiedadAction() {
    }

    public String getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(String idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public String getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(String idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSuperficie() {
        return superficie;
    }

    public void setSuperficie(String superficie) {
        this.superficie = superficie;
    }

    public String getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(String numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(String idOperacion) {
        this.idOperacion = idOperacion;
    }

    public Propiedades getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedades propiedad) {
        this.propiedad = propiedad;
    }

    public Direcciones getDireccion() {
        return direccion;
    }

    public void setDireccion(Direcciones direccion) {
        this.direccion = direccion;
    }

    public Operaciones getOperacion() {
        return operacion;
    }

    public void setOperacion(Operaciones operacion) {
        this.operacion = operacion;
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
        DAODirecciones daoDirecciones = new DAODirecciones();
        DAOPropiedades daoPropiedades = new DAOPropiedades();
        DAOOperaciones daoOperaciones = new DAOOperaciones();
        
        GenericType<Direcciones> generic_direccion;
        generic_direccion = new GenericType<Direcciones> () {};
        
        direccion = daoDirecciones.find_XML(generic_direccion, idDireccion);
        
        Direcciones direccionEditada = new Direcciones(direccion.getId(), calle, Integer.parseInt(numero), Integer.parseInt(codigoPostal), ciudad, provincia, pais);
        
        Object obj_direccion = direccionEditada;
        daoDirecciones.edit_XML(obj_direccion, idDireccion);
        
        GenericType<Propiedades> generic_propiedad;
        generic_propiedad = new GenericType<Propiedades> () {};
        
        propiedad = daoPropiedades.find_XML(generic_propiedad, idPropiedad);
        
        GenericType<Operaciones> generic_operacion;
        generic_operacion = new GenericType<Operaciones> () {};
        
        operacion = daoOperaciones.find_XML(generic_operacion, idOperacion);
        
        Propiedades propiedadEditada = new Propiedades(propiedad.getId(), titulo, descripcion, Integer.parseInt(superficie), Integer.parseInt(numeroHabitaciones), propiedad.getFoto(), Double.parseDouble(precio), propiedad.getIdPropietario(), propiedad.getIdInquilino(), direccionEditada, operacion);
        
        Object obj_propiedad = propiedadEditada;
        daoPropiedades.edit_XML(obj_propiedad, idPropiedad);
        
        GenericType<List<Propiedades>> generic_propiedades;
        generic_propiedades = new GenericType<List<Propiedades>> () {};
        
        propiedades = daoPropiedades.findAll_XML(generic_propiedades);
        
        for (int i = 0; i < propiedades.size(); i++) {
            if (propiedades.get(i).getIdPropietario().getId() != Integer.parseInt(idUsuario)) {
                propiedades.remove(propiedades.get(i));
            }
        }
        
        return SUCCESS;
    }
}
