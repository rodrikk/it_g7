package modelos;
// Generated 18-may-2024 17:30:18 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Usuarios generated by hbm2java
 */
public class Usuarios  implements java.io.Serializable {


     private int id;
     private Rol rol;
     private String nombre;
     private String apellidos;
     private String email;
     private Set comprarsForIdComprador = new HashSet(0);
     private Set alquilersForIdInquilino = new HashSet(0);
     private Set valoracionpropiedads = new HashSet(0);
     private Set visitas = new HashSet(0);
     private Set alquilersForIdPropietario = new HashSet(0);
     private Set valoracionusuariosForIdUsuario = new HashSet(0);
     private Set valoracionusuariosForIdValorador = new HashSet(0);
     private Set comprarsForIdVendedor = new HashSet(0);
     private Set seguros = new HashSet(0);
     private Set propiedadesesForIdPropietario = new HashSet(0);
     private Set propiedadesesForIdInquilino = new HashSet(0);

    public Usuarios() {
    }

	
    public Usuarios(int id, Rol rol) {
        this.id = id;
        this.rol = rol;
    }
    public Usuarios(int id, Rol rol, String nombre, String apellidos, String email, Set comprarsForIdComprador, Set alquilersForIdInquilino, Set valoracionpropiedads, Set visitas, Set alquilersForIdPropietario, Set valoracionusuariosForIdUsuario, Set valoracionusuariosForIdValorador, Set comprarsForIdVendedor, Set seguros, Set propiedadesesForIdPropietario, Set propiedadesesForIdInquilino) {
       this.id = id;
       this.rol = rol;
       this.nombre = nombre;
       this.apellidos = apellidos;
       this.email = email;
       this.comprarsForIdComprador = comprarsForIdComprador;
       this.alquilersForIdInquilino = alquilersForIdInquilino;
       this.valoracionpropiedads = valoracionpropiedads;
       this.visitas = visitas;
       this.alquilersForIdPropietario = alquilersForIdPropietario;
       this.valoracionusuariosForIdUsuario = valoracionusuariosForIdUsuario;
       this.valoracionusuariosForIdValorador = valoracionusuariosForIdValorador;
       this.comprarsForIdVendedor = comprarsForIdVendedor;
       this.seguros = seguros;
       this.propiedadesesForIdPropietario = propiedadesesForIdPropietario;
       this.propiedadesesForIdInquilino = propiedadesesForIdInquilino;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Rol getRol() {
        return this.rol;
    }
    
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Set getComprarsForIdComprador() {
        return this.comprarsForIdComprador;
    }
    
    public void setComprarsForIdComprador(Set comprarsForIdComprador) {
        this.comprarsForIdComprador = comprarsForIdComprador;
    }
    public Set getAlquilersForIdInquilino() {
        return this.alquilersForIdInquilino;
    }
    
    public void setAlquilersForIdInquilino(Set alquilersForIdInquilino) {
        this.alquilersForIdInquilino = alquilersForIdInquilino;
    }
    public Set getValoracionpropiedads() {
        return this.valoracionpropiedads;
    }
    
    public void setValoracionpropiedads(Set valoracionpropiedads) {
        this.valoracionpropiedads = valoracionpropiedads;
    }
    public Set getVisitas() {
        return this.visitas;
    }
    
    public void setVisitas(Set visitas) {
        this.visitas = visitas;
    }
    public Set getAlquilersForIdPropietario() {
        return this.alquilersForIdPropietario;
    }
    
    public void setAlquilersForIdPropietario(Set alquilersForIdPropietario) {
        this.alquilersForIdPropietario = alquilersForIdPropietario;
    }
    public Set getValoracionusuariosForIdUsuario() {
        return this.valoracionusuariosForIdUsuario;
    }
    
    public void setValoracionusuariosForIdUsuario(Set valoracionusuariosForIdUsuario) {
        this.valoracionusuariosForIdUsuario = valoracionusuariosForIdUsuario;
    }
    public Set getValoracionusuariosForIdValorador() {
        return this.valoracionusuariosForIdValorador;
    }
    
    public void setValoracionusuariosForIdValorador(Set valoracionusuariosForIdValorador) {
        this.valoracionusuariosForIdValorador = valoracionusuariosForIdValorador;
    }
    public Set getComprarsForIdVendedor() {
        return this.comprarsForIdVendedor;
    }
    
    public void setComprarsForIdVendedor(Set comprarsForIdVendedor) {
        this.comprarsForIdVendedor = comprarsForIdVendedor;
    }
    public Set getSeguros() {
        return this.seguros;
    }
    
    public void setSeguros(Set seguros) {
        this.seguros = seguros;
    }
    public Set getPropiedadesesForIdPropietario() {
        return this.propiedadesesForIdPropietario;
    }
    
    public void setPropiedadesesForIdPropietario(Set propiedadesesForIdPropietario) {
        this.propiedadesesForIdPropietario = propiedadesesForIdPropietario;
    }
    public Set getPropiedadesesForIdInquilino() {
        return this.propiedadesesForIdInquilino;
    }
    
    public void setPropiedadesesForIdInquilino(Set propiedadesesForIdInquilino) {
        this.propiedadesesForIdInquilino = propiedadesesForIdInquilino;
    }




}

