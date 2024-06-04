package servicios;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import servicios.Alquileres;
import servicios.Compras;
import servicios.Favoritos;
import servicios.Propiedades;
import servicios.Seguros;
import servicios.Valoraciones;
import servicios.Visitas;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2024-06-03T12:48:12")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, String> apellidos;
    public static volatile CollectionAttribute<Usuarios, Favoritos> favoritosCollection;
    public static volatile CollectionAttribute<Usuarios, Visitas> visitasCollection;
    public static volatile CollectionAttribute<Usuarios, Valoraciones> valoracionesCollection;
    public static volatile CollectionAttribute<Usuarios, Compras> comprasCollection;
    public static volatile CollectionAttribute<Usuarios, Propiedades> propiedadesCollection;
    public static volatile CollectionAttribute<Usuarios, Propiedades> propiedadesCollection1;
    public static volatile SingularAttribute<Usuarios, Date> fechaNacimiento;
    public static volatile CollectionAttribute<Usuarios, Alquileres> alquileresCollection1;
    public static volatile SingularAttribute<Usuarios, String> nombre;
    public static volatile SingularAttribute<Usuarios, String> password;
    public static volatile CollectionAttribute<Usuarios, Compras> comprasCollection1;
    public static volatile CollectionAttribute<Usuarios, Seguros> segurosCollection;
    public static volatile CollectionAttribute<Usuarios, Alquileres> alquileresCollection;
    public static volatile SingularAttribute<Usuarios, Integer> id;
    public static volatile SingularAttribute<Usuarios, String> telefono;
    public static volatile SingularAttribute<Usuarios, String> email;

}