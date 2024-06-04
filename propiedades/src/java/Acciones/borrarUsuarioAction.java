package Acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
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

public class borrarUsuarioAction extends ActionSupport {

    private String idUsuario = "";

    public borrarUsuarioAction() {
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String execute() throws Exception {
        DAOUsuarios daoUsuarios = new DAOUsuarios();
        daoUsuarios.remove(idUsuario);
        Map session = (Map) ActionContext.getContext().get("session");
        session.remove("usuario");
        return SUCCESS;
    }
}
