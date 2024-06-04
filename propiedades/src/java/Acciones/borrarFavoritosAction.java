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
import org.apache.struts2.interceptor.ServletRequestAware;
import servicios.DAOFavoritos;
import servicios.DAOPropiedades;
import servicios.DAOUsuarios;

public class borrarFavoritosAction extends ActionSupport implements ServletRequestAware {

    private HttpServletRequest request;
    private String idFavorito = "";
    private List<Favoritos> favoritos;
    private String idUsuario = "";
    private String idPropiedad = "";
    private Propiedades propiedad;
    private String boton = "";

    public borrarFavoritosAction() {
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public String getIdFavorito() {
        return idFavorito;
    }

    public void setIdFavorito(String idFavorito) {
        this.idFavorito = idFavorito;
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

    public String getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(String idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public Propiedades getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedades propiedad) {
        this.propiedad = propiedad;
    }

    public String getBoton() {
        return boton;
    }

    public void setBoton(String boton) {
        this.boton = boton;
    }

    public String execute() throws Exception {
        DAOFavoritos daoFavoritos = new DAOFavoritos();
        HttpSession session = request.getSession();
        GenericType<List<Favoritos>> generic_favoritos;
        generic_favoritos = new GenericType<List<Favoritos>>() {};

        switch (boton) {
            case "Eliminar de favoritos":
                favoritos = daoFavoritos.findAll_XML(generic_favoritos);
                
                for (int i = 0; i < favoritos.size(); i++) {
                    if (favoritos.get(i).getIdUsuario().getId() == Integer.parseInt(idUsuario) && favoritos.get(i).getIdPropiedad().getId() == Integer.parseInt(idPropiedad)) {
                        daoFavoritos.remove(String.valueOf(favoritos.get(i).getId()));
                    }
                }
                
                DAOPropiedades dao = new DAOPropiedades();
                GenericType<Propiedades> generic_propiedades;
                generic_propiedades = new GenericType<Propiedades> () {};
                propiedad = dao.find_XML(generic_propiedades, idPropiedad);
                
                session.setAttribute("existeFavorito", false);
                
                return "borrar";
            default:
                daoFavoritos.remove(idFavorito);
                favoritos = daoFavoritos.findAll_XML(generic_favoritos);

                for (int i = 0; i < favoritos.size(); i++) {
                    if (favoritos.get(i).getIdUsuario().getId() != Integer.parseInt(idUsuario)) {
                        favoritos.remove(favoritos.get(i));
                    }
                }

                session.setAttribute("existeFavorito", false);

                return SUCCESS;
        }
    }
}
