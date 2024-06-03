/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import modelo.Favoritos;
import modelo.Propiedades;
import modelo.Usuarios;
import modelo.Valoraciones;
import modelo.Valoracionestotales;
import org.apache.struts2.interceptor.ServletRequestAware;
import servicios.DAOFavoritos;
import servicios.DAOPropiedades;
import servicios.DAOUsuarios;
import servicios.DAOValoraciones;
import servicios.DAOValoracionesTotales;

/**
 *
 * @author migue
 */
public class borrarValoracionAction extends ActionSupport {

    private String idValoracion = "";
    private List<Valoracionestotales> valoracionesTotales;
    private String idPropiedad = "";
    private List<Valoraciones> valoraciones;
    private String idValorador = "";
    private Propiedades propiedad;
    private double valoracionTotal;
    private int cont;
    private boolean existeValoracion;
    
    public borrarValoracionAction() {
    }

    public String execute() throws Exception {
        DAOValoraciones daoValoraciones = new DAOValoraciones();
        DAOValoracionesTotales daoValoracionesTotales = new DAOValoracionesTotales();
        DAOPropiedades daoPropiedades = new DAOPropiedades();

        daoValoraciones.remove(idValoracion);
        
        GenericType<List<Valoraciones>> generic_valoraciones;
        generic_valoraciones = new GenericType<List<Valoraciones>>() {};
        
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
        
        Valoracionestotales vTotal = new Valoracionestotales(Integer.parseInt(idValoracion), valoracionTotal, propiedad);
        daoValoracionesTotales.edit_XML(vTotal, idValoracion);
        
        GenericType<Propiedades> generic_propiedad;
        generic_propiedad = new GenericType<Propiedades>() {};
        
        propiedad = daoPropiedades.find_XML(generic_propiedad, idPropiedad);
        
        existeValoracion = true;

        return SUCCESS;
    }
}
