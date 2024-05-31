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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author migue
 */
@Entity
@Table(name = "seguros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguros.findAll", query = "SELECT s FROM Seguros s")
    , @NamedQuery(name = "Seguros.findById", query = "SELECT s FROM Seguros s WHERE s.id = :id")
    , @NamedQuery(name = "Seguros.findByCobertura", query = "SELECT s FROM Seguros s WHERE s.cobertura = :cobertura")
    , @NamedQuery(name = "Seguros.findByTarifa", query = "SELECT s FROM Seguros s WHERE s.tarifa = :tarifa")
    , @NamedQuery(name = "Seguros.findByFechaInicio", query = "SELECT s FROM Seguros s WHERE s.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Seguros.findByFechaFin", query = "SELECT s FROM Seguros s WHERE s.fechaFin = :fechaFin")})
public class Seguros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cobertura")
    private String cobertura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tarifa")
    private double tarifa;
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
    @JoinColumn(name = "id_inquilino", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idInquilino;

    public Seguros() {
    }

    public Seguros(Integer id) {
        this.id = id;
    }

    public Seguros(Integer id, String cobertura, double tarifa, Date fechaInicio, Date fechaFin) {
        this.id = id;
        this.cobertura = cobertura;
        this.tarifa = tarifa;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCobertura() {
        return cobertura;
    }

    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
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

    public Usuarios getIdInquilino() {
        return idInquilino;
    }

    public void setIdInquilino(Usuarios idInquilino) {
        this.idInquilino = idInquilino;
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
        if (!(object instanceof Seguros)) {
            return false;
        }
        Seguros other = (Seguros) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "servicios.Seguros[ id=" + id + " ]";
    }
    
}
