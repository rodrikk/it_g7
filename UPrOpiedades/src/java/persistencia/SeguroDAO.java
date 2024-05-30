package persistencia;

import modelos.HibernateUtil;
import java.util.Date;
import java.util.List;
import modelos.Seguros;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @autor Carlos
 */
public class SeguroDAO {

    Session session = null;

    // Create
    public void registrarSeguro(Seguros s) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(s);
        tx.commit();
    }

    // Read Seguro
    public Seguros obtenerSeguro(int id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        String sql = "From Seguro WHERE id=" + id;
        Query query = session.createQuery(sql);
        Seguros seguro = (Seguros) query.uniqueResult();
        tx.commit();
        return seguro;
    }

    // Update
    public void actualizarSeguro(int id, String nuevaCobertura, double nuevaTarifa, Date nuevaFechaInicio, Date nuevaFechaFin) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String sql = "From Seguro Where id = " + id;
        Query query = session.createQuery(sql);
        Seguros seguro = (Seguros) query.uniqueResult();
        seguro.setCobertura(nuevaCobertura);
        seguro.setTarifa(nuevaTarifa);
        seguro.setFechaInicio(nuevaFechaInicio);
        seguro.setFechaFin(nuevaFechaFin);
        session.update(seguro);
        transaction.commit();
    }

    // Delete
    public void eliminarSeguro(Seguros s) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(s);
        tx.commit();
    }

    // List Seguros
    public List<Seguros> listaSeguros() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        String sql = "From Seguro";
        Query query = session.createQuery(sql);
        List<Seguros> list = (List<Seguros>) query.list();
        tx.commit();
        return list;
    }
}
