package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Propiedades;
import modelo.Usuarios;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2024-06-03T19:30:13")
@StaticMetamodel(Valoraciones.class)
public class Valoraciones_ { 

    public static volatile SingularAttribute<Valoraciones, Propiedades> idPropiedad;
    public static volatile SingularAttribute<Valoraciones, Double> puntuacion;
    public static volatile SingularAttribute<Valoraciones, Usuarios> idValorador;
    public static volatile SingularAttribute<Valoraciones, Integer> id;

}