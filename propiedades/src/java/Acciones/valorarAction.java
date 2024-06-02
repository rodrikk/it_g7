/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.ws.rs.core.GenericType;
import modelo.Propiedades;
import modelo.Usuarios;
import modelo.Valoraciones;
import modelo.Valoracionestotales;
import servicios.DAOPropiedades;
import servicios.DAOUsuarios;
import servicios.DAOValoraciones;
import servicios.DAOValoracionesTotales;

/**
 *
 * @author migue
 */
public class valorarAction extends ActionSupport {

    private List<Valoraciones> valoraciones;
    private List<Valoracionestotales> valoracionesTotales;
    private String idValoracion = "";
    private String rating = "";
    private String idPropiedad = "";
    private String idValorador = "";
    private double valoracionTotal;
    private int cont;

    public valorarAction() {
    }

    public List<Valoraciones> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(List<Valoraciones> valoraciones) {
        this.valoraciones = valoraciones;
    }

    public List<Valoracionestotales> getValoracionesTotales() {
        return valoracionesTotales;
    }

    public void setValoracionesTotales(List<Valoracionestotales> valoracionesTotales) {
        this.valoracionesTotales = valoracionesTotales;
    }

    public String getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(String idValoracion) {
        this.idValoracion = idValoracion;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
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

    public double getValoracionTotal() {
        return valoracionTotal;
    }

    public void setValoracionTotal(double valoracionTotal) {
        this.valoracionTotal = valoracionTotal;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public String execute() throws Exception {
        DAOValoraciones daoValoraciones = new DAOValoraciones();
        DAOValoracionesTotales daoValoracionesTotales = new DAOValoracionesTotales();
        DAOPropiedades daoPropiedades = new DAOPropiedades();
        DAOUsuarios daoUsuarios = new DAOUsuarios();
        
        GenericType<List<Valoraciones>> generic_valoraciones;
        generic_valoraciones = new GenericType<List<Valoraciones>>() {};

        Valoraciones valoracion = new Valoraciones();
        valoracion.setPuntuacion(Integer.parseInt(rating));

        GenericType<Propiedades> generic_propiedad;
        generic_propiedad = new GenericType<Propiedades>() {};
        Propiedades propiedad = daoPropiedades.find_XML(generic_propiedad, idPropiedad);
        valoracion.setIdPropiedad(propiedad);

        GenericType<Usuarios> generic_usuario;
        generic_usuario = new GenericType<Usuarios>() {};
        Usuarios usuario = daoUsuarios.find_XML(generic_usuario, idValorador);
        valoracion.setIdValorador(usuario);

        Object obj_valoracion = valoracion;
        daoValoraciones.create_XML(obj_valoracion);

        valoraciones = daoValoraciones.findAll_XML(generic_valoraciones);
        
        cont = 0;
        
        for (int i = 0; i < valoraciones.size(); i++) {
            if (valoraciones.get(i).getIdPropiedad().getId() == Integer.parseInt(idPropiedad)) {
                valoracionTotal += valoraciones.get(i).getPuntuacion();
                cont++;
            }
        }

        valoracionTotal = valoracionTotal / cont;
        
        GenericType<List<Valoracionestotales>> generic_valoracionesTotales;
        generic_valoracionesTotales = new GenericType<List<Valoracionestotales>>() {};
        
        valoracionesTotales = daoValoracionesTotales.findAll_XML(generic_valoracionesTotales);
        
        for (int i = 0; i < valoracionesTotales.size(); i++) {
            if (valoracionesTotales.get(i).getIdPropiedad().getId() == Integer.parseInt(idPropiedad)) {
                idValoracion = String.valueOf(valoracionesTotales.get(i).getId());
            }
        }
        
        // daoValoracionesTotales.remove(idValoracion);
        Valoracionestotales vTotal = new Valoracionestotales();
        vTotal.setValoracionTotal(valoracionTotal);
        vTotal.setIdPropiedad(propiedad);
        
        Object obj_vTotal = vTotal;
        daoValoracionesTotales.edit_XML(obj_vTotal, idValoracion);
        
        return SUCCESS;
    }
}
