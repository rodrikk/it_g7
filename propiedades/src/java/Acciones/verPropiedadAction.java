/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.ws.rs.core.GenericType;
import modelo.Operaciones;
import modelo.Propiedades;
import modelo.Valoraciones;
import servicios.DAOOperaciones;
import servicios.DAOPropiedades;
import servicios.DAOValoraciones;
/**
 *
 * @author migue
 */
public class verPropiedadAction extends ActionSupport {
    
    private Propiedades propiedad;
    private String idPropiedad = "";
    private String idValorador = "";
    private List<Operaciones> operaciones;
    private List<Valoraciones> valoraciones;
    private String idValoracion = "";
    private boolean existeValoracion;

    public verPropiedadAction() {
    }

    public Propiedades getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedades propiedad) {
        this.propiedad = propiedad;
    }

    public String getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(String idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public String getIdValorador() {
        return idValorador;
    }

    public void setIdValorador(String idValorador) {
        this.idValorador = idValorador;
    }

    public List<Operaciones> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(List<Operaciones> operaciones) {
        this.operaciones = operaciones;
    }

    public List<Valoraciones> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(List<Valoraciones> valoraciones) {
        this.valoraciones = valoraciones;
    }

    public boolean isExisteValoracion() {
        return existeValoracion;
    }

    public void setExisteValoracion(boolean existeValoracion) {
        this.existeValoracion = existeValoracion;
    }

    public String getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(String idValoracion) {
        this.idValoracion = idValoracion;
    }
    
    public String execute() throws Exception {
        DAOPropiedades daoPropiedades = new DAOPropiedades();
        DAOOperaciones daoOperaciones = new DAOOperaciones();
        DAOValoraciones daoValoraciones = new DAOValoraciones();
        
        GenericType<Propiedades> generic_propiedades;
        generic_propiedades = new GenericType<Propiedades> () {};
        propiedad = daoPropiedades.find_XML(generic_propiedades, idPropiedad);
        
        GenericType<List<Operaciones>> generic_operaciones;
        generic_operaciones = new GenericType<List<Operaciones>> () {};
        operaciones = daoOperaciones.findAll_XML(generic_operaciones);
        
        GenericType<List<Valoraciones>> generic_valoraciones;
        generic_valoraciones = new GenericType<List<Valoraciones>> () {};
        
        valoraciones = daoValoraciones.findAll_XML(generic_valoraciones);
        
        for (int i = 0; i < valoraciones.size(); i++) {
            if (valoraciones.get(i).getIdPropiedad().getId() == Integer.parseInt(idPropiedad) && valoraciones.get(i).getIdValorador().getId() == Integer.parseInt(idValorador)) {
                existeValoracion = true;
                idValoracion = String.valueOf(valoraciones.get(i).getId());
            } else {
                existeValoracion = false;
            }
        }
        
        return SUCCESS;
    }
}
