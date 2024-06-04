package Acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.ws.rs.core.GenericType;
import modelo.Operaciones;
import servicios.DAOOperaciones;

public class verOperacionesAction extends ActionSupport {
    
    private List<Operaciones> operaciones;

    public verOperacionesAction() {
    }

    public List<Operaciones> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(List<Operaciones> operaciones) {
        this.operaciones = operaciones;
    }
    
    public String execute() throws Exception {
        DAOOperaciones daoOperaciones = new DAOOperaciones();
        
        GenericType<List<Operaciones>> generic;
        generic = new GenericType<List<Operaciones>> () {};
        
        operaciones = daoOperaciones.findAll_XML(generic);
        
        return SUCCESS;
    }
}
