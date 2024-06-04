package Acciones;

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
    private Propiedades propiedad;
    private Direcciones direccion;
    private Operaciones operacion;
    private List<Propiedades> propiedades;
    private String idUsuario = "";
    private Usuarios usuario;
    private Direcciones direccionAgregada;

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

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Direcciones getDireccionAgregada() {
        return direccionAgregada;
    }

    public void setDireccionAgregada(Direcciones direccionAgregada) {
        this.direccionAgregada = direccionAgregada;
    }
    
    
    
    public String execute() throws Exception {
        DAODirecciones daoDirecciones = new DAODirecciones();
        DAOPropiedades daoPropiedades = new DAOPropiedades();
        DAOOperaciones daoOperaciones = new DAOOperaciones();
        DAOUsuarios daoUsuarios = new DAOUsuarios();
        
        GenericType<Direcciones> generic_direccion;
        generic_direccion = new GenericType<Direcciones> () {};
                
        
        direccionAgregada = new Direcciones(calle, Integer.parseInt(numero), Integer.parseInt(codigoPostal), ciudad, provincia, pais);
        
        Object obj_direccion = direccionAgregada;
        daoDirecciones.create_XML(obj_direccion);
        
        GenericType<Propiedades> generic_propiedad;
        generic_propiedad = new GenericType<Propiedades> () {};
        
        GenericType<Usuarios> generic_usuario;
        generic_usuario = new GenericType<Usuarios> () {};
        
        usuario = daoUsuarios.find_XML(generic_usuario, idUsuario);
        
        
        GenericType<Operaciones> generic_operacion;
        generic_operacion = new GenericType<Operaciones> () {};
        
        operacion = daoOperaciones.find_XML(generic_operacion, idOperacion);
        
        Propiedades propiedadAgregada = new Propiedades();
        
        propiedadAgregada.setTitulo(titulo);
        propiedadAgregada.setDescripcion(descripcion);
        propiedadAgregada.setSuperficie(Integer.parseInt(superficie));
        propiedadAgregada.setNumeroHabitaciones(Integer.parseInt(numeroHabitaciones));        
        propiedadAgregada.setPrecio(Double.parseDouble(precio));
        propiedadAgregada.setIdPropietario(usuario);
        propiedadAgregada.setIdDireccion(direccionAgregada);
        propiedadAgregada.setIdOperacion(operacion);
        
        
        
        Object obj_propiedad = propiedadAgregada;
        daoPropiedades.create_XML(obj_propiedad);
        
        
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