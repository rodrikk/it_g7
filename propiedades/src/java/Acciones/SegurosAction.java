package Acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.GenericType;
import modelo.Propiedades;
import modelo.Seguros;
import modelo.Usuarios;
import servicios.DAOSeguros;
import servicios.DAOPropiedades;
import servicios.DAOUsuarios;

public class SegurosAction extends ActionSupport {
    private List<Seguros> seguros;
    private DAOSeguros daoSeguros;
    private int id;
    private Seguros seguro;
    private String cobertura;
    private double tarifa;
    private Date fechaInicio;
    private Date fechaFin;
    private int idPropiedad;
    private int idInquilino;

    public SegurosAction() {
        daoSeguros = new DAOSeguros();
        seguros = new ArrayList<>();
    }

    @Override
    public String execute() {
        try {
            GenericType<List<Seguros>> genericType = new GenericType<List<Seguros>>() {};
            seguros = daoSeguros.findAll_XML(genericType);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public List<Seguros> getSeguros() {
        return seguros;
    }

    public void setSeguros(List<Seguros> seguros) {
        this.seguros = seguros;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCobertura() {
        return cobertura;
    }

    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(int idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public int getIdInquilino() {
        return idInquilino;
    }

    public void setIdInquilino(int idInquilino) {
        this.idInquilino = idInquilino;
    }

    public Seguros getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguros seguro) {
        this.seguro = seguro;
    }

    public String edit() {
        try {
            GenericType<Seguros> generic_seguro = new GenericType<Seguros>() {};
            seguro = daoSeguros.find_XML(generic_seguro, String.valueOf(id));

            seguro.setCobertura(cobertura);
            seguro.setTarifa(tarifa);
            seguro.setFechaInicio(fechaInicio);
            seguro.setFechaFin(fechaFin);

            DAOPropiedades daoPropiedades = new DAOPropiedades();
            GenericType<Propiedades> generic_propiedad = new GenericType<Propiedades>() {};
            Propiedades propiedad = daoPropiedades.find_XML(generic_propiedad, String.valueOf(idPropiedad));
            seguro.setIdPropiedad(propiedad);

            DAOUsuarios daoUsuarios = new DAOUsuarios();
            GenericType<Usuarios> generic_usuario = new GenericType<Usuarios>() {};
            Usuarios inquilino = daoUsuarios.find_XML(generic_usuario, String.valueOf(idInquilino));
            seguro.setIdInquilino(inquilino);

            daoSeguros.edit_XML(seguro, String.valueOf(id));
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String delete() {
        try {
            daoSeguros.remove(String.valueOf(id));
            System.out.println(id);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }
}
