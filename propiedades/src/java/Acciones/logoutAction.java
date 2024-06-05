package Acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import modelo.Propiedades;
import modelo.Usuarios;
import modelo.Valoracionestotales;
import servicios.DAOUsuarios;
import servicios.DAOValoracionesTotales;

public class logoutAction extends ActionSupport {

    private List<Valoracionestotales> valoracionesTotales;
    
    public logoutAction() {
    }

    public List<Valoracionestotales> getValoracionesTotales() {
        return valoracionesTotales;
    }

    public void setValoracionesTotales(List<Valoracionestotales> valoracionesTotales) {
        this.valoracionesTotales = valoracionesTotales;
    }

    public String execute() throws Exception {
        DAOValoracionesTotales daoValoracionesTotales = new DAOValoracionesTotales();
        
        Map session = (Map) ActionContext.getContext().get("session");
        session.remove("usuario");
        session.remove("idUsuario");

        GenericType<List<Valoracionestotales>> generic_valoracionesTotales;
        generic_valoracionesTotales = new GenericType<List<Valoracionestotales>>() {};

        valoracionesTotales = daoValoracionesTotales.findAll_XML(generic_valoracionesTotales);

        return SUCCESS;
    }
}
