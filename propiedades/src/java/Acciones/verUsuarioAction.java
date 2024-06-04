package Acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.ws.rs.core.GenericType;
import modelo.Usuarios;
import servicios.DAOUsuarios;

public class verUsuarioAction extends ActionSupport {

    private Usuarios usuario;
    private int idUsuario;

    public verUsuarioAction() {
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String execute() throws Exception {
        DAOUsuarios dao = new DAOUsuarios();
        GenericType<Usuarios> generic;
        generic = new GenericType<Usuarios>() {};
        usuario = dao.find_XML(generic, String.valueOf(idUsuario));
        return SUCCESS;
    }
}