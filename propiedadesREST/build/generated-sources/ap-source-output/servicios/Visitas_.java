package servicios;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import servicios.Propiedades;
import servicios.Usuarios;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2024-06-02T18:37:41")
@StaticMetamodel(Visitas.class)
public class Visitas_ { 

    public static volatile SingularAttribute<Visitas, Propiedades> idPropiedad;
    public static volatile SingularAttribute<Visitas, Integer> duracion;
    public static volatile SingularAttribute<Visitas, Integer> id;
    public static volatile SingularAttribute<Visitas, Usuarios> idVisitante;

}