package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Alquileres;
import modelo.Compras;
import modelo.Direcciones;
import modelo.Favoritos;
import modelo.Operaciones;
import modelo.Seguros;
import modelo.Usuarios;
import modelo.Valoraciones;
import modelo.Valoracionestotales;
import modelo.Visitas;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2024-06-03T19:30:13")
@StaticMetamodel(Propiedades.class)
public class Propiedades_ { 

    public static volatile SingularAttribute<Propiedades, String> descripcion;
    public static volatile CollectionAttribute<Propiedades, Favoritos> favoritosCollection;
    public static volatile SingularAttribute<Propiedades, Usuarios> idInquilino;
    public static volatile CollectionAttribute<Propiedades, Visitas> visitasCollection;
    public static volatile CollectionAttribute<Propiedades, Valoracionestotales> valoracionestotalesCollection;
    public static volatile CollectionAttribute<Propiedades, Valoraciones> valoracionesCollection;
    public static volatile CollectionAttribute<Propiedades, Compras> comprasCollection;
    public static volatile SingularAttribute<Propiedades, Usuarios> idPropietario;
    public static volatile SingularAttribute<Propiedades, String> titulo;
    public static volatile SingularAttribute<Propiedades, Double> precio;
    public static volatile SingularAttribute<Propiedades, Direcciones> idDireccion;
    public static volatile SingularAttribute<Propiedades, Integer> numeroHabitaciones;
    public static volatile SingularAttribute<Propiedades, byte[]> foto;
    public static volatile SingularAttribute<Propiedades, Integer> superficie;
    public static volatile CollectionAttribute<Propiedades, Seguros> segurosCollection;
    public static volatile CollectionAttribute<Propiedades, Alquileres> alquileresCollection;
    public static volatile SingularAttribute<Propiedades, Integer> id;
    public static volatile SingularAttribute<Propiedades, Operaciones> idOperacion;

}