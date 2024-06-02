/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "operaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operaciones.findAll", query = "SELECT o FROM Operaciones o")
    , @NamedQuery(name = "Operaciones.findById", query = "SELECT o FROM Operaciones o WHERE o.id = :id")
    , @NamedQuery(name = "Operaciones.findByOperacion", query = "SELECT o FROM Operaciones o WHERE o.operacion = :operacion")})
public class Operaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "operacion")
    private String operacion;
    @OneToMany(mappedBy = "idOperacion")
    private Collection<Propiedades> propiedadesCollection;

    public Operaciones() {
    }

    public Operaciones(Integer id) {
        this.id = id;
    }

    public Operaciones(Integer id, String operacion) {
        this.id = id;
        this.operacion = operacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    @XmlTransient
    public Collection<Propiedades> getPropiedadesCollection() {
        return propiedadesCollection;
    }

    public void setPropiedadesCollection(Collection<Propiedades> propiedadesCollection) {
        this.propiedadesCollection = propiedadesCollection;
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
        if (!(object instanceof Operaciones)) {
            return false;
        }
        Operaciones other = (Operaciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "servicios.Operaciones[ id=" + id + " ]";
    }
    
}
