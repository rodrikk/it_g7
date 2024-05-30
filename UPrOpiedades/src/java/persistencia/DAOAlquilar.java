package persistencia;

import java.util.Date;
import java.util.List;
import modelos.HibernateUtil;
import modelos.Alquiler;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @autor Carlos
 */
public class DAOAlquilar {

    Session session = null;

    // Create
    public void registrarAlquiler(Alquiler a) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(a);
        tx.commit();
    }

    // Read Alquiler
    public Alquiler obtenerAlquiler(int id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        String sql = "From Alquiler WHERE id=" + id;
        Query query = session.createQuery(sql);
        Alquiler alquiler = (Alquiler) query.uniqueResult();
        tx.commit();
        return alquiler;
    }

    // Update
    public void actualizarAlquiler(int id, double nuevoPrecio, Date nuevaFechaInicio, Date nuevaFechaFin) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String sql = "From Alquiler Where id = '" + id + "'";
        Query query = session.createQuery(sql);
        Alquiler alquiler = (Alquiler) query.uniqueResult();
        alquiler.setPrecio(nuevoPrecio);
        alquiler.setFechaInicio(nuevaFechaInicio);
        alquiler.setFechaFin(nuevaFechaFin);
        session.update(alquiler);
        transaction.commit();
    }

    // Delete
    public void eliminarAlquiler(Alquiler a) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(a);
        tx.commit();
    }

    // List Alquileres
    public List<Alquiler> listaAlquileres() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        String sql = "From Alquiler";
        Query query = session.createQuery(sql);
        List<Alquiler> list = (List<Alquiler>) query.list();
        tx.commit();
        return list;
    }
}
