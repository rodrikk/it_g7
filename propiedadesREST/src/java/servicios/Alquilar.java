/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author migue
 */
@Entity
@Table(name = "alquilar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alquilar.findAll", query = "SELECT a FROM Alquilar a")
    , @NamedQuery(name = "Alquilar.findById", query = "SELECT a FROM Alquilar a WHERE a.id = :id")
    , @NamedQuery(name = "Alquilar.findByPrecio", query = "SELECT a FROM Alquilar a WHERE a.precio = :precio")
    , @NamedQuery(name = "Alquilar.findByFechaInicio", query = "SELECT a FROM Alquilar a WHERE a.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Alquilar.findByFechaFin", query = "SELECT a FROM Alquilar a WHERE a.fechaFin = :fechaFin")})
public class Alquilar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @JoinColumn(name = "id_propiedad", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Propiedades idPropiedad;
    @JoinColumn(name = "id_propietario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idPropietario;
    @JoinColumn(name = "id_alquilado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idAlquilado;

    public Alquilar() {
    }

    public Alquilar(Integer id) {
        this.id = id;
    }

    public Alquilar(Integer id, double precio, Date fechaInicio, Date fechaFin) {
        this.id = id;
        this.precio = precio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Propiedades getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(Propiedades idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public Usuarios getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Usuarios idPropietario) {
        this.idPropietario = idPropietario;
    }

    public Usuarios getIdAlquilado() {
        return idAlquilado;
    }

    public void setIdAlquilado(Usuarios idAlquilado) {
        this.idAlquilado = idAlquilado;
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
        if (!(object instanceof Alquilar)) {
            return false;
        }
        Alquilar other = (Alquilar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "servicios.Alquilar[ id=" + id + " ]";
    }
    
}
