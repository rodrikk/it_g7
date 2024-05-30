package persistencia;

import java.util.Date;
import java.util.List;
import modelos.HibernateUtil;
import modelos.Alquilar;
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
    public void registrarAlquilar(Alquilar a) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(a);
        tx.commit();
    }

    // Read Alquilar
    public Alquilar obtenerAlquilar(int id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        String sql = "From Alquilar WHERE id=" + id;
        Query query = session.createQuery(sql);
        Alquilar Alquilar = (Alquilar) query.uniqueResult();
        tx.commit();
        return Alquilar;
    }

    // Update
    public void actualizarAlquilar(int id, double nuevoPrecio, Date nuevaFechaInicio, Date nuevaFechaFin) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String sql = "From Alquilar Where id = '" + id + "'";
        Query query = session.createQuery(sql);
        Alquilar Alquilar = (Alquilar) query.uniqueResult();
        Alquilar.setPrecio(nuevoPrecio);
        Alquilar.setFechaInicio(nuevaFechaInicio);
        Alquilar.setFechaFin(nuevaFechaFin);
        session.update(Alquilar);
        transaction.commit();
    }

    // Delete
    public void eliminarAlquilar(Alquilar a) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(a);
        tx.commit();
    }

    // List Alquilares
    public List<Alquilar> listaAlquilares() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        String sql = "From Alquilar";
        Query query = session.createQuery(sql);
        List<Alquilar> list = (List<Alquilar>) query.list();
        tx.commit();
        return list;
    }
}
