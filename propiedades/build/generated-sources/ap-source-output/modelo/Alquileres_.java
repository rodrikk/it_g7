package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Propiedades;
import modelo.Usuarios;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2024-06-03T19:30:13")
@StaticMetamodel(Alquileres.class)
public class Alquileres_ { 

    public static volatile SingularAttribute<Alquileres, Propiedades> idPropiedad;
    public static volatile SingularAttribute<Alquileres, Usuarios> idAlquilado;
    public static volatile SingularAttribute<Alquileres, Date> fechaInicio;
    public static volatile SingularAttribute<Alquileres, Usuarios> idPropietario;
    public static volatile SingularAttribute<Alquileres, Integer> id;
    public static volatile SingularAttribute<Alquileres, Date> fechaFin;

}