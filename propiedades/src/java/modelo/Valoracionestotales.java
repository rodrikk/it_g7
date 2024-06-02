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
@Table(name = "valoracionestotales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valoracionestotales.findAll", query = "SELECT v FROM Valoracionestotales v")
    , @NamedQuery(name = "Valoracionestotales.findById", query = "SELECT v FROM Valoracionestotales v WHERE v.id = :id")
    , @NamedQuery(name = "Valoracionestotales.findByValoracionTotal", query = "SELECT v FROM Valoracionestotales v WHERE v.valoracionTotal = :valoracionTotal")})
public class Valoracionestotales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valoracion_total")
    private double valoracionTotal;
    @JoinColumn(name = "id_propiedad", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Propiedades idPropiedad;

    public Valoracionestotales() {
    }

    public Valoracionestotales(Integer id) {
        this.id = id;
    }

    public Valoracionestotales(Integer id, double valoracionTotal) {
        this.id = id;
        this.valoracionTotal = valoracionTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValoracionTotal() {
        return valoracionTotal;
    }

    public void setValoracionTotal(double valoracionTotal) {
        this.valoracionTotal = valoracionTotal;
    }

    public Propiedades getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(Propiedades idPropiedad) {
        this.idPropiedad = idPropiedad;
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
        if (!(object instanceof Valoracionestotales)) {
            return false;
        }
        Valoracionestotales other = (Valoracionestotales) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Valoracionestotales[ id=" + id + " ]";
    }
    
}
