/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.ws.rs.core.GenericType;
import modelo.Direcciones;
import modelo.Operaciones;
import modelo.Propiedades;
import modelo.Usuarios;
import servicios.DAODirecciones;
import servicios.DAOOperaciones;
import servicios.DAOPropiedades;
import servicios.DAOUsuarios;

/**
 *
 * @author migue
 */
public class agregarPropiedadAction extends ActionSupport {
    
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
    private Operaciones operacion;
    private List<Propiedades> propiedades;
    private String idUsuario = "";
    private Usuarios propietario;
    
    public agregarPropiedadAction() {
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

    public Usuarios getPropietario() {
        return propietario;
    }

    public void setPropietario(Usuarios propietario) {
        this.propietario = propietario;
    }
    
    public String execute() throws Exception {
        DAODirecciones daoDirecciones = new DAODirecciones();
        DAOPropiedades daoPropiedades = new DAOPropiedades();
        DAOOperaciones daoOperaciones = new DAOOperaciones();
        DAOUsuarios daoUsuarios = new DAOUsuarios();
        
        GenericType<Direcciones> generic_direccion;
        generic_direccion = new GenericType<Direcciones> () {};
        
        Direcciones direccionCrear = new Direcciones(calle, Integer.parseInt(numero), Integer.parseInt(codigoPostal), ciudad, provincia, pais);
        
        Object obj_direccion = direccionCrear;
        daoDirecciones.create_XML(obj_direccion);
        
        GenericType<Operaciones> generic_operacion;
        generic_operacion = new GenericType<Operaciones> () {};
        
        operacion = daoOperaciones.find_XML(generic_operacion, idOperacion);
        
        GenericType<Usuarios> generic_usuario;
        generic_usuario = new GenericType<Usuarios> () {};
        
        propietario = daoUsuarios.find_XML(generic_usuario, idUsuario);
        
        Propiedades propiedadCrear = new Propiedades(100, titulo, descripcion, Integer.parseInt(superficie), Integer.parseInt(numeroHabitaciones), null, Double.parseDouble(precio), propietario, null, direccionCrear, operacion);
        
        Object obj_propiedad = propiedadCrear;
        daoPropiedades.edit_XML(obj_propiedad, "100");
        
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
