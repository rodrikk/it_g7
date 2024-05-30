package persistencia;

import modelos.HibernateUtil;
import java.util.Date;
import java.util.List;
import modelos.Seguro;
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
    public void registrarSeguro(Seguro s) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(s);
        tx.commit();
    }

    // Read Seguro
    public Seguro obtenerSeguro(int id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        String sql = "From Seguro WHERE id=" + id;
        Query query = session.createQuery(sql);
        Seguro seguro = (Seguro) query.uniqueResult();
        tx.commit();
        return seguro;
    }

    // Update
    public void actualizarSeguro(int id, String nuevaCobertura, double nuevaTarifa, Date nuevaFechaInicio, Date nuevaFechaFin) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String sql = "From Seguro Where id = " + id;
        Query query = session.createQuery(sql);
        Seguro seguro = (Seguro) query.uniqueResult();
        seguro.setCobertura(nuevaCobertura);
        seguro.setTarifa(nuevaTarifa);
        seguro.setFechaInicio(nuevaFechaInicio);
        seguro.setFechaFin(nuevaFechaFin);
        session.update(seguro);
        transaction.commit();
    }

    // Delete
    public void eliminarSeguro(Seguro s) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(s);
        tx.commit();
    }

    // List Seguros
    public List<Seguro> listaSeguros() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        String sql = "From Seguro";
        Query query = session.createQuery(sql);
        List<Seguro> list = (List<Seguro>) query.list();
        tx.commit();
        return list;
    }
}
