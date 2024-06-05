/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author migue
 */
@Entity
@Table(name = "propiedades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propiedades.findAll", query = "SELECT p FROM Propiedades p")
    , @NamedQuery(name = "Propiedades.findById", query = "SELECT p FROM Propiedades p WHERE p.id = :id")
    , @NamedQuery(name = "Propiedades.findByTitulo", query = "SELECT p FROM Propiedades p WHERE p.titulo = :titulo")
    , @NamedQuery(name = "Propiedades.findByDescripcion", query = "SELECT p FROM Propiedades p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Propiedades.findBySuperficie", query = "SELECT p FROM Propiedades p WHERE p.superficie = :superficie")
    , @NamedQuery(name = "Propiedades.findByNumeroHabitaciones", query = "SELECT p FROM Propiedades p WHERE p.numeroHabitaciones = :numeroHabitaciones")
    , @NamedQuery(name = "Propiedades.findByFoto", query = "SELECT p FROM Propiedades p WHERE p.foto = :foto")
    , @NamedQuery(name = "Propiedades.findByPrecio", query = "SELECT p FROM Propiedades p WHERE p.precio = :precio")})
public class Propiedades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "superficie")
    private int superficie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_habitaciones")
    private int numeroHabitaciones;
    @Size(max = 255)
    @Column(name = "foto")
    private String foto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPropiedad")
    private Collection<Compras> comprasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPropiedad")
    private Collection<Alquileres> alquileresCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPropiedad")
    private Collection<Valoracionestotales> valoracionestotalesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPropiedad")
    private Collection<Favoritos> favoritosCollection;
    @JoinColumn(name = "id_direccion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Direcciones idDireccion;
    @JoinColumn(name = "id_operacion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Operaciones idOperacion;
    @JoinColumn(name = "id_propietario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idPropietario;
    @JoinColumn(name = "id_inquilino", referencedColumnName = "id")
    @ManyToOne
    private Usuarios idInquilino;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPropiedad")
    private Collection<Seguros> segurosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPropiedad")
    private Collection<Valoraciones> valoracionesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPropiedad")
    private Collection<Visitas> visitasCollection;

    public Propiedades() {
    }

    public Propiedades(Integer id) {
        this.id = id;
    }

    public Propiedades(Integer id, String titulo, String descripcion, int superficie, int numeroHabitaciones, double precio) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.superficie = superficie;
        this.numeroHabitaciones = numeroHabitaciones;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public int getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(int numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @XmlTransient
    public Collection<Compras> getComprasCollection() {
        return comprasCollection;
    }

    public void setComprasCollection(Collection<Compras> comprasCollection) {
        this.comprasCollection = comprasCollection;
    }

    @XmlTransient
    public Collection<Alquileres> getAlquileresCollection() {
        return alquileresCollection;
    }

    public void setAlquileresCollection(Collection<Alquileres> alquileresCollection) {
        this.alquileresCollection = alquileresCollection;
    }

    @XmlTransient
    public Collection<Valoracionestotales> getValoracionestotalesCollection() {
        return valoracionestotalesCollection;
    }

    public void setValoracionestotalesCollection(Collection<Valoracionestotales> valoracionestotalesCollection) {
        this.valoracionestotalesCollection = valoracionestotalesCollection;
    }

    @XmlTransient
    public Collection<Favoritos> getFavoritosCollection() {
        return favoritosCollection;
    }

    public void setFavoritosCollection(Collection<Favoritos> favoritosCollection) {
        this.favoritosCollection = favoritosCollection;
    }

    public Direcciones getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Direcciones idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Operaciones getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Operaciones idOperacion) {
        this.idOperacion = idOperacion;
    }

    public Usuarios getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Usuarios idPropietario) {
        this.idPropietario = idPropietario;
    }

    public Usuarios getIdInquilino() {
        return idInquilino;
    }

    public void setIdInquilino(Usuarios idInquilino) {
        this.idInquilino = idInquilino;
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
        if (!(object instanceof Propiedades)) {
            return false;
        }
        Propiedades other = (Propiedades) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "servicios.Propiedades[ id=" + id + " ]";
    }
    
}
