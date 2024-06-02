package servicios;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import servicios.Propiedades;
import servicios.Usuarios;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2024-06-02T18:37:41")
@StaticMetamodel(Alquileres.class)
public class Alquileres_ { 

    public static volatile SingularAttribute<Alquileres, Propiedades> idPropiedad;
    public static volatile SingularAttribute<Alquileres, Usuarios> idAlquilado;
    public static volatile SingularAttribute<Alquileres, Date> fechaInicio;
    public static volatile SingularAttribute<Alquileres, Usuarios> idPropietario;
    public static volatile SingularAttribute<Alquileres, Integer> id;
    public static volatile SingularAttribute<Alquileres, Date> fechaFin;

}