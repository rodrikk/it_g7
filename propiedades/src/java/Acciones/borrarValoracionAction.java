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

public class borrarValoracionAction extends ActionSupport {

    private List<Valoraciones> valoraciones;
    private List<Valoracionestotales> valoracionesTotales;
    private int idValoracion;
    private String rating = "";
    private String idPropiedad = "";
    private String idValorador = "";
    private Propiedades propiedad;
    private double valoracionTotal;
    private int cont;
    private boolean existeValoracion;

    public borrarValoracionAction() {
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

    public int getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(int idValoracion) {
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

    public Propiedades getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedades propiedad) {
        this.propiedad = propiedad;
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

    public boolean isExisteValoracion() {
        return existeValoracion;
    }

    public void setExisteValoracion(boolean existeValoracion) {
        this.existeValoracion = existeValoracion;
    }

    public String execute() throws Exception {
        DAOValoraciones daoValoraciones = new DAOValoraciones();
        DAOValoracionesTotales daoValoracionesTotales = new DAOValoracionesTotales();
        DAOPropiedades daoPropiedades = new DAOPropiedades();
        DAOUsuarios daoUsuarios = new DAOUsuarios();

        GenericType<List<Valoraciones>> generic_valoraciones;
        generic_valoraciones = new GenericType<List<Valoraciones>>() {
        };

        valoraciones = daoValoraciones.findAll_XML(generic_valoraciones);

        for (int i = 0; i < valoraciones.size(); i++) {
            if (valoraciones.get(i).getIdPropiedad().getId() == Integer.parseInt(idPropiedad) && valoraciones.get(i).getIdValorador().getId() == Integer.parseInt(idValorador)) {
                idValoracion = valoraciones.get(i).getId();
            }
        }

        daoValoraciones.remove(String.valueOf(idValoracion));

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
        generic_valoracionesTotales = new GenericType<List<Valoracionestotales>>() {
        };

        valoracionesTotales = daoValoracionesTotales.findAll_XML(generic_valoracionesTotales);

        for (int i = 0; i < valoracionesTotales.size(); i++) {
            if (valoracionesTotales.get(i).getIdPropiedad().getId() == Integer.parseInt(idPropiedad)) {
                idValoracion = valoracionesTotales.get(i).getId();
            }
        }
        
        GenericType<Propiedades> generic_propiedad;
        generic_propiedad = new GenericType<Propiedades>() {};

        propiedad = daoPropiedades.find_XML(generic_propiedad, idPropiedad);

        Valoracionestotales vTotal = new Valoracionestotales(idValoracion, valoracionTotal, propiedad);
        daoValoracionesTotales.edit_XML(vTotal, String.valueOf(idValoracion));

        propiedad = daoPropiedades.find_XML(generic_propiedad, idPropiedad);

        existeValoracion = false;

        return SUCCESS;
    }
}
