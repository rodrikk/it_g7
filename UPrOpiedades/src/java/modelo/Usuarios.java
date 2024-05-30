package modelo;
// Generated 30-may-2024 16:36:51 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Usuarios generated by hbm2java
 */
public class Usuarios  implements java.io.Serializable {


     private Integer id;
     private Roles roles;
     private String nombre;
     private String apellidos;
     private String email;
     private String password;
     private String telefono;
     private Date fechaNacimiento;
     private Set favoritoses = new HashSet(0);
     private Set visitases = new HashSet(0);
     private Set comprarsForIdVendedor = new HashSet(0);
     private Set seguroses = new HashSet(0);
     private Set propiedadesesForIdPropietario = new HashSet(0);
     private Set alquilarsForIdPropietario = new HashSet(0);
     private Set propiedadesesForIdInquilino = new HashSet(0);
     private Set alquilarsForIdAlquilado = new HashSet(0);
     private Set valoracioneses = new HashSet(0);
     private Set comprarsForIdComprador = new HashSet(0);

    public Usuarios() {
    }

	
    public Usuarios(Roles roles, String password, String telefono, Date fechaNacimiento) {
        this.roles = roles;
        this.password = password;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }
    public Usuarios(Roles roles, String nombre, String apellidos, String email, String password, String telefono, Date fechaNacimiento, Set favoritoses, Set visitases, Set comprarsForIdVendedor, Set seguroses, Set propiedadesesForIdPropietario, Set alquilarsForIdPropietario, Set propiedadesesForIdInquilino, Set alquilarsForIdAlquilado, Set valoracioneses, Set comprarsForIdComprador) {
       this.roles = roles;
       this.nombre = nombre;
       this.apellidos = apellidos;
       this.email = email;
       this.password = password;
       this.telefono = telefono;
       this.fechaNacimiento = fechaNacimiento;
       this.favoritoses = favoritoses;
       this.visitases = visitases;
       this.comprarsForIdVendedor = comprarsForIdVendedor;
       this.seguroses = seguroses;
       this.propiedadesesForIdPropietario = propiedadesesForIdPropietario;
       this.alquilarsForIdPropietario = alquilarsForIdPropietario;
       this.propiedadesesForIdInquilino = propiedadesesForIdInquilino;
       this.alquilarsForIdAlquilado = alquilarsForIdAlquilado;
       this.valoracioneses = valoracioneses;
       this.comprarsForIdComprador = comprarsForIdComprador;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Roles getRoles() {
        return this.roles;
    }
    
    public void setRoles(Roles roles) {
        this.roles = roles;
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
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public Set getFavoritoses() {
        return this.favoritoses;
    }
    
    public void setFavoritoses(Set favoritoses) {
        this.favoritoses = favoritoses;
    }
    public Set getVisitases() {
        return this.visitases;
    }
    
    public void setVisitases(Set visitases) {
        this.visitases = visitases;
    }
    public Set getComprarsForIdVendedor() {
        return this.comprarsForIdVendedor;
    }
    
    public void setComprarsForIdVendedor(Set comprarsForIdVendedor) {
        this.comprarsForIdVendedor = comprarsForIdVendedor;
    }
    public Set getSeguroses() {
        return this.seguroses;
    }
    
    public void setSeguroses(Set seguroses) {
        this.seguroses = seguroses;
    }
    public Set getPropiedadesesForIdPropietario() {
        return this.propiedadesesForIdPropietario;
    }
    
    public void setPropiedadesesForIdPropietario(Set propiedadesesForIdPropietario) {
        this.propiedadesesForIdPropietario = propiedadesesForIdPropietario;
    }
    public Set getAlquilarsForIdPropietario() {
        return this.alquilarsForIdPropietario;
    }
    
    public void setAlquilarsForIdPropietario(Set alquilarsForIdPropietario) {
        this.alquilarsForIdPropietario = alquilarsForIdPropietario;
    }
    public Set getPropiedadesesForIdInquilino() {
        return this.propiedadesesForIdInquilino;
    }
    
    public void setPropiedadesesForIdInquilino(Set propiedadesesForIdInquilino) {
        this.propiedadesesForIdInquilino = propiedadesesForIdInquilino;
    }
    public Set getAlquilarsForIdAlquilado() {
        return this.alquilarsForIdAlquilado;
    }
    
    public void setAlquilarsForIdAlquilado(Set alquilarsForIdAlquilado) {
        this.alquilarsForIdAlquilado = alquilarsForIdAlquilado;
    }
    public Set getValoracioneses() {
        return this.valoracioneses;
    }
    
    public void setValoracioneses(Set valoracioneses) {
        this.valoracioneses = valoracioneses;
    }
    public Set getComprarsForIdComprador() {
        return this.comprarsForIdComprador;
    }
    
    public void setComprarsForIdComprador(Set comprarsForIdComprador) {
        this.comprarsForIdComprador = comprarsForIdComprador;
    }




}


