/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
@Table(name = "comprar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comprar.findAll", query = "SELECT c FROM Comprar c")
    , @NamedQuery(name = "Comprar.findById", query = "SELECT c FROM Comprar c WHERE c.id = :id")
    , @NamedQuery(name = "Comprar.findByPrecio", query = "SELECT c FROM Comprar c WHERE c.precio = :precio")
    , @NamedQuery(name = "Comprar.findByFecha", query = "SELECT c FROM Comprar c WHERE c.fecha = :fecha")})
public class Comprar implements Serializable {

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
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "id_propiedad", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Propiedades idPropiedad;
    @JoinColumn(name = "id_vendedor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idVendedor;
    @JoinColumn(name = "id_comprador", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idComprador;

    public Comprar() {
    }

    public Comprar(Integer id) {
        this.id = id;
    }

    public Comprar(Integer id, double precio, Date fecha) {
        this.id = id;
        this.precio = precio;
        this.fecha = fecha;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Propiedades getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(Propiedades idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public Usuarios getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Usuarios idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Usuarios getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(Usuarios idComprador) {
        this.idComprador = idComprador;
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
        if (!(object instanceof Comprar)) {
            return false;
        }
        Comprar other = (Comprar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Comprar[ id=" + id + " ]";
    }
    
}
