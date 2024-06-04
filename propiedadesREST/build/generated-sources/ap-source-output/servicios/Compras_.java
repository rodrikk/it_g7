package servicios;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import servicios.Propiedades;
import servicios.Usuarios;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2024-06-03T12:48:12")
@StaticMetamodel(Compras.class)
public class Compras_ { 

    public static volatile SingularAttribute<Compras, Date> fecha;
    public static volatile SingularAttribute<Compras, Propiedades> idPropiedad;
    public static volatile SingularAttribute<Compras, Usuarios> idVendedor;
    public static volatile SingularAttribute<Compras, Integer> id;
    public static volatile SingularAttribute<Compras, Usuarios> idComprador;

}