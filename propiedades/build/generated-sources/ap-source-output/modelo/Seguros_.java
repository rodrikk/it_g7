package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Propiedades;
import modelo.Usuarios;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2024-06-02T19:25:18")
@StaticMetamodel(Seguros.class)
public class Seguros_ { 

    public static volatile SingularAttribute<Seguros, Usuarios> idInquilino;
    public static volatile SingularAttribute<Seguros, String> cobertura;
    public static volatile SingularAttribute<Seguros, Double> tarifa;
    public static volatile SingularAttribute<Seguros, Propiedades> idPropiedad;
    public static volatile SingularAttribute<Seguros, Date> fechaInicio;
    public static volatile SingularAttribute<Seguros, Integer> id;
    public static volatile SingularAttribute<Seguros, Date> fechaFin;

}