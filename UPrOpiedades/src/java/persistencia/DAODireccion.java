package persistencia;

import java.util.List;
import modelos.Direcciones;
import modelos.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @autor Carlos
 */
public class DAODireccion {

    Session session = null;

    // Create
    public void registrarDireccion(Direcciones d) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(d);
        tx.commit();
    }

    // Read Direccion
    public Direcciones obtenerDireccion(int id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        String sql = "From Direccion WHERE id=" + id;
        Query query = session.createQuery(sql);
        Direcciones direccion = (Direcciones) query.uniqueResult();
        tx.commit();
        return direccion;
    }

    // Update
    public void actualizarDireccion(int id, String nuevaCalle, int nuevoNumero, int nuevoCodigoPostal, String nuevaCiudad, String nuevaProvincia, String nuevoPais) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String sql = "From Direccion Where id = " + id;
        Query query = session.createQuery(sql);
        Direcciones direccion = (Direcciones) query.uniqueResult();
        direccion.setCalle(nuevaCalle);
        direccion.setNumero(nuevoNumero);
        direccion.setCodigoPostal(nuevoCodigoPostal);
        direccion.setCiudad(nuevaCiudad);
        direccion.setProvincia(nuevaProvincia);
        direccion.setPais(nuevoPais);
        session.update(direccion);
        transaction.commit();
    }

    // Delete
    public void eliminarDireccion(Direcciones d) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(d);
        tx.commit();
    }

    // List Direcciones
    public List<Direcciones> listaDirecciones() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        String sql = "From Direccion";
        Query query = session.createQuery(sql);
        List<Direcciones> list = (List<Direcciones>) query.list();
        tx.commit();
        return list;
    }
}