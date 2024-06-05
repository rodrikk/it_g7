package Acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.ws.rs.core.GenericType;
import modelo.Propiedades;
import modelo.Valoracionestotales;
import servicios.DAOPropiedades;
import servicios.DAOValoracionesTotales;

public class verPropiedadesAction extends ActionSupport {

    private List<Valoracionestotales> valoracionesTotales;

    public verPropiedadesAction() {
    }

    public List<Valoracionestotales> getValoracionesTotales() {
        return valoracionesTotales;
    }

    public void setValoracionesTotales(List<Valoracionestotales> valoracionesTotales) {
        this.valoracionesTotales = valoracionesTotales;
    }

    public String execute() throws Exception {
        DAOValoracionesTotales daoValoracionesTotales = new DAOValoracionesTotales();
        
        GenericType<List<Valoracionestotales>> generic_valoracionesTotales;
        generic_valoracionesTotales = new GenericType<List<Valoracionestotales>>() {};

        valoracionesTotales = daoValoracionesTotales.findAll_XML(generic_valoracionesTotales);

        return SUCCESS;
    }
}
