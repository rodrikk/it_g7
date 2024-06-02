package Acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.ws.rs.core.GenericType;
import modelo.Favoritos;
import servicios.DAOFavoritos;
/**
 *
 * @author migue
 */
public class verFavoritosAction extends ActionSupport {
    
    private List<Favoritos> favoritos;
    private String idUsuario = "";

    public verFavoritosAction() {
    }

    public List<Favoritos> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(List<Favoritos> favoritos) {
        this.favoritos = favoritos;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String execute() throws Exception {
        DAOFavoritos daoFavoritos = new DAOFavoritos();
        GenericType<List<Favoritos>> generic;
        generic = new GenericType<List<Favoritos>> () {};
        favoritos = daoFavoritos.findAll_XML(generic);
        
        for (int i = 0; i < favoritos.size(); i++) {
            if (favoritos.get(i).getIdUsuario().getId() != Integer.parseInt(idUsuario)) {
                favoritos.remove(favoritos.get(i));
            }
        }
        
        return SUCCESS;
    }
}
