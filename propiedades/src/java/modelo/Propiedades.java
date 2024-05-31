/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
    , @NamedQuery(name = "Propiedades.findBySuperficie", query = "SELECT p FROM Propiedades p WHERE p.superficie = :superficie")
    , @NamedQuery(name = "Propiedades.findByNumeroHabitaciones", query = "SELECT p FROM Propiedades p WHERE p.numeroHabitaciones = :numeroHabitaciones")})
public class Propiedades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "superficie")
    private int superficie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_habitaciones")
    private int numeroHabitaciones;
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPropiedad")
    private Collection<Comprar> comprarCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPropiedad")
    private Collection<Favoritos> favoritosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPropiedad")
    private Collection<Alquilar> alquilarCollection;
    @JoinColumn(name = "id_direccion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Direcciones idDireccion;
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

    public Propiedades(Integer id, int superficie, int numeroHabitaciones) {
        this.id = id;
        this.superficie = superficie;
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @XmlTransient
    public Collection<Comprar> getComprarCollection() {
        return comprarCollection;
    }

    public void setComprarCollection(Collection<Comprar> comprarCollection) {
        this.comprarCollection = comprarCollection;
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

    public Direcciones getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Direcciones idDireccion) {
        this.idDireccion = idDireccion;
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
        return "modelo.Propiedades[ id=" + id + " ]";
    }
    
}