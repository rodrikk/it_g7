/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
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

/**
 *
 * @author migue
 */
public class agregarFavoritosAction extends ActionSupport implements ServletRequestAware {
    
    private HttpServletRequest request;
    private String idUsuario = "";
    private String idPropiedad = "";
    private Usuarios usuario;
    private Propiedades propiedad;
    private String id = "";

    public agregarFavoritosAction() {
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

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Propiedades getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedades propiedad) {
        this.propiedad = propiedad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String execute() throws Exception {
        DAOFavoritos daoFavoritos = new DAOFavoritos();
        DAOUsuarios daoUsuarios = new DAOUsuarios();
        DAOPropiedades daoPropiedades = new DAOPropiedades();
        
        Favoritos favorito = new Favoritos();
        
        GenericType<Usuarios> generic_usuario;
        generic_usuario = new GenericType<Usuarios> () {};
        usuario = daoUsuarios.find_XML(generic_usuario, idUsuario);
        favorito.setIdUsuario(usuario);
        
        GenericType<Propiedades> generic_propiedad;
        generic_propiedad = new GenericType<Propiedades> () {};
        propiedad = daoPropiedades.find_XML(generic_propiedad, idPropiedad);
        favorito.setIdPropiedad(propiedad);
        
        Object obj_favorito = favorito;
        daoFavoritos.create_XML(obj_favorito);
        
        HttpSession session = request.getSession();
        session.setAttribute("existeFavorito", true);
        
        id = String.valueOf(favorito.getId());
        
        return SUCCESS;
    }
}
