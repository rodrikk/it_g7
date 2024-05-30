package persistencia;

import java.util.Date;
import java.util.List;
import modelos.HibernateUtil;
import modelos.Comprar;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @autor Carlos
 */
public class DAOComprar {

    Session session = null;

    // Create
    public void registrarCompra(Comprar c) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(c);
        tx.commit();
    }

    // Read Comprar
    public Comprar obtenerCompra(int id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        String sql = "From Comprar WHERE id=" + id;
        Query query = session.createQuery(sql);
        Comprar compra = (Comprar) query.uniqueResult();
        tx.commit();
        return compra;
    }

    // Update
    public void actualizarCompra(int id, double nuevoPrecio, Date nuevaFecha) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String sql = "From Comprar Where id = '" + id + "'";
        Query query = session.createQuery(sql);
        Comprar compra = (Comprar) query.uniqueResult();
        compra.setPrecio(nuevoPrecio);
        compra.setFecha(nuevaFecha);
        session.update(compra);
        transaction.commit();
    }

    // Delete
    public void eliminarCompra(Comprar c) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(c);
        tx.commit();
    }

    // List Compras
    public List<Comprar> listaCompras() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        String sql = "From Comprar";
        Query query = session.createQuery(sql);
        List<Comprar> list = (List<Comprar>) query.list();
        tx.commit();
        return list;
    }
}
