package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Propiedades;
import modelo.Usuarios;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2024-06-02T19:25:18")
@StaticMetamodel(Visitas.class)
public class Visitas_ { 

    public static volatile SingularAttribute<Visitas, Propiedades> idPropiedad;
    public static volatile SingularAttribute<Visitas, Integer> duracion;
    public static volatile SingularAttribute<Visitas, Integer> id;
    public static volatile SingularAttribute<Visitas, Usuarios> idVisitante;

}