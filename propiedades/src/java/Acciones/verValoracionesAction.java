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

public class verValoracionesAction extends ActionSupport {

    private List<Valoracionestotales> valoracionesTotales;

    public verValoracionesAction() {
    }

    public List<Valoracionestotales> getValoracionesTotales() {
        return valoracionesTotales;
    }

    public void setValoracionesTotales(List<Valoracionestotales> valoracionesTotales) {
        this.valoracionesTotales = valoracionesTotales;
    }

    public String execute() throws Exception {
        DAOValoracionesTotales daoValoracionesTotales = new DAOValoracionesTotales();

        GenericType<List<Valoracionestotales>> generic;
        generic = new GenericType<List<Valoracionestotales>>() {};

        valoracionesTotales = daoValoracionesTotales.findAll_XML(generic);

        return SUCCESS;
    }
}