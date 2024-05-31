/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author migue
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findById", query = "SELECT u FROM Usuarios u WHERE u.id = :id")
    , @NamedQuery(name = "Usuarios.findByNombre", query = "SELECT u FROM Usuarios u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuarios.findByApellidos", query = "SELECT u FROM Usuarios u WHERE u.apellidos = :apellidos")
    , @NamedQuery(name = "Usuarios.findByEmail", query = "SELECT u FROM Usuarios u WHERE u.email = :email")
    , @NamedQuery(name = "Usuarios.findByPassword", query = "SELECT u FROM Usuarios u WHERE u.password = :password")
    , @NamedQuery(name = "Usuarios.findByTelefono", query = "SELECT u FROM Usuarios u WHERE u.telefono = :telefono")
    , @NamedQuery(name = "Usuarios.findByFechaNacimiento", query = "SELECT u FROM Usuarios u WHERE u.fechaNacimiento = :fechaNacimiento")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "apellidos")
    private String apellidos;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVendedor")
    private Collection<Comprar> comprarCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComprador")
    private Collection<Comprar> comprarCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<Favoritos> favoritosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPropietario")
    private Collection<Alquilar> alquilarCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAlquilado")
    private Collection<Alquilar> alquilarCollection1;
    @JoinColumn(name = "id_rol", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Roles idRol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPropietario")
    private Collection<Propiedades> propiedadesCollection;
    @OneToMany(mappedBy = "idInquilino")
    private Collection<Propiedades> propiedadesCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInquilino")
    private Collection<Seguros> segurosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idValorador")
    private Collection<Valoraciones> valoracionesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVisitante")
    private Collection<Visitas> visitasCollection;

    public Usuarios() {
    }

    public Usuarios(Integer id) {
        this.id = id;
    }

    public Usuarios(Integer id, String password, String telefono, Date fechaNacimiento) {
        this.id = id;
        this.password = password;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @XmlTransient
    public Collection<Comprar> getComprarCollection() {
        return comprarCollection;
    }

    public void setComprarCollection(Collection<Comprar> comprarCollection) {
        this.comprarCollection = comprarCollection;
    }

    @XmlTransient
    public Collection<Comprar> getComprarCollection1() {
        return comprarCollection1;
    }

    public void setComprarCollection1(Collection<Comprar> comprarCollection1) {
        this.comprarCollection1 = comprarCollection1;
    }

    @XmlTransient
    public Collection<Favoritos> getFavoritosCollection() {
        return favoritosCollection;
    }

    public void setFavoritosCollection(Collection<Favoritos> favoritosCollection) {
        this.favoritosCollection = favoritosCollection;
    }

    @XmlTransient
    public Collection<Alquilar> getAlquilarCollection() {
        return alquilarCollection;
    }

    public void setAlquilarCollection(Collection<Alquilar> alquilarCollection) {
        this.alquilarCollection = alquilarCollection;
    }

    @XmlTransient
    public Collection<Alquilar> getAlquilarCollection1() {
        return alquilarCollection1;
    }

    public void setAlquilarCollection1(Collection<Alquilar> alquilarCollection1) {
        this.alquilarCollection1 = alquilarCollection1;
    }

    public Roles getIdRol() {
        return idRol;
    }

    public void setIdRol(Roles idRol) {
        this.idRol = idRol;
    }

    @XmlTransient
    public Collection<Propiedades> getPropiedadesCollection() {
        return propiedadesCollection;
    }

    public void setPropiedadesCollection(Collection<Propiedades> propiedadesCollection) {
        this.propiedadesCollection = propiedadesCollection;
    }

    @XmlTransient
    public Collection<Propiedades> getPropiedadesCollection1() {
        return propiedadesCollection1;
    }

    public void setPropiedadesCollection1(Collection<Propiedades> propiedadesCollection1) {
        this.propiedadesCollection1 = propiedadesCollection1;
    }

    @XmlTransient
    public Collection<Seguros> getSegurosCollection() {
        return segurosCollection;
    }

    public void setSegurosCollection(Collection<Seguros> segurosCollection) {
        this.segurosCollection = segurosCollection;
    }

    @XmlTransient
    public Collection<Valoraciones> getValoracionesCollection() {
        return valoracionesCollection;
    }

    public void setValoracionesCollection(Collection<Valoraciones> valoracionesCollection) {
        this.valoracionesCollection = valoracionesCollection;
    }

    @XmlTransient
    public Collection<Visitas> getVisitasCollection() {
        return visitasCollection;
    }

    public void setVisitasCollection(Collection<Visitas> visitasCollection) {
        this.visitasCollection = visitasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Usuarios[ id=" + id + " ]";
    }
    
}
