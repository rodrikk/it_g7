package Acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.ws.rs.core.GenericType;
import modelo.Usuarios;
import servicios.DAOUsuarios;

public class verUsuariosAction extends ActionSupport {
    
    private List<Usuarios> usuarios;

    public verUsuariosAction() {
    }

    public List<Usuarios> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }
    
    public String execute() throws Exception {
        DAOUsuarios dao = new DAOUsuarios();
        GenericType<List<Usuarios>> generic;
        generic = new GenericType<List<Usuarios>> () {};
        usuarios = dao.findAll_XML(generic);
        return SUCCESS;
    }
}
