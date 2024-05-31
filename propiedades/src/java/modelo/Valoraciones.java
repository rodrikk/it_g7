/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author migue
 */
@Entity
@Table(name = "valoraciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valoraciones.findAll", query = "SELECT v FROM Valoraciones v")
    , @NamedQuery(name = "Valoraciones.findById", query = "SELECT v FROM Valoraciones v WHERE v.id = :id")
    , @NamedQuery(name = "Valoraciones.findByPuntuacion", query = "SELECT v FROM Valoraciones v WHERE v.puntuacion = :puntuacion")})
public class Valoraciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntuacion")
    private double puntuacion;
    @JoinColumn(name = "id_propiedad", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Propiedades idPropiedad;
    @JoinColumn(name = "id_valorador", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idValorador;

    public Valoraciones() {
    }

    public Valoraciones(Integer id) {
        this.id = id;
    }

    public Valoraciones(Integer id, double puntuacion) {
        this.id = id;
        this.puntuacion = puntuacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Propiedades getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(Propiedades idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public Usuarios getIdValorador() {
        return idValorador;
    }

    public void setIdValorador(Usuarios idValorador) {
        this.idValorador = idValorador;
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
        if (!(object instanceof Valoraciones)) {
            return false;
        }
        Valoraciones other = (Valoraciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Valoraciones[ id=" + id + " ]";
    }
    
}
