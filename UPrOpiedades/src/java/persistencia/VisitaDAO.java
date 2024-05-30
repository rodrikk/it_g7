package persistencia;

import java.util.List;
import modelos.Visitas;
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
    public void registrarVisita(Visitas v) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(v);
        tx.commit();
    }

    // Read Visita
    public Visitas obtenerVisita(int id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        String sql = "From Visita WHERE id=" + id;
        Query query = session.createQuery(sql);
        Visitas visita = (Visitas) query.uniqueResult();
        tx.commit();
        return visita;
    }

    // Update
    public void actualizarVisita(int id, int nuevaDuracion) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String sql = "From Visita Where id = " + id;
        Query query = session.createQuery(sql);
        Visitas visita = (Visitas) query.uniqueResult();
        visita.setDuracion(nuevaDuracion);
        session.update(visita);
        transaction.commit();
    }

    // Delete
    public void eliminarVisita(Visitas v) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(v);
        tx.commit();
    }

    // List Visitas
    public List<Visitas> listaVisitas() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        String sql = "From Visita";
        Query query = session.createQuery(sql);
        List<Visitas> list = (List<Visitas>) query.list();
        tx.commit();
        return list;
    }
}
