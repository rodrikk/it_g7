package Acciones;

import static com.opensymphony.xwork2.Action.SUCCESS;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.GenericType;
import modelo.Alquileres;
import modelo.Usuarios;
import servicios.DAOAlquileres;
import servicios.DAOUsuarios;

public class editarAlquilerAction {
    
    private String idAlquiler = "";
    private String fechaInicio = "";
    private String fechaFin = "";
    private Alquileres alquiler;
    private List<Alquileres> alquileres;
    private String idUsuario = "";

    public editarAlquilerAction() {
    }

    public String getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(String idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Alquileres getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquileres alquiler) {
        this.alquiler = alquiler;
    }

    public List<Alquileres> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(List<Alquileres> alquileres) {
        this.alquileres = alquileres;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String execute() throws Exception {
        DAOAlquileres daoAlquileres = new DAOAlquileres();
        
        GenericType<Alquileres> generic_alquiler;
        generic_alquiler = new GenericType<Alquileres> () {};
        
        alquiler = daoAlquileres.find_XML(generic_alquiler, idAlquiler);
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fInicio = formatter.parse(fechaInicio);
        Date fFin = formatter.parse(fechaFin);
        
        Alquileres alquilerEdiatdo = new Alquileres(alquiler.getId(), alquiler.getIdPropietario(), alquiler.getIdAlquilado(), alquiler.getIdPropiedad(), fInicio, fFin);
        daoAlquileres.edit_XML(alquilerEdiatdo, idAlquiler);
        
        GenericType<List<Alquileres>> generic_alquileres;
        generic_alquileres = new GenericType<List<Alquileres>> () {};
        
        alquileres = daoAlquileres.findAll_XML(generic_alquileres);
        
        for (int i = 0; i < alquileres.size(); i++) {
            if (alquileres.get(i).getIdAlquilado().getId() != Integer.parseInt(idUsuario)) {
                alquileres.remove(alquileres.get(i));
            }
        }
        
        
        return SUCCESS;
    }   
}