package persistencia;

import java.util.List;
import modelos.Visita;
import modelos.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @autor Carlos
 */
public class VisitaDAO {

    Session session = null;

    // Create
    public void registrarVisita(Visita v) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(v);
        tx.commit();
    }

    // Read Visita
    public Visita obtenerVisita(int id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        String sql = "From Visita WHERE id=" + id;
        Query query = session.createQuery(sql);
        Visita visita = (Visita) query.uniqueResult();
        tx.commit();
        return visita;
    }

    // Update
    public void actualizarVisita(int id, int nuevaDuracion) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String sql = "From Visita Where id = " + id;
        Query query = session.createQuery(sql);
        Visita visita = (Visita) query.uniqueResult();
        visita.setDuracion(nuevaDuracion);
        session.update(visita);
        transaction.commit();
    }

    // Delete
    public void eliminarVisita(Visita v) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(v);
        tx.commit();
    }

    // List Visitas
    public List<Visita> listaVisitas() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        String sql = "From Visita";
        Query query = session.createQuery(sql);
        List<Visita> list = (List<Visita>) query.list();
        tx.commit();
        return list;
    }
}
