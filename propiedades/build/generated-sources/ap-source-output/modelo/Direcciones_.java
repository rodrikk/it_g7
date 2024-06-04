package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Propiedades;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2024-06-03T19:30:13")
@StaticMetamodel(Direcciones.class)
public class Direcciones_ { 

    public static volatile SingularAttribute<Direcciones, Integer> numero;
    public static volatile SingularAttribute<Direcciones, Integer> codigoPostal;
    public static volatile CollectionAttribute<Direcciones, Propiedades> propiedadesCollection;
    public static volatile SingularAttribute<Direcciones, String> ciudad;
    public static volatile SingularAttribute<Direcciones, String> calle;
    public static volatile SingularAttribute<Direcciones, Integer> id;
    public static volatile SingularAttribute<Direcciones, String> provincia;
    public static volatile SingularAttribute<Direcciones, String> pais;

}