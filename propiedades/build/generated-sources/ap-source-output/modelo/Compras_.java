package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Propiedades;
import modelo.Usuarios;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2024-06-02T19:25:18")
@StaticMetamodel(Compras.class)
public class Compras_ { 

    public static volatile SingularAttribute<Compras, Date> fecha;
    public static volatile SingularAttribute<Compras, Propiedades> idPropiedad;
    public static volatile SingularAttribute<Compras, Usuarios> idVendedor;
    public static volatile SingularAttribute<Compras, Integer> id;
    public static volatile SingularAttribute<Compras, Usuarios> idComprador;

}